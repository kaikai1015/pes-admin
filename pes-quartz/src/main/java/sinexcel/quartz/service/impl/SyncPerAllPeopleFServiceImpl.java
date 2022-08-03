package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncPerAllPeopleFEO;
import sinexcel.quartz.mapper.SyncPerAllPeopleFMapper;
import sinexcel.quartz.service.ISyncPerAllPeopleFService;

import java.util.List;

/**
 * 人员编码信息Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-12-17
 */
@Service
public class SyncPerAllPeopleFServiceImpl implements ISyncPerAllPeopleFService {
    @Autowired
    private SyncPerAllPeopleFMapper syncPerAllPeopleFMapper;
    /**
     * 查询人员编码信息列表
     *
     * @param syncPerAllPeopleF 人员编码信息
     * @return 人员编码信息
     */
    @Override
    public List<SyncPerAllPeopleFEO> selectSyncPerAllPeopleFList(SyncPerAllPeopleFEO syncPerAllPeopleF)
    {
        return syncPerAllPeopleFMapper.selectSyncPerAllPeopleFList(syncPerAllPeopleF);
    }
}
