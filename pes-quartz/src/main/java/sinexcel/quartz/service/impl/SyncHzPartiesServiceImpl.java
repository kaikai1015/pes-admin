package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncHzPartiesEO;
import sinexcel.quartz.mapper.SyncHzPartiesMapper;
import sinexcel.quartz.service.ISyncHzPartiesService;

import java.util.List;

/**
 * 供应商信息Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-12-15
 */
@Service
public class SyncHzPartiesServiceImpl implements ISyncHzPartiesService
{
    @Autowired
    private SyncHzPartiesMapper syncHzPartiesMapper;

    /**
     * 查询供应商信息列表
     *
     * @param syncHzParties 供应商信息
     * @return 供应商信息
     */
    @Override
    public List<SyncHzPartiesEO> selectSyncHzPartiesList(SyncHzPartiesEO syncHzParties)
    {
        return syncHzPartiesMapper.selectSyncHzPartiesList(syncHzParties);
    }
}
