package sinexcel.quartz.service;

import sinexcel.quartz.domain.*;

import java.util.List;

/**
 * 库存事务处理明细Service接口
 *
 * @author Zhang Kai
 * @date 2020-12-31
 */
public interface ISyncInvMaterialTxnsService {
    /**
     * 查询库存事务处理明细列表
     *
     * @param syncInvMaterialTxns 库存事务处理明细
     * @return 库存事务处理明细集合
     */
    public List<SyncInvMaterialTxnsEO> selectSyncInvMaterialTxnsList(SyncInvMaterialTxnsEO syncInvMaterialTxns);

    public List<SyncInvMaterialTxnsEO> selectSyncInvMaterialTxnsListErp(SyncInvMaterialTxnsEO syncInvMaterialTxns);

    void batchInsertDeleteSyncInvMaterialTxnsEO(List<SyncInvMaterialTxnsEO> list);

    void batchInsertDeleteOrderDemandSyncInvMaterialTxnsEO(List<CuxOrderDemandMaterialSumQuantityAllEO> list);

    void batchInsertDeleteWieSupplySyncInvMaterialTxnsEO(List<CuxWieSupplyMaterialSumQuantityAllEO> list);

    void batchInsertDeleteWieDemandSyncInvMaterialTxnsEO(List<CuxWieDemandMaterialSumQuantityAllEO> list);

    void batchInsertDeletePoSupplySyncInvMaterialTxnsEO(List<CuxPoSupplyMaterialSumQuantityAllEO> list);

    void batchInsertDeleteOtherSupplySyncInvMaterialTxnsEO(List<CuxOtherSupplyMaterialSumQuantityAllEO> list);

    int weekInsertDeleteSyncInvMaterialTxnsEO(List<invOnhandMaterialSumQuantitySubinventoryList> list);
}
