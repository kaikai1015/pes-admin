package sinexcel.daysPlan.service;

import java.util.List;

import sinexcel.daysPlan.domain.PesInvMaterialTxns;
import sinexcel.daysPlan.domain.PesProdPlanTransferAll;

/**
 * 生产计划调拨单Service接口
 * 
 * @author Zhang Kai
 * @date 2021-07-01
 */
public interface IPesProdPlanTransferAllService 
{

    /**
     * 查询生产计划调拨单列表
     * 
     * @param pesProdPlanTransferAll 生产计划调拨单
     * @return 生产计划调拨单集合
     */
    public List<PesProdPlanTransferAll> selectPesProdPlanTransferAllList(PesProdPlanTransferAll pesProdPlanTransferAll);

    /**
     * 新增生产计划调拨单
     * 
     * @param id 生产计划调拨单
     * @return 结果
     */
    public int insertPesProdPlanTransferAll(Long id,String sourceCategory);


    /**
     * 批量删除生产计划调拨单
     * 
     * @param planTransferIds 需要删除的生产计划调拨单ID
     * @return 结果
     */
    public int deletePesProdPlanTransferAllByIds(Long[] planTransferIds);

    /**
     * @Author mingshen.wang
     * @Description 根据入库信息 发起接收调拨单 并回写接收数量
     * @Date 11:23 2021/8/29
     * @Param [o]
     * @return void
     **/
    Boolean insertReceive(PesInvMaterialTxns o);

    /**
     * @Author mingshen.wang
     * @Description 回写接收数量 回写调拨单状态
     * @Date 17:19 2021/8/30
     * @Param [o]
     * @return void
     **/
    Boolean receive(PesInvMaterialTxns o);
}
