package sinexcel.plans.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.plans.domain.PesPoPlanLineList;
import sinexcel.plans.service.IPesPoPlanLineListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 采购计划行Controller
 * 
 * @author Zhang Kai
 * @date 2020-11-26
 */
@RestController
@RequestMapping("/plans/poLine")
public class PesPoPlanLineListController extends BaseController
{
    @Autowired
    private IPesPoPlanLineListService pesPoPlanLineListService;

    /**
     * 查询采购计划行列表
     */
    @PreAuthorize("@ss.hasPermi('plans:poLine:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesPoPlanLineList pesPoPlanLineList)
    {
        startPage();
        List<PesPoPlanLineList> list = pesPoPlanLineListService.selectPesPoPlanLineListList(pesPoPlanLineList);
        return getDataTable(list);
    }

    /**
     * 导出采购计划行列表
     */
    @PreAuthorize("@ss.hasPermi('plans:poLine:export')")
    @Log(title = "采购计划行", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesPoPlanLineList pesPoPlanLineList)
    {
        List<PesPoPlanLineList> list = pesPoPlanLineListService.selectPesPoPlanLineListList(pesPoPlanLineList);
        ExcelUtil<PesPoPlanLineList> util = new ExcelUtil<PesPoPlanLineList>(PesPoPlanLineList.class);
        return util.exportExcel(list, "采购计划");
    }
    /**
     * 获取采购计划行详细信息
     */
    @PreAuthorize("@ss.hasPermi('plans:poLine:query')")
    @GetMapping(value = "/{lineNum}")
    public AjaxResult getInfo(@PathVariable("lineNum") Long lineNum)
    {
        return AjaxResult.success(pesPoPlanLineListService.selectPesPoPlanLineListById(lineNum));
    }

    /**
     * 修改采购计划行
     */
    @PreAuthorize("@ss.hasPermi('plans:poLine:edit')")
    @Log(title = "采购计划行", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesPoPlanLineList pesPoPlanLineList)
    {
        pesPoPlanLineList.setLastUpdateBy(SecurityUtils.getUsername());
        return toAjax(pesPoPlanLineListService.updatePesPoPlanLineList(pesPoPlanLineList));
    }
}
