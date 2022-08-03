package sinexcel.quartz.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncInvTrnxEffEO;
import sinexcel.quartz.mapper.SyncInvTrnxEffMapper;
import sinexcel.quartz.service.SyncInvTrnxEffService;

import java.util.List;

@Service
public class SyncInvTrnxEffServiceImpl implements SyncInvTrnxEffService {

    @Autowired
    private SyncInvTrnxEffMapper syncInvTrnxEffMapper;

    @Override
    public List<SyncInvTrnxEffEO> selectSyncInvTrnxEffList(SyncInvTrnxEffEO syncInvTrnxEff)
    {
        return syncInvTrnxEffMapper.selectSyncInvTrnxEffList(syncInvTrnxEff);
    }
}
