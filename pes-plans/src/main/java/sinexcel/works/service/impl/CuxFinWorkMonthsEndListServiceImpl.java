package sinexcel.works.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.*;
import sinexcel.works.mapper.CuxFinWorkMonthsEndListMapper;
import sinexcel.works.domain.CuxFinWorkMonthsEndList;
import sinexcel.works.service.ICuxFinWorkMonthsEndListService;

/**
 * 月结工单批量操行Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-05-07
 */
@Service
public class CuxFinWorkMonthsEndListServiceImpl implements ICuxFinWorkMonthsEndListService 
{
    @Autowired
    private CuxFinWorkMonthsEndListMapper cuxFinWorkMonthsEndListMapper;

    public static final String CONTECT_TYPE = "application/vnd.oracle.adf.resourceitem+json";


    /**
     * 查询月结工单批量操行列表
     * 
     * @param cuxFinWorkMonthsEndList 月结工单批量操行
     * @return 月结工单批量操行
     */
    @Override
    public List<CuxFinWorkMonthsEndList> selectCuxFinWorkMonthsEndListList(CuxFinWorkMonthsEndList cuxFinWorkMonthsEndList)
    {
        return cuxFinWorkMonthsEndListMapper.selectCuxFinWorkMonthsEndListList(cuxFinWorkMonthsEndList);
    }

    /**
     * 导入数据
     *
     * @param lotNum 数据列表
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importData(List<CuxFinWorkMonthsEndList> lineLists, Long lotNum,String operName)
    {
        if (StringUtils.isNull(lineLists) || lineLists.size() == 0)
        {
            throw new CustomException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<CuxFinWorkMonthsEndList> list = new ArrayList<CuxFinWorkMonthsEndList>();
        for (CuxFinWorkMonthsEndList lineList : lineLists)
        {
            try
            {
                CuxFinWorkMonthsEndList getWorkDatas = cuxFinWorkMonthsEndListMapper.getWorkDatas(lineList);
                if (StringUtils.isNotNull(getWorkDatas)){
                    // 验证是否存这条数据
                    lineList.setLotNum(lotNum);
                    lineList.setOrganizationId(getWorkDatas.getOrganizationId());
                    lineList.setWorkOrderId(getWorkDatas.getWorkOrderId());
                    // 验证是否存这条数据
                    CuxFinWorkMonthsEndList count = cuxFinWorkMonthsEndListMapper.selectCount(lineList);
                    if (StringUtils.isNull(count)){
                        lineList.setCreateBy(operName);
                        successNum++;
                        list.add(lineList);
                    }else {
                            failureNum++;
                            failureMsg.append("<br/>" + failureNum + "、库存组织 " + lineList.getOrganizationcode()+"、工单号 " + lineList.getWorkOrderNumber() + " 已存在");
                    }
                }else {
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、库存组织 " + lineList.getOrganizationcode()+"、工单号 " + lineList.getWorkOrderNumber() + "不存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、库存组织 " + lineList.getOrganizationcode()+"、工单号 " + lineList.getWorkOrderNumber() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        this.insertCuxFinWorkMonthsEndList(list);
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条");
        }
        return successMsg.toString();
    }

    @Transactional
    public int insertCuxFinWorkMonthsEndList(List<CuxFinWorkMonthsEndList> list)
    {
        int rows = 0;
        if (list.size() > 0) {
            int batchCount =298;//每批处理的条数
            int batchLastIndex = batchCount - 1;// 每批最后一个的下标
            for (int index = 0; index < list.size();) {
                if (batchLastIndex > (list.size() - 1)) {
                    batchLastIndex = list.size() - 1;
                    rows = cuxFinWorkMonthsEndListMapper.insertCuxFinWorkMonthsEndList(list.subList(index, (batchLastIndex + 1)));
                    break;// 数据插入完毕,退出循环
                }else {
                    rows = cuxFinWorkMonthsEndListMapper.insertCuxFinWorkMonthsEndList(list.subList(index, (batchLastIndex + 1)));
                    index = batchLastIndex + 1;// 设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
        }
        return rows;
    }

    @Override
    public int getHandleWieErp(Long lotNum)
    {
        int WorkOrderStatusId = 0;
        CuxFinWorkMonthsEndList monthsFlag = cuxFinWorkMonthsEndListMapper.getMonthsFlag(lotNum);
        if("C".equals(monthsFlag.getMonthsFlag())){
            WorkOrderStatusId = 10001;
        }else {
            WorkOrderStatusId = "R".equals(monthsFlag.getMonthsFlagStstus())?10004:10002;
        }
        //Json头信息
        JSONObject requestJsonObject = new JSONObject();
        requestJsonObject.put("WorkOrderStatusId", WorkOrderStatusId);
        String requestBody = requestJsonObject.toJSONString();
        monthsFlag.setErpFlag("0");
        List<CuxFinWorkMonthsEndList> lineLists = cuxFinWorkMonthsEndListMapper.selectCuxFinWorkMonthsEndListList(monthsFlag);
        if(lineLists.size() > 0){
            for(CuxFinWorkMonthsEndList lineList:lineLists){
                String getEndWieWoUrl = ConfigUtils.getEndWieWoUrl().replace("{WorkOrderId}",lineList.getWorkOrderId().toString());
                //发送PATCH请求
                try {
                    int sta = RestClient.patchData(getEndWieWoUrl, requestBody, CONTECT_TYPE, "UTF-8",ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
                    if(sta == 200 || sta == 201){
                        System.out.println(WorkOrderStatusId);
                        lineList.setErpFlag("1");
                        lineList.setLastUpdateBy(SecurityUtils.getUsername());
                        lineList.setCreateDate(DateUtils.getNowDate());
                        lineList.setWorkOrderStatusId(WorkOrderStatusId);
                        cuxFinWorkMonthsEndListMapper.updateErpFlag(lineList);
                    }else {
                        lineList.setErpFlag("2");
                        lineList.setLastUpdateBy(SecurityUtils.getUsername());
                        lineList.setCreateDate(DateUtils.getNowDate());
                        lineList.setWorkOrderStatusId(WorkOrderStatusId);
                        cuxFinWorkMonthsEndListMapper.updateErpFlagFalse(lineList);
                    }
                } catch (Exception e) {
                    lineList.setErpFlag("2");
                    lineList.setCreateDate(DateUtils.getNowDate());
                    lineList.setWorkOrderStatusId(WorkOrderStatusId);
                    lineList.setLastUpdateBy(SecurityUtils.getUsername());
                    cuxFinWorkMonthsEndListMapper.updateErpFlagFalse(lineList);
                }
                //返回值解析
            }
        }
        return 1;
    }

}
