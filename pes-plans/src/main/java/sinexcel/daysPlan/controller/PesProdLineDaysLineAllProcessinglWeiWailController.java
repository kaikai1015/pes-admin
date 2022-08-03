package sinexcel.daysPlan.controller;

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
import sinexcel.daysPlan.domain.PesProdLineDaysLineAllWW;
import sinexcel.daysPlan.service.IPesProdLineDaysLineAllWWService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 产品线日计划明细Controller
 *
 * @author Zhang Kai
 * @date 2021-06-07
 */
@RestController
@RequestMapping("/daysPlan/weiWaiProcessingl")
public class PesProdLineDaysLineAllProcessinglWeiWailController extends BaseController
{
    @Autowired
    private IPesProdLineDaysLineAllWWService pesProdLineDaysLineAllService;

    /**
     * 查询产品线日计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiWaiProcessingl:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesProdLineDaysLineAllWW pesProdLineDaysLineAll)
    {
        startPage();
        List<PesProdLineDaysLineAllWW> list = pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllList(pesProdLineDaysLineAll);
        return getDataTable(list);
    }

    /**
     * 导出产品线日计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiWaiProcessingl:export')")
    @Log(title = "导出委外生产进度回复", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesProdLineDaysLineAllWW pesProdLineDaysLineAll)
    {
        List<PesProdLineDaysLineAllWW> list = pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllList(pesProdLineDaysLineAll);
        ExcelUtil<PesProdLineDaysLineAllWW> util = new ExcelUtil<PesProdLineDaysLineAllWW>(PesProdLineDaysLineAllWW.class);
        return util.exportExcel(list, "委外生产进度回复");
    }

    /**
     * 获取产品线日计划明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiWaiProcessingl:query')")
    @GetMapping(value = "/{lineId}")
    public AjaxResult getInfo(@PathVariable("lineId") Long lineId)
    {
        return AjaxResult.success(pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllById(lineId));
    }

    /**
     * 修改产品线日计划明细
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiWaiProcessingl:edit')")
    @Log(title = "修改委外生产进度回复", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesProdLineDaysLineAllWW pesProdLineDaysLineAll)
    {
        return toAjax(pesProdLineDaysLineAllService.updatePesProdLineDaysLineAll(pesProdLineDaysLineAll));
    }
}
