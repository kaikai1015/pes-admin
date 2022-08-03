package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncRcvTransactionsEO;

import java.util.List;

public interface SyncRcvTransactionsMapper {
    public int batchSyncRcvTransactionsEO(List<SyncRcvTransactionsEO> list);

    public int deleteSyncRcvTransactionsEO(List<SyncRcvTransactionsEO> list);

    /**
     * 查询PO交易明细列表
     *
     * @param syncRcvTransactions PO交易明细
     * @return PO交易明细集合
     */
    public List<SyncRcvTransactionsEO> selectSyncRcvTransactionsList(SyncRcvTransactionsEO syncRcvTransactions);
}
