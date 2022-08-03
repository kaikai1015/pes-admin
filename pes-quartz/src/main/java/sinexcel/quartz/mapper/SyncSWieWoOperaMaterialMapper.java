package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncSWieWoOperaMaterialEO;

import java.util.List;

public interface SyncSWieWoOperaMaterialMapper {
    public int batchSyncSWieWoOperaMaterialEO(List<SyncSWieWoOperaMaterialEO> list);

    public int deleteSyncSWieWoOperaMaterialEO(List<SyncSWieWoOperaMaterialEO> list);
}
