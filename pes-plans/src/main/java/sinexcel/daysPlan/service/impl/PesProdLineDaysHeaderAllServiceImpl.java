package sinexcel.daysPlan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.daysPlan.mapper.PesProdLineDaysHeaderAllMapper;
import sinexcel.daysPlan.domain.PesProdLineDaysHeaderAll;
import sinexcel.daysPlan.service.IPesProdLineDaysHeaderAllService;

/**
 * 日计划Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-06-07
 */
@Service
public class PesProdLineDaysHeaderAllServiceImpl implements IPesProdLineDaysHeaderAllService 
{
    @Autowired
    private PesProdLineDaysHeaderAllMapper pesProdLineDaysHeaderAllMapper;

    /**
     * 查询日计划
     *
     * @param id 日计划ID
     * @return 日计划
     */
    @Override
    public PesProdLineDaysHeaderAll selectPesProdLineDaysHeaderAllById(Long id)
    {
        return pesProdLineDaysHeaderAllMapper.selectPesProdLineDaysHeaderAllById(id);
    }
    /**
     * 查询日计划列表
     * 
     * @param pesProdLineDaysHeaderAll 日计划
     * @return 日计划
     */
    @Override
    public List<PesProdLineDaysHeaderAll> selectPesProdLineDaysHeaderAllList(PesProdLineDaysHeaderAll pesProdLineDaysHeaderAll)
    {
        return pesProdLineDaysHeaderAllMapper.selectPesProdLineDaysHeaderAllList(pesProdLineDaysHeaderAll);
    }

    /**
     * 新增日计划
     * 
     * @param pesProdLineDaysHeaderAll 日计划
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPesProdLineDaysHeaderAll(PesProdLineDaysHeaderAll pesProdLineDaysHeaderAll)
    {
        pesProdLineDaysHeaderAll.setCreateBy(SecurityUtils.getUsername());
        return pesProdLineDaysHeaderAllMapper.insertPesProdLineDaysHeaderAll(pesProdLineDaysHeaderAll);
    }

    /**
     * 删除日计划信息
     *
     * @param id 日计划ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePesProdLineDaysHeaderAllById(Long id)
    {
        checkDeleteAllowed(id);
        return pesProdLineDaysHeaderAllMapper.deletePesProdLineDaysHeaderAllById(id);
    }

    //判断是否允许删除
    public void checkDeleteAllowed(Long id)
    {
        if (pesProdLineDaysHeaderAllMapper.checkDeleteAllowed(id) > 0 ? true : false)
        {
            throw new CustomException("已经产生明细数据，不允许删除！！！");
        }
    }
}
