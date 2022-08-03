package sinexcel.items.mapper;

import java.util.List;
import sinexcel.items.domain.PesInvOnhandQuantityNewPrice;

/**
 * ERP库存现有量Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-06-28
 */
public interface PesInvOnhandQuantityNewPriceMapper
{


    List<PesInvOnhandQuantityNewPrice> selectSyncInvOnhandQuantityNewSubCodeListPrice(PesInvOnhandQuantityNewPrice syncInvOnhandQuantityNew);

    List<PesInvOnhandQuantityNewPrice> selectSyncInvOnhandQuantityNewListPrice(PesInvOnhandQuantityNewPrice syncInvOnhandQuantityNew);
}
