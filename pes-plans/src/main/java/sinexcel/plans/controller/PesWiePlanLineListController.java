package sinexcel.plans.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.plans.domain.PesWiePlanLineList;
import sinexcel.plans.service.IPesWiePlanLineListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 生产计划行Controller
 * 
 * @author Zhang Kai
 * @date 2020-11-25
 */
@RestController
@RequestMapping("/plans/wieLine")
public class PesWiePlanLineListController extends BaseController
{
    @Autowired
    private IPesWiePlanLineListService pesWiePlanLineListService;

    /**
     * 查询生产计划行列表
     */
    @PreAuthorize("@ss.hasPermi('plans:wieLine:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesWiePlanLineList pesWiePlanLineList)
    {
        startPage();
        List<PesWiePlanLineList> list = pesWiePlanLineListService.selectPesWiePlanLineListList(pesWiePlanLineList);
        return getDataTable(list);
    }

    /**
     * 导出生产计划行列表
     */
    @PreAuthorize("@ss.hasPermi('plans:wieLine:export')")
    @Log(title = "生产计划行", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesWiePlanLineList pesWiePlanLineList)
    {
        List<PesWiePlanLineList> list = pesWiePlanLineListService.selectPesWiePlanLineListList(pesWiePlanLineList);
        ExcelUtil<PesWiePlanLineList> util = new ExcelUtil<PesWiePlanLineList>(PesWiePlanLineList.class);
        return util.exportExcel(list, "生产计划");
    }

    /**
     * 获取生产计划行详细信息
     */
    @PreAuthorize("@ss.hasPermi('plans:wieLine:query')")
    @GetMapping(value = "/{lineNum}")
    public AjaxResult getInfo(@PathVariable("lineNum") Long lineNum)
    {
        return AjaxResult.success(pesWiePlanLineListService.selectPesWiePlanLineListById(lineNum));
    }

    /**
     * 修改生产计划行
     */
    @PreAuthorize("@ss.hasPermi('plans:wieLine:edit')")
    @Log(title = "生产计划行", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesWiePlanLineList pesWiePlanLineList)
    {
        pesWiePlanLineList.setLastUpdateBy(SecurityUtils.getUsername());
        return toAjax(pesWiePlanLineListService.updatePesWiePlanLineList(pesWiePlanLineList));
    }

    /**
     * 更新MRP生产计划行
     */
    @PreAuthorize("@ss.hasPermi('plans:wieLine:edit')")
    @Log(title = "生产计划行", businessType = BusinessType.UPDATE)
    @PutMapping("/{lineNum}")
    public AjaxResult updateMrp(@PathVariable Long lineNum)
    {
        return toAjax(pesWiePlanLineListService.updatePesWiePlanLineListById(lineNum));
    }

    /**
     * MRP生产计划计算
     */
    @PreAuthorize("@ss.hasPermi('plans:wieLine:remove')")
    @Log(title = "生产计划计算", businessType = BusinessType.DELETE)
    @DeleteMapping("/{planLotNum}")
    public AjaxResult getWiePlan(@PathVariable("planLotNum") Long planLotNum)
    {

//        pesWiePlanLineListService.updateLevelTreeCodeQuantity(planLotNum);
        return toAjax(pesWiePlanLineListService.getWiePlan(planLotNum));
    }
}
