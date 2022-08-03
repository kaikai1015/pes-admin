package sinexcel.quartz.service;

import sinexcel.quartz.domain.SyncRcvTransactionsEO;

import java.util.List;

/**
 * PO交易明细Service接口
 *
 * @author Zhang Kai
 * @date 2021-01-05
 */
public interface ISyncRcvTransactionsService {
    /**
     * 查询PO交易明细列表
     *
     * @param syncRcvTransactions PO交易明细
     * @return PO交易明细集合
     */
    public List<SyncRcvTransactionsEO> selectSyncRcvTransactionsList(SyncRcvTransactionsEO syncRcvTransactions);
}
