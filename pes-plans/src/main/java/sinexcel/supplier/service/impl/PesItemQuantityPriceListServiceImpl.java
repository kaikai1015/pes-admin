package sinexcel.supplier.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.constant.UserConstants;
import sinexcel.supplier.mapper.PesItemQuantityPriceListMapper;
import sinexcel.supplier.domain.PesItemQuantityPriceList;
import sinexcel.supplier.service.IPesItemQuantityPriceListService;

/**
 * 分量计价Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-12-24
 */
@Service
public class PesItemQuantityPriceListServiceImpl implements IPesItemQuantityPriceListService 
{
    @Autowired
    private PesItemQuantityPriceListMapper pesItemQuantityPriceListMapper;


    /**
     * 查询分量计价列表
     * 
     * @param pesItemQuantityPriceList 分量计价
     * @return 分量计价
     */
    @Override
    public List<PesItemQuantityPriceList> selectPesItemQuantityPriceListList(PesItemQuantityPriceList pesItemQuantityPriceList)
    {
        return pesItemQuantityPriceListMapper.selectPesItemQuantityPriceListList(pesItemQuantityPriceList);
    }

    /**
     * 新增分量计价
     * 
     * @param pesItemQuantityPriceList 分量计价
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPesItemQuantityPriceList(PesItemQuantityPriceList pesItemQuantityPriceList)
    {
        return pesItemQuantityPriceListMapper.insertPesItemQuantityPriceList(pesItemQuantityPriceList);
    }

    /**
     * 批量删除分量计价
     * 
     * @param quantityPriceId 需要删除的分量计价ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePesItemQuantityPriceListByIds(Long quantityPriceId)
    {
        return pesItemQuantityPriceListMapper.deletePesItemQuantityPriceListByIds(quantityPriceId);
    }

    /**
     * 校验分量计价是否唯一
     *
     * @param pesItemQuantityPriceList 用户名称
     * @return 结果
     */
    @Override
    public String checkItemQuantityListUnique(PesItemQuantityPriceList pesItemQuantityPriceList)
    {
        int count = pesItemQuantityPriceListMapper.checkItemQuantityListUnique(pesItemQuantityPriceList);
        if (count > 0)
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验是否OA审批能否再次添加
     *
     * @param itemPriceId 用户名称
     * @return 结果
     */
    @Override
    public String checkItemQuantityListOAUnique(Long itemPriceId)
    {
        int count = pesItemQuantityPriceListMapper.checkItemQuantityListOAUnique(itemPriceId);
        if (count > 0)
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验是否可以删除
     *
     * @param quantityPriceId 用户名称
     * @return 结果
     */
    @Override
    public String checkItemQuantityListDelete(Long quantityPriceId)
    {
        int count = pesItemQuantityPriceListMapper.checkItemQuantityListDelete(quantityPriceId);
        if (count > 0)
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }
}
