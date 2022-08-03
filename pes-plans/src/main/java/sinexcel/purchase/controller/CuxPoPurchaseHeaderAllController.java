package sinexcel.purchase.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.purchase.domain.CuxPoPurchaseHeaderAll;
import sinexcel.purchase.service.ICuxPoPurchaseHeaderAllService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 管理采购单Controller
 * 
 * @author Zhang Kai
 * @date 2021-01-22
 */
@RestController
@RequestMapping("/purchase/purchaseHeader")
public class CuxPoPurchaseHeaderAllController extends BaseController
{
    @Autowired
    private ICuxPoPurchaseHeaderAllService cuxPoPurchaseHeaderAllService;

    /**
     * 查询管理采购单列表
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseHeader:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxPoPurchaseHeaderAll cuxPoPurchaseHeaderAll)
    {
        startPage();
        List<CuxPoPurchaseHeaderAll> list = cuxPoPurchaseHeaderAllService.selectCuxPoPurchaseHeaderAllList(cuxPoPurchaseHeaderAll);
        return getDataTable(list);
    }

    /**
     * 获取管理采购单详细信息
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseHeader:query')")
    @GetMapping(value = "/{poHeaderId}")
    public AjaxResult getInfo(@PathVariable("poHeaderId") Long poHeaderId)
    {
        return AjaxResult.success(cuxPoPurchaseHeaderAllService.selectCuxPoPurchaseHeaderAllById(poHeaderId));
    }

    /**
     * 新增管理采购单
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseHeader:add')")
    @Log(title = "管理采购单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CuxPoPurchaseHeaderAll cuxPoPurchaseHeaderAll)
    {
        return toAjax(cuxPoPurchaseHeaderAllService.insertCuxPoPurchaseHeaderAll(cuxPoPurchaseHeaderAll));
    }

    /**
     * 修改管理采购单
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseHeader:edit')")
    @Log(title = "管理采购单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CuxPoPurchaseHeaderAll cuxPoPurchaseHeaderAll)
    {
        return toAjax(cuxPoPurchaseHeaderAllService.updateCuxPoPurchaseHeaderAll(cuxPoPurchaseHeaderAll));
    }

}
