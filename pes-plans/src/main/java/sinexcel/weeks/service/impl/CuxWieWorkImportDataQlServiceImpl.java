package sinexcel.weeks.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.weeks.mapper.CuxWieWorkImportDataQlMapper;
import sinexcel.weeks.domain.CuxWieWorkImportDataQl;
import sinexcel.weeks.service.ICuxWieWorkImportDataQlService;

/**
 * 排程欠料分析数据Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-11-06
 */
@Service
public class CuxWieWorkImportDataQlServiceImpl implements ICuxWieWorkImportDataQlService 
{
    @Autowired
    private CuxWieWorkImportDataQlMapper cuxWieWorkImportDataQlMapper;

    /**
     * 查询排程欠料分析数据列表
     * 
     * @param cuxWieWorkImportDataQl 排程欠料分析数据
     * @return 排程欠料分析数据
     */
    @Override
    public List<CuxWieWorkImportDataQl> selectCuxWieWorkImportDataQlList(CuxWieWorkImportDataQl cuxWieWorkImportDataQl)
    {
        return cuxWieWorkImportDataQlMapper.selectCuxWieWorkImportDataQlList(cuxWieWorkImportDataQl);
    }

    /**
     * 删除排程欠料分析数据信息
     *
     * @param lotNum 排程欠料分析数据ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int deleteCuxWieWorkImportDataQlById(Long lotNum)
    {
        cuxWieWorkImportDataQlMapper.insertCuxWieWorkImportDataQlByIds();
        cuxWieWorkImportDataQlMapper.insertCuxWieWorkImportDataQlByIdsQuantity();
        cuxWieWorkImportDataQlMapper.deleteCuxWieWorkImportDataQlByIds(lotNum);
        return cuxWieWorkImportDataQlMapper.deleteCuxWieWorkImportDataQlById(lotNum);
    }

    @Override
    public List<CuxWieWorkImportDataQl> selectListUntransferQuantityList(CuxWieWorkImportDataQl cuxWieWorkImportDataQl)
    {
        return cuxWieWorkImportDataQlMapper.selectListUntransferQuantityList(cuxWieWorkImportDataQl);
    }

}
