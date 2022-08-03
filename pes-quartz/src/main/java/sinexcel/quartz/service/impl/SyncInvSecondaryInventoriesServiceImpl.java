package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncInvSecondaryInventoriesEO;
import sinexcel.quartz.mapper.SyncInvSecondaryInventoriesMapper;
import sinexcel.quartz.service.ISyncInvSecondaryInventoriesService;

import java.util.List;

/**
 * 库存库位信息Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-12-15
 */
@Service
public class SyncInvSecondaryInventoriesServiceImpl implements ISyncInvSecondaryInventoriesService
{
    @Autowired
    private SyncInvSecondaryInventoriesMapper syncInvSecondaryInventoriesMapper;

    /**
     * 查询库存库位信息列表
     *
     * @param syncInvSecondaryInventories 库存库位信息
     * @return 库存库位信息
     */
    @Override
    public List<SyncInvSecondaryInventoriesEO> selectSyncInvSecondaryInventoriesList(SyncInvSecondaryInventoriesEO syncInvSecondaryInventories)
    {
        return syncInvSecondaryInventoriesMapper.selectSyncInvSecondaryInventoriesList(syncInvSecondaryInventories);
    }
}
