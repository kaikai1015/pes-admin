package sinexcel.lotNums.mapper;

import java.util.List;
import sinexcel.lotNums.domain.PesPoOrdersLineList;

/**
 * 订单采购计划行Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
public interface PesPoOrdersLineListMapper 
{

    /**
     * 查询订单采购计划行列表
     * 
     * @param pesPoOrdersLineList 订单采购计划行
     * @return 订单采购计划行集合
     */
    public List<PesPoOrdersLineList> selectPesPoOrdersLineListList(PesPoOrdersLineList pesPoOrdersLineList);

    public int mrpSyncOrdersDemandListByIds();
}
