package sinexcel.weeks.service;

import java.util.List;
import sinexcel.weeks.domain.CuxWieWorkImportDataQl;

/**
 * 排程欠料分析数据Service接口
 * 
 * @author Zhang Kai
 * @date 2021-11-06
 */
public interface ICuxWieWorkImportDataQlService 
{

    /**
     * 查询排程欠料分析数据列表
     * 
     * @param cuxWieWorkImportDataQl 排程欠料分析数据
     * @return 排程欠料分析数据集合
     */
    public List<CuxWieWorkImportDataQl> selectCuxWieWorkImportDataQlList(CuxWieWorkImportDataQl cuxWieWorkImportDataQl);

    /**
     * 删除排程欠料分析数据信息
     *
     * @param lotNum 排程欠料分析数据ID
     * @return 结果
     */
    public int deleteCuxWieWorkImportDataQlById(Long lotNum);

    List<CuxWieWorkImportDataQl> selectListUntransferQuantityList(CuxWieWorkImportDataQl cuxWieWorkImportDataQl);
}
