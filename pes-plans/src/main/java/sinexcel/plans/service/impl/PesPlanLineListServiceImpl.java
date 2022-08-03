package sinexcel.plans.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.StringUtils;
import sinexcel.plans.mapper.PesPlanLineListMapper;
import sinexcel.plans.domain.PesPlanLineList;
import sinexcel.plans.service.IPesPlanLineListService;


/**
 * 主计划行Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-11-20
 */
@Service
public class PesPlanLineListServiceImpl implements IPesPlanLineListService 
{
    @Autowired
    private PesPlanLineListMapper pesPlanLineListMapper;


    /**
     * 查询主计划行列表
     * 
     * @param pesPlanLineList 主计划行
     * @return 主计划行
     */
    @Override
    public List<PesPlanLineList> selectPesPlanLineListList(PesPlanLineList pesPlanLineList)
    {
        return pesPlanLineListMapper.selectPesPlanLineListList(pesPlanLineList);
    }

    /**
     * 导入数据
     *
     * @param plines 数据列表
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importData(List<PesPlanLineList> plines, Long planLotNum, String operName)
    {
        int pTree = 10001;
        if (StringUtils.isNull(plines) || plines.size() == 0)
        {
            throw new CustomException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<PesPlanLineList> list = new ArrayList<PesPlanLineList>();
        for (PesPlanLineList pline : plines)
        {
            try
            {
                //获取主计划头上那个信息
                PesPlanLineList getPlanHeader = pesPlanLineListMapper.getPlanHeader(planLotNum);
                // 验证是否存这条数据
                pline.setPlanLotNum(getPlanHeader.getPlanLotNum());
                pline.setOrganizationId(getPlanHeader.getOrganizationId());
                pline.setProdLine(getPlanHeader.getProdLine());
                PesPlanLineList count = pesPlanLineListMapper.selectCount(pline);
                //获取组织ID和物料ID
                PesPlanLineList getOrgItemId = pesPlanLineListMapper.getOrgItemId(pline);
                if (StringUtils.isNull(count))
                {
                    pline.setCreateBy(operName);
                    pline.setInventoryItemId(getOrgItemId.getInventoryItemId());
                    pline.setPlanItemDescription(getOrgItemId.getPlanItemDescription());
                    pline.setPlanItemType(getOrgItemId.getPlanItemType());
                    successNum++;
                    pline.setPlanTreeCode(getPlanHeader.getPlanLotNum()+((pTree++)+"").substring(1));
                    pline.setPlanLotLineNum(successNum);
                    list.add(pline);
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、库存组织 " + pline.getOrganizationCode()+"、物料编码 " + pline.getPlanItemNumber() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、库存组织 " + pline.getOrganizationCode()+"、物料编码 " + pline.getPlanItemNumber() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        this.insertPlines(list);
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

    /**
     *
     * @return 结果
     */
    @Transactional
    public int insertPlines(List<PesPlanLineList> list)
    {
        int rows = 0;
        if (list.size() > 0) {
            int batchCount =115;//每批处理的条数
            int batchLastIndex = batchCount - 1;// 每批最后一个的下标
            for (int index = 0; index < list.size();) {
                if (batchLastIndex > (list.size() - 1)) {
                    batchLastIndex = list.size() - 1;
                    rows = pesPlanLineListMapper.insertPlines(list.subList(index, (batchLastIndex + 1)));
                    break;// 数据插入完毕,退出循环
                }else {
                    rows = pesPlanLineListMapper.insertPlines(list.subList(index, (batchLastIndex + 1)));
                    index = batchLastIndex + 1;// 设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
        }
        return rows;
    }
}
