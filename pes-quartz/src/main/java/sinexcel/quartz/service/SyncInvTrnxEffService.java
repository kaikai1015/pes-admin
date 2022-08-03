package sinexcel.quartz.service;

import sinexcel.quartz.domain.SyncInvTrnxEffEO;

import java.util.List;

public interface SyncInvTrnxEffService {
    public List<SyncInvTrnxEffEO> selectSyncInvTrnxEffList(SyncInvTrnxEffEO syncInvTrnxEff);
}
