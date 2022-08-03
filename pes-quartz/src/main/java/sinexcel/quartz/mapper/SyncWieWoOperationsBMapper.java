package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncWieWoOperationsBEO;

import java.util.List;

/**
 * 工单工序操作信息Mapper接口
 *
 * @author Zhang Kai
 * @date 2021-02-24
 */
public interface SyncWieWoOperationsBMapper {

    public int batchSyncWieWoOperationsBEO(List<SyncWieWoOperationsBEO> list);

    public int deleteSyncWieWoOperationsBEO(List<SyncWieWoOperationsBEO> list);
}
