package sinexcel.daysPlan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import sinexcel.daysPlan.domain.PesProdPlanTransferAll;

/**
 * 生产计划调拨单Mapper接口
 * 
 * @author Zhang Kai
 * @date 2021-07-01
 */
public interface PesProdPlanTransferAllMapper 
{
    /**
     * 查询生产计划调拨单
     *
     * @param id 生产计划调拨单ID
     * @return 生产计划调拨单
     */
    public List<PesProdPlanTransferAll> selectPesProdPlanTransferAllById(@Param("id") Long id,
                                                                         @Param("sourceType") String sourceType);

    public List<PesProdPlanTransferAll> selectPesProdOnhandQuantitys(PesProdPlanTransferAll pesProdPlanTransferAll);

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
     * @param pesProdPlanTransferAll 生产计划调拨单
     * @return 结果
     */
    public int insertPesProdPlanTransferAll(PesProdPlanTransferAll pesProdPlanTransferAll);

    public int updateTransferFlag(Long id);

    /**
     * 批量删除生产计划调拨单
     * 
     * @param planTransferIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePesProdPlanTransferAllByIds(Long[] planTransferIds);

    /**
     * 更新生产计划调拨单
     *
     * @param id 生产计划调拨单
     * @return 结果
     */
     int updatePesProdPlanTransferAll(PesProdPlanTransferAll pesProdPlanTransferAll);
}
