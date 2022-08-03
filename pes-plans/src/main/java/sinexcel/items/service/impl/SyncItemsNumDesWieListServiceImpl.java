package sinexcel.items.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.domain.SyncItemsNumDesWieList;
import sinexcel.items.mapper.SyncItemsNumDesWieListMapper;
import sinexcel.items.service.ISyncItemsNumDesWieListService;

import java.util.List;

@Service
public class SyncItemsNumDesWieListServiceImpl implements ISyncItemsNumDesWieListService {

    @Autowired
    private SyncItemsNumDesWieListMapper syncItemsNumDesWieListMapper;

    @Override
    public List<SyncItemsNumDesWieList> selectSyncItemsNumDesWieListList(SyncItemsNumDesWieList syncItemsNumDesWieList)
    {
        return syncItemsNumDesWieListMapper.selectSyncItemsNumDesWieListList(syncItemsNumDesWieList);
    }

}
