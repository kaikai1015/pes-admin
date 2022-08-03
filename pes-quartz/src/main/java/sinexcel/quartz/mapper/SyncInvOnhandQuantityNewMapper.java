package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncInvOnhandQuantityNewEO;

import java.util.List;

public interface SyncInvOnhandQuantityNewMapper {

    public int batchSyncInvOnhandQuantityNewTempEO(List<SyncInvOnhandQuantityNewEO> list);

    public int deleteSyncInvOnhandQuantityNewTempEO();

    public int batchSyncInvOnhandQuantityNewEO();
}
