package sinexcel.works.service;

import java.util.List;
import sinexcel.works.domain.PesWorkPlanHeaderList;

/**
 * 生产计划池Service接口
 * 
 * @author Zhang Kai
 * @date 2021-04-16
 */
public interface IPesWorkPlanHeaderListService 
{

    /**
     * 查询生产计划池列表
     * 
     * @param pesWorkPlanHeaderList 生产计划池
     * @return 生产计划池集合
     */
    public List<PesWorkPlanHeaderList> selectPesWorkPlanHeaderListList(PesWorkPlanHeaderList pesWorkPlanHeaderList);

    public int getWorkWieHeader(Long planLotNum);
}
