package sinexcel.daysPlan.mapper;

import sinexcel.daysPlan.domain.PesInvMaterialTxns;

import java.util.List;

/**
 * 库存事务处理明细Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-08-28
 */
public interface PesInvMaterialTxnsMapper 
{
    /**
     * 查询库存事务处理明细
     * 
     * @param id 库存事务处理明细ID
     * @return 库存事务处理明细
     */
    public PesInvMaterialTxns selectPesInvMaterialTxnsById(Long id);

    /**
     * 查询库存事务处理明细列表
     * 
     * @param pesInvMaterialTxns 库存事务处理明细
     * @return 库存事务处理明细集合
     */
    public List<PesInvMaterialTxns> selectPesInvMaterialTxnsList(PesInvMaterialTxns pesInvMaterialTxns);

    /**
     * 新增库存事务处理明细
     * 
     * @param pesInvMaterialTxns 库存事务处理明细
     * @return 结果
     */
    public int insertPesInvMaterialTxns(PesInvMaterialTxns pesInvMaterialTxns);

    /**
     * 修改库存事务处理明细
     * 
     * @param pesInvMaterialTxns 库存事务处理明细
     * @return 结果
     */
    public int updatePesInvMaterialTxns(PesInvMaterialTxns pesInvMaterialTxns);

    /**
     * 删除库存事务处理明细
     * 
     * @param id 库存事务处理明细ID
     * @return 结果
     */
    public int deletePesInvMaterialTxnsById(Long id);

    /**
     * 批量删除库存事务处理明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePesInvMaterialTxnsByIds(Long[] ids);

    /**
     * @Author mingshen.wang
     * @Description
     * @Date 16:07 2021/8/28
     * @Param [mesInvIds]
     * @return java.util.List<sinexcel.daysPlan.domain.PesInvMaterialTxns>
     **/
    List<PesInvMaterialTxns> getListByMesIds(long[] mesTransferId);

    /**
     * @Author mingshen.wang
     * @Description 获取需要处理的入库数据
     * @Date 11:09 2021/8/29
     * @Param []
     * @return java.util.List<sinexcel.daysPlan.domain.PesInvMaterialTxns>
     **/
    List<PesInvMaterialTxns> getPendingList();

    List<PesInvMaterialTxns> getKey();

}
