package sinexcel.quartz.service;


import sinexcel.quartz.domain.SyncDooLinesAllEO;

import java.util.List;

/**
 * 订单行Service接口
 *
 * @author Zhang Kai
 * @date 2020-12-22
 */
public interface ISyncDooLinesAllService {

    /**
     * 查询订单行列表
     *
     * @param syncDooLinesAll 订单行
     * @return 订单行集合
     */
    public List<SyncDooLinesAllEO> selectSyncDooLinesAllList(SyncDooLinesAllEO syncDooLinesAll);
}
