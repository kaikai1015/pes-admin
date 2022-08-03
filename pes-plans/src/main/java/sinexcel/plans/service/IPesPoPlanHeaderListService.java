package sinexcel.plans.service;

import java.util.List;
import sinexcel.plans.domain.PesPoPlanHeaderList;

/**
 * 采购计划头Service接口
 * 
 * @author Zhang Kai
 * @date 2020-11-25
 */
public interface IPesPoPlanHeaderListService 
{

    /**
     * 查询采购计划头列表
     * 
     * @param pesPoPlanHeaderList 采购计划头
     * @return 采购计划头集合
     */
    public List<PesPoPlanHeaderList> selectPesPoPlanHeaderListList(PesPoPlanHeaderList pesPoPlanHeaderList);

    /**
     * 生成采购计划
     *
     * @param ids 采购计划头
     * @return 结果
     */
    public int prPesPoPlanHeaderList(Integer ids);


}
