package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncWieWorkOrdersBEO;

import java.util.List;

public interface SyncWieWorkOrdersBMapper {

    public int batchSyncWieWorkOrdersBEO(List<SyncWieWorkOrdersBEO> list);

    public int deleteSyncWieWorkOrdersBEO(List<SyncWieWorkOrdersBEO> list);

    /**
     * 查询工单信息数据列表
     *
     * @param syncWieWorkOrdersB 工单信息数据
     * @return 工单信息数据集合
     */
    public List<SyncWieWorkOrdersBEO> selectSyncWieWorkOrdersBList(SyncWieWorkOrdersBEO syncWieWorkOrdersB);
}
