package sinexcel.items.service;

import java.util.List;
import sinexcel.items.domain.PesItemSupplyDemandQty;

/**
 * 供应和需求汇总Service接口
 * 
 * @author Zhang Kai
 * @date 2021-04-19
 */
public interface IPesItemSupplyDemandQtyService 
{

    /**
     * 查询供应和需求汇总列表
     * 
     * @param pesItemSupplyDemandQty 供应和需求汇总
     * @return 供应和需求汇总集合
     */
    public List<PesItemSupplyDemandQty> selectPesItemSupplyDemandQtyList(PesItemSupplyDemandQty pesItemSupplyDemandQty);

}
