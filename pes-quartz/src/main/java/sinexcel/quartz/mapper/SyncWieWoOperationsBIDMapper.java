package sinexcel.quartz.mapper;


import sinexcel.quartz.domain.SyncWieWoOperationsBIDEO;

import java.util.List;

/**
 * 工单工序操作信息Mapper接口
 *
 * @author Zhang Kai
 * @date 2021-02-24
 */
public interface SyncWieWoOperationsBIDMapper {

    public int batchSyncWieWoOperationsBIdTempEO(List<SyncWieWoOperationsBIDEO> list);

    public int deleteSyncWieWoOperationsBIdTempEO();

    public int batchSyncWieWoOperationsBIdEO();
}
