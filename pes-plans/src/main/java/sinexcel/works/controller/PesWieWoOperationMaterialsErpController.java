package sinexcel.works.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
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
import org.springframework.web.multipart.MultipartFile;
import sinexcel.common.annotation.Log;
import sinexcel.common.annotation.RepeatSubmit;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.domain.model.LoginUser;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.ServletUtils;
import sinexcel.framework.web.service.TokenService;
import sinexcel.works.domain.PesWieWoOperationMaterialsErp;
import sinexcel.works.domain.PesWieWoOperationMaterialsPriceErp;
import sinexcel.works.service.IPesWieWoOperationMaterialsErpService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * pes自定义工单单身数据Controller
 * 
 * @author Zhang Kai
 * @date 2021-11-26
 */
@RestController
@RequestMapping("/works/PESmaterials")
public class PesWieWoOperationMaterialsErpController extends BaseController
{
    @Autowired
    private IPesWieWoOperationMaterialsErpService pesWieWoOperationMaterialsErpService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询pes自定义工单单身数据列表
     */
    @PreAuthorize("@ss.hasPermi('works:PESmaterials:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp)
    {
        startPage();
        List<PesWieWoOperationMaterialsErp> list = pesWieWoOperationMaterialsErpService.selectPesWieWoOperationMaterialsErpList(pesWieWoOperationMaterialsErp);
        return getDataTable(list);
    }

    /**
     * 导出pes自定义工单单身数据列表
     */
    @PreAuthorize("@ss.hasPermi('works:PESmaterials:export')")
    @Log(title = "pes自定义工单单身数据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp)
    {
        List<PesWieWoOperationMaterialsErp> list = pesWieWoOperationMaterialsErpService.selectPesWieWoOperationMaterialsErpListByExport(pesWieWoOperationMaterialsErp);
        ExcelUtil<PesWieWoOperationMaterialsErp> util = new ExcelUtil<PesWieWoOperationMaterialsErp>(PesWieWoOperationMaterialsErp.class);
        return util.exportExcel(list, "工单单身物料明细");
    }

    /**
     * 获取pes自定义工单单身数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('works:PESmaterials:query')")
    @GetMapping(value = "/{pesWorkOrderMaterialId}")
    public AjaxResult getInfo(@PathVariable("pesWorkOrderMaterialId") Long pesWorkOrderMaterialId)
    {
        return AjaxResult.success(pesWieWoOperationMaterialsErpService.selectPesWieWoOperationMaterialsErpById(pesWorkOrderMaterialId));
    }

    /**
     * 新增pes自定义工单单身数据
     */
    @PreAuthorize("@ss.hasPermi('works:PESmaterials:add')")
    @Log(title = "新增pes自定义工单单身数据", businessType = BusinessType.INSERT)
    @PostMapping
    @RepeatSubmit
    public AjaxResult add(@RequestBody PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp)
    {
        return toAjax(pesWieWoOperationMaterialsErpService.insertPesWieWoOperationMaterialsErpAdd(pesWieWoOperationMaterialsErp));
    }

    /**
     * 修改pes自定义工单单身数据
     */
    @PreAuthorize("@ss.hasPermi('works:PESmaterials:edit')")
    @Log(title = "修改pes自定义工单单身数据", businessType = BusinessType.UPDATE)
    @PutMapping
    @RepeatSubmit
    public AjaxResult edit(@RequestBody PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp)
    {
        return toAjax(pesWieWoOperationMaterialsErpService.updatePesWieWoOperationMaterialsErp(pesWieWoOperationMaterialsErp));
    }

    /**
     * 单身数据回传ERP
     */
    @PreAuthorize("@ss.hasPermi('works:PESmaterials:erp')")
    @Log(title = "PES单身数据回传ERP", businessType = BusinessType.ERP)
    @DeleteMapping("/handleMaterialSubmitErp/{pesWorkOrderIds}")
    @RepeatSubmit
    public AjaxResult handleMaterialSubmitErp(@PathVariable Long pesWorkOrderIds)
    {
        String endName = "userName";
        return toAjax(pesWieWoOperationMaterialsErpService.handleSubmitErpPesOperationMaterialByIds(pesWorkOrderIds,endName));
    }

    /**
     * 单身变更数据回传ERP
     */
    @PreAuthorize("@ss.hasPermi('works:PESmaterials:erp')")
    @Log(title = "PES单身变更数据回传ERP", businessType = BusinessType.ERP)
    @DeleteMapping("/handleMaterialUpdateSubmitErp/{pesWorkOrderIds}")
    @RepeatSubmit
    public AjaxResult handleMaterialUpdateSubmitErp(@PathVariable Long pesWorkOrderIds)
    {
        return toAjax(pesWieWoOperationMaterialsErpService.handleMaterialUpdateSubmitErp(pesWorkOrderIds));
    }
    @PreAuthorize("@ss.hasPermi('works:PESmaterials:delete')")
    @Log(title = "工单单身物料BOM刷新", businessType = BusinessType.DELETE)
    @DeleteMapping("/delPESmaterials/{workOrderStatusIds}/{pesWorkOrderIds}")
    @RepeatSubmit
    public AjaxResult remove(@PathVariable Long workOrderStatusIds,@PathVariable Long pesWorkOrderIds)
    {
        return toAjax(pesWieWoOperationMaterialsErpService.deletePesWieWoOperationMaterialsErpByIds(workOrderStatusIds,pesWorkOrderIds));
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<PesWieWoOperationMaterialsErp> util = new ExcelUtil<PesWieWoOperationMaterialsErp>(PesWieWoOperationMaterialsErp.class);
        return util.importTemplateExcel("单身明细导入模板");
    }

    @Log(title = "PES单身明细导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('works:PESmaterials:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, Long pesWorkOrderId,Integer workOrderStatusId) throws Exception
    {
        ExcelUtil<PesWieWoOperationMaterialsErp> util = new ExcelUtil<PesWieWoOperationMaterialsErp>(PesWieWoOperationMaterialsErp.class);
        List<PesWieWoOperationMaterialsErp> materialLists = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = pesWieWoOperationMaterialsErpService.importData(materialLists, operName,pesWorkOrderId,workOrderStatusId);
        return AjaxResult.success(message);
    }

    @PreAuthorize("@ss.hasPermi('works:PESmaterials:newItem')")
    @GetMapping("/getSubNewItemList")
    public TableDataInfo getSubNewItemList(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp)
    {
        List<PesWieWoOperationMaterialsErp> getSubNewItemList = pesWieWoOperationMaterialsErpService.selectPesWiegetSubNewItemList(pesWieWoOperationMaterialsErp);
        return getDataTable(getSubNewItemList);
    }

    @PreAuthorize("@ss.hasPermi('works:PESmaterials:newItem')")
    @Log(title = "添加单身替代物料", businessType = BusinessType.INSERT)
    @DeleteMapping("/addNewItem/{workSubId}/{pInventoryItemId}/{organizationId}/{pesWorkOrderId}/{subItemFlag}")
    @RepeatSubmit
    public AjaxResult addNewItem(@PathVariable Long workSubId,@PathVariable Long pInventoryItemId,@PathVariable Long organizationId,@PathVariable Long pesWorkOrderId,@PathVariable String subItemFlag)
    {
        return toAjax(pesWieWoOperationMaterialsErpService.addPesWieWoOperationMaterialsErpByIds(workSubId,pInventoryItemId,organizationId,pesWorkOrderId,subItemFlag));
    }

    /**
     * 查询pes自定义工单单身数据列表
     */
    @PreAuthorize("@ss.hasPermi('works:PESmaterials:list')")
    @GetMapping("/importAll/list")
    public TableDataInfo allList(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp)
    {
        startPage();
        List<PesWieWoOperationMaterialsErp> list = pesWieWoOperationMaterialsErpService.selectPesWieWoOperationMaterialsErpListByImport(pesWieWoOperationMaterialsErp);
        return getDataTable(list);
    }

    /**
     * 导出pes自定义工单单身数据列表
     */
    @PreAuthorize("@ss.hasPermi('works:PESmaterials:export')")
    @Log(title = "pes自定义工单单身数据", businessType = BusinessType.EXPORT)
    @GetMapping("/importAll/export")
    public AjaxResult allExport(PesWieWoOperationMaterialsErp pesWieWoOperationMaterialsErp)
    {
        List<PesWieWoOperationMaterialsErp> list = pesWieWoOperationMaterialsErpService.selectPesWieWoOperationMaterialsErpListByImport(pesWieWoOperationMaterialsErp);
        ExcelUtil<PesWieWoOperationMaterialsErp> util = new ExcelUtil<PesWieWoOperationMaterialsErp>(PesWieWoOperationMaterialsErp.class);
        return util.exportExcel(list, "工单单身物料明细");
    }

    @PreAuthorize("@ss.hasPermi('works:PESmaterials:erp')")
    @Log(title = "单身主键ID刷新", businessType = BusinessType.DELETE)
    @DeleteMapping("/handleMaterialUpdateSubmitErpId/{pesWorkOrderIds}")
    public AjaxResult handleMaterialUpdateSubmitErpId(@PathVariable Long pesWorkOrderIds)
    {
        return toAjax(pesWieWoOperationMaterialsErpService.handleMaterialUpdateSubmitErpId(pesWorkOrderIds));
    }

    @PreAuthorize("@ss.hasPermi('works:PESmaterials:fcl')")
    @Log(title = "手工扣料", businessType = BusinessType.DELETE)
    @DeleteMapping("/handleSubmitErpFcl/{pesWorkOrderMaterialIds}")
    @RepeatSubmit
    public AjaxResult handleSubmitErpFcl(@PathVariable Long[] pesWorkOrderMaterialIds)
    {
        String materialType = "MATERIAL_ISSUE";
        return toAjax(pesWieWoOperationMaterialsErpService.handleSubmitErpFcl(pesWorkOrderMaterialIds,materialType));
    }

    @PreAuthorize("@ss.hasPermi('works:PESmaterials:fcl')")
    @Log(title = "手工退料", businessType = BusinessType.DELETE)
    @DeleteMapping("/handleSubmitReturnErpFcl/{pesWorkOrderMaterialIds}")
    @RepeatSubmit
    public AjaxResult handleSubmitReturnErpFcl(@PathVariable Long[] pesWorkOrderMaterialIds)
    {
        String materialType = "MATERIAL_RETURN";
        return toAjax(pesWieWoOperationMaterialsErpService.handleSubmitErpFcl(pesWorkOrderMaterialIds,materialType));
    }

    /**
     * 查询pes自定义工单单身数据列表
     */
    @PreAuthorize("@ss.hasPermi('works:PESmaterials:list')")
    @GetMapping("/importAll/priceList")
    public TableDataInfo allPriceList(PesWieWoOperationMaterialsPriceErp pesWieWoOperationMaterialsErp)
    {
        startPage();
        List<PesWieWoOperationMaterialsPriceErp> list = pesWieWoOperationMaterialsErpService.selectPesWieWoOperationMaterialsErpListByPriceImport(pesWieWoOperationMaterialsErp);
        return getDataTable(list);
    }

    /**
     * 导出pes自定义工单单身数据列表
     */
    @PreAuthorize("@ss.hasPermi('works:PESmaterials:export')")
    @Log(title = "pes自定义工单单身数据", businessType = BusinessType.EXPORT)
    @GetMapping("/importAll/priceExport")
    public AjaxResult allPriceExport(PesWieWoOperationMaterialsPriceErp pesWieWoOperationMaterialsErp)
    {
        List<PesWieWoOperationMaterialsPriceErp> list = pesWieWoOperationMaterialsErpService.selectPesWieWoOperationMaterialsErpListByPriceImport(pesWieWoOperationMaterialsErp);
        ExcelUtil<PesWieWoOperationMaterialsPriceErp> util = new ExcelUtil<PesWieWoOperationMaterialsPriceErp>(PesWieWoOperationMaterialsPriceErp.class);
        return util.exportExcel(list, "工单单身物料明细");
    }

}
