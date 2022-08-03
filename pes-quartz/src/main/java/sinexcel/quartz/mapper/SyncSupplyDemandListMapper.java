package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncSupplyDemandList;

import java.util.List;

public interface SyncSupplyDemandListMapper {

    public int batchSyncSupplyDemandListTemp(List<SyncSupplyDemandList> list);

    public int deleteSyncSupplyDemandListTemp();

    public int batchSyncSupplyDemandHeaderList();

    public int batchSyncSupplyDemandQuantity();

    public int deleteSyncSupplyDemandList();
}
