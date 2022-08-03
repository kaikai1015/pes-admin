package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncPoInboundRcvQtyEO;

import java.util.List;

public interface SyncPoInboundRcvQtyMapper {
    public int batchSyncPoInboundRcvQtyEO(List<SyncPoInboundRcvQtyEO> list);

    public int deleteSyncPoInboundRcvQtyEO(List<SyncPoInboundRcvQtyEO> list);
}
