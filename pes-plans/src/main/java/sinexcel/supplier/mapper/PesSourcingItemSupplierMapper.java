package sinexcel.supplier.mapper;

import java.util.List;
import sinexcel.supplier.domain.PesSourcingItemSupplier;

/**
 * 寻源规则Mapper接口
 * 
 * @author Zhang Kai
 * @date 2020-12-18
 */
public interface PesSourcingItemSupplierMapper 
{

    /**
     * 查询寻源规则列表
     * 
     * @param pesSourcingItemSupplier 寻源规则
     * @return 寻源规则集合
     */
    public List<PesSourcingItemSupplier> selectPesSourcingItemSupplierList(PesSourcingItemSupplier pesSourcingItemSupplier);

    /**
     * 新增寻源规则
     * 
     * @param pesSourcingItemSupplier 寻源规则
     * @return 结果
     */
    public int insertPesSourcingItemSupplier(PesSourcingItemSupplier pesSourcingItemSupplier);

    /**
     * 修改寻源规则
     * 
     * @param colums 寻源规则
     * @return 结果
     */
    public int updatePesSourcingItemSupplier(PesSourcingItemSupplier colums);
    /**
     * 校验物料编码是否唯一
     *
     * @param pesSourcingItemSupplier 用户名称
     * @return 结果
     */
    public int checkItemSupplierUnique(PesSourcingItemSupplier pesSourcingItemSupplier);

    /**
     * 查询寻源规则
     *
     * @param sourcingItemId 寻源规则ID
     * @return 寻源规则
     */
    public PesSourcingItemSupplier selectPesSourcingItemSupplierById(Long sourcingItemId);
}
