package sinexcel.quartz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncHzCustAccountsEO;
import sinexcel.quartz.mapper.SyncHzCustAccountsMapper;
import sinexcel.quartz.service.ISyncHzCustAccountsService;

/**
 * 客户账户Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-12-15
 */
@Service
public class SyncHzCustAccountsServiceImpl implements ISyncHzCustAccountsService
{
    @Autowired
    private SyncHzCustAccountsMapper syncHzCustAccountsMapper;

    /**
     * 查询客户账户列表
     * 
     * @param syncHzCustAccounts 客户账户
     * @return 客户账户
     */
    @Override
    public List<SyncHzCustAccountsEO> selectSyncHzCustAccountsList(SyncHzCustAccountsEO syncHzCustAccounts)
    {
        return syncHzCustAccountsMapper.selectSyncHzCustAccountsList(syncHzCustAccounts);
    }
}
