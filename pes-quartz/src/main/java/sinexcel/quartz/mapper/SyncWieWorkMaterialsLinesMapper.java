package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncWieWorkMaterialsLinesEO;

import java.util.List;

public interface SyncWieWorkMaterialsLinesMapper {

    public int batchSyncWieWorkMaterialsLinesEO(List<SyncWieWorkMaterialsLinesEO> list);

    public int deleteSyncWieWorkMaterialsLinesEO();

    public int batchPesWieWorkMaterialsLines();
}
