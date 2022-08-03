package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncEgpSystemItemsBEO;

import java.util.List;

public interface SyncEgpSystemItemsBMapper {

    /**
     * 批量新增SyncEgpSystemItemsBEO信息
     *
     * @param list 列表
     * @return 结果
     */
    public int batchSyncEgpSystemItemsB(List<SyncEgpSystemItemsBEO> list);

    public int deletebatchSyncEgpSystemItemsB(List<SyncEgpSystemItemsBEO> list);
}
