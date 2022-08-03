package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncInvTransactionTypeTlEO;

import java.util.List;

public interface SyncInvTransactionTypeTlMapper {
    public int deleteSyncInvTransactionTypeTl(List<SyncInvTransactionTypeTlEO> list);

    public int batchSyncInvTransactionTypeTl(List<SyncInvTransactionTypeTlEO> list);

    public List<SyncInvTransactionTypeTlEO> selectSyncInvTransactionTypeTlList(SyncInvTransactionTypeTlEO syncInvTrnxEff);
}
