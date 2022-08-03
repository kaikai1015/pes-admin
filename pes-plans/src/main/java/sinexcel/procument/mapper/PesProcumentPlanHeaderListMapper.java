package sinexcel.procument.mapper;

import java.util.List;

import sinexcel.plans.domain.PesPoPlanHeaderList;
import sinexcel.procument.domain.PesProcumentPlanHeaderList;

/**
 * 生成采购计划头信息Mapper接口
 * 
 * @author Zhang Kai
 * @date 2020-12-09
 */
public interface PesProcumentPlanHeaderListMapper 
{
    /**
     * 查询生成采购计划头信息
     * 
     * @param planLotNum 生成采购计划头信息ID
     * @return 生成采购计划头信息
     */
    public PesProcumentPlanHeaderList selectPesProcumentPlanHeaderListById(Long planLotNum);

    /**
     * 查询生成采购计划头信息列表
     * 
     * @param pesProcumentPlanHeaderList 生成采购计划头信息
     * @return 生成采购计划头信息集合
     */
    public List<PesProcumentPlanHeaderList> selectPesProcumentPlanHeaderListList(PesProcumentPlanHeaderList pesProcumentPlanHeaderList);

    public int insertMrpHeaderList(PesPoPlanHeaderList poHeader);
}
