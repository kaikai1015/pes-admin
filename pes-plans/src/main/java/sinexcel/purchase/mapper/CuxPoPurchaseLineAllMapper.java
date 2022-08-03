package sinexcel.purchase.mapper;

import java.util.List;
import sinexcel.purchase.domain.CuxPoPurchaseLineAll;

/**
 * 采购行信息Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-01-25
 */
public interface CuxPoPurchaseLineAllMapper 
{
    /**
     * 查询采购行信息
     * 
     * @param poLineId 采购行信息ID
     * @return 采购行信息
     */
    public CuxPoPurchaseLineAll selectCuxPoPurchaseLineAllById(Long poLineId);

    /**
     * 查询采购行信息列表
     * 
     * @param cuxPoPurchaseLineAll 采购行信息
     * @return 采购行信息集合
     */
    public List<CuxPoPurchaseLineAll> selectCuxPoPurchaseLineAllList(CuxPoPurchaseLineAll cuxPoPurchaseLineAll);

    /**
     * 新增采购行信息
     * 
     * @param cuxPoPurchaseLineAll 采购行信息
     * @return 结果
     */
    public int insertCuxPoPurchaseLineAll(CuxPoPurchaseLineAll cuxPoPurchaseLineAll);

    /**
     * 修改采购行信息
     * 
     * @param cuxPoPurchaseLineAll 采购行信息
     * @return 结果
     */
    public int updateCuxPoPurchaseLineAll(CuxPoPurchaseLineAll cuxPoPurchaseLineAll);

    /**
     * 删除采购行信息
     * 
     * @param poLineId 采购行信息ID
     * @return 结果
     */
    public int deleteCuxPoPurchaseLineAllById(Long poLineId);

    /**
     * 批量删除采购行信息
     * 
     * @param poLineIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCuxPoPurchaseLineAllByIds(Long[] poLineIds);
}
