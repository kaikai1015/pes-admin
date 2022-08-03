package sinexcel.weeks.mapper;

import java.util.List;
import sinexcel.weeks.domain.PesMonthsSalsePlanLines;

/**
 * 月度销售计划行Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-04-21
 */
public interface PesMonthsSalsePlanLinesMapper 
{
    /**
     * 查询月度销售计划行列表
     * 
     * @param pesMonthsSalsePlanLines 月度销售计划行
     * @return 月度销售计划行集合
     */
    public List<PesMonthsSalsePlanLines> selectPesMonthsSalsePlanLinesList(PesMonthsSalsePlanLines pesMonthsSalsePlanLines);

    public PesMonthsSalsePlanLines getFlags(Long id);

    public List<PesMonthsSalsePlanLines> selectPesMonthsSalsePlanLinesListAll(PesMonthsSalsePlanLines pesMonthsSalsePlanLines);

    /**
     * 新增月度销售计划行
     * 
     * @param pesMonthsSalsePlanLines 月度销售计划行
     * @return 结果
     */
    public int insertPesMonthsSalsePlanLines(List<PesMonthsSalsePlanLines> pesMonthsSalsePlanLines);

    public PesMonthsSalsePlanLines selectCount(PesMonthsSalsePlanLines pesMonthsSalsePlanLines);

    public PesMonthsSalsePlanLines getItemDescDatas(PesMonthsSalsePlanLines pesMonthsSalsePlanLines);

    public int deletePesMonthsSalsePlanLinesByIds(Long id);

    public int updateflag(Long id);

    public PesMonthsSalsePlanLines getLotNum(String lotNum);

    int insertPesMonthsSalsePlanLinesByIds(Long id);
}
