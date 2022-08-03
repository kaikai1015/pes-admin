package sinexcel.quartz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.CuxMaterialTransactionsVendorEO;
import sinexcel.quartz.service.ICuxMaterialTransactionsVendorService;

import java.util.List;

@RestController
@RequestMapping("/quartz/wieMaterialVendor")
public class CuxMaterialTransactionsVendorController extends BaseController {

    @Autowired
    private ICuxMaterialTransactionsVendorService cuxMaterialTransactionsVendorService;

    /**
     * 查询工单发料列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:wieMaterialVendor:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxMaterialTransactionsVendorEO cuxMaterialTransactions)
    {
        startPage();
        List<CuxMaterialTransactionsVendorEO> list = cuxMaterialTransactionsVendorService.selectCuxMaterialTransactionsList(cuxMaterialTransactions);
        return getDataTable(list);
    }

    /**
     * 获取工单发料详细信息
     */
    @PreAuthorize("@ss.hasPermi('quartz:wieMaterialVendor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(cuxMaterialTransactionsVendorService.selectCuxMaterialTransactionsById(id));
    }

    /**
     * 修改工单发料
     */
    @PreAuthorize("@ss.hasPermi('quartz:wieMaterialVendor:edit')")
    @Log(title = "修改工单发料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CuxMaterialTransactionsVendorEO cuxMaterialTransactions)
    {
        return toAjax(cuxMaterialTransactionsVendorService.updateCuxMaterialTransactions(cuxMaterialTransactions));
    }

    /**
     * 提交工单发料
     */
    @PreAuthorize("@ss.hasPermi('quartz:wieMaterialVendor:remove')")
    @Log(title = "领料回写ERP", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) throws Exception
    {
        return toAjax(cuxMaterialTransactionsVendorService.selectCuxMaterialTransactionsByIds(ids));
    }
}
