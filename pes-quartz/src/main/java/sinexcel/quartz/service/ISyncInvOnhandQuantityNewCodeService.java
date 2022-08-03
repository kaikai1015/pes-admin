package sinexcel.quartz.service;


import sinexcel.quartz.domain.SyncInvOnhandQuantityNewCodeEO;

import java.util.List;

public interface ISyncInvOnhandQuantityNewCodeService {

    void batchInsertDeleteSyncInvOnhandQuantityNewCodeTempEO(List<SyncInvOnhandQuantityNewCodeEO> list);
}
