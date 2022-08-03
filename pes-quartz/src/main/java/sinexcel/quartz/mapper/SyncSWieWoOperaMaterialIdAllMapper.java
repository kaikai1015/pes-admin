package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncSWieWoOperaMaterialIdAllEO;

import java.util.List;

public interface SyncSWieWoOperaMaterialIdAllMapper {

    public int batchSyncSWieWoOperaMaterialIdAllTempEO(List<SyncSWieWoOperaMaterialIdAllEO> list);

    public int deleteSyncSWieWoOperaMaterialIdAllTempEO();

    public int batchSyncSWieWoOperaMaterialIdAllEO();
}
