package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncDooOrderDataListEO;

import java.util.List;

public interface SyncDooOrderDataListMapper {
    int deleteSyncDooOrderDataListTempEO(List<SyncDooOrderDataListEO> list);

    int batchSyncDooOrderDataListTempEO(List<SyncDooOrderDataListEO> syncDooOrderDataListEOS);

    int deleteSyncDooOrderDataListEO(List<SyncDooOrderDataListEO> list);

    List<SyncDooOrderDataListEO> selectSyncDooOrderDataListList(SyncDooOrderDataListEO syncDooOrderDataList);
}
