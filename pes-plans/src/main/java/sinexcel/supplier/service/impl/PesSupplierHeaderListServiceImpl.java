package sinexcel.supplier.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.constant.UserConstants;
import sinexcel.supplier.mapper.PesSupplierHeaderListMapper;
import sinexcel.supplier.domain.PesSupplierHeaderList;
import sinexcel.supplier.service.IPesSupplierHeaderListService;

/**
 * 供应商基础信息Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-12-17
 */
@Service
public class PesSupplierHeaderListServiceImpl implements IPesSupplierHeaderListService 
{
    @Autowired
    private PesSupplierHeaderListMapper pesSupplierHeaderListMapper;

    /**
     * 查询供应商基础信息列表
     * 
     * @param pesSupplierHeaderList 供应商基础信息
     * @return 供应商基础信息
     */
    @Override
    public List<PesSupplierHeaderList> selectPesSupplierHeaderListList(PesSupplierHeaderList pesSupplierHeaderList)
    {
        return pesSupplierHeaderListMapper.selectPesSupplierHeaderListList(pesSupplierHeaderList);
    }

    /**
     * 新增供应商基础信息
     * 
     * @param pesSupplierHeaderList 供应商基础信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPesSupplierHeaderList(PesSupplierHeaderList pesSupplierHeaderList)
    {
        return pesSupplierHeaderListMapper.insertPesSupplierHeaderList(pesSupplierHeaderList);
    }

    /**
     * 校验供应商编码是否唯一
     *
     * @param supplierNumber 用户名称
     * @return 结果
     */
    @Override
    public String checkSupplierNumberUnique(String supplierNumber)
    {
        int count = pesSupplierHeaderListMapper.checkSupplierNumberUnique(supplierNumber);
        if (count > 0)
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 查询供应商基础信息
     *
     * @param supplierId 供应商基础信息ID
     * @return 供应商基础信息
     */
    @Override
    public PesSupplierHeaderList selectPesSupplierHeaderListById(Long supplierId)
    {
        return pesSupplierHeaderListMapper.selectPesSupplierHeaderListById(supplierId);
    }

    /**
     * 修改供应商基础信息
     *
     * @param pesSupplierHeaderList 供应商基础信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePesSupplierHeaderList(PesSupplierHeaderList pesSupplierHeaderList)
    {
        return pesSupplierHeaderListMapper.updatePesSupplierHeaderList(pesSupplierHeaderList);
    }

    @Override
    public List<PesSupplierHeaderList> getAllSupplier()
    {
        return pesSupplierHeaderListMapper.getAllSupplier();
    }
}
