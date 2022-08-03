package sinexcel.works.controller;

import java.util.List;

import com.sun.xml.rpc.processor.model.soap.SOAPUnorderedStructureType;
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
import sinexcel.common.annotation.RepeatSubmit;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.works.domain.PesWieWorkOrdersBErp;
import sinexcel.works.service.IPesWieWorkOrdersBErpService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * PES工单管理Controller
 * 
 * @author Zhang Kai
 * @date 2021-11-24
 */
@RestController
@RequestMapping("/works/PESworkData")
public class PesWieWorkOrdersBErpController extends BaseController
{
    @Autowired
    private IPesWieWorkOrdersBErpService pesWieWorkOrdersBErpService;

    /**
     * 查询PES工单管理列表
     */
    @PreAuthorize("@ss.hasPermi('works:PESworkData:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesWieWorkOrdersBErp pesWieWorkOrdersBErp)
    {
        startPage();
        List<PesWieWorkOrdersBErp> list = pesWieWorkOrdersBErpService.selectPesWieWorkOrdersBErpList(pesWieWorkOrdersBErp);
        return getDataTable(list);
    }

    /**
     * 导出PES工单管理列表
     */
    @PreAuthorize("@ss.hasPermi('works:PESworkData:export')")
    @Log(title = "PES工单导出", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesWieWorkOrdersBErp pesWieWorkOrdersBErp)
    {
        List<PesWieWorkOrdersBErp> list = pesWieWorkOrdersBErpService.selectPesWieWorkOrdersBErpList(pesWieWorkOrdersBErp);
        ExcelUtil<PesWieWorkOrdersBErp> util = new ExcelUtil<PesWieWorkOrdersBErp>(PesWieWorkOrdersBErp.class);
        return util.exportExcel(list, "PES工单");
    }

    /**
     * 获取PES工单管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('works:PESworkData:query')")
    @GetMapping(value = "/{pesWorkOrderId}")
    public AjaxResult getInfo(@PathVariable("pesWorkOrderId") Long pesWorkOrderId)
    {
        return AjaxResult.success(pesWieWorkOrdersBErpService.selectPesWieWorkOrdersBErpById(pesWorkOrderId));
    }

    /**
     * 修改PES工单管理
     */
    @PreAuthorize("@ss.hasPermi('works:PESworkData:edit')")
    @Log(title = "PES工单修改", businessType = BusinessType.UPDATE)
    @PutMapping
    @RepeatSubmit
    public AjaxResult edit(@RequestBody PesWieWorkOrdersBErp pesWieWorkOrdersBErp)
    {
        return toAjax(pesWieWorkOrdersBErpService.updatePesWieWorkOrdersBErp(pesWieWorkOrdersBErp));
    }

    /**
     * PES工发布生效
     */
    @PreAuthorize("@ss.hasPermi('works:PESworkData:remove')")
    @Log(title = "PES工发布生效", businessType = BusinessType.DELETE)
	@DeleteMapping("/delPESworkData/{pesWorkOrderIds}")
    public AjaxResult delPESworkData(@PathVariable Long[] pesWorkOrderIds)
    {
        return toAjax(pesWieWorkOrdersBErpService.deletePesWieWorkOrdersBErpByIds(pesWorkOrderIds));
    }

    /**
     * 创建工单数据
     */
    @PreAuthorize("@ss.hasPermi('works:PESworkData:import')")
    @Log(title = "生成PES工单", businessType = BusinessType.IMPORT)
    @DeleteMapping("/erpWorksLines/{lineNums}")
    @RepeatSubmit
    public AjaxResult erpWorksLines(@PathVariable Long[] lineNums)
    {
        return toAjax(pesWieWorkOrdersBErpService.insertPesWieWorkOrdersBErp(lineNums));
    }

    /**
     * PES工单回传ERP
     */
    @PreAuthorize("@ss.hasPermi('works:PESworkData:erp')")
    @Log(title = "PES工单回传ERP", businessType = BusinessType.ERP)
    @DeleteMapping("/handleSubmitErp/{pesWorkOrderIds}")
    @RepeatSubmit
    public AjaxResult handleSubmitErp(@PathVariable Long[] pesWorkOrderIds)
    {
        return toAjax(pesWieWorkOrdersBErpService.handleSubmitErpPesWieWorkOrdersBErpByIds(pesWorkOrderIds));
    }

    @PreAuthorize("@ss.hasPermi('works:PESworkData:remove')")
    @Log(title = "PES变更工单回传ERP", businessType = BusinessType.DELETE)
    @DeleteMapping("/handleSubmitUpdateErp/{pesWorkOrderIds}")
    @RepeatSubmit
    public AjaxResult handleSubmitUpdateErp(@PathVariable Long pesWorkOrderIds)
    {
        String endName = "userName";
        return toAjax(pesWieWorkOrdersBErpService.updateErpPesWieWorkOrdersBErpByIds(pesWorkOrderIds,endName));
    }

    /**
     * 新增PES工单管理
     */
    @PreAuthorize("@ss.hasPermi('works:PESworkData:add')")
    @Log(title = "PES工单手工创建", businessType = BusinessType.INSERT)
    @PostMapping
    @RepeatSubmit
    public AjaxResult add(@RequestBody PesWieWorkOrdersBErp pesWieWorkOrdersBErp)
    {
        return toAjax(pesWieWorkOrdersBErpService.insertAddPesWieWorkOrdersBErp(pesWieWorkOrdersBErp));
    }

    @PreAuthorize("@ss.hasPermi('works:PESworkData:add')")
    @Log(title = "手工复制PES工单", businessType = BusinessType.INSERT)
    @DeleteMapping("/handleCopyWorkErp/{pesWorkOrderIds}")
    @RepeatSubmit
    public AjaxResult handleCopyWorkErp(@PathVariable Long pesWorkOrderIds)
    {
        return toAjax(pesWieWorkOrdersBErpService.copyErpPesWieWorkOrdersBErpByIds(pesWorkOrderIds));
    }

    /**
     * 工单发放
     * @param pesWorkOrderIds
     * @return
     */
    @PreAuthorize("@ss.hasPermi('works:PESworkData:remove')")
    @Log(title = "PES工发布发放", businessType = BusinessType.DELETE)
    @DeleteMapping("/releasedPESworkData/{pesWorkOrderIds}")
    public AjaxResult releasedPESworkData(@PathVariable Long[] pesWorkOrderIds)
    {
        return toAjax(pesWieWorkOrdersBErpService.releasedWieWorkOrdersBErpByIds(pesWorkOrderIds));
    }

    @PreAuthorize("@ss.hasPermi('works:PESworkData:handleList')")
    @GetMapping("/handle/list")
    public TableDataInfo handleList(PesWieWorkOrdersBErp pesWieWorkOrdersBErp)
    {
        startPage();
        List<PesWieWorkOrdersBErp> list = pesWieWorkOrdersBErpService.selectHandle(pesWieWorkOrdersBErp);
        return getDataTable(list);
    }

//    @PreAuthorize("@ss.hasPermi('works:PESworkData:handleAdd')")
//    @Log(title = "添加工单完工/退库", businessType = BusinessType.INSERT)
//    @PostMapping("/handle/add")
//    @RepeatSubmit
//    public AjaxResult handleAdd(@RequestBody PesWieWorkOrdersBErp pesWieWorkOrdersBErp)
//    {
//        return toAjax(pesWieWorkOrdersBErpService.insertHandleAdd(pesWieWorkOrdersBErp));
//    }
}
