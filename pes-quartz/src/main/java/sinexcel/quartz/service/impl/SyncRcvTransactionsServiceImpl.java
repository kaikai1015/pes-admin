package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncRcvTransactionsEO;
import sinexcel.quartz.mapper.SyncRcvTransactionsMapper;
import sinexcel.quartz.service.ISyncRcvTransactionsService;

import java.util.List;

/**
 * PO交易明细Service业务层处理
 *
 * @author Zhang Kai
 * @date 2021-01-05
 */
@Service
public class SyncRcvTransactionsServiceImpl implements ISyncRcvTransactionsService {
    @Autowired
    private SyncRcvTransactionsMapper syncRcvTransactionsMapper;

    /**
     * 查询PO交易明细列表
     *
     * @param syncRcvTransactions PO交易明细
     * @return PO交易明细
     */
    @Override
    public List<SyncRcvTransactionsEO> selectSyncRcvTransactionsList(SyncRcvTransactionsEO syncRcvTransactions)
    {
        return syncRcvTransactionsMapper.selectSyncRcvTransactionsList(syncRcvTransactions);
    }
}
