package sinexcel.procument.service;

import java.util.List;
import sinexcel.procument.domain.PesProcumentPlanLineList;

/**
 * 生成采购计划行信息Service接口
 * 
 * @author Zhang Kai
 * @date 2020-12-09
 */
public interface IPesProcumentPlanLineListService 
{
    /**
     * 查询生成采购计划行信息列表
     * 
     * @param pesProcumentPlanLineList 生成采购计划行信息
     * @return 生成采购计划行信息集合
     */
    public List<PesProcumentPlanLineList> selectPesProcumentPlanLineListList(PesProcumentPlanLineList pesProcumentPlanLineList);

    public List<PesProcumentPlanLineList> selectBuyer(PesProcumentPlanLineList pesProcumentPlanLineList);
}
