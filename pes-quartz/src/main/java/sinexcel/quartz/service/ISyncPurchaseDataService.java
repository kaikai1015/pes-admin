package sinexcel.quartz.service;

import sinexcel.quartz.domain.SyncPoHeadersAllEO;
import sinexcel.quartz.domain.SyncPoLineLocationsAllEO;
import sinexcel.quartz.domain.SyncPoLinesAllEO;

import java.util.List;

public interface ISyncPurchaseDataService {
    void batchSyncPoHeadersAllEO(List<SyncPoHeadersAllEO> list);

    void batchSyncPoLinesAllEO(List<SyncPoLinesAllEO> list);

    void batchSyncPoLinesLocationAllEO(List<SyncPoLineLocationsAllEO> list);
}
