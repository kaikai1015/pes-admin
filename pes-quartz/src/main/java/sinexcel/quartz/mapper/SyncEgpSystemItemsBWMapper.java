package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncEgpSystemItemsWEO;

import java.util.List;

public interface SyncEgpSystemItemsBWMapper {

    public int batchSyncEgpSystemItemsWEO(List<SyncEgpSystemItemsWEO> list);

    public int deletebatchSyncEgpSystemItemsWEO(List<SyncEgpSystemItemsWEO> list);
}
