package sinexcel.supplier.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.constant.UserConstants;
import sinexcel.supplier.mapper.PesItemSupplierPriceListMapper;
import sinexcel.supplier.domain.PesItemSupplierPriceList;
import sinexcel.supplier.service.IPesItemSupplierPriceListService;

/**
 * 报价单Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-12-20
 */
@Service
public class PesItemSupplierPriceListServiceImpl implements IPesItemSupplierPriceListService 
{
    @Autowired
    private PesItemSupplierPriceListMapper pesItemSupplierPriceListMapper;


    /**
     * 查询报价单列表
     * 
     * @param pesItemSupplierPriceList 报价单
     * @return 报价单
     */
    @Override
    public List<PesItemSupplierPriceList> selectPesItemSupplierPriceListList(PesItemSupplierPriceList pesItemSupplierPriceList)
    {
        return pesItemSupplierPriceListMapper.selectPesItemSupplierPriceListList(pesItemSupplierPriceList);
    }

    /**
     * 新增报价单
     * 
     * @param pesItemSupplierPriceList 报价单
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPesItemSupplierPriceList(PesItemSupplierPriceList pesItemSupplierPriceList)
    {
        return pesItemSupplierPriceListMapper.insertPesItemSupplierPriceList(pesItemSupplierPriceList);
    }

    /**
     * 批量删除报价单
     * 
     * @param itemPriceIds 需要删除的报价单ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePesItemSupplierPriceListByIds(Long[] itemPriceIds)
    {
        return pesItemSupplierPriceListMapper.deletePesItemSupplierPriceListByIds(itemPriceIds);
    }

    /**
     * 校验物料编码是否唯一
     *
     * @param pesItemSupplierPriceList 用户名称
     * @return 结果
     */
    @Override
    public String checkItemPriceListUnique(PesItemSupplierPriceList pesItemSupplierPriceList)
    {
        int count = pesItemSupplierPriceListMapper.checkItemPriceListUnique(pesItemSupplierPriceList);
        if (count > 0)
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }
}
