package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncWieWorkOrdersBWEO;

import java.util.List;

public interface SyncWieWorkOrdersBWMapper {

    public int batchSyncWieWorkOrdersBWTempEO(List<SyncWieWorkOrdersBWEO> list);

    public int deleteSyncWieWorkOrdersBWTempEO();

    public int batchSyncWieWorkOrdersBWEO();
}
