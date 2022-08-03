package sinexcel.daysPlan.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
import sinexcel.daysPlan.domain.PesProdLineDaysLineAll;
import sinexcel.daysPlan.service.IPesProdLineDaysLineAllService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 产品线日计划明细Controller
 *
 * @author Zhang Kai
 * @date 2021-06-07
 */
@RestController
@RequestMapping("/daysPlan/processingl")
public class PesProdLineDaysLineAllProcessinglController extends BaseController
{
    @Autowired
    private IPesProdLineDaysLineAllService pesProdLineDaysLineAllService;

    /**
     * 查询产品线日计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:processingl:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesProdLineDaysLineAll pesProdLineDaysLineAll)
    {
        startPage();
        List<PesProdLineDaysLineAll> list = pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllList(pesProdLineDaysLineAll);
        return getDataTable(list);
    }

    /**
     * 导出产品线日计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:processingl:export')")
    @Log(title = "导出生产进度回复", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesProdLineDaysLineAll pesProdLineDaysLineAll)
    {
        List<PesProdLineDaysLineAll> list = pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllList(pesProdLineDaysLineAll);
        ExcelUtil<PesProdLineDaysLineAll> util = new ExcelUtil<PesProdLineDaysLineAll>(PesProdLineDaysLineAll.class);
        return util.exportExcel(list, "生产进度回复");
    }

    /**
     * 获取产品线日计划明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:processingl:query')")
    @GetMapping(value = "/{lineId}")
    public AjaxResult getInfo(@PathVariable("lineId") Long lineId)
    {
        return AjaxResult.success(pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllById(lineId));
    }

    /**
     * 修改产品线日计划明细
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:processingl:edit')")
    @Log(title = "修改生产进度回复", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesProdLineDaysLineAll pesProdLineDaysLineAll)
    {
        return toAjax(pesProdLineDaysLineAllService.updatePesProdLineDaysLineAll(pesProdLineDaysLineAll));
    }
}
