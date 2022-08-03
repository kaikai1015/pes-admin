package sinexcel.items.mapper;

import sinexcel.items.domain.SyncInvOnhandQuantityNewPriceEO;

import java.util.List;

public interface SyncInvOnhandQuantityNewPriceMapper {
    List<SyncInvOnhandQuantityNewPriceEO> selectSyncInvOnhandQuantityNewList(SyncInvOnhandQuantityNewPriceEO syncInvOnhandQuantityNewPriceEO);
}
