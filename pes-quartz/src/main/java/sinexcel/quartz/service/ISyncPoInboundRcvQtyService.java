package sinexcel.quartz.service;

import sinexcel.quartz.domain.SyncPoInboundRcvQtyEO;

import java.util.List;

public interface ISyncPoInboundRcvQtyService {
    void batchInsertDeleteSyncPoInboundRcvQtyEO(List<SyncPoInboundRcvQtyEO> list);
}
