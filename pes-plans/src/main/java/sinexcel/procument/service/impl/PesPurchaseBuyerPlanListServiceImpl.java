package sinexcel.procument.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.por.domain.CuxPorRequisitionLineAll;
import sinexcel.por.mapper.CuxPorRequisitionLineAllMapper;
import sinexcel.procument.mapper.PesProcumentPlanLineListMapper;
import sinexcel.procument.mapper.PesPurchaseBuyerPlanListMapper;
import sinexcel.procument.domain.PesPurchaseBuyerPlanList;
import sinexcel.procument.service.IPesPurchaseBuyerPlanListService;

/**
 * 维护采购计划Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-12-15
 */
@Service
public class PesPurchaseBuyerPlanListServiceImpl implements IPesPurchaseBuyerPlanListService 
{
    @Autowired
    private PesPurchaseBuyerPlanListMapper pesPurchaseBuyerPlanListMapper;

    @Autowired
    private PesProcumentPlanLineListMapper pesProcumentPlanLineListMapper;

    @Autowired
    private CuxPorRequisitionLineAllMapper cuxPorRequisitionLineAllMapper;

    /**
     * 查询维护采购计划列表
     *
     * @param pesPurchaseBuyerPlanList 维护采购计划
     * @return 维护采购计划
     */
    @Override
    public List<PesPurchaseBuyerPlanList> selectPesPurchaseBuyerRcvListList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList)
    {
        return pesPurchaseBuyerPlanListMapper.selectPesPurchaseBuyerRcvListList(pesPurchaseBuyerPlanList);
    }

    /**
     * 查询维护采购计划
     * 
     * @param lineNum 维护采购计划ID
     * @return 维护采购计划
     */
    @Override
    public PesPurchaseBuyerPlanList selectPesPurchaseBuyerPlanListById(Long lineNum)
    {
        return pesPurchaseBuyerPlanListMapper.selectPesPurchaseBuyerPlanListById(lineNum);
    }

    /**
     * 查询维护采购计划列表
     * 
     * @param pesPurchaseBuyerPlanList 维护采购计划
     * @return 维护采购计划
     */
    @Override
    public List<PesPurchaseBuyerPlanList> selectPesPurchaseBuyerPlanListList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList)
    {
        return pesPurchaseBuyerPlanListMapper.selectPesPurchaseBuyerPlanListList(pesPurchaseBuyerPlanList);
    }

    /**
     * 修改维护采购计划
     * 
     * @param pesPurchaseBuyerPlanList 维护采购计划
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePesPurchaseBuyerPlanList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList)
    {
        pesPurchaseBuyerPlanList.setLastUpdateBy(SecurityUtils.getUsername());
        return pesPurchaseBuyerPlanListMapper.updatePesPurchaseBuyerPlanList(pesPurchaseBuyerPlanList);
    }

    /**
     * 发放采购计划到采购员
     *
     * @param lineNum 生成采购计划行信息ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePesProcumentPlanLineListByIds(Long lineNum)
    {
        PesPurchaseBuyerPlanList getProcumentPlanLine =  pesPurchaseBuyerPlanListMapper.selectPesProcumentPlanLineListById(lineNum);
        getProcumentPlanLine.setCreateBy(SecurityUtils.getUsername());
        pesPurchaseBuyerPlanListMapper.insertPesPurchaseBuyerPlanList(getProcumentPlanLine);
        return pesProcumentPlanLineListMapper.deletePesProcumentPlanLineListByIds(lineNum);
    }

    /**
     * 删除维护采购计划信息
     *
     * @param lineNum 维护采购计划ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePesPurchaseBuyerPlanListByIds(Long lineNum)
    {
        pesPurchaseBuyerPlanListMapper.updatePesPurchaseBuyerPlanListByIds(lineNum);
        return pesPurchaseBuyerPlanListMapper.deletePesPurchaseBuyerPlanListByIds(lineNum);
    }

    @Override
    @Transactional
    public int rcv(Long lineNum)
    {
        PesPurchaseBuyerPlanList getProcumentPlanLine =  pesPurchaseBuyerPlanListMapper.selectPesProcumentPlanLineListById(lineNum);
        getProcumentPlanLine.setCreateBy(SecurityUtils.getUsername());
        pesPurchaseBuyerPlanListMapper.insertPesPurchaseBuyerRcvList(getProcumentPlanLine);
        return pesPurchaseBuyerPlanListMapper.deletePesPurchaseBuyerPlanListByIds(lineNum);
    }

    /**
     * 转请购池
     *
     * @param lineNums 转请购池
     * @return 结果
     */
    @Override
    @Transactional
    public int delPorPoBuyer(Long[] lineNums)
    {
        int k = 0;
        for(Long lineNum:lineNums){
            PesPurchaseBuyerPlanList getPorPoBuyer = pesPurchaseBuyerPlanListMapper.selectPesPurchaseBuyerPlanListById(lineNum);
            getPorPoBuyer.setCreateBy(SecurityUtils.getUsername());
            pesPurchaseBuyerPlanListMapper.insertPesPorBuyerRcvList(getPorPoBuyer);
            pesPurchaseBuyerPlanListMapper.delPorPoBuyer(lineNum);
            k++;
        }
        return k;
    }

    /**
     * 查询关联物料信息
     */
    @Override
    public List<PesPurchaseBuyerPlanList> porList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList)
    {
        return pesPurchaseBuyerPlanListMapper.porList(pesPurchaseBuyerPlanList);
    }

    /**
     * 添加请购行信息
     *
     * @param pesPurchaseBuyerPlanList 添加请购行信息
     * @return 结果
     */
    @Override
    @Transactional
    public int delPorRequitionList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList)
    {
        CuxPorRequisitionLineAll getPorLines = cuxPorRequisitionLineAllMapper.selectCuxPorRequisitionLineAllById(pesPurchaseBuyerPlanList.getLineNum());
        CuxPorRequisitionLineAll maxLin =cuxPorRequisitionLineAllMapper.selectMaxLine(pesPurchaseBuyerPlanList.getRequisitioningId());
        getPorLines.setCreateBy(SecurityUtils.getUsername());
        getPorLines.setRequisitioningId(pesPurchaseBuyerPlanList.getRequisitioningId());
        getPorLines.setLineNumber(maxLin.getLineNumber());
        getPorLines.setTaxCode(pesPurchaseBuyerPlanList.getTaxCode());
        cuxPorRequisitionLineAllMapper.insertCuxPorRequisitionLineAll(getPorLines);
        return cuxPorRequisitionLineAllMapper.delCuxPorRequisitionLineAll(pesPurchaseBuyerPlanList.getLineNum());
    }
}
