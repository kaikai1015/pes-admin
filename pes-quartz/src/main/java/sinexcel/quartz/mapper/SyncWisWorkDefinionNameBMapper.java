package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncWisWorkDefinionNameBEO;

import java.util.List;

public interface SyncWisWorkDefinionNameBMapper {

    public int batchSyncWisWorkDefinionNameEO(List<SyncWisWorkDefinionNameBEO> list);

    public int deleteSyncWisWorkDefinionNameEO(List<SyncWisWorkDefinionNameBEO> list);
}
