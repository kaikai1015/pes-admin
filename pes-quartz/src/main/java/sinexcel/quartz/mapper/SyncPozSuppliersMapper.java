package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncPozSuppliersEO;

import java.util.List;

public interface SyncPozSuppliersMapper {
    public int batchSyncPozSuppliersEO(List<SyncPozSuppliersEO> list);

    public int deleteSyncPozSuppliersEO(List<SyncPozSuppliersEO> list);

    /**
     * 查询供应商信息列表
     *
     * @param syncPozSuppliers 供应商信息
     * @return 供应商信息集合
     */
    public List<SyncPozSuppliersEO> selectSyncPozSuppliersList(SyncPozSuppliersEO syncPozSuppliers);
}
