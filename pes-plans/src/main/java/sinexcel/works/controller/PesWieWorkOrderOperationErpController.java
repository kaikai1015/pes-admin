package sinexcel.works.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.works.domain.PesWieWorkOrderOperationErp;
import sinexcel.works.service.IPesWieWorkOrderOperationErpService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * pes自定义工单工序数据Controller
 * 
 * @author Zhang Kai
 * @date 2021-11-26
 */
@RestController
@RequestMapping("/works/PESoperation")
public class PesWieWorkOrderOperationErpController extends BaseController
{
    @Autowired
    private IPesWieWorkOrderOperationErpService pesWieWorkOrderOperationErpService;

    /**
     * 查询pes自定义工单工序数据列表
     */
    @PreAuthorize("@ss.hasPermi('works:PESoperation:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesWieWorkOrderOperationErp pesWieWorkOrderOperationErp)
    {
        startPage();
        List<PesWieWorkOrderOperationErp> list = pesWieWorkOrderOperationErpService.selectPesWieWorkOrderOperationErpList(pesWieWorkOrderOperationErp);
        return getDataTable(list);
    }

    /**
     * 工序数据回传ERP
     */
    @PreAuthorize("@ss.hasPermi('works:PESoperation:erp')")
    @Log(title = "PES工序数据回传ERP", businessType = BusinessType.ERP)
    @DeleteMapping("/handleMaterialOperationSubmitErp/{pesWorkOrderId}")
    public AjaxResult handleMaterialOperationSubmitErp(@PathVariable Long pesWorkOrderId)
    {
        String endName = "userName";
        return toAjax(pesWieWorkOrderOperationErpService.handleSubmitErpPesOperationByIds(pesWorkOrderId,endName));
    }

    /**
     * 获取pes自定义工单工序数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('works:PESoperation:query')")
    @GetMapping(value = "/listPesOspItem/{pesWorkOrderOperationId}")
    public AjaxResult listPesOspItem(@PathVariable("pesWorkOrderOperationId") Long pesWorkOrderOperationId)
    {
        return AjaxResult.success(pesWieWorkOrderOperationErpService.selectPesWieWorkOrderOperationOspErpById(pesWorkOrderOperationId));
    }

}
