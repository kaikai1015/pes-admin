package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncPoLinesAllEO;
import sinexcel.quartz.mapper.SyncPoLinesAllMapper;
import sinexcel.quartz.service.ISyncPoLinesAllService;

import java.util.List;

/**
 * PO行信息Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-12-21
 */
@Service
public class SyncPoLinesAllServiceImpl implements ISyncPoLinesAllService {

    @Autowired
    private SyncPoLinesAllMapper syncPoLinesAllMapper;

    /**
     * 查询PO行信息列表
     *
     * @param syncPoLinesAll PO行信息
     * @return PO行信息
     */
    @Override
    public List<SyncPoLinesAllEO> selectSyncPoLinesAllList(SyncPoLinesAllEO syncPoLinesAll)
    {
        return syncPoLinesAllMapper.selectSyncPoLinesAllList(syncPoLinesAll);
    }
}
