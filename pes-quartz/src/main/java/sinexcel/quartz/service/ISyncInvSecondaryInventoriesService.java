package sinexcel.quartz.service;


import sinexcel.quartz.domain.SyncInvSecondaryInventoriesEO;

import java.util.List;

/**
 * 库存库位信息Service接口
 *
 * @author Zhang Kai
 * @date 2020-12-15
 */
public interface ISyncInvSecondaryInventoriesService {
    /**
     * 查询库存库位信息列表
     *
     * @param syncInvSecondaryInventories 库存库位信息
     * @return 库存库位信息集合
     */
    public List<SyncInvSecondaryInventoriesEO> selectSyncInvSecondaryInventoriesList(SyncInvSecondaryInventoriesEO syncInvSecondaryInventories);
}
