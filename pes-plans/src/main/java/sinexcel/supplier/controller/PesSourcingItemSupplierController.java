package sinexcel.supplier.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.constant.UserConstants;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.supplier.domain.PesSourcingItemSupplier;
import sinexcel.supplier.service.IPesSourcingItemSupplierService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 寻源规则Controller
 * 
 * @author Zhang Kai
 * @date 2020-12-18
 */
@RestController
@RequestMapping("/supplier/itemSupplier")
public class PesSourcingItemSupplierController extends BaseController
{
    @Autowired
    private IPesSourcingItemSupplierService pesSourcingItemSupplierService;

    /**
     * 查询寻源规则列表
     */
    @PreAuthorize("@ss.hasPermi('supplier:itemSupplier:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesSourcingItemSupplier pesSourcingItemSupplier)
    {
        startPage();
        List<PesSourcingItemSupplier> list = pesSourcingItemSupplierService.selectPesSourcingItemSupplierList(pesSourcingItemSupplier);
        return getDataTable(list);
    }

    /**
     * 新增寻源规则
     */
    @PreAuthorize("@ss.hasPermi('supplier:itemSupplier:add')")
    @Log(title = "寻源规则", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PesSourcingItemSupplier pesSourcingItemSupplier)
    {
        if (UserConstants.NOT_UNIQUE.equals(pesSourcingItemSupplierService.checkItemSupplierUnique(pesSourcingItemSupplier)))
        {
            return AjaxResult.error("创建物料关系失败；" + pesSourcingItemSupplier.getItemNumber() + "物料编码已存在");
        }
        pesSourcingItemSupplier.setLastUpdateBy(SecurityUtils.getUsername());
        return toAjax(pesSourcingItemSupplierService.insertPesSourcingItemSupplier(pesSourcingItemSupplier));
    }
    /**
     * 修改寻源规则
     */
    @PreAuthorize("@ss.hasPermi('supplier:itemSupplier:edit')")
    @Log(title = "寻源规则", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody List<PesSourcingItemSupplier> pesSourcingItemSupplier)
    {
        return toAjax(pesSourcingItemSupplierService.updatePesSourcingItemSupplier(pesSourcingItemSupplier));
    }

    /**
     * 获取寻源规则详细信息
     */
    @PreAuthorize("@ss.hasPermi('supplier:itemSupplier:query')")
    @GetMapping(value = "/{sourcingItemId}")
    public AjaxResult getInfo(@PathVariable("sourcingItemId") Long sourcingItemId)
    {
        return AjaxResult.success(pesSourcingItemSupplierService.selectPesSourcingItemSupplierById(sourcingItemId));
    }
}
