package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncEgpComponentsBEO;

import java.util.List;

public interface SyncEgpComponentsBMapper {

    public int batchSyncEgpComponentsBEO(List<SyncEgpComponentsBEO> list);

    public int deleteSyncEgpComponentsBEO(List<SyncEgpComponentsBEO> list);
}
