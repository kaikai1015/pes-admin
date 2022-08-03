package sinexcel.items.service;

import java.util.List;
import sinexcel.items.domain.CuxWieSupplyMaterialSumQuantityAll;

/**
 * 工单入库数据汇总Service接口
 * 
 * @author Zhang Kai
 * @date 2022-05-07
 */
public interface ICuxWieSupplyMaterialSumQuantityAllService 
{
    /**
     * 查询工单入库数据汇总列表
     * 
     * @param cuxWieSupplyMaterialSumQuantityAll 工单入库数据汇总
     * @return 工单入库数据汇总集合
     */
    public List<CuxWieSupplyMaterialSumQuantityAll> selectCuxWieSupplyMaterialSumQuantityAllList(CuxWieSupplyMaterialSumQuantityAll cuxWieSupplyMaterialSumQuantityAll);

}
