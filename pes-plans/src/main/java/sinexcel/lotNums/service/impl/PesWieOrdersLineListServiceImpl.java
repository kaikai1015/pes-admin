package sinexcel.lotNums.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.lotNums.mapper.PesPoOrdersLineListMapper;
import sinexcel.lotNums.mapper.PesWieOrdersLineListMapper;
import sinexcel.lotNums.domain.PesWieOrdersLineList;
import sinexcel.lotNums.service.IPesWieOrdersLineListService;

/**
 * 订单生产计划Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
@Service
public class PesWieOrdersLineListServiceImpl implements IPesWieOrdersLineListService 
{
    @Autowired
    private PesWieOrdersLineListMapper pesWieOrdersLineListMapper;

    @Autowired
    private PesPoOrdersLineListMapper pesPoOrdersLineListMapper;


    /**
     * 查询订单生产计划列表
     * 
     * @param pesWieOrdersLineList 订单生产计划
     * @return 订单生产计划
     */
    @Override
    public List<PesWieOrdersLineList> selectPesWieOrdersLineListList(PesWieOrdersLineList pesWieOrdersLineList)
    {
        return pesWieOrdersLineListMapper.selectPesWieOrdersLineListList(pesWieOrdersLineList);
    }

    @Override
    @Transactional
    public int mrpSyncOrdersDemandListByIds(Long planLotNum)
    {
        pesWieOrdersLineListMapper.deleteOrdersSumGrossQuantity();
        //获取LLC
        List<PesWieOrdersLineList> countLlcs = pesWieOrdersLineListMapper.getCountLlcs(planLotNum);
        if(countLlcs.size() > 0){
            System.out.println("----------订单批次llc循环开始----------");
            System.out.println(new Date());
            for(int llc = 0; llc <= countLlcs.size()-1; llc ++){
                System.out.println("----------第"+llc+"次订单批次LLC循环----------");
                //传入参数i获取数据
                pesWieOrdersLineListMapper.insertSumGrossQuantity(llc);
                //删除pes_plan_bom_parent_qty_temp数据，获取最新LLC的数据
                pesWieOrdersLineListMapper.deleteQarentQuantityTemp();
                //插入最新的LLC的数据
                pesWieOrdersLineListMapper.insertQarentQuantityTemp(llc);
                List<PesWieOrdersLineList> countLlcsDatas = pesWieOrdersLineListMapper.getCountLlcsDatas();
                if(countLlcsDatas.size() > 0){
                    //多线程处理循环每一个底阶码的数据
                    cycleOrdersGetNextNetQuantityList(countLlcsDatas);
                }
            }
            pesPoOrdersLineListMapper.mrpSyncOrdersDemandListByIds();
            pesWieOrdersLineListMapper.mpsSyncOrdersDemandListByIds();
            System.out.println(new Date());
            System.out.println("----------订单批次llc循环结束----------");
        }
        //批次计划收集完毕后，自动失效当前批次
        int i = pesWieOrdersLineListMapper.updatOrdersHeaderListCode(planLotNum);
        return i;
    }

    @Transactional
    public int cycleOrdersGetNextNetQuantityList(List<PesWieOrdersLineList> countLlcsDatas){
        //跟新下一阶次需求数量
        System.out.println("----------订单批次获取数据开始----------"+countLlcsDatas.size());
        //先删除本结的数据，然后插入和下阶次同时计算的新的数据
        pesWieOrdersLineListMapper.deleteLevelTreeCodeTemp();
        return pesWieOrdersLineListMapper.getNextGrossQuantity();
    }

}
