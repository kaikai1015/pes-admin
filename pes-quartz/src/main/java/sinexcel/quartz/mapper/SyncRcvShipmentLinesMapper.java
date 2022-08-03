package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncRcvShipmentLinesEO;

import java.util.List;

public interface SyncRcvShipmentLinesMapper {

    public int batchSyncRcvShipmentLinesEO(List<SyncRcvShipmentLinesEO> list);

    public int deleteSyncRcvShipmentLinesEO(List<SyncRcvShipmentLinesEO> list);
}
