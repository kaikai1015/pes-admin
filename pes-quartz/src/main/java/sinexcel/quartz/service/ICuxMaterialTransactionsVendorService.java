package sinexcel.quartz.service;

import sinexcel.quartz.domain.CuxMaterialTransactionsVendorEO;

import java.util.List;

public interface ICuxMaterialTransactionsVendorService {
    /**
     * 查询工单发料列表
     *
     * @param cuxMaterialTransactions 工单发料
     * @return 工单发料集合
     */
    public List<CuxMaterialTransactionsVendorEO> selectCuxMaterialTransactionsList(CuxMaterialTransactionsVendorEO cuxMaterialTransactions);

    /**
     * 查询工单发料
     *
     * @param id 工单发料ID
     * @return 工单发料
     */
    public CuxMaterialTransactionsVendorEO selectCuxMaterialTransactionsById(Integer id);

    /**
     * 修改工单发料
     *
     * @param cuxMaterialTransactions 工单发料
     * @return 结果
     */
    public int updateCuxMaterialTransactions(CuxMaterialTransactionsVendorEO cuxMaterialTransactions);

    /**
     * 提交工单发料
     *
     * @param ids 提交工单发料
     * @return 结果
     */
    public int selectCuxMaterialTransactionsByIds(Integer[] ids)throws Exception;
}
