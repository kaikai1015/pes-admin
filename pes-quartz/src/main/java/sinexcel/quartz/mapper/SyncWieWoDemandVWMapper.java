package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncWieWoDemandVWEO;

import java.util.List;

public interface SyncWieWoDemandVWMapper {

    public int batchSyncWieWoDemandVWTempEO(List<SyncWieWoDemandVWEO> list);

    public int deleteSyncWieWoDemandVWTempEO(List<SyncWieWoDemandVWEO> list);

    public int deleteSyncWieWoDemandVWEO(List<SyncWieWoDemandVWEO> list);
}
