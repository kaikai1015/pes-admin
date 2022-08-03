package sinexcel.weeks.service;

import java.util.List;
import sinexcel.weeks.domain.CuxWieWorkImportDataList;

/**
 * 排程欠料导入数据Service接口
 * 
 * @author Zhang Kai
 * @date 2021-11-05
 */
public interface ICuxWieWorkImportDataListService 
{
    /**
     * 查询排程欠料导入数据列表
     * 
     * @param cuxWieWorkImportDataList 排程欠料导入数据
     * @return 排程欠料导入数据集合
     */
    public List<CuxWieWorkImportDataList> selectCuxWieWorkImportDataListList(CuxWieWorkImportDataList cuxWieWorkImportDataList);

    /**
     * 导入数据
     *
     * @param weeksLists 用户数据列表
     * @param operName 操作用户
     * @return 结果
     */
    public String importData(List<CuxWieWorkImportDataList> weeksLists, String operName,Long lotNumber);

}
