package sinexcel.weeks.mapper;

import java.util.List;
import sinexcel.weeks.domain.CuxWorkOrdersQtDetailsQl;

/**
 * 欠料查询Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-03-11
 */
public interface CuxWorkOrdersQtDetailsQlMapper 
{
    /**
     * 查询欠料查询列表
     * 
     * @param cuxWorkOrdersQtDetailsQl 欠料查询
     * @return 欠料查询集合
     */
    public List<CuxWorkOrdersQtDetailsQl> selectCuxWorkOrdersQtDetailsQlList(CuxWorkOrdersQtDetailsQl cuxWorkOrdersQtDetailsQl);


    /**
     * 欠料计算
     *
     * @param cuxWorkOrdersQtDetailsQl
     * @return 结果
     */
    public int qtWorkImport(CuxWorkOrdersQtDetailsQl cuxWorkOrdersQtDetailsQl);

    public int deleteQtWorkImport(CuxWorkOrdersQtDetailsQl cuxWorkOrdersQtDetailsQl);
}
