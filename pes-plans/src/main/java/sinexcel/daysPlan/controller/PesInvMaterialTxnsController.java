package sinexcel.daysPlan.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
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
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.daysPlan.domain.PesInvMaterialTxns;
import sinexcel.daysPlan.service.IMesInvMaterialTxnsService;
import sinexcel.daysPlan.service.IPesInvMaterialTxnsService;

/**
 * 库存事务处理明细Controller
 * 
 * @author Zhang Kai
 * @date 2021-08-28
 */
@RestController
@RequestMapping("/system/txns")
@Api
public class PesInvMaterialTxnsController extends BaseController
{
    @Autowired
    private IPesInvMaterialTxnsService pesInvMaterialTxnsService;
    /**
     * 查询库存事务处理明细列表
     */
    @PreAuthorize("@ss.hasPermi('system:txns:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesInvMaterialTxns pesInvMaterialTxns)
    {
        startPage();
        List<PesInvMaterialTxns> list = pesInvMaterialTxnsService.selectPesInvMaterialTxnsList(pesInvMaterialTxns);
        return getDataTable(list);
    }

    /**
     * 导出库存事务处理明细列表
     */
    @PreAuthorize("@ss.hasPermi('system:txns:export')")
    @Log(title = "库存事务处理明细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesInvMaterialTxns pesInvMaterialTxns)
    {
        List<PesInvMaterialTxns> list = pesInvMaterialTxnsService.selectPesInvMaterialTxnsList(pesInvMaterialTxns);
        ExcelUtil<PesInvMaterialTxns> util = new ExcelUtil<PesInvMaterialTxns>(PesInvMaterialTxns.class);
        return util.exportExcel(list, "库存事务处理明细");
    }

    /**
     * 获取库存事务处理明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:txns:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pesInvMaterialTxnsService.selectPesInvMaterialTxnsById(id));
    }

    /**
     * 新增库存事务处理明细
     */
    @PreAuthorize("@ss.hasPermi('system:txns:add')")
    @Log(title = "库存事务处理明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PesInvMaterialTxns pesInvMaterialTxns)
    {
        return toAjax(pesInvMaterialTxnsService.insertPesInvMaterialTxns(pesInvMaterialTxns));
    }
    /**
     * 批量新增库存事务处理明细
     */
    @PreAuthorize("@ss.hasPermi('system:txns:addBatch')")
    @Log(title = "批量新增库存事务处理明细", businessType = BusinessType.INSERT)
    @PostMapping("addBatch")
    @ApiOperation(value = "批量新增库存事务处理明细", tags = "批量新增库存事务处理明细")
    public AjaxResult addBatch(@RequestBody List<PesInvMaterialTxns> infoList)
    {
        return pesInvMaterialTxnsService.insertBatchAndVerify(infoList);
    }

    /**
     * 修改库存事务处理明细
     */
    @PreAuthorize("@ss.hasPermi('system:txns:edit')")
    @Log(title = "库存事务处理明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesInvMaterialTxns pesInvMaterialTxns)
    {
        return toAjax(pesInvMaterialTxnsService.updatePesInvMaterialTxns(pesInvMaterialTxns));
    }

    /**
     * 删除库存事务处理明细
     */
    @PreAuthorize("@ss.hasPermi('system:txns:remove')")
    @Log(title = "库存事务处理明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pesInvMaterialTxnsService.deletePesInvMaterialTxnsByIds(ids));
    }
    /**
     * 初始化riders库存事务处理明细key
     */
    @Log(title = "初始化riders库存事务处理明细key", businessType = BusinessType.OTHER)
    @ApiOperation(value = "初始化riders库存事务处理明细key", tags = "初始化riders库存事务处理明细key")
	@GetMapping("intiKey")
    public AjaxResult intiKey()
    {
        return toAjax(pesInvMaterialTxnsService.intiKey());
    }
}
