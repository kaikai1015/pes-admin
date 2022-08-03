package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.items.mapper.CuxItemDemandQuantityListMapper;
import sinexcel.items.domain.CuxItemDemandQuantityList;
import sinexcel.items.service.ICuxItemDemandQuantityListService;

/**
 * 物料需求平均备货数量Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-10-27
 */
@Service
public class CuxItemDemandQuantityListServiceImpl implements ICuxItemDemandQuantityListService 
{
    @Autowired
    private CuxItemDemandQuantityListMapper cuxItemDemandQuantityListMapper;

    /**
     * 查询物料需求平均备货数量列表
     * 
     * @param cuxItemDemandQuantityList 物料需求平均备货数量
     * @return 物料需求平均备货数量
     */
    @Override
    public List<CuxItemDemandQuantityList> selectCuxItemDemandQuantityListList(CuxItemDemandQuantityList cuxItemDemandQuantityList)
    {
        return cuxItemDemandQuantityListMapper.selectCuxItemDemandQuantityListList(cuxItemDemandQuantityList);
    }
}
