package sinexcel.items.service;

import java.util.List;
import sinexcel.items.domain.CuxInvOnhandMaterialSumQuantitySubinventoryList;

/**
 * 库存周波动汇总Service接口
 * 
 * @author Zhang Kai
 * @date 2022-05-28
 */
public interface ICuxInvOnhandMaterialSumQuantitySubinventoryListService 
{

    /**
     * 查询库存周波动汇总列表
     * 
     * @param cuxInvOnhandMaterialSumQuantitySubinventoryList 库存周波动汇总
     * @return 库存周波动汇总集合
     */
    public List<CuxInvOnhandMaterialSumQuantitySubinventoryList> selectCuxInvOnhandMaterialSumQuantitySubinventoryListList(CuxInvOnhandMaterialSumQuantitySubinventoryList cuxInvOnhandMaterialSumQuantitySubinventoryList);

}
