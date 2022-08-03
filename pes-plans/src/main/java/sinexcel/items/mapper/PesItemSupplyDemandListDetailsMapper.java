package sinexcel.items.mapper;

import java.util.List;
import sinexcel.items.domain.PesItemSupplyDemandListDetails;

/**
 * 复核项供应和需求明细Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-05-07
 */
public interface PesItemSupplyDemandListDetailsMapper 
{

    /**
     * 查询复核项供应和需求明细列表
     * 
     * @param pesItemSupplyDemandListDetails 复核项供应和需求明细
     * @return 复核项供应和需求明细集合
     */
    public List<PesItemSupplyDemandListDetails> selectPesItemSupplyDemandListDetailsList(PesItemSupplyDemandListDetails pesItemSupplyDemandListDetails);
}
