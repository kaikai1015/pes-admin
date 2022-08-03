package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncWisWorkDefinitionsEO;

import java.util.List;

public interface SyncWisWorkDefinitionsMapper {
    public int batchSyncWisWorkDefinitionsEO(List<SyncWisWorkDefinitionsEO> list);

    public int deleteSyncWisWorkDefinitionsEO(List<SyncWisWorkDefinitionsEO> list);
}
