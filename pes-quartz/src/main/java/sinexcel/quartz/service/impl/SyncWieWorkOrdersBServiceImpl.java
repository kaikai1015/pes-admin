package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.quartz.domain.SyncWieWorkOrdersBEO;
import sinexcel.quartz.mapper.SyncWieWorkOrdersBMapper;
import sinexcel.quartz.service.ISyncWieWorkOrdersBService;

import java.util.List;

/**
 * 工单信息数据Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-12-17
 */
@Service
public class SyncWieWorkOrdersBServiceImpl implements ISyncWieWorkOrdersBService {

    @Autowired
    private SyncWieWorkOrdersBMapper syncWieWorkOrdersBMapper;

    /**
     * 查询工单信息数据列表
     *
     * @param syncWieWorkOrdersB 工单信息数据
     * @return 工单信息数据
     */
    @Override
    public List<SyncWieWorkOrdersBEO> selectSyncWieWorkOrdersBList(SyncWieWorkOrdersBEO syncWieWorkOrdersB)
    {
        return syncWieWorkOrdersBMapper.selectSyncWieWorkOrdersBList(syncWieWorkOrdersB);
    }
}
