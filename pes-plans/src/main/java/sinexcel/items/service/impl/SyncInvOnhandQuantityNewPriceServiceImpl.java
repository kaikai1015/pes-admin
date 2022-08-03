package sinexcel.items.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.domain.SyncInvOnhandQuantityNewPriceEO;
import sinexcel.items.mapper.SyncInvOnhandQuantityNewPriceMapper;
import sinexcel.items.service.ISyncInvOnhandQuantityNewPriceService;

import java.util.List;

@Service
public class SyncInvOnhandQuantityNewPriceServiceImpl implements ISyncInvOnhandQuantityNewPriceService {

    @Autowired
    private SyncInvOnhandQuantityNewPriceMapper syncInvOnhandQuantityNewPriceMapper;

    @Override
    public List<SyncInvOnhandQuantityNewPriceEO> selectSyncInvOnhandQuantityNewList(SyncInvOnhandQuantityNewPriceEO syncInvOnhandQuantityNewPriceEO)
    {
        return syncInvOnhandQuantityNewPriceMapper.selectSyncInvOnhandQuantityNewList(syncInvOnhandQuantityNewPriceEO);
    }
}
