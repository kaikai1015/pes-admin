package sinexcel.items.service;

import java.util.List;
import sinexcel.items.domain.PesItemSupplyDemandListDetails;

/**
 * 复核项供应和需求明细Service接口
 * 
 * @author Zhang Kai
 * @date 2021-05-07
 */
public interface IPesItemSupplyDemandListDetailsService 
{
    /**
     * 查询复核项供应和需求明细列表
     * 
     * @param pesItemSupplyDemandListDetails 复核项供应和需求明细
     * @return 复核项供应和需求明细集合
     */
    public List<PesItemSupplyDemandListDetails> selectPesItemSupplyDemandListDetailsList(PesItemSupplyDemandListDetails pesItemSupplyDemandListDetails);

}
