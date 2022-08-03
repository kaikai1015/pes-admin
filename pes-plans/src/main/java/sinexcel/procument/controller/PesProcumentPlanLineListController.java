package sinexcel.procument.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.procument.domain.PesProcumentPlanLineList;
import sinexcel.procument.service.IPesProcumentPlanLineListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.procument.service.IPesPurchaseBuyerPlanListService;

/**
 * 生成采购计划行信息Controller
 * 
 * @author Zhang Kai
 * @date 2020-12-09
 */
@RestController
@RequestMapping("/procument/mrpLine")
public class PesProcumentPlanLineListController extends BaseController
{
    @Autowired
    private IPesProcumentPlanLineListService pesProcumentPlanLineListService;

    @Autowired
    private IPesPurchaseBuyerPlanListService pesPurchaseBuyerPlanListService;

    /**
     * 查询生成采购计划行信息列表
     */
    @PreAuthorize("@ss.hasPermi('procument:mrpLine:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesProcumentPlanLineList pesProcumentPlanLineList)
    {
        startPage();
        List<PesProcumentPlanLineList> list = pesProcumentPlanLineListService.selectPesProcumentPlanLineListList(pesProcumentPlanLineList);
        return getDataTable(list);
    }

    /**
     * 导出生成采购计划行信息列表
     */
    @PreAuthorize("@ss.hasPermi('procument:mrpLine:export')")
    @Log(title = "生成采购计划行信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesProcumentPlanLineList pesProcumentPlanLineList)
    {
        List<PesProcumentPlanLineList> list = pesProcumentPlanLineListService.selectPesProcumentPlanLineListList(pesProcumentPlanLineList);
        ExcelUtil<PesProcumentPlanLineList> util = new ExcelUtil<PesProcumentPlanLineList>(PesProcumentPlanLineList.class);
        return util.exportExcel(list, "mrpLine");
    }

    /**
     * 查询生成采购计划行信息列表
     */
    @PreAuthorize("@ss.hasPermi('procument:mrpLine:buyer')")
    @GetMapping("/buyer")
    public TableDataInfo buyer(PesProcumentPlanLineList pesProcumentPlanLineList)
    {
        startPage();
        List<PesProcumentPlanLineList> buyer = pesProcumentPlanLineListService.selectBuyer(pesProcumentPlanLineList);
        return getDataTable(buyer);
    }

    /**
     * 发放采购计划到采购员
     */
    @PreAuthorize("@ss.hasPermi('procument:mrpLine:buyer')")
    @Log(title = "发放采购计划到采购员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{lineNums}")
    public AjaxResult remove(@PathVariable Long lineNums)
    {
        return toAjax(pesPurchaseBuyerPlanListService.deletePesProcumentPlanLineListByIds(lineNums));
    }

}
