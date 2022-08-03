package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncDooFulfillLinesAllEO;

import java.util.List;

public interface SyncDooFulfillLinesAllMapper {

    public int batchSyncDooFulfillLinesAllEO(List<SyncDooFulfillLinesAllEO> list);

    public int deleteSyncDooFulfillLinesAllEO(List<SyncDooFulfillLinesAllEO> list);
}
