package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.quartz.domain.SyncDooOrderDataListEO;
import sinexcel.quartz.mapper.SyncDooOrderDataListMapper;
import sinexcel.quartz.service.ISyncDooOrderDataListService;

import java.util.List;

@Service
public class SyncDooOrderDataListServiceImpl implements ISyncDooOrderDataListService
{
    @Autowired
    private SyncDooOrderDataListMapper syncDooOrderDataListMapper;
    /**
     * 新增MRP计算计划员查看订单信息
     *
     * @param syncDooOrderDataList MRP计算计划员查看订单信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int insertSyncDooOrderDataList(List<SyncDooOrderDataListEO> list)
    {
        syncDooOrderDataListMapper.deleteSyncDooOrderDataListTempEO(list);
            int batchCount =53;//每批处理的条数
            int batchLastIndex = batchCount - 1;// 每批最后一个的下标
            for (int index = 0; index < list.size();) {
                if (batchLastIndex > (list.size() - 1)) {
                    batchLastIndex = list.size() - 1;
                    syncDooOrderDataListMapper.batchSyncDooOrderDataListTempEO(list.subList(index, (batchLastIndex + 1)));
                    break;// 数据插入完毕,退出循环
                }else {
                    syncDooOrderDataListMapper.batchSyncDooOrderDataListTempEO(list.subList(index, (batchLastIndex + 1)));
                    index = batchLastIndex + 1;// 设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
        return syncDooOrderDataListMapper.deleteSyncDooOrderDataListEO(list);
    }

    /**
     * 查询MRP计算计划员查看订单信息列表
     *
     * @param syncDooOrderDataList MRP计算计划员查看订单信息
     * @return MRP计算计划员查看订单信息
     */
    @Override
    public List<SyncDooOrderDataListEO> selectSyncDooOrderDataListList(SyncDooOrderDataListEO syncDooOrderDataList)
    {
        return syncDooOrderDataListMapper.selectSyncDooOrderDataListList(syncDooOrderDataList);
    }
}
