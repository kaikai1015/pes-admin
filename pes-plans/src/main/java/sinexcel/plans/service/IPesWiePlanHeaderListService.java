package sinexcel.plans.service;

import java.util.List;
import sinexcel.plans.domain.PesWiePlanHeaderList;

/**
 * 生产计划头Service接口
 * 
 * @author Zhang Kai
 * @date 2020-11-25
 */
public interface IPesWiePlanHeaderListService 
{
    /**
     * 查询生产计划头列表
     * 
     * @param pesWiePlanHeaderList 生产计划头
     * @return 生产计划头集合
     */
    public List<PesWiePlanHeaderList> selectPesWiePlanHeaderListList(PesWiePlanHeaderList pesWiePlanHeaderList);
}
