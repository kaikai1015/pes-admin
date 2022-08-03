package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncPoHeadersAllEO;
import sinexcel.quartz.mapper.SyncPoHeadersAllMapper;
import sinexcel.quartz.service.ISyncPoHeadersAllService;

import java.util.List;

/**
 * PO头信息Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-12-21
 */
@Service
public class SyncPoHeadersAllServiceImpl implements ISyncPoHeadersAllService {

    @Autowired
    private SyncPoHeadersAllMapper syncPoHeadersAllMapper;

    /**
     * 查询PO头信息列表
     *
     * @param syncPoHeadersAll PO头信息
     * @return PO头信息
     */
    @Override
    public List<SyncPoHeadersAllEO> selectSyncPoHeadersAllList(SyncPoHeadersAllEO syncPoHeadersAll)
    {
        return syncPoHeadersAllMapper.selectSyncPoHeadersAllList(syncPoHeadersAll);
    }
}
