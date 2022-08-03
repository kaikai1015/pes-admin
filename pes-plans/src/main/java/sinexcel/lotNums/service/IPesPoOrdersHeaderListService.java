package sinexcel.lotNums.service;

import java.util.List;
import sinexcel.lotNums.domain.PesPoOrdersHeaderList;

/**
 * 订单采购计划头Service接口
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
public interface IPesPoOrdersHeaderListService 
{

    /**
     * 查询订单采购计划头列表
     * 
     * @param pesPoOrdersHeaderList 订单采购计划头
     * @return 订单采购计划头集合
     */
    public List<PesPoOrdersHeaderList> selectPesPoOrdersHeaderListList(PesPoOrdersHeaderList pesPoOrdersHeaderList);
}
