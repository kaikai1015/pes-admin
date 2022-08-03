package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncPorRequisitionLinesAllEO;

import java.util.List;

public interface SyncPorRequisitionLinesAllMapper {

    public int batchSyncPorRequisitionLinesAllEO(List<SyncPorRequisitionLinesAllEO> list);

    public int deleteSyncPorRequisitionLinesAllEO(List<SyncPorRequisitionLinesAllEO> list);
}
