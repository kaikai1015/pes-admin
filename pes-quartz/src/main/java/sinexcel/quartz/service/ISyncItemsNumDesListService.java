package sinexcel.quartz.service;

import sinexcel.quartz.domain.SyncBomItemDataLisEO;
import sinexcel.quartz.domain.SyncItemNumsDescLisEO;

import java.util.List;

public interface ISyncItemsNumDesListService {
    /**
     * 查询物料编码和描述快码列表
     *
     * @param syncItemsNumDesList 物料编码和描述快码
     * @return 物料编码和描述快码集合
     */
    public List<SyncItemNumsDescLisEO> selectSyncItemsNumDesListList(SyncItemNumsDescLisEO syncItemsNumDesList);

    void batchSyncItemNumsDescLis(List<SyncItemNumsDescLisEO> list);

    void batchSyncBomItemDataLis(List<SyncBomItemDataLisEO> list);
}
