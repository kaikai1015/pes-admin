package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.mapper.CuxPoStrategicStockListMapper;
import sinexcel.items.domain.CuxPoStrategicStockList;
import sinexcel.items.service.ICuxPoStrategicStockListService;

/**
 * 战略备货-采购件Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-05-18
 */
@Service
public class CuxPoStrategicStockListServiceImpl implements ICuxPoStrategicStockListService 
{
    @Autowired
    private CuxPoStrategicStockListMapper cuxPoStrategicStockListMapper;

    /**
     * 查询战略备货-采购件列表
     * 
     * @param cuxPoStrategicStockList 战略备货-采购件
     * @return 战略备货-采购件
     */
    @Override
    public List<CuxPoStrategicStockList> selectCuxPoStrategicStockListList(CuxPoStrategicStockList cuxPoStrategicStockList)
    {
        return cuxPoStrategicStockListMapper.selectCuxPoStrategicStockListList(cuxPoStrategicStockList);
    }
}
