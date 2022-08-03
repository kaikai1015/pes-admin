package sinexcel.items.mapper;

import java.util.List;
import sinexcel.items.domain.PesItemSupplyDemandQty;

/**
 * 供应和需求汇总Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-04-19
 */
public interface PesItemSupplyDemandQtyMapper 
{

    /**
     * 查询供应和需求汇总列表
     * 
     * @param pesItemSupplyDemandQty 供应和需求汇总
     * @return 供应和需求汇总集合
     */
    public List<PesItemSupplyDemandQty> selectPesItemSupplyDemandQtyList(PesItemSupplyDemandQty pesItemSupplyDemandQty);
}
