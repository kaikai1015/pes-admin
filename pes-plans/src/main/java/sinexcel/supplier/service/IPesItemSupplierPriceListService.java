package sinexcel.supplier.service;

import java.util.List;
import sinexcel.supplier.domain.PesItemSupplierPriceList;

/**
 * 报价单Service接口
 * 
 * @author Zhang Kai
 * @date 2020-12-20
 */
public interface IPesItemSupplierPriceListService 
{
    /**
     * 查询报价单列表
     * 
     * @param pesItemSupplierPriceList 报价单
     * @return 报价单集合
     */
    public List<PesItemSupplierPriceList> selectPesItemSupplierPriceListList(PesItemSupplierPriceList pesItemSupplierPriceList);

    /**
     * 新增报价单
     * 
     * @param pesItemSupplierPriceList 报价单
     * @return 结果
     */
    public int insertPesItemSupplierPriceList(PesItemSupplierPriceList pesItemSupplierPriceList);

    /**
     * 批量删除报价单
     * 
     * @param itemPriceIds 需要删除的报价单ID
     * @return 结果
     */
    public int deletePesItemSupplierPriceListByIds(Long[] itemPriceIds);

    /**
     * 校验是否唯一
     *
     * @param pesItemSupplierPriceList 用户名称
     * @return 结果
     */
    public String checkItemPriceListUnique(PesItemSupplierPriceList pesItemSupplierPriceList);

}
