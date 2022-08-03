package sinexcel.items.service;

import java.util.List;
import sinexcel.items.domain.CuxPoStrategicStockList;

/**
 * 战略备货-采购件Service接口
 * 
 * @author Zhang Kai
 * @date 2021-05-18
 */
public interface ICuxPoStrategicStockListService 
{

    /**
     * 查询战略备货-采购件列表
     * 
     * @param cuxPoStrategicStockList 战略备货-采购件
     * @return 战略备货-采购件集合
     */
    public List<CuxPoStrategicStockList> selectCuxPoStrategicStockListList(CuxPoStrategicStockList cuxPoStrategicStockList);
}
