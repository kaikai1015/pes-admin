package sinexcel.lotNums.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.lotNums.mapper.SyncOrdersDemandLotNumsListMapper;
import sinexcel.lotNums.domain.SyncOrdersDemandList;
import sinexcel.lotNums.service.ISyncOrdersDemandListService;

/**
 * 订单需求收集Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-04-23
 */
@Service
public class SyncOrdersDemandListServiceImpl implements ISyncOrdersDemandListService 
{
    @Autowired
    private SyncOrdersDemandLotNumsListMapper syncOrdersDemandLotNumsListMapper;

    /**
     * 查询订单需求收集列表
     * 
     * @param syncOrdersDemandList 订单需求收集
     * @return 订单需求收集
     */
    @Override
    public List<SyncOrdersDemandList> selectSyncOrdersDemandListList(SyncOrdersDemandList syncOrdersDemandList)
    {
        return syncOrdersDemandLotNumsListMapper.selectSyncOrdersDemandListList(syncOrdersDemandList);
    }

    @Override
    @Transactional
    public int deleteSyncOrdersDemandListByIds()
    {
        return syncOrdersDemandLotNumsListMapper.deleteSyncOrdersDemandListByIds();
    }

}
