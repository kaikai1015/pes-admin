package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncBomItemDataLisEO;

import java.util.List;

public interface SyncBomItemDataLisMapper {
    public int deleteSyncItemNumsDescLis(List<SyncBomItemDataLisEO> list);


    public int batchSyncBomItemDataLis(List<SyncBomItemDataLisEO> list);
}
