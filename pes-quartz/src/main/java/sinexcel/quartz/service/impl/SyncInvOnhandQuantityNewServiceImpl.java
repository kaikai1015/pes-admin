package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.quartz.domain.SyncInvOnhandQuantityNewEO;
import sinexcel.quartz.mapper.SyncInvOnhandQuantityNewMapper;
import sinexcel.quartz.service.ISyncInvOnhandQuantityNewService;

import java.util.List;

/**
 * 库存事务处理明细Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-12-31
 */
@Service
public class SyncInvOnhandQuantityNewServiceImpl implements ISyncInvOnhandQuantityNewService {
    @Autowired
    private SyncInvOnhandQuantityNewMapper syncInvOnhandQuantityNewMapper;

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchInsertDeleteSyncInvOnhandQuantityNewTempEO(List<SyncInvOnhandQuantityNewEO> list)
    {
        syncInvOnhandQuantityNewMapper.deleteSyncInvOnhandQuantityNewTempEO();
        int batchCount =697;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                syncInvOnhandQuantityNewMapper.batchSyncInvOnhandQuantityNewTempEO(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                syncInvOnhandQuantityNewMapper.batchSyncInvOnhandQuantityNewTempEO(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
        syncInvOnhandQuantityNewMapper.batchSyncInvOnhandQuantityNewEO();
    }
}
