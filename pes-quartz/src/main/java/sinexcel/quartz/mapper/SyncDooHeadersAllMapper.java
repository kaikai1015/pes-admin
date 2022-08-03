package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncDooHeadersAllEO;

import java.util.List;

public interface SyncDooHeadersAllMapper {

    public int batchSyncDooHeadersAllEO(List<SyncDooHeadersAllEO> list);

    public int deleteSyncDooHeadersAllEO(List<SyncDooHeadersAllEO> list);

    /**
     * 查询订单头列表
     *
     * @param syncDooHeadersAll 订单头
     * @return 订单头集合
     */
    public List<SyncDooHeadersAllEO> selectSyncDooHeadersAllList(SyncDooHeadersAllEO syncDooHeadersAll);
}
