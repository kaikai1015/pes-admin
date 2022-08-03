package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncHzCustAccountsEO;

import java.util.List;

public interface SyncHzCustAccountsMapper {
    /**
     * 批量新增SSyncHzCustAccountsEO信息
     *
     * @param list 列表
     * @return 结果
     */
    public int batchSyncHzCustAccountsEO(List<SyncHzCustAccountsEO> list);

    public int deleteSyncHzCustAccountsEO(List<SyncHzCustAccountsEO> list);

    /**
     * 查询客户账户列表
     *
     * @param syncHzCustAccounts 客户账户
     * @return 客户账户集合
     */
    public List<SyncHzCustAccountsEO> selectSyncHzCustAccountsList(SyncHzCustAccountsEO syncHzCustAccounts);
}
