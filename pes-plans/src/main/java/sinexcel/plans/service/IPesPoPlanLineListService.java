package sinexcel.plans.service;

import java.util.List;
import sinexcel.plans.domain.PesPoPlanLineList;

/**
 * 采购计划行Service接口
 * 
 * @author Zhang Kai
 * @date 2020-11-26
 */
public interface IPesPoPlanLineListService 
{

    /**
     * 查询采购计划行列表
     * 
     * @param pesPoPlanLineList 采购计划行
     * @return 采购计划行集合
     */
    public List<PesPoPlanLineList> selectPesPoPlanLineListList(PesPoPlanLineList pesPoPlanLineList);

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

}
