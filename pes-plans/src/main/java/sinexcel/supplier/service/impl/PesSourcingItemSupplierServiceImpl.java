package sinexcel.supplier.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.constant.UserConstants;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.supplier.mapper.PesSourcingItemSupplierMapper;
import sinexcel.supplier.domain.PesSourcingItemSupplier;
import sinexcel.supplier.service.IPesSourcingItemSupplierService;

/**
 * 寻源规则Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-12-18
 */
@Service
public class PesSourcingItemSupplierServiceImpl implements IPesSourcingItemSupplierService 
{
    @Autowired
    private PesSourcingItemSupplierMapper pesSourcingItemSupplierMapper;

    /**
     * 查询寻源规则列表
     * 
     * @param pesSourcingItemSupplier 寻源规则
     * @return 寻源规则
     */
    @Override
    public List<PesSourcingItemSupplier> selectPesSourcingItemSupplierList(PesSourcingItemSupplier pesSourcingItemSupplier)
    {
        return pesSourcingItemSupplierMapper.selectPesSourcingItemSupplierList(pesSourcingItemSupplier);
    }

    /**
     * 新增寻源规则
     * 
     * @param pesSourcingItemSupplier 寻源规则
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPesSourcingItemSupplier(PesSourcingItemSupplier pesSourcingItemSupplier)
    {
        return pesSourcingItemSupplierMapper.insertPesSourcingItemSupplier(pesSourcingItemSupplier);
    }

    /**
     * 校验物料编码是否唯一
     *
     * @param pesSourcingItemSupplier 用户名称
     * @return 结果
     */
    @Override
    public String checkItemSupplierUnique(PesSourcingItemSupplier pesSourcingItemSupplier)
    {
        int count = pesSourcingItemSupplierMapper.checkItemSupplierUnique(pesSourcingItemSupplier);
        if (count > 0)
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 修改寻源规则
     *
     * @param pesSourcingItemSupplier 寻源规则
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePesSourcingItemSupplier(List<PesSourcingItemSupplier> pesSourcingItemSupplier)
    {
        int j = 0;
        for(PesSourcingItemSupplier colums :pesSourcingItemSupplier){
            colums.setLastUpdateBy(SecurityUtils.getUsername());
            j = pesSourcingItemSupplierMapper.updatePesSourcingItemSupplier(colums);
        }
        return j;
    }

    /**
     * 查询寻源规则
     *
     * @param sourcingItemId 寻源规则ID
     * @return 寻源规则
     */
    @Override
    public PesSourcingItemSupplier selectPesSourcingItemSupplierById(Long sourcingItemId)
    {
        return pesSourcingItemSupplierMapper.selectPesSourcingItemSupplierById(sourcingItemId);
    }
}
