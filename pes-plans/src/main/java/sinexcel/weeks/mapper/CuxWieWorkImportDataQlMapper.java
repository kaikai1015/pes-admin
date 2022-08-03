package sinexcel.weeks.mapper;

import java.util.List;
import sinexcel.weeks.domain.CuxWieWorkImportDataQl;

/**
 * 排程欠料分析数据Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-11-06
 */
public interface CuxWieWorkImportDataQlMapper 
{

    /**
     * 查询排程欠料分析数据列表
     * 
     * @param cuxWieWorkImportDataQl 排程欠料分析数据
     * @return 排程欠料分析数据集合
     */
    public List<CuxWieWorkImportDataQl> selectCuxWieWorkImportDataQlList(CuxWieWorkImportDataQl cuxWieWorkImportDataQl);

    /**
     * 删除排程欠料分析数据
     *
     * @param lotNum 排程欠料分析数据ID
     * @return 结果
     */
    public int deleteCuxWieWorkImportDataQlByIds(Long lotNum);

    public int deleteCuxWieWorkImportDataQlById(Long lotNum);

    int insertCuxWieWorkImportDataQlByIds();

    int insertCuxWieWorkImportDataQlByIdsQuantity();

    List<CuxWieWorkImportDataQl> selectListUntransferQuantityList(CuxWieWorkImportDataQl cuxWieWorkImportDataQl);
}
