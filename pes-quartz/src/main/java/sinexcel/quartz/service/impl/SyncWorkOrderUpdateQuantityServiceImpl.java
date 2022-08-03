package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.quartz.domain.SyncPesWorkOrderUpdateMaterialQuantityEO;
import sinexcel.quartz.domain.SyncWorkOrderUpdateMaterialQuantityEO;
import sinexcel.quartz.domain.SyncWorkOrderUpdateQuantityEO;
import sinexcel.quartz.mapper.SyncPesWorkOrderUpdateMaterialQuantityMapper;
import sinexcel.quartz.mapper.SyncWorkOrderUpdateMaterialQuantityMapper;
import sinexcel.quartz.mapper.SyncWorkOrderUpdateQuantityMapper;
import sinexcel.quartz.service.ISyncWorkOrderUpdateQuantityService;

import java.util.List;

@Service
public class SyncWorkOrderUpdateQuantityServiceImpl implements ISyncWorkOrderUpdateQuantityService {

    @Autowired
    private SyncWorkOrderUpdateQuantityMapper syncWorkOrderUpdateQuantityMapper;

    @Autowired
    private SyncWorkOrderUpdateMaterialQuantityMapper syncWorkOrderUpdateMaterialQuantityMapper;


    @Autowired
    private SyncPesWorkOrderUpdateMaterialQuantityMapper syncPesWorkOrderUpdateMaterialQuantityMapper;


    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchSyncWorkOrderUpdateQuantityEO(List<SyncWorkOrderUpdateQuantityEO> list)
    {
        int batchCount =208;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                syncWorkOrderUpdateQuantityMapper.deleteSyncWorkOrderUpdateQuantityEO(list.subList(index, (batchLastIndex + 1)));
                syncWorkOrderUpdateQuantityMapper.batchSyncWorkOrderUpdateQuantityEO(list.subList(index, (batchLastIndex + 1)));
                syncWorkOrderUpdateQuantityMapper.updateSyncWorkOrderUpdateQuantityEO(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                syncWorkOrderUpdateQuantityMapper.deleteSyncWorkOrderUpdateQuantityEO(list.subList(index, (batchLastIndex + 1)));
                syncWorkOrderUpdateQuantityMapper.batchSyncWorkOrderUpdateQuantityEO(list.subList(index, (batchLastIndex + 1)));
                syncWorkOrderUpdateQuantityMapper.updateSyncWorkOrderUpdateQuantityEO(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchSyncWorkOrderUpdateMaterialQuantityEO(List<SyncWorkOrderUpdateMaterialQuantityEO> list)
    {
        int batchCount =348;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                syncWorkOrderUpdateMaterialQuantityMapper.deleteSyncWorkOrderUpdateMaterialQuantityEO(list.subList(index, (batchLastIndex + 1)));
                syncWorkOrderUpdateMaterialQuantityMapper.batchSyncWorkOrderUpdateMaterialQuantityEO(list.subList(index, (batchLastIndex + 1)));
                syncWorkOrderUpdateMaterialQuantityMapper.updateSyncWorkOrderUpdateMaterialQuantityEO(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                syncWorkOrderUpdateMaterialQuantityMapper.deleteSyncWorkOrderUpdateMaterialQuantityEO(list.subList(index, (batchLastIndex + 1)));
                syncWorkOrderUpdateMaterialQuantityMapper.batchSyncWorkOrderUpdateMaterialQuantityEO(list.subList(index, (batchLastIndex + 1)));
                syncWorkOrderUpdateMaterialQuantityMapper.updateSyncWorkOrderUpdateMaterialQuantityEO(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchSyncPesWorkOrderUpdateMaterialQuantityEO(List<SyncPesWorkOrderUpdateMaterialQuantityEO> list)
    {
        int batchCount =348;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                syncPesWorkOrderUpdateMaterialQuantityMapper.deleteSyncPesWorkOrderUpdateMaterialQuantityEO(list.subList(index, (batchLastIndex + 1)));
                syncPesWorkOrderUpdateMaterialQuantityMapper.batchSyncPesWorkOrderUpdateMaterialQuantityEO(list.subList(index, (batchLastIndex + 1)));
                syncPesWorkOrderUpdateMaterialQuantityMapper.updateSyncPesWorkOrderUpdateMaterialQuantityEO(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                syncPesWorkOrderUpdateMaterialQuantityMapper.deleteSyncPesWorkOrderUpdateMaterialQuantityEO(list.subList(index, (batchLastIndex + 1)));
                syncPesWorkOrderUpdateMaterialQuantityMapper.batchSyncPesWorkOrderUpdateMaterialQuantityEO(list.subList(index, (batchLastIndex + 1)));
                syncPesWorkOrderUpdateMaterialQuantityMapper.updateSyncPesWorkOrderUpdateMaterialQuantityEO(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }
}
