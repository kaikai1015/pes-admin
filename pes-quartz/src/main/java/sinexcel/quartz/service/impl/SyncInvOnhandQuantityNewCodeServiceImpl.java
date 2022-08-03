package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.quartz.domain.SyncInvOnhandQuantityNewCodeEO;
import sinexcel.quartz.mapper.SyncInvOnhandQuantityNewCodeMapper;
import sinexcel.quartz.service.ISyncInvOnhandQuantityNewCodeService;

import java.util.List;

/**
 * 库存事务处理明细Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-12-31
 */
@Service
public class SyncInvOnhandQuantityNewCodeServiceImpl implements ISyncInvOnhandQuantityNewCodeService {
    @Autowired
    private SyncInvOnhandQuantityNewCodeMapper syncInvOnhandQuantityNewCodeMapper;

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchInsertDeleteSyncInvOnhandQuantityNewCodeTempEO(List<SyncInvOnhandQuantityNewCodeEO> list)
    {
        syncInvOnhandQuantityNewCodeMapper.deleteSyncInvOnhandQuantityNewCodeTempEO();
        int batchCount =348;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                syncInvOnhandQuantityNewCodeMapper.batchSyncInvOnhandQuantityNewCodeTempEO(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                syncInvOnhandQuantityNewCodeMapper.batchSyncInvOnhandQuantityNewCodeTempEO(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
        syncInvOnhandQuantityNewCodeMapper.batchSyncInvOnhandQuantityNewCodeEO();
    }
}
