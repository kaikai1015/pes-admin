package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncPerAllPeopleFEO;

import java.util.List;

public interface SyncPerAllPeopleFMapper {
    public int batchSyncPerAllPeopleFEO(List<SyncPerAllPeopleFEO> list);

    public int deleteSyncPerAllPeopleFEO(List<SyncPerAllPeopleFEO> list);

    /**
     * 查询人员编码信息列表
     *
     * @param syncPerAllPeopleF 人员编码信息
     * @return 人员编码信息集合
     */
    public List<SyncPerAllPeopleFEO> selectSyncPerAllPeopleFList(SyncPerAllPeopleFEO syncPerAllPeopleF);
}
