package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncPesWorkOrderUpdateMaterialQuantityEO;

import java.util.List;

public interface SyncPesWorkOrderUpdateMaterialQuantityMapper {

    int deleteSyncPesWorkOrderUpdateMaterialQuantityEO(List<SyncPesWorkOrderUpdateMaterialQuantityEO> list);

    int batchSyncPesWorkOrderUpdateMaterialQuantityEO(List<SyncPesWorkOrderUpdateMaterialQuantityEO> list);

    int updateSyncPesWorkOrderUpdateMaterialQuantityEO(List<SyncPesWorkOrderUpdateMaterialQuantityEO> list);
}
