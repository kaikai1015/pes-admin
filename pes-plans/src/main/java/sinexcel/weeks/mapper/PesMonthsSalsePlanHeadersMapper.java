package sinexcel.weeks.mapper;

import java.util.List;
import sinexcel.weeks.domain.PesMonthsSalsePlanHeaders;

/**
 * 月度销售计划头Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-04-21
 */
public interface PesMonthsSalsePlanHeadersMapper 
{

    /**
     * 查询月度销售计划头
     *
     * @param id 月度销售计划头ID
     * @return 月度销售计划头
     */
    public PesMonthsSalsePlanHeaders selectPesMonthsSalsePlanHeadersById(Long id);

    /**
     * 查询月度销售计划头列表
     * 
     * @param pesMonthsSalsePlanHeaders 月度销售计划头
     * @return 月度销售计划头集合
     */
    public List<PesMonthsSalsePlanHeaders> selectPesMonthsSalsePlanHeadersList(PesMonthsSalsePlanHeaders pesMonthsSalsePlanHeaders);

    /**
     * 新增月度销售计划头
     * 
     * @param pesMonthsSalsePlanHeaders 月度销售计划头
     * @return 结果
     */
    public int insertPesMonthsSalsePlanHeaders(PesMonthsSalsePlanHeaders pesMonthsSalsePlanHeaders);

    public int checkAddAllowed(PesMonthsSalsePlanHeaders pesMonthsSalsePlanHeaders);

    /**
     * 批量删除月度销售计划头
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePesMonthsSalsePlanHeadersByIds(Long ids);

    public int checkDeleteAllowed(Long ids);
}
