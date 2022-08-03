package sinexcel.lotNums.mapper;

import java.util.List;
import sinexcel.lotNums.domain.PesOrdersHeaderList;

/**
 * 订单批次计划Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
public interface PesOrdersHeaderListMapper 
{

    /**
     * 查询订单批次计划列表
     * 
     * @param pesOrdersHeaderList 订单批次计划
     * @return 订单批次计划集合
     */
    public List<PesOrdersHeaderList> selectPesOrdersHeaderListList(PesOrdersHeaderList pesOrdersHeaderList);

}
