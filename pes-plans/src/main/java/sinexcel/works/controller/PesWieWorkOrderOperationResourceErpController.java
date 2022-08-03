package sinexcel.works.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.annotation.RepeatSubmit;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.works.domain.PesWieWorkOrderOperationResourceErp;
import sinexcel.works.service.IPesWieWorkOrderOperationResourceErpService;

import java.util.List;

/**
 * PES工单资源工时Controller
 *
 * @author Zhang Kai
 * @date 2021-12-27
 */
@RestController
@RequestMapping("/works/PesResources")
public class PesWieWorkOrderOperationResourceErpController extends BaseController
{
    @Autowired
    private IPesWieWorkOrderOperationResourceErpService pesWieWorkOrderOperationResourceErpService;

    @PreAuthorize("@ss.hasPermi('works:PesResources:list')")
    @GetMapping("/list/{pesWorkOrderOperationId}")
    public TableDataInfo list(@PathVariable("pesWorkOrderOperationId") Long pesWorkOrderOperationId)
    {
        List<PesWieWorkOrderOperationResourceErp> list = pesWieWorkOrderOperationResourceErpService.selectPesWieWorkOrderOperationResourceErpById(pesWorkOrderOperationId);
        return getDataTable(list);
    }

    /**
     * 获取PES工单资源工时详细信息
     */
    @PreAuthorize("@ss.hasPermi('works:PesResources:query')")
    @GetMapping(value = "/{pesWorkOrderOperationResourceId}")
    public AjaxResult getInfo(@PathVariable("pesWorkOrderOperationResourceId") Long pesWorkOrderOperationResourceId)
    {
        return AjaxResult.success(pesWieWorkOrderOperationResourceErpService.selectPesWieWorkOrderOperationResourceErpByIds(pesWorkOrderOperationResourceId));
    }

    /**
     * 修改PES工单资源工时
     */
    @PreAuthorize("@ss.hasPermi('works:PesResources:edit')")
    @Log(title = "修改PES工单资源工时", businessType = BusinessType.UPDATE)
    @PutMapping("/updatePesResources")
    @RepeatSubmit
    public AjaxResult edit(@RequestBody PesWieWorkOrderOperationResourceErp pesWieWorkOrderOperationResourceErp)
    {
        return toAjax(pesWieWorkOrderOperationResourceErpService.updatePesWieWorkOrderOperationResourceErp(pesWieWorkOrderOperationResourceErp));
    }

    /**
     * 新增PES工单资源工时
     */
    @PreAuthorize("@ss.hasPermi('works:PesResources:add')")
    @Log(title = "新增PES工单资源工时", businessType = BusinessType.INSERT)
    @PostMapping("/addPesResources")
    @RepeatSubmit
    public AjaxResult add(@RequestBody PesWieWorkOrderOperationResourceErp pesWieWorkOrderOperationResourceErp)
    {
        return toAjax(pesWieWorkOrderOperationResourceErpService.insertPesWieWorkOrderOperationResourceErp(pesWieWorkOrderOperationResourceErp));
    }
}
