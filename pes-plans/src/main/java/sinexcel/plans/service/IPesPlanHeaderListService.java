package sinexcel.plans.service;

import java.util.List;
import sinexcel.plans.domain.PesPlanHeaderList;

/**
 * 主计划头Service接口
 * 
 * @author Zhang Kai
 * @date 2020-11-23
 */
public interface IPesPlanHeaderListService 
{
    /**
     * 查询主计划头
     *
     * @param id 主计划头ID
     * @return 主计划头
     */
    public PesPlanHeaderList selectPesPlanHeaderListById(Integer id);

    /**
     * 查询主计划头列表
     * 
     * @param pesPlanHeaderList 主计划头
     * @return 主计划头集合
     */
    public List<PesPlanHeaderList> selectPesPlanHeaderListList(PesPlanHeaderList pesPlanHeaderList);

    /**
     * 新增主计划头
     * 
     * @param pesPlanHeaderList 主计划头
     * @return 结果
     */
    public int insertPesPlanHeaderList(PesPlanHeaderList pesPlanHeaderList);

    /**
     * 修改主计划头
     *
     * @param pesPlanHeaderList 主计划头
     * @return 结果
     */
    public int updatePesPlanHeaderList(PesPlanHeaderList pesPlanHeaderList);

    /**
     * 批量删除主计划头
     * 
     * @param ids 需要删除的主计划头ID
     * @return 结果
     */
    public int deletePesPlanHeaderListByIds(Integer[] ids);

}
