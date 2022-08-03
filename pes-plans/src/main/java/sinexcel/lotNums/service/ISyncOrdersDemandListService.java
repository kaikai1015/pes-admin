package sinexcel.lotNums.service;

import java.util.List;
import sinexcel.lotNums.domain.SyncOrdersDemandList;

/**
 * 订单需求收集Service接口
 * 
 * @author Zhang Kai
 * @date 2021-04-23
 */
public interface ISyncOrdersDemandListService 
{
    /**
     * 查询订单需求收集列表
     * 
     * @param syncOrdersDemandList 订单需求收集
     * @return 订单需求收集集合
     */
    public List<SyncOrdersDemandList> selectSyncOrdersDemandListList(SyncOrdersDemandList syncOrdersDemandList);

    public int deleteSyncOrdersDemandListByIds();

}
