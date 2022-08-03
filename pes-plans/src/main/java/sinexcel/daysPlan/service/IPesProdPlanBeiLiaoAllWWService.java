package sinexcel.daysPlan.service;

import java.math.BigDecimal;
import java.util.List;
import sinexcel.daysPlan.domain.PesProdPlanBeiLiaoAllWW;
import sinexcel.daysPlan.domain.PesProdPlanTransferAll;

/**
 * 生产计划备料单Service接口
 *
 * @author Zhang Kai
 * @date 2021-06-16
 */
public interface IPesProdPlanBeiLiaoAllWWService
{

    /**
     * 查询生产计划备料单列表
     *
     * @param pesProdPlanBeiLiaoAll 生产计划备料单
     * @return 生产计划备料单集合
     */
    public List<PesProdPlanBeiLiaoAllWW> selectPesProdPlanBeiLiaoAllList(PesProdPlanBeiLiaoAllWW pesProdPlanBeiLiaoAll);


    /**
     * 批量删除生产计划备料单
     *
     * @param id 需要删除的生产计划备料单ID
     * @return 结果
     */
    public int insertPesProdPlanBeiLiaoAll(Long id);


    /**
     * @Author mingshen.wang
     * @Description 根据发放调拨更新备料单数据
     * @Date 10:13 2021/8/24
     * @Param [pesProdPlanTransferAll]
     * @return void
     **/
    void updateTransferStart(PesProdPlanTransferAll pesProdPlanTransferAll);


    /**
     * @Author mingshen.wang
     * @Description 更新备料单数量
     * @Date 14:08 2021/8/29
     * @Param [sourceId, transactionQuantity, type（0-周转确认 1-接收确认）]
     * @return void
     **/
    void updateReceiveQty(Long sourceId, BigDecimal transactionQuantity, String type);
}
