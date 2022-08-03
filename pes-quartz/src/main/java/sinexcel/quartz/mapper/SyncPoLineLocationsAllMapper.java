package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncPoLineLocationsAllEO;

import java.util.List;

public interface SyncPoLineLocationsAllMapper {
    int deleteSyncPoLinesLocationAllEO(List<SyncPoLineLocationsAllEO> list);

    int batchSyncPoLinesLocationAllEO(List<SyncPoLineLocationsAllEO> list);
}
