package sinexcel.weeks.service;

import java.util.List;
import sinexcel.weeks.domain.CuxWorkOrdersQtDetailsQl;

/**
 * 欠料查询Service接口
 * 
 * @author Zhang Kai
 * @date 2021-03-11
 */
public interface ICuxWorkOrdersQtDetailsQlService 
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
     * @return 结果
     */
    public int qtWorkImport(CuxWorkOrdersQtDetailsQl cuxWorkOrdersQtDetailsQl);
}
