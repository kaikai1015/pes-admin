package sinexcel.items.mapper;

import java.util.List;
import sinexcel.items.domain.PesInvOnhandQuantityNew;

/**
 * ERP库存现有量Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-06-28
 */
public interface PesInvOnhandQuantityNewMapper
{

    /**
     * 查询ERP库存现有量列表
     * 
     * @param pesInvOnhandQuantityNew ERP库存现有量
     * @return ERP库存现有量集合
     */
    public List<PesInvOnhandQuantityNew> selectSyncInvOnhandQuantityNewList(PesInvOnhandQuantityNew pesInvOnhandQuantityNew);


    public List<PesInvOnhandQuantityNew> getOnhandList(PesInvOnhandQuantityNew pesInvOnhandQuantityNew);

    List<PesInvOnhandQuantityNew> selectSyncInvOnhandQuantityNewSubCodeList(PesInvOnhandQuantityNew syncInvOnhandQuantityNew);
}
