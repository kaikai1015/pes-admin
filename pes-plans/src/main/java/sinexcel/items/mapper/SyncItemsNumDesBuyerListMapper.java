package sinexcel.items.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import sinexcel.items.domain.SyncItemsNumDesBuyerList;

/**
 * 物料编码和描述快码Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-12-21
 */
public interface SyncItemsNumDesBuyerListMapper 
{
    /**
     * 查询物料编码和描述快码
     * 
     * @param organizationId 物料编码和描述快码ID
     * @return 物料编码和描述快码
     */
    public SyncItemsNumDesBuyerList selectSyncItemsNumDesBuyerListById(@Param("organizationId") Long organizationId, @Param("inventoryItemId") Long inventoryItemId);

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

    SyncItemsNumDesBuyerList getBuyerNameByBuyerNumber(String buyerNumber);

    int insertSyncItemsNumDesBuyerList(SyncItemsNumDesBuyerList syncItemsNumDesBuyerList);
}
