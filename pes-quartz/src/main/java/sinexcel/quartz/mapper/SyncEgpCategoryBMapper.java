package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncEgpCategoryBEO;

import java.util.List;

public interface SyncEgpCategoryBMapper {
    public int batchSyncEgpCategoryBEO(List<SyncEgpCategoryBEO> list);

    public int deleteSyncEgpCategoryBEO(List<SyncEgpCategoryBEO> list);
}
