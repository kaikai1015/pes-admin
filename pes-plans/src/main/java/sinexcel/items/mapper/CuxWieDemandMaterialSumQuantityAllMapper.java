package sinexcel.items.mapper;

import java.util.List;
import sinexcel.items.domain.CuxWieDemandMaterialSumQuantityAll;

/**
 * 工单发料数据汇总Mapper接口
 * 
 * @author Zhang Kai
 * @date 2022-05-07
 */
public interface CuxWieDemandMaterialSumQuantityAllMapper 
{

    /**
     * 查询工单发料数据汇总列表
     * 
     * @param cuxWieDemandMaterialSumQuantityAll 工单发料数据汇总
     * @return 工单发料数据汇总集合
     */
    public List<CuxWieDemandMaterialSumQuantityAll> selectCuxWieDemandMaterialSumQuantityAllList(CuxWieDemandMaterialSumQuantityAll cuxWieDemandMaterialSumQuantityAll);

}
