package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncDooHeadersAllEO;
import sinexcel.quartz.mapper.SyncDooHeadersAllMapper;
import sinexcel.quartz.service.ISyncDooHeadersAllService;

import java.util.List;

/**
 * 订单头Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-12-22
 */
@Service
public class SyncDooHeadersAllServiceImpl implements ISyncDooHeadersAllService {

    @Autowired
    private SyncDooHeadersAllMapper syncDooHeadersAllMapper;

    /**
     * 查询订单头列表
     *
     * @param syncDooHeadersAll 订单头
     * @return 订单头
     */
    @Override
    public List<SyncDooHeadersAllEO> selectSyncDooHeadersAllList(SyncDooHeadersAllEO syncDooHeadersAll)
    {
        return syncDooHeadersAllMapper.selectSyncDooHeadersAllList(syncDooHeadersAll);
    }
}
