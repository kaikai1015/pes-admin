package sinexcel.supplier.service;

import java.util.List;
import sinexcel.supplier.domain.PesItemQuantityPriceList;

/**
 * 分量计价Service接口
 * 
 * @author Zhang Kai
 * @date 2020-12-24
 */
public interface IPesItemQuantityPriceListService 
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
     * @param quantityPriceId 需要删除的分量计价ID
     * @return 结果
     */
    public int deletePesItemQuantityPriceListByIds(Long quantityPriceId);

    /**
     * 校验分量计价是否唯一
     *
     * @param pesItemQuantityPriceList 用户名称
     * @return 结果
     */
    public String checkItemQuantityListUnique(PesItemQuantityPriceList pesItemQuantityPriceList);

    public String checkItemQuantityListOAUnique(Long itemPriceId);

    public String checkItemQuantityListDelete(Long quantityPriceId);
}
