package sinexcel.quartz.service;

import sinexcel.quartz.domain.SyncWieWorkOrdersBEO;

import java.util.List;

/**
 * 工单信息数据Service接口
 *
 * @author Zhang Kai
 * @date 2020-12-17
 */
public interface ISyncWieWorkOrdersBService  {
    /**
     * 查询工单信息数据列表
     *
     * @param syncWieWorkOrdersB 工单信息数据
     * @return 工单信息数据集合
     */
    public List<SyncWieWorkOrdersBEO> selectSyncWieWorkOrdersBList(SyncWieWorkOrdersBEO syncWieWorkOrdersB);
}
