package sinexcel.items.service;

import sinexcel.items.domain.SyncInvOnhandQuantityNewPriceEO;

import java.util.List;

public interface ISyncInvOnhandQuantityNewPriceService {
    List<SyncInvOnhandQuantityNewPriceEO> selectSyncInvOnhandQuantityNewList(SyncInvOnhandQuantityNewPriceEO syncInvOnhandQuantityNewPriceEO);
}
