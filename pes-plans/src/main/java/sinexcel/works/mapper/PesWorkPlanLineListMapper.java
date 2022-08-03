package sinexcel.works.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import sinexcel.works.domain.PesWorkPlanHeaderList;
import sinexcel.works.domain.PesWorkPlanLineList;

/**
 * 生产计划池行信息Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-04-16
 */
public interface PesWorkPlanLineListMapper 
{

    /**
     * 查询生产计划池行信息列表
     * 
     * @param pesWorkPlanLineList 生产计划池行信息
     * @return 生产计划池行信息集合
     */
    public List<PesWorkPlanLineList> selectPesWorkPlanLineListList(PesWorkPlanLineList pesWorkPlanLineList);

    /**
     * 新增生产计划池行信息
     * 
     * @param pesWorkPlanLineList 生产计划池行信息
     * @return 结果
     */
    public int insertPesWorkPlanLineList(PesWorkPlanHeaderList pesWorkPlanLineList);


    /**
     * 批量生产计划池行信息
     * 
     * @param lineNums 需要删除的数据ID
     * @return 结果
     */
    public int wieWorkPlanLineListByIds(@Param("lineNums") Long[] lineNums, @Param("lastUpdateBy") String lastUpdateBy);

    public int deleteWorksLines(@Param("lineNums") Long[] lineNums, @Param("lastUpdateBy") String lastUpdateBy);
}
