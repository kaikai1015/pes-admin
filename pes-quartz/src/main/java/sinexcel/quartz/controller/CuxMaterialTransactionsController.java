package sinexcel.quartz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.CuxMaterialTransactionsEO;
import sinexcel.quartz.service.ICuxMaterialTransactionsService;
import sinexcel.common.annotation.Log;

import java.util.List;

/**
 * 工单发料Controller
 *
 * @author Zhang Kai
 * @date 2021-03-12
 */
@RestController
@RequestMapping("/quartz/wieMaterial")
public class CuxMaterialTransactionsController extends BaseController {

    @Autowired
    private ICuxMaterialTransactionsService cuxMaterialTransactionsService;

    /**
     * 查询工单发料列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:wieMaterial:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxMaterialTransactionsEO cuxMaterialTransactions)
    {
        startPage();
        List<CuxMaterialTransactionsEO> list = cuxMaterialTransactionsService.selectCuxMaterialTransactionsList(cuxMaterialTransactions);
        return getDataTable(list);
    }

    /**
     * 获取工单发料详细信息
     */
    @PreAuthorize("@ss.hasPermi('quartz:wieMaterial:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(cuxMaterialTransactionsService.selectCuxMaterialTransactionsById(id));
    }

    /**
     * 修改工单发料
     */
    @PreAuthorize("@ss.hasPermi('quartz:wieMaterial:edit')")
    @Log(title = "修改工单发料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CuxMaterialTransactionsEO cuxMaterialTransactions)
    {
        return toAjax(cuxMaterialTransactionsService.updateCuxMaterialTransactions(cuxMaterialTransactions));
    }

    /**
     * 提交工单发料
     */
    @PreAuthorize("@ss.hasPermi('quartz:wieMaterial:remove')")
    @Log(title = "领料回写ERP", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) throws Exception
    {
        return toAjax(cuxMaterialTransactionsService.selectCuxMaterialTransactionsByIds(ids));
    }
}
