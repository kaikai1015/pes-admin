package sinexcel.quartz.service;

import sinexcel.quartz.domain.SyncDooOrderDataListEO;

import java.util.List;

public interface ISyncDooOrderDataListService {
    int insertSyncDooOrderDataList(List<SyncDooOrderDataListEO> list);

    List<SyncDooOrderDataListEO> selectSyncDooOrderDataListList(SyncDooOrderDataListEO syncDooOrderDataList);
}
