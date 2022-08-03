package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncCstCostedVuCostsVEO;

import java.util.List;

public interface SyncCstCostedVuCostsVMapper {
    public int batchSyncCstCostedVuCostsVEO(List<SyncCstCostedVuCostsVEO> list);

    public int deleteSyncCstCostedVuCostsVEO();

    public int insertSyncCstCostedVuCostsVEO();
}
