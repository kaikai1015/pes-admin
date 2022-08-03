package sinexcel.weeks.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.weeks.mapper.CuxWieWorkQianliaoHeaderMapper;
import sinexcel.weeks.domain.CuxWieWorkQianliaoHeader;
import sinexcel.weeks.service.ICuxWieWorkQianliaoHeaderService;

/**
 * 排程欠料头信息Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-11-05
 */
@Service
public class CuxWieWorkQianliaoHeaderServiceImpl implements ICuxWieWorkQianliaoHeaderService 
{
    @Autowired
    private CuxWieWorkQianliaoHeaderMapper cuxWieWorkQianliaoHeaderMapper;

    /**
     * 查询排程欠料头信息列表
     * 
     * @param cuxWieWorkQianliaoHeader 排程欠料头信息
     * @return 排程欠料头信息
     */
    @Override
    public List<CuxWieWorkQianliaoHeader> selectCuxWieWorkQianliaoHeaderList(CuxWieWorkQianliaoHeader cuxWieWorkQianliaoHeader)
    {
        return cuxWieWorkQianliaoHeaderMapper.selectCuxWieWorkQianliaoHeaderList(cuxWieWorkQianliaoHeader);
    }

    /**
     * 新增排程欠料头信息
     * 
     * @param cuxWieWorkQianliaoHeader 排程欠料头信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int insertCuxWieWorkQianliaoHeader(CuxWieWorkQianliaoHeader cuxWieWorkQianliaoHeader)
    {
        cuxWieWorkQianliaoHeader.setCreateBy(SecurityUtils.getUsername());
        return cuxWieWorkQianliaoHeaderMapper.insertCuxWieWorkQianliaoHeader(cuxWieWorkQianliaoHeader);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int deleteCuxWieWorkQianliaoHeaderById(Long lotNumber)
    {
        cuxWieWorkQianliaoHeaderMapper.insertCuxWieWorkQianliaoHeaderById(lotNumber);
        return cuxWieWorkQianliaoHeaderMapper.deleteCuxWieWorkQianliaoHeaderById(lotNumber);
    }
}
