package sinexcel.por.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.por.domain.CuxPorRequisitionHeaderAll;
import sinexcel.por.service.ICuxPorRequisitionHeaderAllService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 管理请购单Controller
 * 
 * @author Zhang Kai
 * @date 2020-12-30
 */
@RestController
@RequestMapping("/por/requisitionHeader")
public class CuxPorRequisitionHeaderAllController extends BaseController
{
    @Autowired
    private ICuxPorRequisitionHeaderAllService cuxPorRequisitionHeaderAllService;

    /**
     * 查询管理请购单列表
     */
    @PreAuthorize("@ss.hasPermi('por:requisitionHeader:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxPorRequisitionHeaderAll cuxPorRequisitionHeaderAll)
    {
        startPage();
        List<CuxPorRequisitionHeaderAll> list = cuxPorRequisitionHeaderAllService.selectCuxPorRequisitionHeaderAllList(cuxPorRequisitionHeaderAll);
        return getDataTable(list);
    }

    /**
     * 新增管理请购单
     */
    @PreAuthorize("@ss.hasPermi('por:requisitionHeader:add')")
    @Log(title = "新增请购单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CuxPorRequisitionHeaderAll cuxPorRequisitionHeaderAll)
    {
        return toAjax(cuxPorRequisitionHeaderAllService.insertCuxPorRequisitionHeaderAll(cuxPorRequisitionHeaderAll));
    }

    /**
     * 获取管理请购单详细信息
     */
    @PreAuthorize("@ss.hasPermi('por:requisitionHeader:query')")
    @GetMapping(value = "/{requisitioningId}")
    public AjaxResult getInfo(@PathVariable("requisitioningId") Long requisitioningId)
    {
        return AjaxResult.success(cuxPorRequisitionHeaderAllService.selectCuxPorRequisitionHeaderAllById(requisitioningId));
    }

    /**
     * 修改管理请购单状态
     */
    @PreAuthorize("@ss.hasPermi('por:requisitionHeader:remove')")
    @Log(title = "保存管理请购单", businessType = BusinessType.DELETE)
    @DeleteMapping("/saveRequisitionIdStatus/{requisitioningId}")
    public AjaxResult saveRequisitionIdStatus(@PathVariable Long requisitioningId)
    {
        CuxPorRequisitionHeaderAll cuxPorRequisitionHeaderAll = new CuxPorRequisitionHeaderAll();
        cuxPorRequisitionHeaderAll.setStatus("1");
        cuxPorRequisitionHeaderAll.setLastUpdateBy(SecurityUtils.getUsername());
        cuxPorRequisitionHeaderAll.setRequisitioningId(requisitioningId);
        return toAjax(cuxPorRequisitionHeaderAllService.updateCuxPorRequisitionHeaderAll(cuxPorRequisitionHeaderAll));
    }

    /**
     * 审批管理请购单状态
     */
    @PreAuthorize("@ss.hasPermi('por:requisitionHeader:remove')")
    @Log(title = "审批管理请购单", businessType = BusinessType.DELETE)
    @DeleteMapping("/approvalRequisitionIdStatus/{requisitioningId}")
    public AjaxResult approvalRequisitionIdStatus(@PathVariable Long requisitioningId)
    {
        CuxPorRequisitionHeaderAll cuxPorRequisitionHeaderAll = new CuxPorRequisitionHeaderAll();
        cuxPorRequisitionHeaderAll.setStatus("2");
        cuxPorRequisitionHeaderAll.setLastUpdateBy(SecurityUtils.getUsername());
        cuxPorRequisitionHeaderAll.setRequisitioningId(requisitioningId);
        return toAjax(cuxPorRequisitionHeaderAllService.updateCuxPorRequisitionHeaderAll(cuxPorRequisitionHeaderAll));
    }
}
