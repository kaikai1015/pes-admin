package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncWorkOrderUpdateMaterialQuantityEO;

import java.util.List;

public interface SyncWorkOrderUpdateMaterialQuantityMapper {

    int deleteSyncWorkOrderUpdateMaterialQuantityEO(List<SyncWorkOrderUpdateMaterialQuantityEO> list);

    int batchSyncWorkOrderUpdateMaterialQuantityEO(List<SyncWorkOrderUpdateMaterialQuantityEO> list);

    int updateSyncWorkOrderUpdateMaterialQuantityEO(List<SyncWorkOrderUpdateMaterialQuantityEO> list);
}
