package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncDooLinesAllEO;

import java.util.List;

public interface SyncDooLinesAllEOMapper {

    public int batchSyncDooLinesAllEO(List<SyncDooLinesAllEO> list);

    public int deleteSyncDooLinesAllEO(List<SyncDooLinesAllEO> list);

    /**
     * 查询订单行列表
     *
     * @param syncDooLinesAll 订单行
     * @return 订单行集合
     */
    public List<SyncDooLinesAllEO> selectSyncDooLinesAllList(SyncDooLinesAllEO syncDooLinesAll);
}
