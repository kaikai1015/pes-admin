package sinexcel.weeks.mapper;

import java.util.List;
import sinexcel.weeks.domain.PesPoBackInforHeaderAll;

/**
 *  采购回货计划Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-07-26
 */
public interface PesPoBackInforHeaderAllMapper 
{

    /**
     * 查询 采购回货计划列表
     * 
     * @param pesPoBackInforHeaderAll  采购回货计划
     * @return  采购回货计划集合
     */
    public List<PesPoBackInforHeaderAll> selectPesPoBackInforHeaderAllList(PesPoBackInforHeaderAll pesPoBackInforHeaderAll);

    /**
     * 新增 采购回货计划
     * 
     * @param pesPoBackInforHeaderAll  采购回货计划
     * @return 结果
     */
    public int insertPesPoBackInforHeaderAll(PesPoBackInforHeaderAll pesPoBackInforHeaderAll);


    /**
     * 删除 采购回货计划
     * 
     * @param headerId  采购回货计划ID
     * @return 结果
     */
    public int deletePesPoBackInforHeaderAllById(Long headerId);

    /**
     * 查询 采购回货计划
     *
     * @param headerId  采购回货计划ID
     * @return  采购回货计划
     */
    public PesPoBackInforHeaderAll selectPesPoBackInforHeaderAllById(Long headerId);

    /**
     * 修改 采购回货计划
     *
     * @param pesPoBackInforHeaderAll  采购回货计划
     * @return 结果
     */
    public int updatePesPoBackInforHeaderAll(PesPoBackInforHeaderAll pesPoBackInforHeaderAll);
}
