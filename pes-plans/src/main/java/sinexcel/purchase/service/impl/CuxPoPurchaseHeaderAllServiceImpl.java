package sinexcel.purchase.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.purchase.mapper.CuxPoPurchaseHeaderAllMapper;
import sinexcel.purchase.domain.CuxPoPurchaseHeaderAll;
import sinexcel.purchase.service.ICuxPoPurchaseHeaderAllService;

/**
 * 管理采购单Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-01-22
 */
@Service
public class CuxPoPurchaseHeaderAllServiceImpl implements ICuxPoPurchaseHeaderAllService 
{
    @Autowired
    private CuxPoPurchaseHeaderAllMapper cuxPoPurchaseHeaderAllMapper;

    /**
     * 查询管理采购单
     * 
     * @param poHeaderId 管理采购单ID
     * @return 管理采购单
     */
    @Override
    public CuxPoPurchaseHeaderAll selectCuxPoPurchaseHeaderAllById(Long poHeaderId)
    {
        return cuxPoPurchaseHeaderAllMapper.selectCuxPoPurchaseHeaderAllById(poHeaderId);
    }

    /**
     * 查询管理采购单列表
     * 
     * @param cuxPoPurchaseHeaderAll 管理采购单
     * @return 管理采购单
     */
    @Override
    public List<CuxPoPurchaseHeaderAll> selectCuxPoPurchaseHeaderAllList(CuxPoPurchaseHeaderAll cuxPoPurchaseHeaderAll)
    {
        return cuxPoPurchaseHeaderAllMapper.selectCuxPoPurchaseHeaderAllList(cuxPoPurchaseHeaderAll);
    }

    /**
     * 新增管理采购单
     * 
     * @param cuxPoPurchaseHeaderAll 管理采购单
     * @return 结果
     */
    @Override
    @Transactional
    public int insertCuxPoPurchaseHeaderAll(CuxPoPurchaseHeaderAll cuxPoPurchaseHeaderAll)
    {
        CuxPoPurchaseHeaderAll getPoNum = cuxPoPurchaseHeaderAllMapper.getLastPoNum();
        cuxPoPurchaseHeaderAll.setCreateBy(SecurityUtils.getUsername());
        cuxPoPurchaseHeaderAll.setBuyerName(SecurityUtils.getUsername());
        cuxPoPurchaseHeaderAll.setPoNumber(getPoNum.getPoNumber());
        return cuxPoPurchaseHeaderAllMapper.insertCuxPoPurchaseHeaderAll(cuxPoPurchaseHeaderAll);
    }

    /**
     * 修改管理采购单
     * 
     * @param cuxPoPurchaseHeaderAll 管理采购单
     * @return 结果
     */
    @Override
    @Transactional
    public int updateCuxPoPurchaseHeaderAll(CuxPoPurchaseHeaderAll cuxPoPurchaseHeaderAll)
    {
        return cuxPoPurchaseHeaderAllMapper.updateCuxPoPurchaseHeaderAll(cuxPoPurchaseHeaderAll);
    }
}
