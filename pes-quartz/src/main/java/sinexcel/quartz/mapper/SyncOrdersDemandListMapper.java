package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncOrdersDemandListEO;

import java.util.List;

public interface SyncOrdersDemandListMapper {
    public int batchSyncOrdersDemandList(List<SyncOrdersDemandListEO> list);

    public int addOrdersDemandsList(Long planLotNum);

    public int addOrdersDemandsMpsList(Long planLotNum);

    public int addOrdersDemandsMrpList(Long planLotNum);
}
