package sinexcel.por.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.por.mapper.CuxPorRequisitionHeaderAllMapper;
import sinexcel.por.domain.CuxPorRequisitionHeaderAll;
import sinexcel.por.service.ICuxPorRequisitionHeaderAllService;

/**
 * 管理请购单Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-12-30
 */
@Service
public class CuxPorRequisitionHeaderAllServiceImpl implements ICuxPorRequisitionHeaderAllService 
{
    @Autowired
    private CuxPorRequisitionHeaderAllMapper cuxPorRequisitionHeaderAllMapper;

    /**
     * 查询管理请购单列表
     * 
     * @param cuxPorRequisitionHeaderAll 管理请购单
     * @return 管理请购单
     */
    @Override
    public List<CuxPorRequisitionHeaderAll> selectCuxPorRequisitionHeaderAllList(CuxPorRequisitionHeaderAll cuxPorRequisitionHeaderAll)
    {
        return cuxPorRequisitionHeaderAllMapper.selectCuxPorRequisitionHeaderAllList(cuxPorRequisitionHeaderAll);
    }

    /**
     * 新增管理请购单
     * 
     * @param cuxPorRequisitionHeaderAll 管理请购单
     * @return 结果
     */
    @Override
    @Transactional
    public int insertCuxPorRequisitionHeaderAll(CuxPorRequisitionHeaderAll cuxPorRequisitionHeaderAll)
    {
        CuxPorRequisitionHeaderAll getPorNum = cuxPorRequisitionHeaderAllMapper.getLastPorNum();
        cuxPorRequisitionHeaderAll.setRequisitioningNumber(getPorNum.getRequisitioningNumber());
        cuxPorRequisitionHeaderAll.setCreateBy(SecurityUtils.getUsername());
        cuxPorRequisitionHeaderAll.setRequisitioningBuyer(SecurityUtils.getUsername());
        return cuxPorRequisitionHeaderAllMapper.insertCuxPorRequisitionHeaderAll(cuxPorRequisitionHeaderAll);
    }

    /**
     * 查询管理请购单
     *
     * @param requisitioningId 管理请购单ID
     * @return 管理请购单
     */
    @Override
    public CuxPorRequisitionHeaderAll selectCuxPorRequisitionHeaderAllById(Long requisitioningId)
    {
        return cuxPorRequisitionHeaderAllMapper.selectCuxPorRequisitionHeaderAllById(requisitioningId);
    }

    /**
     * 修改管理请购单
     *
     * @param cuxPorRequisitionHeaderAll 管理请购单
     * @return 结果
     */
    @Override
    @Transactional
    public int updateCuxPorRequisitionHeaderAll(CuxPorRequisitionHeaderAll cuxPorRequisitionHeaderAll)
    {
        return cuxPorRequisitionHeaderAllMapper.updateCuxPorRequisitionHeaderAll(cuxPorRequisitionHeaderAll);
    }

}
