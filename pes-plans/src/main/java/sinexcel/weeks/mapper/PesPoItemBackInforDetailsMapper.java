package sinexcel.weeks.mapper;

import java.util.List;
import sinexcel.weeks.domain.PesPoItemBackInforDetails;

/**
 * 采购回货计划明细Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-07-26
 */
public interface PesPoItemBackInforDetailsMapper 
{
    /**
     * 查询采购回货计划明细
     * 
     * @param itemBackId 采购回货计划明细ID
     * @return 采购回货计划明细
     */
    public PesPoItemBackInforDetails selectPesPoItemBackInforDetailsById(Long itemBackId);

    /**
     * 查询采购回货计划明细列表
     * 
     * @param pesPoItemBackInforDetails 采购回货计划明细
     * @return 采购回货计划明细集合
     */
    public List<PesPoItemBackInforDetails> selectPesPoItemBackInforDetailsList(PesPoItemBackInforDetails pesPoItemBackInforDetails);

    public List<PesPoItemBackInforDetails> selectPesPoItemBackInforDetailsListPOInbound(PesPoItemBackInforDetails pesPoItemBackInforDetails);

    /**
     * 新增采购回货计划明细
     * 
     * @param pesPoItemBackInforDetails 采购回货计划明细
     * @return 结果
     */
    public int insertPesPoItemBackInforDetails(List<PesPoItemBackInforDetails> pesPoItemBackInforDetails);

    /**
     * 修改采购回货计划明细
     * 
     * @param pesPoItemBackInforDetails 采购回货计划明细
     * @return 结果
     */
    public int updatePesPoItemBackInforDetails(PesPoItemBackInforDetails pesPoItemBackInforDetails);

    public int updatePesPoItemBackInforDetailsPO(PesPoItemBackInforDetails pesPoItemBackInforDetails);

    /**
     * 批量删除采购回货计划明细
     * 
     * @param itemBackIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePesPoItemBackInforDetailsByIds(Long[] itemBackIds);

    public PesPoItemBackInforDetails selectCount(PesPoItemBackInforDetails pesPoItemBackInforDetails);

    public PesPoItemBackInforDetails getItemDescDatas(PesPoItemBackInforDetails pesPoItemBackInforDetails);

    public PesPoItemBackInforDetails selectOrganizationId(String organizationCode);
}
