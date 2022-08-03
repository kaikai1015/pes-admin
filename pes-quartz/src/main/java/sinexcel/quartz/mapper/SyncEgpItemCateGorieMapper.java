package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncEgpItemCateGorieEO;

import java.util.List;

public interface SyncEgpItemCateGorieMapper {
    public int batchSyncEgpItemCateGorieEO(List<SyncEgpItemCateGorieEO> list);

    public int deleteSyncEgpItemCateGorieEO(List<SyncEgpItemCateGorieEO> list);
}
