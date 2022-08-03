package sinexcel.weeks.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinexcel.common.annotation.DataScope;
import sinexcel.weeks.mapper.CuxWorkOrdersQtDetailsQlMapper;
import sinexcel.weeks.domain.CuxWorkOrdersQtDetailsQl;
import sinexcel.weeks.service.ICuxWorkOrdersQtDetailsQlService;

/**
 * 欠料查询Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-03-11
 */
@Service
public class CuxWorkOrdersQtDetailsQlServiceImpl implements ICuxWorkOrdersQtDetailsQlService 
{
    @Autowired
    private CuxWorkOrdersQtDetailsQlMapper cuxWorkOrdersQtDetailsQlMapper;


    /**
     * 查询欠料查询列表
     * 
     * @param cuxWorkOrdersQtDetailsQl 欠料查询
     * @return 欠料查询
     */
    @Override
    @DataScope(userAlias = "u")
    public List<CuxWorkOrdersQtDetailsQl> selectCuxWorkOrdersQtDetailsQlList(CuxWorkOrdersQtDetailsQl cuxWorkOrdersQtDetailsQl)
    {
        return cuxWorkOrdersQtDetailsQlMapper.selectCuxWorkOrdersQtDetailsQlList(cuxWorkOrdersQtDetailsQl);
    }

    /**
     * 欠料计算
     *
     * @return 结果
     */
    @Override
    public int qtWorkImport(CuxWorkOrdersQtDetailsQl cuxWorkOrdersQtDetailsQl)
    {
        cuxWorkOrdersQtDetailsQlMapper.deleteQtWorkImport(cuxWorkOrdersQtDetailsQl);
        return cuxWorkOrdersQtDetailsQlMapper.qtWorkImport(cuxWorkOrdersQtDetailsQl);
    }
}
