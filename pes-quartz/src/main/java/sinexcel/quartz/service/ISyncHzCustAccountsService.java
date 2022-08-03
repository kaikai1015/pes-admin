package sinexcel.quartz.service;

import java.util.List;
import sinexcel.quartz.domain.SyncHzCustAccountsEO;

/**
 * 客户账户Service接口
 * 
 * @author Zhang Kai
 * @date 2020-12-15
 */
public interface ISyncHzCustAccountsService 
{

    /**
     * 查询客户账户列表
     * 
     * @param syncHzCustAccounts 客户账户
     * @return 客户账户集合
     */
    public List<SyncHzCustAccountsEO> selectSyncHzCustAccountsList(SyncHzCustAccountsEO syncHzCustAccounts);
}
