package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncPerPersonNamesFEO;
import sinexcel.quartz.mapper.SyncPerPersonNamesFMapper;
import sinexcel.quartz.service.ISyncPerPersonNamesFService;

import java.util.List;

/**
 * 人员姓名Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-12-17
 */
@Service
public class SyncPerPersonNamesFServiceImpl implements ISyncPerPersonNamesFService {
    @Autowired
    private SyncPerPersonNamesFMapper syncPerPersonNamesFMapper;

    /**
     * 查询人员姓名列表
     *
     * @param syncPerPersonNamesF 人员姓名
     * @return 人员姓名
     */
    @Override
    public List<SyncPerPersonNamesFEO> selectSyncPerPersonNamesFList(SyncPerPersonNamesFEO syncPerPersonNamesF)
    {
        return syncPerPersonNamesFMapper.selectSyncPerPersonNamesFList(syncPerPersonNamesF);
    }
}
