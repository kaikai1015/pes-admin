package sinexcel.procument.mapper;

import java.util.List;
import sinexcel.procument.domain.PesPurchaseBuyerPlanList;

/**
 * 维护采购计划Mapper接口
 * 
 * @author Zhang Kai
 * @date 2020-12-15
 */
public interface PesPurchaseBuyerPlanListMapper 
{

    /**
     * 查询维护采购计划列表
     *
     * @param pesPurchaseBuyerPlanList 维护采购计划
     * @return 维护采购计划集合
     */
    public List<PesPurchaseBuyerPlanList> selectPesPurchaseBuyerRcvListList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList);

    /**
     * 查询维护采购计划
     * 
     * @param lineNum 维护采购计划ID
     * @return 维护采购计划
     */
    public PesPurchaseBuyerPlanList selectPesPurchaseBuyerPlanListById(Long lineNum);

    /**
     * 查询维护采购计划列表
     * 
     * @param pesPurchaseBuyerPlanList 维护采购计划
     * @return 维护采购计划集合
     */
    public List<PesPurchaseBuyerPlanList> selectPesPurchaseBuyerPlanListList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList);

    /**
     * 新增维护采购计划
     * 
     * @param pesPurchaseBuyerPlanList 维护采购计划
     * @return 结果
     */
    public int insertPesPurchaseBuyerPlanList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList);

    /**
     * 修改维护采购计划
     * 
     * @param pesPurchaseBuyerPlanList 维护采购计划
     * @return 结果
     */
    public int updatePesPurchaseBuyerPlanList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList);

    /**
     * 查询生成采购计划行信息
     *
     * @param lineNum 生成采购计划行信息ID
     * @return 生成采购计划行信息
     */
    public PesPurchaseBuyerPlanList selectPesProcumentPlanLineListById(Long lineNum);

    /**
     * 批量删除维护采购计划
     *
     * @param lineNums 需要删除的数据ID
     * @return 结果
     */
    public int deletePesPurchaseBuyerPlanListByIds(Long lineNums);

    public int updatePesPurchaseBuyerPlanListByIds(Long lineNums);

    /**
     * 采购员确认的采购计划
     *
     * @param pesPurchaseBuyerPlanList 维护采购计划
     * @return 结果
     */
    public int insertPesPurchaseBuyerRcvList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList);

    public int insertPesPorBuyerRcvList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList);

    public int delPorPoBuyer(Long lineNums);

    /**
     * 查询关联物料信息
     */
    public List<PesPurchaseBuyerPlanList> porList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList);
}
