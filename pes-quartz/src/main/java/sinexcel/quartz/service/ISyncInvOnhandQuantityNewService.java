package sinexcel.quartz.service;

import sinexcel.quartz.domain.SyncInvOnhandQuantityNewEO;

import java.util.List;

public interface ISyncInvOnhandQuantityNewService {

    void batchInsertDeleteSyncInvOnhandQuantityNewTempEO(List<SyncInvOnhandQuantityNewEO> list);
}
