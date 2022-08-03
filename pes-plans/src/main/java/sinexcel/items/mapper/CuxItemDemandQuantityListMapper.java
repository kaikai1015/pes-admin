package sinexcel.items.mapper;

import java.util.List;
import sinexcel.items.domain.CuxItemDemandQuantityList;

/**
 * 物料需求平均备货数量Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-10-27
 */
public interface CuxItemDemandQuantityListMapper 
{

    /**
     * 查询物料需求平均备货数量列表
     * 
     * @param cuxItemDemandQuantityList 物料需求平均备货数量
     * @return 物料需求平均备货数量集合
     */
    public List<CuxItemDemandQuantityList> selectCuxItemDemandQuantityListList(CuxItemDemandQuantityList cuxItemDemandQuantityList);
}
