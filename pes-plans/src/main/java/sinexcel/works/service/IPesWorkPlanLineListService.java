package sinexcel.works.service;

import java.util.List;
import sinexcel.works.domain.PesWorkPlanLineList;

/**
 * 生产计划池行信息Service接口
 * 
 * @author Zhang Kai
 * @date 2021-04-16
 */
public interface IPesWorkPlanLineListService 
{
    /**
     * 查询生产计划池行信息列表
     * 
     * @param pesWorkPlanLineList 生产计划池行信息
     * @return 生产计划池行信息集合
     */
    public List<PesWorkPlanLineList> selectPesWorkPlanLineListList(PesWorkPlanLineList pesWorkPlanLineList);


    /**
     * 批量生产计划池行信息
     * 
     * @param lineNums 需要删除的生产计划池行信息ID
     * @return 结果
     */
    public int wieWorkPlanLineListByIds(Long[] lineNums);

    public int deleteWorksLines(Long[] lineNums);
}
