package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncWieWoStatusHistoryEO;

import java.util.List;

public interface SyncWieWoStatusHistoryMapper {

    void deleteSyncWieWoStatusHistoryEO(List<SyncWieWoStatusHistoryEO> list);

    void batchSyncWieWoStatusHistoryEO(List<SyncWieWoStatusHistoryEO> list);
}
