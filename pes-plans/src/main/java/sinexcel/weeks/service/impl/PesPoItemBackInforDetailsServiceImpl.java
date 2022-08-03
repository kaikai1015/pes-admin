package sinexcel.weeks.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.weeks.mapper.PesPoItemBackInforDetailsMapper;
import sinexcel.weeks.domain.PesPoItemBackInforDetails;
import sinexcel.weeks.service.IPesPoItemBackInforDetailsService;

/**
 * 采购回货计划明细Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-07-26
 */
@Service
public class PesPoItemBackInforDetailsServiceImpl implements IPesPoItemBackInforDetailsService 
{
    @Autowired
    private PesPoItemBackInforDetailsMapper pesPoItemBackInforDetailsMapper;

    /**
     * 查询采购回货计划明细
     * 
     * @param itemBackId 采购回货计划明细ID
     * @return 采购回货计划明细
     */
    @Override
    public PesPoItemBackInforDetails selectPesPoItemBackInforDetailsById(Long itemBackId)
    {
        return pesPoItemBackInforDetailsMapper.selectPesPoItemBackInforDetailsById(itemBackId);
    }

    /**
     * 查询采购回货计划明细列表
     * 
     * @param pesPoItemBackInforDetails 采购回货计划明细
     * @return 采购回货计划明细
     */
    @Override
    public List<PesPoItemBackInforDetails> selectPesPoItemBackInforDetailsList(PesPoItemBackInforDetails pesPoItemBackInforDetails)
    {
        return pesPoItemBackInforDetailsMapper.selectPesPoItemBackInforDetailsList(pesPoItemBackInforDetails);
    }

    @Override
    public List<PesPoItemBackInforDetails> selectPesPoItemBackInforDetailsListPOInbound(PesPoItemBackInforDetails pesPoItemBackInforDetails)
    {
        return pesPoItemBackInforDetailsMapper.selectPesPoItemBackInforDetailsListPOInbound(pesPoItemBackInforDetails);
    }

    /**
     * 新增采购回货计划明细
     * 
     * @param list 采购回货计划明细
     * @return 结果
     */
    @Transactional
    public int insertPesPoItemBackInforDetails(List<PesPoItemBackInforDetails> list)
    {
            int rows = 0;
            if (list.size() > 0) {
                int batchCount =82;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        rows = pesPoItemBackInforDetailsMapper.insertPesPoItemBackInforDetails(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        rows = pesPoItemBackInforDetailsMapper.insertPesPoItemBackInforDetails(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
            return rows;
    }

    /**
     * 修改采购回货计划明细
     * 
     * @param pesPoItemBackInforDetails 采购回货计划明细
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePesPoItemBackInforDetails(PesPoItemBackInforDetails pesPoItemBackInforDetails)
    {
        pesPoItemBackInforDetails.setLastUpdateBy(SecurityUtils.getUsername());
        return pesPoItemBackInforDetailsMapper.updatePesPoItemBackInforDetails(pesPoItemBackInforDetails);
    }

    @Override
    @Transactional
    public int updatePesPoItemBackInforDetailsPO(PesPoItemBackInforDetails pesPoItemBackInforDetails)
    {
        pesPoItemBackInforDetails.setLastUpdateBy(SecurityUtils.getUsername());
        return pesPoItemBackInforDetailsMapper.updatePesPoItemBackInforDetailsPO(pesPoItemBackInforDetails);
    }


    /**
     * 批量删除采购回货计划明细
     * 
     * @param itemBackIds 需要删除的采购回货计划明细ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePesPoItemBackInforDetailsByIds(Long[] itemBackIds)
    {
        return pesPoItemBackInforDetailsMapper.deletePesPoItemBackInforDetailsByIds(itemBackIds);
    }

    /**
     * 导入数据
     *
     * @param headerId 数据列表
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importData(List<PesPoItemBackInforDetails> lists, Long headerId, String operName)
    {
        if (StringUtils.isNull(lists) || lists.size() == 0)
        {
            throw new CustomException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<PesPoItemBackInforDetails> list = new ArrayList<PesPoItemBackInforDetails>();
        for (PesPoItemBackInforDetails ls : lists)
        {
            try
            {
                PesPoItemBackInforDetails organizationId = pesPoItemBackInforDetailsMapper.selectOrganizationId(ls.getOrganizationCode());
                // 验证是否存这条数据
                ls.setHeaderId(headerId);
                ls.setOrganizationId(organizationId.getOrganizationId());
                // 验证是否存这条数据
                PesPoItemBackInforDetails count = pesPoItemBackInforDetailsMapper.selectCount(ls);
                if (StringUtils.isNull(count))
                {//获取组织ID和物料ID
                    PesPoItemBackInforDetails getItemDescDatas = pesPoItemBackInforDetailsMapper.getItemDescDatas(ls);
                    if (StringUtils.isNotNull(getItemDescDatas))
                    {
                        ls.setCreateBy(operName);
                        ls.setInventoryItemId(getItemDescDatas.getInventoryItemId());
                        successNum++;
                        list.add(ls);
                    }else
                    {
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、物料编码 " + ls.getItemNumber()+ "获取物料信息失败");
                    }
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、物料编码 " + ls.getItemNumber() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、物料编码 " + ls.getItemNumber() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        this.insertPesPoItemBackInforDetails(list);
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


}
