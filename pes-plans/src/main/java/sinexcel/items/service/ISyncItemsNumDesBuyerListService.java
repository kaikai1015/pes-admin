package sinexcel.items.service;

import java.util.List;
import sinexcel.items.domain.SyncItemsNumDesBuyerList;

/**
 * 物料编码和描述快码Service接口
 * 
 * @author Zhang Kai
 * @date 2021-12-21
 */
public interface ISyncItemsNumDesBuyerListService 
{
    /**
     * 查询物料编码和描述快码
     * 
     * @param organizationId 物料编码和描述快码ID
     * @return 物料编码和描述快码
     */
    public SyncItemsNumDesBuyerList selectSyncItemsNumDesBuyerListById(Long organizationId,Long inventoryItemId);

    /**
     * 查询物料编码和描述快码列表
     * 
     * @param syncItemsNumDesBuyerList 物料编码和描述快码
     * @return 物料编码和描述快码集合
     */
    public List<SyncItemsNumDesBuyerList> selectSyncItemsNumDesBuyerListList(SyncItemsNumDesBuyerList syncItemsNumDesBuyerList);


    /**
     * 修改物料编码和描述快码
     * 
     * @param syncItemsNumDesBuyerList 物料编码和描述快码
     * @return 结果
     */
    public int updateSyncItemsNumDesBuyerList(SyncItemsNumDesBuyerList syncItemsNumDesBuyerList);

}
