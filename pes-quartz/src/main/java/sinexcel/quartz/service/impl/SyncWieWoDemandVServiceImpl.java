package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncWieWoDemandVEO;
import sinexcel.quartz.mapper.SyncWieWoDemandVMapper;
import sinexcel.quartz.service.ISyncWieWoDemandVService;

import java.util.List;

/**
 * 工单行信息Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-12-17
 */
@Service
public class SyncWieWoDemandVServiceImpl implements ISyncWieWoDemandVService {

    @Autowired
    private SyncWieWoDemandVMapper syncWieWoDemandVMapper;

    /**
     * 查询工单行信息列表
     *
     * @param syncWieWoDemandV 工单行信息
     * @return 工单行信息
     */
    @Override
    public List<SyncWieWoDemandVEO> selectSyncWieWoDemandVList(SyncWieWoDemandVEO syncWieWoDemandV)
    {
        return syncWieWoDemandVMapper.selectSyncWieWoDemandVList(syncWieWoDemandV);
    }
}
