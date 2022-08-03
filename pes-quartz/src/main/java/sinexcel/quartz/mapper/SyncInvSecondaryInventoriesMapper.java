package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncInvSecondaryInventoriesEO;

import java.util.List;

public interface SyncInvSecondaryInventoriesMapper {
    public int batchSyncInvSecondaryInventoriesEO(List<SyncInvSecondaryInventoriesEO> list);

    public int deleteSyncInvSecondaryInventoriesEO(List<SyncInvSecondaryInventoriesEO> list);

    /**
     * 查询库存库位信息列表
     *
     * @param syncInvSecondaryInventories 库存库位信息
     * @return 库存库位信息集合
     */
    public List<SyncInvSecondaryInventoriesEO> selectSyncInvSecondaryInventoriesList(SyncInvSecondaryInventoriesEO syncInvSecondaryInventories);
}
