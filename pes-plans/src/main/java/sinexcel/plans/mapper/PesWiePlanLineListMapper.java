package sinexcel.plans.mapper;

import java.util.List;
import sinexcel.plans.domain.PesWiePlanLineList;

/**
 * 生产计划行Mapper接口
 * 
 * @author Zhang Kai
 * @date 2020-11-25
 */
public interface PesWiePlanLineListMapper 
{
    /**
     * 查询生产计划行
     *
     * @param lineNum 生产计划行ID
     * @return 生产计划行
     */
    public PesWiePlanLineList selectPesWiePlanLineListById(Long lineNum);

    /**
     * 修改生产计划行
     *
     * @param pesWiePlanLineList 生产计划行
     * @return 结果
     */
    public int updatePesWiePlanLineList(PesWiePlanLineList pesWiePlanLineList);

    /**
     * 查询生产计划行列表
     * 
     * @param pesWiePlanLineList 生产计划行
     * @return 生产计划行集合
     */
    public List<PesWiePlanLineList> selectPesWiePlanLineListList(PesWiePlanLineList pesWiePlanLineList);

    /**
     * 更新MRP生产计划行
     *
     * @param levelTreeCode 生产计划行ID
     * @return 结果
     */
    public int updatePesWiePlanLineListById(PesWiePlanLineList levelTreeCode);

    public List<PesWiePlanLineList> selectLevelTreeCodeQuantity(Long planLotNum);

    public int updateLevelTreeCodeQuantity(List<PesWiePlanLineList> lineNum);

    public List<PesWiePlanLineList> getCountLlcs(Long planLotNum);

    public int insertQarentQuantityTemp(Integer llc);

    public List<PesWiePlanLineList> getCountLlcsDatas();

    public int deleteQarentQuantityTemp();

    public int insertSumGrossQuantity(Integer llc);

    public int deleteSumGrossQuantity();

    public int deleteLevelTreeCodeTemp();

    public int getNextGrossQuantity();

    public int insertMpsLists();
}
