package sinexcel.plans.mapper;

import java.util.List;
import sinexcel.plans.domain.PesPlanLineList;

/**
 * 主计划行Mapper接口
 * 
 * @author Zhang Kai
 * @date 2020-11-20
 */
public interface PesPlanLineListMapper 
{

    /**
     * 查询主计划行列表
     * 
     * @param pesPlanLineList 主计划行
     * @return 主计划行集合
     */
    public List<PesPlanLineList> selectPesPlanLineListList(PesPlanLineList pesPlanLineList);

    public PesPlanLineList getPlanHeader(Long planLotNum);

    /**
     *是否存在这条数据
     * @return 用户对象信息
     */
    public PesPlanLineList selectCount(PesPlanLineList pline);

    public PesPlanLineList getOrgItemId(PesPlanLineList pline);

    /**
     * 批量新增
     *
     * @param list 批量新增
     * @return 结果
     */
    public int insertPlines(List<PesPlanLineList> list);

}
