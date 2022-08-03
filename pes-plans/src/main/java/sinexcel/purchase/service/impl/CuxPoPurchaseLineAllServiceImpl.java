package sinexcel.purchase.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.purchase.mapper.CuxPoPurchaseLineAllMapper;
import sinexcel.purchase.domain.CuxPoPurchaseLineAll;
import sinexcel.purchase.service.ICuxPoPurchaseLineAllService;

/**
 * 采购行信息Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-01-25
 */
@Service
public class CuxPoPurchaseLineAllServiceImpl implements ICuxPoPurchaseLineAllService 
{
    @Autowired
    private CuxPoPurchaseLineAllMapper cuxPoPurchaseLineAllMapper;

    /**
     * 查询采购行信息
     * 
     * @param poLineId 采购行信息ID
     * @return 采购行信息
     */
    @Override
    public CuxPoPurchaseLineAll selectCuxPoPurchaseLineAllById(Long poLineId)
    {
        return cuxPoPurchaseLineAllMapper.selectCuxPoPurchaseLineAllById(poLineId);
    }

    /**
     * 查询采购行信息列表
     * 
     * @param cuxPoPurchaseLineAll 采购行信息
     * @return 采购行信息
     */
    @Override
    public List<CuxPoPurchaseLineAll> selectCuxPoPurchaseLineAllList(CuxPoPurchaseLineAll cuxPoPurchaseLineAll)
    {
        return cuxPoPurchaseLineAllMapper.selectCuxPoPurchaseLineAllList(cuxPoPurchaseLineAll);
    }

    /**
     * 新增采购行信息
     * 
     * @param cuxPoPurchaseLineAll 采购行信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertCuxPoPurchaseLineAll(CuxPoPurchaseLineAll cuxPoPurchaseLineAll)
    {
        return cuxPoPurchaseLineAllMapper.insertCuxPoPurchaseLineAll(cuxPoPurchaseLineAll);
    }

    /**
     * 修改采购行信息
     * 
     * @param cuxPoPurchaseLineAll 采购行信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateCuxPoPurchaseLineAll(CuxPoPurchaseLineAll cuxPoPurchaseLineAll)
    {
        return cuxPoPurchaseLineAllMapper.updateCuxPoPurchaseLineAll(cuxPoPurchaseLineAll);
    }

    /**
     * 批量删除采购行信息
     * 
     * @param poLineIds 需要删除的采购行信息ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteCuxPoPurchaseLineAllByIds(Long[] poLineIds)
    {
        return cuxPoPurchaseLineAllMapper.deleteCuxPoPurchaseLineAllByIds(poLineIds);
    }

    /**
     * 删除采购行信息信息
     * 
     * @param poLineId 采购行信息ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteCuxPoPurchaseLineAllById(Long poLineId)
    {
        return cuxPoPurchaseLineAllMapper.deleteCuxPoPurchaseLineAllById(poLineId);
    }
}
