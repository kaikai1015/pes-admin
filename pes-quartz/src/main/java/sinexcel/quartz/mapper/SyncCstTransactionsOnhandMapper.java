package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncCstTransactionsOnhandEO;

import java.util.List;

public interface SyncCstTransactionsOnhandMapper {
    void deleteSyncCstTransactionsOnhandEO();

    void batchSyncCstTransactionsOnhandEO(List<SyncCstTransactionsOnhandEO> list);
}
