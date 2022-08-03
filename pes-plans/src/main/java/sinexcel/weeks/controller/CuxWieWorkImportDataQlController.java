package sinexcel.weeks.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.annotation.RepeatSubmit;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.weeks.domain.CuxWieWorkImportDataQl;
import sinexcel.weeks.service.ICuxWieWorkImportDataQlService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 排程欠料分析数据Controller
 * 
 * @author Zhang Kai
 * @date 2021-11-06
 */
@RestController
@RequestMapping("/weeks/calImportData")
public class CuxWieWorkImportDataQlController extends BaseController
{
    @Autowired
    private ICuxWieWorkImportDataQlService cuxWieWorkImportDataQlService;

    /**
     * 查询排程欠料分析数据列表
     */
    @PreAuthorize("@ss.hasPermi('weeks:calImportData:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxWieWorkImportDataQl cuxWieWorkImportDataQl)
    {
        startPage();
        List<CuxWieWorkImportDataQl> list = cuxWieWorkImportDataQlService.selectCuxWieWorkImportDataQlList(cuxWieWorkImportDataQl);
        return getDataTable(list);
    }

    /**
     * 导出排程欠料分析数据列表
     */
    @PreAuthorize("@ss.hasPermi('weeks:calImportData:export')")
    @Log(title = "导出排程欠料分析数据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxWieWorkImportDataQl cuxWieWorkImportDataQl)
    {
        List<CuxWieWorkImportDataQl> list = cuxWieWorkImportDataQlService.selectCuxWieWorkImportDataQlList(cuxWieWorkImportDataQl);
        ExcelUtil<CuxWieWorkImportDataQl> util = new ExcelUtil<CuxWieWorkImportDataQl>(CuxWieWorkImportDataQl.class);
        return util.exportExcel(list, "工单排程欠料数据");
    }

    /**
     * 删除排程欠料分析数据
     */
    @PreAuthorize("@ss.hasPermi('weeks:calImportData:cal')")
    @Log(title = "排程欠料计算", businessType = BusinessType.DELETE)
    @DeleteMapping("/{lotNum}")
    @RepeatSubmit
    public AjaxResult remove(@PathVariable Long lotNum)
    {
        return toAjax(cuxWieWorkImportDataQlService.deleteCuxWieWorkImportDataQlById(lotNum));
    }

    @PreAuthorize("@ss.hasPermi('weeks:calImportData:list')")
    @GetMapping("/untransferAllList/list")
    public TableDataInfo listUntransferQuantity(CuxWieWorkImportDataQl cuxWieWorkImportDataQl)
    {
        startPage();
        List<CuxWieWorkImportDataQl> list = cuxWieWorkImportDataQlService.selectListUntransferQuantityList(cuxWieWorkImportDataQl);
        return getDataTable(list);
    }
}
