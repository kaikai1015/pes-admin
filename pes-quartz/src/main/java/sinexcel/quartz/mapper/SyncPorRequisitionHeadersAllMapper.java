package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncPorRequisitionHeadersAllEO;

import java.util.List;

public interface SyncPorRequisitionHeadersAllMapper {

    public int batchSyncPorRequisitionHeadersAllEO(List<SyncPorRequisitionHeadersAllEO> list);

    public int deleteSyncPorRequisitionHeadersAllEO(List<SyncPorRequisitionHeadersAllEO> list);
}
