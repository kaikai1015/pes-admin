package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.mapper.PesItemSupplyDemandQtyMapper;
import sinexcel.items.domain.PesItemSupplyDemandQty;
import sinexcel.items.service.IPesItemSupplyDemandQtyService;

/**
 * 供应和需求汇总Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-04-19
 */
@Service
public class PesItemSupplyDemandQtyServiceImpl implements IPesItemSupplyDemandQtyService 
{
    @Autowired
    private PesItemSupplyDemandQtyMapper pesItemSupplyDemandQtyMapper;

    /**
     * 查询供应和需求汇总列表
     * 
     * @param pesItemSupplyDemandQty 供应和需求汇总
     * @return 供应和需求汇总
     */
    @Override
    public List<PesItemSupplyDemandQty> selectPesItemSupplyDemandQtyList(PesItemSupplyDemandQty pesItemSupplyDemandQty)
    {
        return pesItemSupplyDemandQtyMapper.selectPesItemSupplyDemandQtyList(pesItemSupplyDemandQty);
    }
}
