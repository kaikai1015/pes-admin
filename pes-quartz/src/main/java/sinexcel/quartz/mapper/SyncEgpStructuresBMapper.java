package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncEgpStructuresB;

import java.util.List;

public interface SyncEgpStructuresBMapper {
    /**
     * 批量新增SyncEgpStructuresBEO信息
     *
     * @param list 列表
     * @return 结果
     */
    public int batchSyncEgpStructuresB(List<SyncEgpStructuresB> list);

    public int deleteSyncEgpStructuresBByIds(List<SyncEgpStructuresB> list);
}
