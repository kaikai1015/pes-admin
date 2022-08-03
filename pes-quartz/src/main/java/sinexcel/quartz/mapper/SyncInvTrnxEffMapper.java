package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncInvTrnxEffEO;

import java.util.List;

public interface SyncInvTrnxEffMapper {

    public int deleteSyncInvTrnxEffLis();

    public int batchSyncInvTrnxEffLis(List<SyncInvTrnxEffEO> list);

    public List<SyncInvTrnxEffEO> selectSyncInvTrnxEffList(SyncInvTrnxEffEO syncInvTrnxEff);
}
