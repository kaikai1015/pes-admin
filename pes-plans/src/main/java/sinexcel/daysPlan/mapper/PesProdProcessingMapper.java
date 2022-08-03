package sinexcel.daysPlan.mapper;

import org.apache.ibatis.annotations.Param;
import sinexcel.daysPlan.domain.PesProdProcessing;

import java.math.BigDecimal;
import java.util.List;

/**
 * 发料进度Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-09-08
 */
public interface PesProdProcessingMapper 
{
    /**
     * 查询发料进度
     * 
     * @param organizationId 发料进度ID
     * @return 发料进度
     */
    public PesProdProcessing selectPesProdProcessingById(Long organizationId);

    /**
     * 查询发料进度列表
     * 
     * @param pesProdProcessing 发料进度
     * @return 发料进度集合
     */
    public List<PesProdProcessing> selectPesProdProcessingList(PesProdProcessing pesProdProcessing);

    /**
     * 新增发料进度
     * 
     * @param pesProdProcessing 发料进度
     * @return 结果
     */
    public int insertPesProdProcessing(PesProdProcessing pesProdProcessing);

    /**
     * 修改发料进度
     * 
     * @param pesProdProcessing 发料进度
     * @return 结果
     */
    public int updatePesProdProcessing(PesProdProcessing pesProdProcessing);

    /**
     * 删除发料进度
     * 
     * @param organizationId 发料进度ID
     * @return 结果
     */
    public int deletePesProdProcessingById(Long organizationId);

    /**
     * 批量删除发料进度
     * 
     * @param organizationIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePesProdProcessingByIds(Long[] organizationIds);

    /**
     * @Author mingshen.wang
     * @Description 生成发料进度基础数据
     * @Date 16:55 2021/9/9
     * @Param [id]
     * @return void
     **/
    void insertInit(@Param("pId") Long pId, @Param("userName") String userName,@Param("isWw") String isWw);

    /**
     * @Author mingshen.wang
     * @Description 根据不同类型 汇总计算
     * @Date 14:51 2021/9/14
     * @Param [transactionQuantity, transactionSourceType]
     * @return void
     **/
    void sumQty(@Param("qty") BigDecimal transactionQuantity, @Param("type") String transactionSourceType,
                @Param("category") String category,@Param("lineId") Long lineId,
                @Param("subinventoryCode") String subinventoryCode);

    /**
     * @Author mingshen.wang
     * @Description
     * @Date 14:52 2021/9/30
     * @Param [pId, isWw]
     * @return void
     **/
    void updateInit(@Param("pId") Long pId,@Param("isWw") String isWw);

    List<PesProdProcessing> isTrueInv(@Param("lineId") Long lineId);

    List<PesProdProcessing> selectPesProdProcessingListWw(PesProdProcessing pesProdProcessing);
}
