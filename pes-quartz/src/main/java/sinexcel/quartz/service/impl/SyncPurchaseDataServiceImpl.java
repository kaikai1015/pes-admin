package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.quartz.domain.SyncPoLineLocationsAllEO;
import sinexcel.quartz.domain.SyncPoLinesAllEO;
import sinexcel.quartz.mapper.SyncPoHeadersAllMapper;
import sinexcel.quartz.mapper.SyncPoLinesAllMapper;
import sinexcel.quartz.mapper.SyncPoLineLocationsAllMapper;
import sinexcel.quartz.domain.SyncPoHeadersAllEO;
import sinexcel.quartz.service.ISyncPurchaseDataService;

import java.util.List;

@Service
public class SyncPurchaseDataServiceImpl implements ISyncPurchaseDataService {

    @Autowired
    private SyncPoHeadersAllMapper syncPoHeadersAllMapper;

    @Autowired
    private SyncPoLinesAllMapper syncPoLinesAllMapper;

    @Autowired
    private SyncPoLineLocationsAllMapper syncPoLineLocationsAllMapper;

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchSyncPoHeadersAllEO(List<SyncPoHeadersAllEO> list)
    {
        int batchCount =190;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                syncPoHeadersAllMapper.deleteSyncPoHeadersAllEO(list.subList(index, (batchLastIndex + 1)));
                syncPoHeadersAllMapper.batchSyncPoHeadersAllEO(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                syncPoHeadersAllMapper.deleteSyncPoHeadersAllEO(list.subList(index, (batchLastIndex + 1)));
                syncPoHeadersAllMapper.batchSyncPoHeadersAllEO(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchSyncPoLinesAllEO(List<SyncPoLinesAllEO> list)
    {
        int batchCount =161;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                syncPoLinesAllMapper.deleteSyncPoLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                syncPoLinesAllMapper.batchSyncPoLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                syncPoLinesAllMapper.deleteSyncPoLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                syncPoLinesAllMapper.batchSyncPoLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchSyncPoLinesLocationAllEO(List<SyncPoLineLocationsAllEO> list)
    {
        int batchCount =70;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                syncPoLineLocationsAllMapper.deleteSyncPoLinesLocationAllEO(list.subList(index, (batchLastIndex + 1)));
                syncPoLineLocationsAllMapper.batchSyncPoLinesLocationAllEO(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                syncPoLineLocationsAllMapper.deleteSyncPoLinesLocationAllEO(list.subList(index, (batchLastIndex + 1)));
                syncPoLineLocationsAllMapper.batchSyncPoLinesLocationAllEO(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }
}
