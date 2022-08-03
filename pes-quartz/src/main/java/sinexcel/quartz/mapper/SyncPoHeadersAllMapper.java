package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncPoHeadersAllEO;

import java.util.List;

public interface SyncPoHeadersAllMapper {
    public int batchSyncPoHeadersAllEO(List<SyncPoHeadersAllEO> list);

    public int deleteSyncPoHeadersAllEO(List<SyncPoHeadersAllEO> list);

    /**
     * 查询PO头信息列表
     *
     * @param syncPoHeadersAll PO头信息
     * @return PO头信息集合
     */
    public List<SyncPoHeadersAllEO> selectSyncPoHeadersAllList(SyncPoHeadersAllEO syncPoHeadersAll);
}
