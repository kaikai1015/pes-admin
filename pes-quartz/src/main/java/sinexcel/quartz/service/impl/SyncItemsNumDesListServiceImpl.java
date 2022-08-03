package sinexcel.quartz.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.quartz.domain.SyncBomItemDataLisEO;
import sinexcel.quartz.domain.SyncItemNumsDescLisEO;
import sinexcel.quartz.mapper.SyncBomItemDataLisMapper;
import sinexcel.quartz.mapper.SyncItemNumsDescLisMapper;
import sinexcel.quartz.service.ISyncItemsNumDesListService;

/**
 * 物料编码和描述快码Service业务层处理
 *
 * @author Zhang Kai
 * @date 2020-12-14
 */
@Service
public class SyncItemsNumDesListServiceImpl implements ISyncItemsNumDesListService
{
    @Autowired
    private SyncItemNumsDescLisMapper syncItemsNumDesListMapper;

    @Autowired
    private SyncItemNumsDescLisMapper syncItemNumsDescLisMapper;

    @Autowired
    private SyncBomItemDataLisMapper syncBomItemDataLisMapper;

    /**
     * 查询物料编码和描述快码列表
     *
     * @param syncItemsNumDesList 物料编码和描述快码
     * @return 物料编码和描述快码
     */
    @Override
    public List<SyncItemNumsDescLisEO> selectSyncItemsNumDesListList(SyncItemNumsDescLisEO syncItemsNumDesList)
    {
        return syncItemsNumDesListMapper.selectSyncItemsNumDesListList(syncItemsNumDesList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchSyncItemNumsDescLis(List<SyncItemNumsDescLisEO> list)
    {
        int batchCount =173;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                syncItemNumsDescLisMapper.deleteSyncItemNumsDescLis(list.subList(index, (batchLastIndex + 1)));
                syncItemNumsDescLisMapper.batchSyncItemNumsDescLis(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                syncItemNumsDescLisMapper.deleteSyncItemNumsDescLis(list.subList(index, (batchLastIndex + 1)));
                syncItemNumsDescLisMapper.batchSyncItemNumsDescLis(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public void batchSyncBomItemDataLis(List<SyncBomItemDataLisEO> list)
    {
        int batchCount =299;//每批处理的条数
        int batchLastIndex = batchCount - 1;// 每批最后一个的下标
        for (int index = 0; index < list.size();) {
            if (batchLastIndex > (list.size() - 1)) {
                batchLastIndex = list.size() - 1;
                syncBomItemDataLisMapper.deleteSyncItemNumsDescLis(list.subList(index, (batchLastIndex + 1)));
                syncBomItemDataLisMapper.batchSyncBomItemDataLis(list.subList(index, (batchLastIndex + 1)));
                break;// 数据插入完毕,退出循环
            }else {
                syncBomItemDataLisMapper.deleteSyncItemNumsDescLis(list.subList(index, (batchLastIndex + 1)));
                syncBomItemDataLisMapper.batchSyncBomItemDataLis(list.subList(index, (batchLastIndex + 1)));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }
}