package sinexcel.lotNums.service;

import java.util.List;
import sinexcel.lotNums.domain.PesWieOrdersLineList;

/**
 * 订单生产计划Service接口
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
public interface IPesWieOrdersLineListService 
{

    /**
     * 查询订单生产计划列表
     * 
     * @param pesWieOrdersLineList 订单生产计划
     * @return 订单生产计划集合
     */
    public List<PesWieOrdersLineList> selectPesWieOrdersLineListList(PesWieOrdersLineList pesWieOrdersLineList);

    public int mrpSyncOrdersDemandListByIds(Long planLotNum);

}
