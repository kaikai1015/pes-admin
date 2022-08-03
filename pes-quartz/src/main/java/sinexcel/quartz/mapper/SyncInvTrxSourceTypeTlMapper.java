package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncInvTrxSourceTypeTlEO;

import java.util.List;

public interface SyncInvTrxSourceTypeTlMapper {

    public int deleteSyncInvTrxSourceTypeTl(List<SyncInvTrxSourceTypeTlEO> list);

    public int batchSyncInvTrxSourceTypeTl(List<SyncInvTrxSourceTypeTlEO> list);
}
