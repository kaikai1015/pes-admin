package sinexcel.procument.mapper;

import java.util.List;

import sinexcel.plans.domain.PesPoPlanHeaderList;
import sinexcel.procument.domain.PesProcumentPlanLineList;

/**
 * 生成采购计划行信息Mapper接口
 * 
 * @author Zhang Kai
 * @date 2020-12-09
 */
public interface PesProcumentPlanLineListMapper 
{

    /**
     * 查询生成采购计划行信息列表
     * 
     * @param pesProcumentPlanLineList 生成采购计划行信息
     * @return 生成采购计划行信息集合
     */
    public List<PesProcumentPlanLineList> selectPesProcumentPlanLineListList(PesProcumentPlanLineList pesProcumentPlanLineList);

    public int insertPesProcumentPlanLineList(PesPoPlanHeaderList planLotNum);

    public List<PesProcumentPlanLineList> selectBuyer(PesProcumentPlanLineList pesProcumentPlanLineList);

    /**
     * 发放采购计划到采购员
     *
     * @param lineNum 生成采购计划行信息ID
     * @return 结果
     */
    public int deletePesProcumentPlanLineListByIds(Long lineNum);

}
