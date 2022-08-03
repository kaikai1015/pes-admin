package sinexcel.plans.mapper;

import java.util.List;

import sinexcel.plans.domain.PesPlanHeaderList;
import sinexcel.plans.domain.PesPoPlanHeaderList;

/**
 * 采购计划头Mapper接口
 * 
 * @author Zhang Kai
 * @date 2020-11-25
 */
public interface PesPoPlanHeaderListMapper 
{

    /**
     * 查询采购计划头列表
     * 
     * @param pesPoPlanHeaderList 采购计划头
     * @return 采购计划头集合
     */
    public List<PesPoPlanHeaderList> selectPesPoPlanHeaderListList(PesPoPlanHeaderList pesPoPlanHeaderList);

    /**
     * 新增采购计划头
     * 
     * @param pesPoPlanHeaderList 采购计划头
     * @return 结果
     */
    public int insertPesPoPlanHeaderList(PesPlanHeaderList pesPoPlanHeaderList);

    /**
     * 批量删除采购计划头
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePesPoPlanHeaderListByIds(Integer[] ids);

    /**
     * 生成采购计划
     *
     * @param ids 需要的数据
     * @return 结果
     */
    public PesPoPlanHeaderList prPesPoPlanHeaderList(Integer ids);
}
