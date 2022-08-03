package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncInvOnhandQuantityNewCodeEO;

import java.util.List;

public interface SyncInvOnhandQuantityNewCodeMapper {

    public int batchSyncInvOnhandQuantityNewCodeTempEO(List<SyncInvOnhandQuantityNewCodeEO> list);

    public int deleteSyncInvOnhandQuantityNewCodeTempEO();

    public int batchSyncInvOnhandQuantityNewCodeEO();
}
