package sinexcel.plans.mapper;

import java.util.List;
import sinexcel.plans.domain.PesPoPlanLineList;
import sinexcel.plans.domain.PesWiePlanLineList;

/**
 * 采购计划行Mapper接口
 * 
 * @author Zhang Kai
 * @date 2020-11-26
 */
public interface PesPoPlanLineListMapper 
{

    /**
     * 查询采购计划行列表
     * 
     * @param pesPoPlanLineList 采购计划行
     * @return 采购计划行集合
     */
    public List<PesPoPlanLineList> selectPesPoPlanLineListList(PesPoPlanLineList pesPoPlanLineList);


    /**
     * 更新MRP生产计划行
     *
     * @param levelTreeCode 生产计划行ID
     * @return 结果
     */
    public int updatePoPlanLineList(PesWiePlanLineList levelTreeCode);

    /**
     * 查询采购计划行
     *
     * @param lineNum 采购计划行ID
     * @return 采购计划行
     */
    public PesPoPlanLineList selectPesPoPlanLineListById(Long lineNum);

    /**
     * 修改采购计划行
     *
     * @param pesPoPlanLineList 采购计划行
     * @return 结果
     */
    public int updatePesPoPlanLineList(PesPoPlanLineList pesPoPlanLineList);

    public int insertMrpLists();

}
