package sinexcel.lotNums.mapper;

import java.util.List;
import sinexcel.lotNums.domain.SyncOrdersDemandList;

/**
 * 订单需求收集Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-04-23
 */
public interface SyncOrdersDemandLotNumsListMapper
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
