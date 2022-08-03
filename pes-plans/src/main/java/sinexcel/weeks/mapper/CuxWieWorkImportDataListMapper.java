package sinexcel.weeks.mapper;

import java.util.List;
import sinexcel.weeks.domain.CuxWieWorkImportDataList;

/**
 * 排程欠料导入数据Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-11-05
 */
public interface CuxWieWorkImportDataListMapper 
{

    /**
     * 查询排程欠料导入数据列表
     * 
     * @param cuxWieWorkImportDataList 排程欠料导入数据
     * @return 排程欠料导入数据集合
     */
    public List<CuxWieWorkImportDataList> selectCuxWieWorkImportDataListList(CuxWieWorkImportDataList cuxWieWorkImportDataList);


    public int addBatchInsertCuxWieWorkImportDataList(List<CuxWieWorkImportDataList> list);

    public int insertCuxWieWorkImportDataList(CuxWieWorkImportDataList cuxWieWorkImportDataList);

    /**
     * 删除排程欠料导入数据
     *
     * @param organizationId 排程欠料导入数据ID
     * @return 结果
     */
    public int deleteCuxWieWorkImportDataListById(Long lotNumber);

    public int deleteCuxWieWorkImportDataListByIds(Long lotNumber);

    public int getCuxWieWorkImportDataListById(Long lotNumber);
}
