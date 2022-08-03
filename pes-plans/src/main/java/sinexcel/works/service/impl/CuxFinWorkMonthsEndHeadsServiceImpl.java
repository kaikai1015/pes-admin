package sinexcel.works.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.works.mapper.CuxFinWorkMonthsEndHeadsMapper;
import sinexcel.works.domain.CuxFinWorkMonthsEndHeads;
import sinexcel.works.service.ICuxFinWorkMonthsEndHeadsService;

/**
 * 月结工单操作Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-05-07
 */
@Service
public class CuxFinWorkMonthsEndHeadsServiceImpl implements ICuxFinWorkMonthsEndHeadsService 
{
    @Autowired
    private CuxFinWorkMonthsEndHeadsMapper cuxFinWorkMonthsEndHeadsMapper;

    /**
     * 查询月结工单操作列表
     * 
     * @param cuxFinWorkMonthsEndHeads 月结工单操作
     * @return 月结工单操作
     */
    @Override
    public List<CuxFinWorkMonthsEndHeads> selectCuxFinWorkMonthsEndHeadsList(CuxFinWorkMonthsEndHeads cuxFinWorkMonthsEndHeads)
    {
        return cuxFinWorkMonthsEndHeadsMapper.selectCuxFinWorkMonthsEndHeadsList(cuxFinWorkMonthsEndHeads);
    }

    /**
     * 新增月结工单操作
     * 
     * @param cuxFinWorkMonthsEndHeads 月结工单操作
     * @return 结果
     */
    @Override
    @Transactional
    public int insertCuxFinWorkMonthsEndHeads(CuxFinWorkMonthsEndHeads cuxFinWorkMonthsEndHeads)
    {
        return cuxFinWorkMonthsEndHeadsMapper.insertCuxFinWorkMonthsEndHeads(cuxFinWorkMonthsEndHeads);
    }

    @Override
    public void checkAddAllowed(Long lotNum)
    {
        if (cuxFinWorkMonthsEndHeadsMapper.checkAddAllowed(lotNum) > 0 ? true : false)
        {
            throw new CustomException("每个批次号具有唯一性,请重新批次号！！！");
        }
    }

    /**
     * 批量删除月结工单操作
     * 
     * @param lotNums 需要删除的月结工单操作ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteCuxFinWorkMonthsEndHeadsByIds(Long lotNums)
    {
        return cuxFinWorkMonthsEndHeadsMapper.deleteCuxFinWorkMonthsEndHeadsByIds(lotNums);
    }

    @Override
    public void checkDeletellowed(Long lotNum)
    {
        if (cuxFinWorkMonthsEndHeadsMapper.checkDeletellowed(lotNum) > 0 ? true : false)
        {
            throw new CustomException("有工单数据修改提交到ERP，不允许删除！！！");
        }
    }

}
