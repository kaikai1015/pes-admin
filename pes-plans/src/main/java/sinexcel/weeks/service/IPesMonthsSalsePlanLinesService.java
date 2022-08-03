package sinexcel.weeks.service;

import java.util.List;
import sinexcel.weeks.domain.PesMonthsSalsePlanLines;

/**
 * 月度销售计划行Service接口
 * 
 * @author Zhang Kai
 * @date 2021-04-21
 */
public interface IPesMonthsSalsePlanLinesService 
{

    /**
     * 查询月度销售计划行列表
     * 
     * @param pesMonthsSalsePlanLines 月度销售计划行
     * @return 月度销售计划行集合
     */
    public List<PesMonthsSalsePlanLines> selectPesMonthsSalsePlanLinesList(PesMonthsSalsePlanLines pesMonthsSalsePlanLines);

    public List<PesMonthsSalsePlanLines> selectPesMonthsSalsePlanLinesListAll(PesMonthsSalsePlanLines pesMonthsSalsePlanLines);

    /**
     * 导入数据
     *
     * @param monthsSalselLists 用户数据列表
     * @param operName 操作用户
     * @return 结果
     */
    public String importData(List<PesMonthsSalsePlanLines> monthsSalselLists, Long id,String operName);

    public int deletePesMonthsSalsePlanLinesByIds(Long id);

    /**
     * 新增月度销售计划行
     *
     * @param pesMonthsSalsePlanLines 月度销售计划行
     * @return 结果
     */
    public int insertPesMonthsSalsePlanLine(PesMonthsSalsePlanLines pesMonthsSalsePlanLines);
}
