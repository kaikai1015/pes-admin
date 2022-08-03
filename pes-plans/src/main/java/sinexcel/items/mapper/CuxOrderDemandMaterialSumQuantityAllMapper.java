package sinexcel.items.mapper;

import java.util.List;
import sinexcel.items.domain.CuxOrderDemandMaterialSumQuantityAll;

/**
 * 工单已发料数据汇总Mapper接口
 * 
 * @author Zhang Kai
 * @date 2022-05-07
 */
public interface CuxOrderDemandMaterialSumQuantityAllMapper 
{
    /**
     * 查询工单已发料数据汇总列表
     * 
     * @param cuxOrderDemandMaterialSumQuantityAll 工单已发料数据汇总
     * @return 工单已发料数据汇总集合
     */
    public List<CuxOrderDemandMaterialSumQuantityAll> selectCuxOrderDemandMaterialSumQuantityAllList(CuxOrderDemandMaterialSumQuantityAll cuxOrderDemandMaterialSumQuantityAll);

}
