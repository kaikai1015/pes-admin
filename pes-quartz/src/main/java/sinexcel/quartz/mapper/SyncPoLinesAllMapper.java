package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncPoLinesAllEO;

import java.util.List;

public interface SyncPoLinesAllMapper {

    public int batchSyncPoLinesAllEO(List<SyncPoLinesAllEO> list);

    public int deleteSyncPoLinesAllEO(List<SyncPoLinesAllEO> list);

    /**
     * 查询PO行信息列表
     *
     * @param syncPoLinesAll PO行信息
     * @return PO行信息集合
     */
    public List<SyncPoLinesAllEO> selectSyncPoLinesAllList(SyncPoLinesAllEO syncPoLinesAll);
}
