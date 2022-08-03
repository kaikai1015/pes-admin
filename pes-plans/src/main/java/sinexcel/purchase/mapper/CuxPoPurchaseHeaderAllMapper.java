package sinexcel.purchase.mapper;

import java.util.List;
import sinexcel.purchase.domain.CuxPoPurchaseHeaderAll;

/**
 * 管理采购单Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-01-22
 */
public interface CuxPoPurchaseHeaderAllMapper 
{
    /**
     * 查询管理采购单
     * 
     * @param poHeaderId 管理采购单ID
     * @return 管理采购单
     */
    public CuxPoPurchaseHeaderAll selectCuxPoPurchaseHeaderAllById(Long poHeaderId);

    /**
     * 查询管理采购单列表
     * 
     * @param cuxPoPurchaseHeaderAll 管理采购单
     * @return 管理采购单集合
     */
    public List<CuxPoPurchaseHeaderAll> selectCuxPoPurchaseHeaderAllList(CuxPoPurchaseHeaderAll cuxPoPurchaseHeaderAll);

    /**
     * 新增管理采购单
     * 
     * @param cuxPoPurchaseHeaderAll 管理采购单
     * @return 结果
     */
    public int insertCuxPoPurchaseHeaderAll(CuxPoPurchaseHeaderAll cuxPoPurchaseHeaderAll);

    /**
     * 修改管理采购单
     * 
     * @param cuxPoPurchaseHeaderAll 管理采购单
     * @return 结果
     */
    public int updateCuxPoPurchaseHeaderAll(CuxPoPurchaseHeaderAll cuxPoPurchaseHeaderAll);

    public CuxPoPurchaseHeaderAll getLastPoNum();

}
