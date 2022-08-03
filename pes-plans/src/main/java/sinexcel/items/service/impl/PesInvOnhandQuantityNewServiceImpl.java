package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.domain.PesInvOnhandQuantityNewPrice;
import sinexcel.items.mapper.PesInvOnhandQuantityNewMapper;
import sinexcel.items.domain.PesInvOnhandQuantityNew;
import sinexcel.items.mapper.PesInvOnhandQuantityNewPriceMapper;
import sinexcel.items.service.IPesInvOnhandQuantityNewService;

/**
 * ERP库存现有量Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-06-28
 */
@Service
public class PesInvOnhandQuantityNewServiceImpl implements IPesInvOnhandQuantityNewService
{
    @Autowired
    private PesInvOnhandQuantityNewMapper pesInvOnhandQuantityNewMapper;

    @Autowired
    private PesInvOnhandQuantityNewPriceMapper pesInvOnhandQuantityNewPriceMapper;


    /**
     * 查询ERP库存现有量列表
     * 
     * @param syncInvOnhandQuantityNew ERP库存现有量
     * @return ERP库存现有量
     */
    @Override
    public List<PesInvOnhandQuantityNew> selectSyncInvOnhandQuantityNewList(PesInvOnhandQuantityNew syncInvOnhandQuantityNew)
    {
        return pesInvOnhandQuantityNewMapper.selectSyncInvOnhandQuantityNewList(syncInvOnhandQuantityNew);
    }

    @Override
    public List<PesInvOnhandQuantityNew> selectSyncInvOnhandQuantityNewSubCodeList(PesInvOnhandQuantityNew syncInvOnhandQuantityNew)
    {
        return pesInvOnhandQuantityNewMapper.selectSyncInvOnhandQuantityNewSubCodeList(syncInvOnhandQuantityNew);
    }

    @Override
    public List<PesInvOnhandQuantityNew> getOnhandList(PesInvOnhandQuantityNew syncInvOnhandQuantityNew)
    {
        return pesInvOnhandQuantityNewMapper.getOnhandList(syncInvOnhandQuantityNew);
    }

    @Override
    public List<PesInvOnhandQuantityNewPrice> selectSyncInvOnhandQuantityNewSubCodeListPrice(PesInvOnhandQuantityNewPrice syncInvOnhandQuantityNew)
    {
        return pesInvOnhandQuantityNewPriceMapper.selectSyncInvOnhandQuantityNewSubCodeListPrice(syncInvOnhandQuantityNew);
    }

    @Override
    public List<PesInvOnhandQuantityNewPrice> selectSyncInvOnhandQuantityNewListPrice(PesInvOnhandQuantityNewPrice syncInvOnhandQuantityNew)
    {
        return pesInvOnhandQuantityNewPriceMapper.selectSyncInvOnhandQuantityNewListPrice(syncInvOnhandQuantityNew);
    }


}
