package sinexcel.plans.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.plans.mapper.PesPoPlanLineListMapper;
import sinexcel.plans.mapper.PesWiePlanLineListMapper;
import sinexcel.plans.domain.PesWiePlanLineList;
import sinexcel.plans.service.IPesWiePlanLineListService;


/**
 * 生产计划行Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-11-25
 */
@Service
public class PesWiePlanLineListServiceImpl implements IPesWiePlanLineListService 
{
    @Autowired
    private PesWiePlanLineListMapper pesWiePlanLineListMapper;

    @Autowired
    private PesPoPlanLineListMapper pesPoPlanLineListMapper;

    /**
     * 查询生产计划行
     *
     * @param lineNum 生产计划行ID
     * @return 生产计划行
     */
    @Override
    public PesWiePlanLineList selectPesWiePlanLineListById(Long lineNum)
    {
        return pesWiePlanLineListMapper.selectPesWiePlanLineListById(lineNum);
    }

    /**
     * 修改生产计划行
     *
     * @param pesWiePlanLineList 生产计划行
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePesWiePlanLineList(PesWiePlanLineList pesWiePlanLineList)
    {
        return pesWiePlanLineListMapper.updatePesWiePlanLineList(pesWiePlanLineList);
    }

    /**
     * 查询生产计划行列表
     * 
     * @param pesWiePlanLineList 生产计划行
     * @return 生产计划行
     */
    @Override
    public List<PesWiePlanLineList> selectPesWiePlanLineListList(PesWiePlanLineList pesWiePlanLineList)
    {
        return pesWiePlanLineListMapper.selectPesWiePlanLineListList(pesWiePlanLineList);
    }

    /**
     * 更新MRP生产计划行
     *
     * @param lineNum 生产计划行ID
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePesWiePlanLineListById(Long lineNum)
    {
        PesWiePlanLineList levelTreeCode = pesWiePlanLineListMapper.selectPesWiePlanLineListById(lineNum);
        levelTreeCode.setLastUpdateBy(SecurityUtils.getUsername());
        return updatePlanLineList(levelTreeCode);
    }

    @Transactional
    public int updatePlanLineList(PesWiePlanLineList levelTreeCode){
        int po = pesPoPlanLineListMapper.updatePoPlanLineList(levelTreeCode);
        if(po > 0){
            pesWiePlanLineListMapper.updatePesWiePlanLineListById(levelTreeCode);
        }
        return po;
    }

    @Override
    @Transactional
    public int updateLevelTreeCodeQuantity(Long planLotNum)
    {
        List<PesWiePlanLineList> planLotNums = pesWiePlanLineListMapper.selectLevelTreeCodeQuantity(planLotNum);
        return pesWiePlanLineListMapper.updateLevelTreeCodeQuantity(planLotNums);
    }

    @Override
    @Transactional
    public int getWiePlan(Long planLotNum)
    {
        int u = 0;
        pesWiePlanLineListMapper.deleteSumGrossQuantity();
        //获取LLC
        List<PesWiePlanLineList> countLlcs = pesWiePlanLineListMapper.getCountLlcs(planLotNum);
        if(countLlcs.size() > 0){
        System.out.println("----------llc循环开始----------");
        System.out.println(new Date());
        for(int llc = 0; llc <= countLlcs.size()-1; llc ++){
            System.out.println("----------第"+llc+"次LLC循环----------");
            //传入参数i获取数据
            pesWiePlanLineListMapper.insertSumGrossQuantity(llc);
            //删除pes_plan_bom_parent_qty_temp数据，获取最新LLC的数据
            pesWiePlanLineListMapper.deleteQarentQuantityTemp();
            //插入最新的LLC的数据
            pesWiePlanLineListMapper.insertQarentQuantityTemp(llc);
         List<PesWiePlanLineList> countLlcsDatas = pesWiePlanLineListMapper.getCountLlcsDatas();
         if(countLlcsDatas.size() > 0){
             //多线程处理循环每一个底阶码的数据
             cycleGetNextNetQuantityList(countLlcsDatas);
         }
        }
        //插入MPS和MRP数据
       pesWiePlanLineListMapper.insertMpsLists();
        pesPoPlanLineListMapper.insertMrpLists();
        System.out.println(new Date());
        System.out.println("----------llc循环结束----------");
        }
        u++;
        return u;
    }

    @Transactional
    public int cycleGetNextNetQuantityList(List<PesWiePlanLineList> countLlcsDatas){
            //跟新下一阶次需求数量
        System.out.println("----------获取数据开始----------"+countLlcsDatas.size());
        //先删除本结的数据，然后插入和下阶次同时计算的新的数据
        pesWiePlanLineListMapper.deleteLevelTreeCodeTemp();
        return pesWiePlanLineListMapper.getNextGrossQuantity();
    }
}
