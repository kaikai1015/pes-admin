package sinexcel.lotNums.mapper;

import java.util.List;
import sinexcel.lotNums.domain.PesWieOrdersHeaderList;

/**
 * 订单生产计划头Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
public interface PesWieOrdersHeaderListMapper 
{

    /**
     * 查询订单生产计划头列表
     * 
     * @param pesWieOrdersHeaderList 订单生产计划头
     * @return 订单生产计划头集合
     */
    public List<PesWieOrdersHeaderList> selectPesWieOrdersHeaderListList(PesWieOrdersHeaderList pesWieOrdersHeaderList);

    public PesWieOrdersHeaderList workOrdersHeader(Long planLotNum);

    public int insertPesWorkOrdersHeaderList(PesWieOrdersHeaderList getWorkOrdersHeader);

    public int insertPesWorkOrderLineList(PesWieOrdersHeaderList getWorkOrdersHeader);

    public int updateActiveCode(Long planLotNum);

}
