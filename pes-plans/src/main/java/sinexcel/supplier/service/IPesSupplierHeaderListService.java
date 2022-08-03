package sinexcel.supplier.service;

import java.util.List;
import sinexcel.supplier.domain.PesSupplierHeaderList;

/**
 * 供应商基础信息Service接口
 * 
 * @author Zhang Kai
 * @date 2020-12-17
 */
public interface IPesSupplierHeaderListService 
{

    /**
     * 查询供应商基础信息列表
     * 
     * @param pesSupplierHeaderList 供应商基础信息
     * @return 供应商基础信息集合
     */
    public List<PesSupplierHeaderList> selectPesSupplierHeaderListList(PesSupplierHeaderList pesSupplierHeaderList);

    /**
     * 新增供应商基础信息
     * 
     * @param pesSupplierHeaderList 供应商基础信息
     * @return 结果
     */
    public int insertPesSupplierHeaderList(PesSupplierHeaderList pesSupplierHeaderList);

    /**
     * 校验供应商编码是否唯一
     *
     * @param supplierNumber 用户名称
     * @return 结果
     */
    public String checkSupplierNumberUnique(String supplierNumber);

    /**
     * 查询供应商基础信息
     *
     * @param supplierId 供应商基础信息ID
     * @return 供应商基础信息
     */
    public PesSupplierHeaderList selectPesSupplierHeaderListById(Long supplierId);

    /**
     * 修改供应商基础信息
     *
     * @param pesSupplierHeaderList 供应商基础信息
     * @return 结果
     */
    public int updatePesSupplierHeaderList(PesSupplierHeaderList pesSupplierHeaderList);

    public List<PesSupplierHeaderList> getAllSupplier();
}
