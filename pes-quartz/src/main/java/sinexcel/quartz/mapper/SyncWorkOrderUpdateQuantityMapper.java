package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncWorkOrderUpdateQuantityEO;

import java.util.List;

public interface SyncWorkOrderUpdateQuantityMapper {

    int deleteSyncWorkOrderUpdateQuantityEO(List<SyncWorkOrderUpdateQuantityEO> list);

    int batchSyncWorkOrderUpdateQuantityEO(List<SyncWorkOrderUpdateQuantityEO> list);

    int updateSyncWorkOrderUpdateQuantityEO(List<SyncWorkOrderUpdateQuantityEO> list);

}
