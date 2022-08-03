package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncHzPartiesEO;

import java.util.List;

public interface SyncHzPartiesMapper {
    public int batchSyncHzPartiesEO(List<SyncHzPartiesEO> list);

    public int deleteSyncHzPartiesEO(List<SyncHzPartiesEO> list);

    /**
     * 查询供应商信息列表
     *
     * @param syncHzParties 供应商信息
     * @return 供应商信息集合
     */
    public List<SyncHzPartiesEO> selectSyncHzPartiesList(SyncHzPartiesEO syncHzParties);
}
