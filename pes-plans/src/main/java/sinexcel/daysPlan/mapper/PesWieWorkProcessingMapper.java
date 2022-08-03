package sinexcel.daysPlan.mapper;

import org.apache.ibatis.annotations.Param;
import sinexcel.daysPlan.domain.PesWieWorkProcessing;

import java.math.BigDecimal;
import java.util.List;

/**
 * WMS工单执行情况数据Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-09-08
 */
public interface PesWieWorkProcessingMapper 
{
    /**
     * 查询WMS工单执行情况数据
     * 
     * @param workOrderId WMS工单执行情况数据ID
     * @return WMS工单执行情况数据
     */
    public PesWieWorkProcessing selectPesWieWorkProcessingById(Long workOrderId);

    /**
     * 查询WMS工单执行情况数据列表
     * 
     * @param pesWieWorkProcessing WMS工单执行情况数据
     * @return WMS工单执行情况数据集合
     */
    public List<PesWieWorkProcessing> selectPesWieWorkProcessingList(PesWieWorkProcessing pesWieWorkProcessing);

    /**
     * 新增WMS工单执行情况数据
     * 
     * @param pesWieWorkProcessing WMS工单执行情况数据
     * @return 结果
     */
    public int insertPesWieWorkProcessing(PesWieWorkProcessing pesWieWorkProcessing);

    /**
     * 修改WMS工单执行情况数据
     * 
     * @param pesWieWorkProcessing WMS工单执行情况数据
     * @return 结果
     */
    public int updatePesWieWorkProcessing(PesWieWorkProcessing pesWieWorkProcessing);

    /**
     * 删除WMS工单执行情况数据
     * 
     * @param workOrderId WMS工单执行情况数据ID
     * @return 结果
     */
    public int deletePesWieWorkProcessingById(Long workOrderId);

    /**
     * 批量删除WMS工单执行情况数据
     * 
     * @param workOrderIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePesWieWorkProcessingByIds(Long[] workOrderIds);
    /**
     * @Author mingshen.wang
     * @Description 根据类型累加对应的数量
     * @Date 11:01 2021/9/8
     * @Param [workOrderId, organizationId, qty, type：COMPLETE-工单入库；LAO_HUA-老化；TEST-测试；BAO_ZHUANG-包装；
     * ZU_ZHUANG_START-投料；ZU_ZHUANG_CAI-？；ZU_ZHUANG_END-装配完成]
     * @return int
     **/
    int sumQuantity(@Param("workOrderId") Long workOrderId,@Param("organizationId") Long organizationId,
                    @Param("qty") BigDecimal qty, @Param("type") String type);

    void insertInit(@Param("pId") Long pId,@Param("userName") String userName,@Param("isWw") String isWw);
}
