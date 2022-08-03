package sinexcel.quartz.service;


import sinexcel.quartz.domain.SyncDooHeadersAllEO;

import java.util.List;

/**
 * 订单头Service接口
 *
 * @author Zhang Kai
 * @date 2020-12-22
 */
public interface ISyncDooHeadersAllService {

    /**
     * 查询订单头列表
     *
     * @param syncDooHeadersAll 订单头
     * @return 订单头集合
     */
    public List<SyncDooHeadersAllEO> selectSyncDooHeadersAllList(SyncDooHeadersAllEO syncDooHeadersAll);
}
