package sinexcel.items.service;

import java.util.List;
import sinexcel.items.domain.CuxOtherSupplyMaterialSumQuantityAll;

/**
 * 其它出入数据汇总Service接口
 * 
 * @author Zhang Kai
 * @date 2022-05-07
 */
public interface ICuxOtherSupplyMaterialSumQuantityAllService 
{

    /**
     * 查询其它出入数据汇总列表
     * 
     * @param cuxOtherSupplyMaterialSumQuantityAll 其它出入数据汇总
     * @return 其它出入数据汇总集合
     */
    public List<CuxOtherSupplyMaterialSumQuantityAll> selectCuxOtherSupplyMaterialSumQuantityAllList(CuxOtherSupplyMaterialSumQuantityAll cuxOtherSupplyMaterialSumQuantityAll);

}
