package sinexcel.items.mapper;

import java.util.List;
import sinexcel.items.domain.CuxPoSupplyMaterialSumQuantityAll;

/**
 * PO入库数据汇总Mapper接口
 * 
 * @author Zhang Kai
 * @date 2022-05-06
 */
public interface CuxPoSupplyMaterialSumQuantityAllMapper 
{

    /**
     * 查询PO入库数据汇总列表
     * 
     * @param cuxPoSupplyMaterialSumQuantityAll PO入库数据汇总
     * @return PO入库数据汇总集合
     */
    public List<CuxPoSupplyMaterialSumQuantityAll> selectCuxPoSupplyMaterialSumQuantityAllList(CuxPoSupplyMaterialSumQuantityAll cuxPoSupplyMaterialSumQuantityAll);

}
