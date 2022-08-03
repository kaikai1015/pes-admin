package sinexcel.procument.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.procument.domain.PesPurchaseBuyerPlanList;
import sinexcel.procument.service.IPesPurchaseBuyerPlanListService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 维护采购计划Controller
 * 
 * @author Zhang Kai
 * @date 2020-12-15
 */
@RestController
@RequestMapping("/procument/poBuyer")
public class PesPurchaseBuyerPlanListController extends BaseController
{
    @Autowired
    private IPesPurchaseBuyerPlanListService pesPurchaseBuyerPlanListService;

    /**
     * 查询已经确认的采购计划列表
     */
    @PreAuthorize("@ss.hasPermi('procument:poBuyer:list')")
    @GetMapping("/list/rcv")
    public TableDataInfo rcv(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList)
    {
        startPage();
        List<PesPurchaseBuyerPlanList> rcv = pesPurchaseBuyerPlanListService.selectPesPurchaseBuyerRcvListList(pesPurchaseBuyerPlanList);
        return getDataTable(rcv);
    }

    /**
     * 查询维护采购计划列表
     */
    @PreAuthorize("@ss.hasPermi('procument:poBuyer:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList)
    {
        startPage();
        List<PesPurchaseBuyerPlanList> list = pesPurchaseBuyerPlanListService.selectPesPurchaseBuyerPlanListList(pesPurchaseBuyerPlanList);
        return getDataTable(list);
    }

    /**
     * 获取维护采购计划详细信息
     */
    @PreAuthorize("@ss.hasPermi('procument:poBuyer:query')")
    @GetMapping(value = "/{lineNum}")
    public AjaxResult getInfo(@PathVariable("lineNum") Long lineNum)
    {
        return AjaxResult.success(pesPurchaseBuyerPlanListService.selectPesPurchaseBuyerPlanListById(lineNum));
    }

    /**
     * 修改维护采购计划
     */
    @PreAuthorize("@ss.hasPermi('procument:poBuyer:edit')")
    @Log(title = "维护采购计划", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList)
    {
        return toAjax(pesPurchaseBuyerPlanListService.updatePesPurchaseBuyerPlanList(pesPurchaseBuyerPlanList));
    }

    /**
     * 退回采购计划
     */
    @PreAuthorize("@ss.hasPermi('procument:poBuyer:remove')")
    @Log(title = "退回采购计划", businessType = BusinessType.DELETE)
    @DeleteMapping("/{lineNums}")
    public AjaxResult remove(@PathVariable Long lineNums)
    {
        return toAjax(pesPurchaseBuyerPlanListService.deletePesPurchaseBuyerPlanListByIds(lineNums));
    }

    /**
     * 确认采购计划
     */
    @PreAuthorize("@ss.hasPermi('procument:poBuyer:remove')")
    @Log(title = "确认采购计划", businessType = BusinessType.DELETE)
    @DeleteMapping("/rcv/{lineNums}")
    public AjaxResult rcv(@PathVariable Long lineNums)
    {
        return toAjax(pesPurchaseBuyerPlanListService.rcv(lineNums));
    }

    /**
     * 转请购池
     */
    @PreAuthorize("@ss.hasPermi('procument:poBuyer:remove')")
    @Log(title = "转请购池", businessType = BusinessType.DELETE)
    @DeleteMapping("/delPorPoBuyer/{lineNums}")
    public AjaxResult delPorPoBuyer(@PathVariable Long[] lineNums)
    {
        return toAjax(pesPurchaseBuyerPlanListService.delPorPoBuyer(lineNums));
    }

    /**
     * 查询关联物料信息
     */
    @PreAuthorize("@ss.hasPermi('por:requisitionLine:add')")
    @GetMapping("/porList")
    public TableDataInfo porList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList)
    {
        startPage();
        List<PesPurchaseBuyerPlanList> porList = pesPurchaseBuyerPlanListService.porList(pesPurchaseBuyerPlanList);
        return getDataTable(porList);
    }

    /**
     * 添加请购行信息
     */
    @PreAuthorize("@ss.hasPermi('por:requisitionLine:add')")
    @Log(title = "添加请购行信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/delPorRequitionList")
    public AjaxResult delPorRequitionList(PesPurchaseBuyerPlanList pesPurchaseBuyerPlanList)
    {
        return toAjax(pesPurchaseBuyerPlanListService.delPorRequitionList(pesPurchaseBuyerPlanList));
    }
}
