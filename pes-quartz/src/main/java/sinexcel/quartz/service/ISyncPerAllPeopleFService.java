package sinexcel.quartz.service;


import sinexcel.quartz.domain.SyncPerAllPeopleFEO;

import java.util.List;

/**
 * 人员编码信息Service接口
 *
 * @author Zhang Kai
 * @date 2020-12-17
 */
public interface ISyncPerAllPeopleFService {
    /**
     * 查询人员编码信息列表
     *
     * @param syncPerAllPeopleF 人员编码信息
     * @return 人员编码信息集合
     */
    public List<SyncPerAllPeopleFEO> selectSyncPerAllPeopleFList(SyncPerAllPeopleFEO syncPerAllPeopleF);
}
