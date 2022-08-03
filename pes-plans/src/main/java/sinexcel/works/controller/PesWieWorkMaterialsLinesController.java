package sinexcel.works.controller;

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
import sinexcel.works.domain.PesWieWorkMaterialsLines;
import sinexcel.works.service.IPesWieWorkMaterialsLinesService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 工单替代料数据Controller
 * 
 * @author Zhang Kai
 * @date 2021-08-03
 */
@RestController
@RequestMapping("/works/pesWieMaterialAll")
public class PesWieWorkMaterialsLinesController extends BaseController
{
    @Autowired
    private IPesWieWorkMaterialsLinesService pesWieWorkMaterialsLinesService;

    /**
     * 查询工单替代料数据列表
     */
    @PreAuthorize("@ss.hasPermi('works:pesWieMaterialAll:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesWieWorkMaterialsLines pesWieWorkMaterialsLines)
    {
        startPage();
        List<PesWieWorkMaterialsLines> list = pesWieWorkMaterialsLinesService.selectPesWieWorkMaterialsLinesList(pesWieWorkMaterialsLines);
        return getDataTable(list);
    }

    /**
     * 导出工单替代料数据列表
     */
    @PreAuthorize("@ss.hasPermi('works:pesWieMaterialAll:export')")
    @Log(title = "导出工单替代料数据列表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesWieWorkMaterialsLines pesWieWorkMaterialsLines)
    {
        List<PesWieWorkMaterialsLines> list = pesWieWorkMaterialsLinesService.selectPesWieWorkMaterialsLinesList(pesWieWorkMaterialsLines);
        ExcelUtil<PesWieWorkMaterialsLines> util = new ExcelUtil<PesWieWorkMaterialsLines>(PesWieWorkMaterialsLines.class);
        return util.exportExcel(list, "pesWieMaterialAll");
    }

    /**
     * 获取工单替代料数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('works:pesWieMaterialAll:query')")
    @GetMapping(value = "/{woOperationMaterialId}")
    public AjaxResult getInfo(@PathVariable("woOperationMaterialId") Long woOperationMaterialId)
    {
        return AjaxResult.success(pesWieWorkMaterialsLinesService.selectPesWieWorkMaterialsLinesById(woOperationMaterialId));
    }

    /**
     * 新增工单替代料数据
     */
    @PreAuthorize("@ss.hasPermi('works:pesWieMaterialAll:add')")
    @Log(title = "新增工单替代料数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PesWieWorkMaterialsLines pesWieWorkMaterialsLines)
    {
        return toAjax(pesWieWorkMaterialsLinesService.insertPesWieWorkMaterialsLines(pesWieWorkMaterialsLines));
    }

    /**
     * 修改工单替代料数据
     */
    @PreAuthorize("@ss.hasPermi('works:pesWieMaterialAll:edit')")
    @Log(title = "修改工单替代料数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesWieWorkMaterialsLines pesWieWorkMaterialsLines)
    {
        return toAjax(pesWieWorkMaterialsLinesService.updatePesWieWorkMaterialsLines(pesWieWorkMaterialsLines));
    }

    /**
     * 删除工单替代料数据
     */
    @PreAuthorize("@ss.hasPermi('works:pesWieMaterialAll:remove')")
    @Log(title = "删除工单替代料数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{woOperationMaterialIds}")
    public AjaxResult remove(@PathVariable Long[] woOperationMaterialIds)
    {
        return toAjax(pesWieWorkMaterialsLinesService.deletePesWieWorkMaterialsLinesByIds(woOperationMaterialIds));
    }

    /**
     * 提交ERP工单替代料数据
     */
    @PreAuthorize("@ss.hasPermi('works:pesWieMaterialAll:erp')")
    @Log(title = "提交ERP工单替代料数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/erp/{woOperationMaterialIds}")
    public AjaxResult submiPesWieMaterialAll(@PathVariable Long[] woOperationMaterialIds)
    {
        return toAjax(pesWieWorkMaterialsLinesService.submiPesWieMaterialAll(woOperationMaterialIds));
    }
}
