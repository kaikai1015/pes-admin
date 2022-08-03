package sinexcel.lotNums.mapper;

import java.util.List;
import sinexcel.lotNums.domain.PesWieOrdersLineList;

/**
 * 订单生产计划Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
public interface PesWieOrdersLineListMapper 
{

    /**
     * 查询订单生产计划列表
     * 
     * @param pesWieOrdersLineList 订单生产计划
     * @return 订单生产计划集合
     */
    public List<PesWieOrdersLineList> selectPesWieOrdersLineListList(PesWieOrdersLineList pesWieOrdersLineList);

    public int mpsSyncOrdersDemandListByIds();

    public int updatOrdersHeaderListCode(Long planLotNum);

    public int deleteOrdersSumGrossQuantity();

    public List<PesWieOrdersLineList> getCountLlcs(Long planLotNum);

    public int insertSumGrossQuantity(Integer llc);

    public int deleteQarentQuantityTemp();

    public int insertQarentQuantityTemp(Integer llc);

    public List<PesWieOrdersLineList> getCountLlcsDatas();

    public int deleteLevelTreeCodeTemp();

    public int getNextGrossQuantity();


}
