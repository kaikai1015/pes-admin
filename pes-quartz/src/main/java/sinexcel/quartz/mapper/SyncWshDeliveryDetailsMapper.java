package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncWshDeliveryDetailsEO;

import java.util.List;

public interface SyncWshDeliveryDetailsMapper {
    public int batchSyncWshDeliveryDetailsEO(List<SyncWshDeliveryDetailsEO> list);

    public int deleteSyncWshDeliveryDetailsEO(List<SyncWshDeliveryDetailsEO> list);
}
