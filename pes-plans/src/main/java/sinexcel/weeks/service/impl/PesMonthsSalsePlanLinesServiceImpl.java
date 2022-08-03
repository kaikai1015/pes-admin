package sinexcel.weeks.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.weeks.mapper.PesMonthsSalsePlanLinesMapper;
import sinexcel.weeks.domain.PesMonthsSalsePlanLines;
import sinexcel.weeks.service.IPesMonthsSalsePlanLinesService;

/**
 * 月度销售计划行Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-04-21
 */
@Service
public class PesMonthsSalsePlanLinesServiceImpl implements IPesMonthsSalsePlanLinesService 
{
    @Autowired
    private PesMonthsSalsePlanLinesMapper pesMonthsSalsePlanLinesMapper;

    /**
     * 查询月度销售计划行列表
     * 
     * @param pesMonthsSalsePlanLines 月度销售计划行
     * @return 月度销售计划行
     */
    @Override
    public List<PesMonthsSalsePlanLines> selectPesMonthsSalsePlanLinesList(PesMonthsSalsePlanLines pesMonthsSalsePlanLines)
    {
        return pesMonthsSalsePlanLinesMapper.selectPesMonthsSalsePlanLinesList(pesMonthsSalsePlanLines);
    }

    @Override
    public List<PesMonthsSalsePlanLines> selectPesMonthsSalsePlanLinesListAll(PesMonthsSalsePlanLines pesMonthsSalsePlanLines)
    {
        return pesMonthsSalsePlanLinesMapper.selectPesMonthsSalsePlanLinesListAll(pesMonthsSalsePlanLines);
    }
    /**
     * 新增月度销售计划行
     * 
     * @param list 月度销售计划行
     * @return 结果
     */
    @Transactional
    public int insertPesMonthsSalsePlanLines(List<PesMonthsSalsePlanLines> list)
    {
        int rows = 0;
        if (list.size() > 0) {
            int batchCount =123;//每批处理的条数
            int batchLastIndex = batchCount - 1;// 每批最后一个的下标
            for (int index = 0; index < list.size();) {
                if (batchLastIndex > (list.size() - 1)) {
                    batchLastIndex = list.size() - 1;
                    rows = pesMonthsSalsePlanLinesMapper.insertPesMonthsSalsePlanLines(list.subList(index, (batchLastIndex + 1)));
                    break;// 数据插入完毕,退出循环
                }else {
                    rows = pesMonthsSalsePlanLinesMapper.insertPesMonthsSalsePlanLines(list.subList(index, (batchLastIndex + 1)));
                    index = batchLastIndex + 1;// 设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
        }
        return rows;
    }

    @Override
    public int insertPesMonthsSalsePlanLine(PesMonthsSalsePlanLines monthsSalselList)
    {
        List<PesMonthsSalsePlanLines> list = new ArrayList<PesMonthsSalsePlanLines>();
            PesMonthsSalsePlanLines ids = pesMonthsSalsePlanLinesMapper.getLotNum(monthsSalselList.getLotNum());
                // 验证是否存这条数据
                 monthsSalselList.setId(ids.getId());
//                // 验证是否存这条数据
//                PesMonthsSalsePlanLines count = pesMonthsSalsePlanLinesMapper.selectCount(monthsSalselList);
//                if (StringUtils.isNull(count))
//                {//获取组织ID和物料ID
                    PesMonthsSalsePlanLines getItemDescDatas = pesMonthsSalsePlanLinesMapper.getItemDescDatas(monthsSalselList);
                    if (StringUtils.isNotNull(getItemDescDatas))
                    {
                        monthsSalselList.setCreateBy(SecurityUtils.getUsername());
                        monthsSalselList.setBuId(getItemDescDatas.getBuId());
                        monthsSalselList.setHeaderId(getItemDescDatas.getHeaderId());
                        monthsSalselList.setLineId(getItemDescDatas.getLineId());
                        monthsSalselList.setOrderNum(getItemDescDatas.getOrderNum());
                        monthsSalselList.setLineNum(getItemDescDatas.getLineNum());
                        monthsSalselList.setCustomerPoNumber(getItemDescDatas.getCustomerPoNumber());
                        monthsSalselList.setOrganizationId(getItemDescDatas.getOrganizationId());
                        monthsSalselList.setInventoryItemId(getItemDescDatas.getInventoryItemId());
                        monthsSalselList.setItemNumber(getItemDescDatas.getItemNumber());
                        monthsSalselList.setItemDescription(getItemDescDatas.getItemDescription());
                        monthsSalselList.setPartyId(getItemDescDatas.getPartyId());
                        monthsSalselList.setOrderedDate(getItemDescDatas.getOrderedDate());
                        list.add(monthsSalselList);
                    }else {
                        throw new CustomException("数据为空，请核对此数据！！！");
                    }
//                }
        return pesMonthsSalsePlanLinesMapper.insertPesMonthsSalsePlanLines(list);
    }

    /**
     * 导入数据
     *
     * @param id 数据列表
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importData(List<PesMonthsSalsePlanLines> monthsSalselLists, Long id, String operName)
    {
        if (StringUtils.isNull(monthsSalselLists) || monthsSalselLists.size() == 0)
        {
            throw new CustomException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<PesMonthsSalsePlanLines> list = new ArrayList<PesMonthsSalsePlanLines>();
        for (PesMonthsSalsePlanLines monthsSalselList : monthsSalselLists)
        {
            try
            {
                // 验证是否存这条数据
                monthsSalselList.setId(id);
                // 验证是否存这条数据
                PesMonthsSalsePlanLines count = pesMonthsSalsePlanLinesMapper.selectCount(monthsSalselList);
                if (StringUtils.isNull(count))
                {//获取组织ID和物料ID
                PesMonthsSalsePlanLines getItemDescDatas = pesMonthsSalsePlanLinesMapper.getItemDescDatas(monthsSalselList);
                if (StringUtils.isNotNull(getItemDescDatas))
                {
                    monthsSalselList.setCreateBy(operName);
                    monthsSalselList.setBuId(getItemDescDatas.getBuId());
                    monthsSalselList.setHeaderId(getItemDescDatas.getHeaderId());
                    monthsSalselList.setLineId(getItemDescDatas.getLineId());
                    monthsSalselList.setOrderNum(getItemDescDatas.getOrderNum());
                    monthsSalselList.setLineNum(getItemDescDatas.getLineNum());
                    monthsSalselList.setCustomerPoNumber(getItemDescDatas.getCustomerPoNumber());
                    monthsSalselList.setOrganizationId(getItemDescDatas.getOrganizationId());
                    monthsSalselList.setInventoryItemId(getItemDescDatas.getInventoryItemId());
                    monthsSalselList.setItemNumber(getItemDescDatas.getItemNumber());
                    monthsSalselList.setItemDescription(getItemDescDatas.getItemDescription());
                    monthsSalselList.setPartyId(getItemDescDatas.getPartyId());
                    successNum++;
                    list.add(monthsSalselList);
                }else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、订单编号 " + monthsSalselList.getOrderNum()+"、订单行号 " + monthsSalselList.getLineNum() + "获取物料信息失败");
                }
            }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、订单编号 " + monthsSalselList.getOrderNum()+"、订单行号 " + monthsSalselList.getLineNum() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、订单编号 " + monthsSalselList.getOrderNum()+"、订单行号 " + monthsSalselList.getLineNum() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        this.insertPesMonthsSalsePlanLines(list);
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

    @Override
    @Transactional
    public int deletePesMonthsSalsePlanLinesByIds(Long id)
    {
        pesMonthsSalsePlanLinesMapper.deletePesMonthsSalsePlanLinesByIds(id);
        pesMonthsSalsePlanLinesMapper.insertPesMonthsSalsePlanLinesByIds(id);
        return pesMonthsSalsePlanLinesMapper.updateflag(id);
    }
}
