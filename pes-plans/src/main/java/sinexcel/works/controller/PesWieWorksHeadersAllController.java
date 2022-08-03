package sinexcel.works.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.annotation.RepeatSubmit;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.works.domain.PesWieWorksHeadersAll;
import sinexcel.works.service.IPesWieWorksHeadersAllService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 创建工单数据Controller
 * 
 * @author Zhang Kai
 * @date 2021-04-18
 */
@RestController
@RequestMapping("/works/erpWorks")
public class PesWieWorksHeadersAllController extends BaseController
{
    @Autowired
    private IPesWieWorksHeadersAllService pesWieWorksHeadersAllService;

    /**
     * 查询创建工单数据列表
     */
    @PreAuthorize("@ss.hasPermi('works:erpWorks:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesWieWorksHeadersAll pesWieWorksHeadersAll)
    {
        startPage();
        List<PesWieWorksHeadersAll> list = pesWieWorksHeadersAllService.selectPesWieWorksHeadersAllList(pesWieWorksHeadersAll);
        return getDataTable(list);
    }

    /**
     * 导出工单汇总
     */
    @PreAuthorize("@ss.hasPermi('works:erpWorks:export')")
    @Log(title = "导出工单汇总", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesWieWorksHeadersAll pesWieWorksHeadersAll)
    {
        List<PesWieWorksHeadersAll> list = pesWieWorksHeadersAllService.selectPesWieWorksHeadersAllList(pesWieWorksHeadersAll);
        ExcelUtil<PesWieWorksHeadersAll> util = new ExcelUtil<PesWieWorksHeadersAll>(PesWieWorksHeadersAll.class);
        return util.exportExcel(list, "工单汇总");
    }

    /**
     * 获取创建工单数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('works:erpWorks:query')")
    @GetMapping(value = "/{wieWorkId}")
    public AjaxResult getInfo(@PathVariable("wieWorkId") Long wieWorkId)
    {
        return AjaxResult.success(pesWieWorksHeadersAllService.selectPesWieWorksHeadersAllById(wieWorkId));
    }

    /**
     * 修改创建工单数据
     */
    @PreAuthorize("@ss.hasPermi('works:erpWorks:edit')")
    @Log(title = "创建工单数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesWieWorksHeadersAll pesWieWorksHeadersAll)
    {
        return toAjax(pesWieWorksHeadersAllService.updatePesWieWorksHeadersAll(pesWieWorksHeadersAll));
    }

    /**
     * 创建工单数据
     */
    @PreAuthorize("@ss.hasPermi('works:erpWorks:import')")
    @Log(title = "创建工单数据", businessType = BusinessType.IMPORT)
	@DeleteMapping("/erpWorksLines/{lineNums}")
    public AjaxResult erpWorksLines(@PathVariable Long[] lineNums)
    {
        return toAjax(pesWieWorksHeadersAllService.erpWorksLines(lineNums));
    }

    /**
     * 合并创建工单数据
     */
    @PreAuthorize("@ss.hasPermi('works:erpWorks:imports')")
    @Log(title = "合并创建工单数据", businessType = BusinessType.IMPORT)
    @DeleteMapping("/erpSumWorksLines/{lineNums}")
    public AjaxResult erpSumWorksLines(@PathVariable Long[] lineNums)
    {
        return toAjax(pesWieWorksHeadersAllService.erpSumWorksLines(lineNums));
    }

    /**
     * 创建ERP工单数据
     */
    @PreAuthorize("@ss.hasPermi('works:erpWorks:erp')")
    @Log(title = "创建ERP工单数据", businessType = BusinessType.ERP)
    @DeleteMapping("/erp/{wieWorkIds}")
    @RepeatSubmit
    public AjaxResult submitErpWorks(@PathVariable Long[] wieWorkIds)
    {
        return toAjax(pesWieWorksHeadersAllService.submitErpWorks(wieWorkIds));
    }


    /**
     * 拆分工单数据
     */
    @PreAuthorize("@ss.hasPermi('works:erpWorks:splits')")
    @Log(title = "拆分工单数据", businessType = BusinessType.INSERT)
    @DeleteMapping("/splitsErpWorks/{wieWorkIds}")
    public AjaxResult splitsErpWorks(@PathVariable Long wieWorkIds)
    {
        return toAjax(pesWieWorksHeadersAllService.splitsErpWorks(wieWorkIds));
    }

    /**
     * 发放ERP工单数据
     */
    @PreAuthorize("@ss.hasPermi('works:erpWorks:released')")
    @Log(title = "发放ERP工单", businessType = BusinessType.ERP)
    @DeleteMapping("/releasedErpWorks/{wieWorkIds}")
    public AjaxResult releasedErpWorks(@PathVariable Long[] wieWorkIds)
    {
        return toAjax(pesWieWorksHeadersAllService.releasedErpWorks(wieWorkIds));
    }

    /**
     * 关闭ERP工单数据
     */
    @PreAuthorize("@ss.hasPermi('works:erpWorks:closed')")
    @Log(title = "关闭ERP工单", businessType = BusinessType.ERP)
    @DeleteMapping("/closedErpWorks/{wieWorkIds}")
    public AjaxResult closedErpWorks(@PathVariable Long[] wieWorkIds)
    {
        return toAjax(pesWieWorksHeadersAllService.closedErpWorks(wieWorkIds));
    }

    /**
     * 取消ERP工单数据
     */
    @PreAuthorize("@ss.hasPermi('works:erpWorks:canceled')")
    @Log(title = "取消ERP工单", businessType = BusinessType.ERP)
    @DeleteMapping("/canceledErpWorks/{wieWorkIds}")
    public AjaxResult canceledErpWorks(@PathVariable Long[] wieWorkIds)
    {
        return toAjax(pesWieWorksHeadersAllService.canceledErpWorks(wieWorkIds));
    }

    /**
     * 变更ERP工单
     */
    @PreAuthorize("@ss.hasPermi('works:erpWorks:patch')")
    @Log(title = "变更ERP工单", businessType = BusinessType.ERP)
    @DeleteMapping("/patchErpWorks/{wieWorkIds}")
    public AjaxResult patchErpWorks(@PathVariable Long[] wieWorkIds)
    {
        return toAjax(pesWieWorksHeadersAllService.patchErpWorks(wieWorkIds));
    }

    /**
     * 失效ERP工单
     */
    @PreAuthorize("@ss.hasPermi('works:erpWorks:remove')")
    @Log(title = "失效工单数据", businessType = BusinessType.ERP)
    @DeleteMapping("/deleteErpWorks/{wieWorkIds}")
    public AjaxResult deleteErpWorks(@PathVariable Long[] wieWorkIds)
    {
        return toAjax(pesWieWorksHeadersAllService.deleteErpWorks(wieWorkIds));
    }
    /**
     * 新增工单操作
     */
    @PreAuthorize("@ss.hasPermi('works:erpWorks:add')")
    @Log(title = "新增工单操作", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PesWieWorksHeadersAll pesWieWorksHeadersAll)
    {
        return toAjax(pesWieWorksHeadersAllService.insertPesWieWorksHeadersAll(pesWieWorksHeadersAll));
    }
}
