package sinexcel.daysPlan.mapper;

import java.util.List;
import sinexcel.daysPlan.domain.PesProdPlanBeiLiaoAll;

/**
 * 生产计划备料单Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-06-16
 */
public interface PesProdPlanBeiLiaoAllMapper 
{

    /**
     * 查询生产计划备料单列表
     * 
     * @param pesProdPlanBeiLiaoAll 生产计划备料单
     * @return 生产计划备料单集合
     */
    public List<PesProdPlanBeiLiaoAll> selectPesProdPlanBeiLiaoAllList(PesProdPlanBeiLiaoAll pesProdPlanBeiLiaoAll);

    /**
     * 批量删除生产计划备料单
     * 
     * @param id 需要删除的数据ID
     * @return 结果
     */
    public int deletePesProdPlanBeiLiaoAllByIds(Long id);
    public int insertPesProdPlanBeiLiaoAll(PesProdPlanBeiLiaoAll pesProdPlanBeiLiaoAll);

    public int updateResetDataFlag(Long id);
}
