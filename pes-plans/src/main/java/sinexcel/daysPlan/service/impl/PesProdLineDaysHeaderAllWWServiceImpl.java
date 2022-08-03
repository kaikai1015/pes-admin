package sinexcel.daysPlan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.annotation.DataScope;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.daysPlan.mapper.PesProdLineDaysHeaderAllWWMapper;
import sinexcel.daysPlan.domain.PesProdLineDaysHeaderAllWW;
import sinexcel.daysPlan.service.IPesProdLineDaysHeaderAllWWService;

/**
 * 日计划Service业务层处理
 *
 * @author Zhang Kai
 * @date 2021-06-07
 */
@Service
public class PesProdLineDaysHeaderAllWWServiceImpl implements IPesProdLineDaysHeaderAllWWService
{
    @Autowired
    private PesProdLineDaysHeaderAllWWMapper pesProdLineDaysHeaderAllMapper;

    /**
     * 查询日计划
     *
     * @param id 日计划ID
     * @return 日计划
     */
    @Override
    public PesProdLineDaysHeaderAllWW selectPesProdLineDaysHeaderAllById(Long id)
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
    @DataScope(deptAlias = "d")
    public List<PesProdLineDaysHeaderAllWW> selectPesProdLineDaysHeaderAllList(PesProdLineDaysHeaderAllWW pesProdLineDaysHeaderAll)
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
    public int insertPesProdLineDaysHeaderAll(PesProdLineDaysHeaderAllWW pesProdLineDaysHeaderAll)
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
