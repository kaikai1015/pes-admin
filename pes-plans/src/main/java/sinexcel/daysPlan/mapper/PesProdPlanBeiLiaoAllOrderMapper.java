package sinexcel.daysPlan.mapper;

import org.apache.ibatis.annotations.Param;
import sinexcel.daysPlan.domain.PesProdPlanBeiLiaoAll;

import java.math.BigDecimal;
import java.util.List;

/**
 * 生产计划备料单Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-06-16
 */
public interface PesProdPlanBeiLiaoAllOrderMapper
{

    /**
     * 查询生产计划备料单列表
     * 
     * @param pesProdPlanBeiLiaoAll 生产计划备料单
     * @return 生产计划备料单集合
     */
    public List<PesProdPlanBeiLiaoAll> selectPesProdPlanBeiLiaoAllList(PesProdPlanBeiLiaoAll pesProdPlanBeiLiaoAll);

    /**
     * 批量删除生产计划备料单
     * 
     * @param id 需要删除的数据ID
     * @return 结果
     */
    public int deletePesProdPlanBeiLiaoAllByIds(Long id);
    public int insertPesProdPlanBeiLiaoAll(PesProdPlanBeiLiaoAll pesProdPlanBeiLiaoAll);

    public int updateResetDataFlag(Long id);

    /**
     * @Author mingshen.wang
     * @Description 根据发放调拨更新备料单数据
     * @Date 10:43 2021/8/24
     * @Param [info]
     * @return void
     **/
    void updateTransferStart(PesProdPlanBeiLiaoAll info);

    /**
     * @Author mingshen.wang
     * @Description 更新备料单数量
     * @Date 14:08 2021/8/29
     * @Param [sourceId, transactionQuantity, type（0-周转确认 1-接收确认）]
     * @return void
     **/
    void updateReceiveQty(@Param("id") Long id,@Param("qty") BigDecimal qty,@Param("type") String type);
}
