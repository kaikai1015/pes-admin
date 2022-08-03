package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.SyncItemNumsDescLisEO;

import java.util.List;

public interface SyncItemNumsDescLisMapper {

    /**
     * 查询物料编码和描述快码列表
     *
     * @param syncItemsNumDesList 物料编码和描述快码
     * @return 物料编码和描述快码集合
     */
    public List<SyncItemNumsDescLisEO> selectSyncItemsNumDesListList(SyncItemNumsDescLisEO syncItemsNumDesList);

    public int deleteSyncItemNumsDescLis(List<SyncItemNumsDescLisEO> list);

    public int batchSyncItemNumsDescLis(List<SyncItemNumsDescLisEO> list);
}
