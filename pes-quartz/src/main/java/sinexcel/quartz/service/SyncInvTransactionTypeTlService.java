package sinexcel.quartz.service;

import sinexcel.quartz.domain.SyncInvTransactionTypeTlEO;

import java.util.List;

public interface SyncInvTransactionTypeTlService {

    public List<SyncInvTransactionTypeTlEO> selectSyncInvTransactionTypeTlList(SyncInvTransactionTypeTlEO syncInvTransactionTypeTl);
}
