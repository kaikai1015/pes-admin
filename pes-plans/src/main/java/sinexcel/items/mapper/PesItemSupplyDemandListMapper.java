package sinexcel.items.mapper;

import java.util.List;
import sinexcel.items.domain.PesItemSupplyDemandList;

/**
 * 复核项供应和需求Mapper接口
 * 
 * @author Zhang Kai
 * @date 2020-12-03
 */
public interface PesItemSupplyDemandListMapper 
{

    /**
     * 查询复核项供应和需求列表
     * 
     * @param pesItemSupplyDemandList 复核项供应和需求
     * @return 复核项供应和需求集合
     */
    public List<PesItemSupplyDemandList> selectPesItemSupplyDemandListList(PesItemSupplyDemandList pesItemSupplyDemandList);

    /**
     * 查询复核项供应和需求明细
     *
     * @param pesItemSupplyDemandList 复核项供应和需求明细ID
     * @return 复核项供应和需求明细
     */
    public PesItemSupplyDemandList selectPesItemSupplyDemandListById(PesItemSupplyDemandList pesItemSupplyDemandList);

    public List<PesItemSupplyDemandList> selectPesItemSupplyDemandList(PesItemSupplyDemandList pesItemSupplyDemandList);

}
