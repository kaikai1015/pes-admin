package sinexcel.weeks.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.weeks.mapper.PesMonthsSalsePlanHeadersMapper;
import sinexcel.weeks.domain.PesMonthsSalsePlanHeaders;
import sinexcel.weeks.service.IPesMonthsSalsePlanHeadersService;

/**
 * 月度销售计划头Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-04-21
 */
@Service
public class PesMonthsSalsePlanHeadersServiceImpl implements IPesMonthsSalsePlanHeadersService 
{
    @Autowired
    private PesMonthsSalsePlanHeadersMapper pesMonthsSalsePlanHeadersMapper;

    /**
     * 查询月度销售计划头
     *
     * @param id 月度销售计划头ID
     * @return 月度销售计划头
     */
    @Override
    public PesMonthsSalsePlanHeaders selectPesMonthsSalsePlanHeadersById(Long id)
    {
        return pesMonthsSalsePlanHeadersMapper.selectPesMonthsSalsePlanHeadersById(id);
    }

    /**
     * 查询月度销售计划头列表
     * 
     * @param pesMonthsSalsePlanHeaders 月度销售计划头
     * @return 月度销售计划头
     */
    @Override
    public List<PesMonthsSalsePlanHeaders> selectPesMonthsSalsePlanHeadersList(PesMonthsSalsePlanHeaders pesMonthsSalsePlanHeaders)
    {
        return pesMonthsSalsePlanHeadersMapper.selectPesMonthsSalsePlanHeadersList(pesMonthsSalsePlanHeaders);
    }

    /**
     * 新增月度销售计划头
     * 
     * @param pesMonthsSalsePlanHeaders 月度销售计划头
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPesMonthsSalsePlanHeaders(PesMonthsSalsePlanHeaders pesMonthsSalsePlanHeaders)
    {
        pesMonthsSalsePlanHeaders.setCreateBy(SecurityUtils.getUsername());
        checkAddAllowed(pesMonthsSalsePlanHeaders);
        return pesMonthsSalsePlanHeadersMapper.insertPesMonthsSalsePlanHeaders(pesMonthsSalsePlanHeaders);
    }

    /**
     * 校验是否允许增加
     *
     * @param pesMonthsSalsePlanHeaders 信息
     */
    public void checkAddAllowed(PesMonthsSalsePlanHeaders pesMonthsSalsePlanHeaders)
    {
        if (pesMonthsSalsePlanHeadersMapper.checkAddAllowed(pesMonthsSalsePlanHeaders) > 0 ? true : false)
        {
            throw new CustomException("每个产品线的批次号具有唯一性！");
        }
    }


    /**
     * 批量删除月度销售计划头
     * 
     * @param ids 需要删除的月度销售计划头ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePesMonthsSalsePlanHeadersByIds(Long ids)
    {
        return pesMonthsSalsePlanHeadersMapper.deletePesMonthsSalsePlanHeadersByIds(ids);
    }

    @Override
    public void checkDeleteAllowed(Long ids)
    {
        if (pesMonthsSalsePlanHeadersMapper.checkDeleteAllowed(ids) > 0 ? true : false)
        {
            throw new CustomException("已经产生计算结，不允许删除！");
        }
    }
}
