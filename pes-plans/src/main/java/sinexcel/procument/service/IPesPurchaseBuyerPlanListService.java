package sinexcel.procument.service;

import java.util.List;
import sinexcel.procument.domain.PesPurchaseBuyerPlanList;

/**
 * 维护采购计划Service接口
 * 
 * @author Zhang Kai
 * @date 2020-12-15
 */
public interface IPesPurchaseBuyerPlanListService 
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
     * 修改维护采购计划
     * 
     * @param pesPurchaseBuyerPlanList 维护采购计划
     * @return 结果
     */
    public int updatePesPurchaseBuyerPlanList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList);


    /**
     * 发放采购计划到采购员
     *
     * @param lineNum 生成采购计划行信息ID
     * @return 结果
     */
    public int deletePesProcumentPlanLineListByIds(Long lineNum);

    /**
     * 退回采购计划
     *
     * @param lineNum 维护采购计划ID
     * @return 结果
     */
    public int deletePesPurchaseBuyerPlanListByIds(Long lineNum);

    /**
     * 确认采购计划
     *
     * @param lineNum 维护采购计划ID
     * @return 结果
     */
    public int rcv(Long lineNum);

    /**
     * 转请购池
     *
     * @param lineNums 转请购池
     * @return 结果
     */
    public int delPorPoBuyer(Long[] lineNums);

    /**
     * 查询关联物料信息
     */
    public List<PesPurchaseBuyerPlanList> porList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList);

    /**
     * 添加请购行信息
     *
     * @param pesPurchaseBuyerPlanList 添加请购行信息
     * @return 结果
     */
    public int delPorRequitionList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList);

}
