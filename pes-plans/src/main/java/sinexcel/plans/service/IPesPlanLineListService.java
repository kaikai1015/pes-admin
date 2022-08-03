package sinexcel.plans.service;

import java.util.List;
import sinexcel.plans.domain.PesPlanLineList;

/**
 * 主计划行Service接口
 * 
 * @author Zhang Kai
 * @date 2020-11-20
 */
public interface IPesPlanLineListService 
{

    /**
     * 查询主计划行列表
     * 
     * @param pesPlanLineList 主计划行
     * @return 主计划行集合
     */
    public List<PesPlanLineList> selectPesPlanLineListList(PesPlanLineList pesPlanLineList);

    /**
     * 导入数据
     *
     * @param plines 用户数据列表
     * @param operName 操作用户
     * @return 结果
     */
    public String importData(List<PesPlanLineList> plines, Long planLotNum, String operName);

}
