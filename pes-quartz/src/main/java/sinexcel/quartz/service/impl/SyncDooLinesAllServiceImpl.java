package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncDooLinesAllEO;
import sinexcel.quartz.mapper.SyncDooLinesAllEOMapper;
import sinexcel.quartz.service.ISyncDooLinesAllService;

import java.util.List;

/**
 * 订单行Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-12-22
 */
@Service
public class SyncDooLinesAllServiceImpl implements ISyncDooLinesAllService {

    @Autowired
    private SyncDooLinesAllEOMapper syncDooLinesAllMapper;

    /**
     * 查询订单行列表
     *
     * @param syncDooLinesAll 订单行
     * @return 订单行
     */
    @Override
    public List<SyncDooLinesAllEO> selectSyncDooLinesAllList(SyncDooLinesAllEO syncDooLinesAll)
    {
        return syncDooLinesAllMapper.selectSyncDooLinesAllList(syncDooLinesAll);
    }
}
