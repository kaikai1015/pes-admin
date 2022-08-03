package sinexcel.supplier.mapper;

import java.util.List;
import sinexcel.supplier.domain.PesItemQuantityPriceList;

/**
 * 分量计价Mapper接口
 * 
 * @author Zhang Kai
 * @date 2020-12-24
 */
public interface PesItemQuantityPriceListMapper 
{

    /**
     * 查询分量计价列表
     * 
     * @param pesItemQuantityPriceList 分量计价
     * @return 分量计价集合
     */
    public List<PesItemQuantityPriceList> selectPesItemQuantityPriceListList(PesItemQuantityPriceList pesItemQuantityPriceList);

    /**
     * 新增分量计价
     * 
     * @param pesItemQuantityPriceList 分量计价
     * @return 结果
     */
    public int insertPesItemQuantityPriceList(PesItemQuantityPriceList pesItemQuantityPriceList);


    /**
     * 批量删除分量计价
     * 
     * @param quantityPriceId 需要删除的数据ID
     * @return 结果
     */
    public int deletePesItemQuantityPriceListByIds(Long quantityPriceId);

    /**
     * 校验分量计价是否唯一
     *
     * @param pesItemQuantityPriceList 用户名称
     * @return 结果
     */
    public int checkItemQuantityListUnique(PesItemQuantityPriceList pesItemQuantityPriceList);

    /**
     * 校验是否OA审批能否再次添加
     *
     * @param itemPriceId 用户名称
     * @return 结果
     */
    public int checkItemQuantityListOAUnique(Long itemPriceId);

    /**
     * 校验是否可以删除
     *
     * @param quantityPriceId 用户名称
     * @return 结果
     */
    public int checkItemQuantityListDelete(Long quantityPriceId);
}
