package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncWisWorkDefinitionsIdEO;

import java.util.List;

public interface SyncWisWorkDefinitionsIdMapper {
    public int batchSyncWisWorkDefinitionsIdTempEO(List<SyncWisWorkDefinitionsIdEO> list);

    public int deleteSyncWisWorkDefinitionsIdTempEO();


    public int batchSyncWisWorkDefinitionsIdEO();
}
