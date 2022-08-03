package sinexcel.plans.mapper;

import java.util.List;

import sinexcel.plans.domain.PesPlanHeaderList;
import sinexcel.plans.domain.PesWiePlanHeaderList;

/**
 * 生产计划头Mapper接口
 * 
 * @author Zhang Kai
 * @date 2020-11-25
 */
public interface PesWiePlanHeaderListMapper 
{
    /**
     * 查询生产计划头列表
     * 
     * @param pesWiePlanHeaderList 生产计划头
     * @return 生产计划头集合
     */
    public List<PesWiePlanHeaderList> selectPesWiePlanHeaderListList(PesWiePlanHeaderList pesWiePlanHeaderList);

    /**
     * 新增生产计划头
     * 
     * @param pesWiePlanHeaderList 生产计划头
     * @return 结果
     */
    public int insertPesWiePlanHeaderList(PesPlanHeaderList pesWiePlanHeaderList);

    /**
     * 批量删除生产计划头
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePesWiePlanHeaderListByIds(Integer[] ids);

}
