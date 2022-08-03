package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncInvMaterialTxnsEO;

import java.util.List;

public interface SyncInvMaterialTxnsMapper {
    public int batchSyncInvMaterialTxnsEO(List<SyncInvMaterialTxnsEO> list);

    public int deleteSyncInvMaterialTxnsEO(List<SyncInvMaterialTxnsEO> list);

    /**
     * 查询库存事务处理明细列表
     *
     * @param syncInvMaterialTxns 库存事务处理明细
     * @return 库存事务处理明细集合
     */
    public List<SyncInvMaterialTxnsEO> selectSyncInvMaterialTxnsList(SyncInvMaterialTxnsEO syncInvMaterialTxns);

    public List<SyncInvMaterialTxnsEO> selectSyncInvMaterialTxnsListErp(SyncInvMaterialTxnsEO syncInvMaterialTxns);
}
