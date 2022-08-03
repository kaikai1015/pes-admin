package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncWieWoDemandVEO;

import java.util.List;

public interface SyncWieWoDemandVMapper {

    public int batchSyncWieWoDemandVTempEO(List<SyncWieWoDemandVEO> list);

    public int deleteSyncWieWoDemandVTempEO(List<SyncWieWoDemandVEO> list);

//    public int batchSyncWieWoDemandVEO(List<SyncWieWoDemandVEO> list);

    public int deleteSyncWieWoDemandVEO(List<SyncWieWoDemandVEO> list);

    /**
     * 查询工单行信息列表
     *
     * @param syncWieWoDemandV 工单行信息
     * @return 工单行信息集合
     */
    public List<SyncWieWoDemandVEO> selectSyncWieWoDemandVList(SyncWieWoDemandVEO syncWieWoDemandV);
}
