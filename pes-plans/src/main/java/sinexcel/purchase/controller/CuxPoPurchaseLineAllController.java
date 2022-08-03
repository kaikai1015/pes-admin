package sinexcel.purchase.controller;

import java.util.List;
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
import sinexcel.purchase.domain.CuxPoPurchaseLineAll;
import sinexcel.purchase.service.ICuxPoPurchaseLineAllService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 采购行信息Controller
 * 
 * @author Zhang Kai
 * @date 2021-01-25
 */
@RestController
@RequestMapping("/purchase/purchaseLine")
public class CuxPoPurchaseLineAllController extends BaseController
{
    @Autowired
    private ICuxPoPurchaseLineAllService cuxPoPurchaseLineAllService;

    /**
     * 查询采购行信息列表
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseLine:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxPoPurchaseLineAll cuxPoPurchaseLineAll)
    {
        startPage();
        List<CuxPoPurchaseLineAll> list = cuxPoPurchaseLineAllService.selectCuxPoPurchaseLineAllList(cuxPoPurchaseLineAll);
        return getDataTable(list);
    }

    /**
     * 导出采购行信息列表
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseLine:export')")
    @Log(title = "采购行信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxPoPurchaseLineAll cuxPoPurchaseLineAll)
    {
        List<CuxPoPurchaseLineAll> list = cuxPoPurchaseLineAllService.selectCuxPoPurchaseLineAllList(cuxPoPurchaseLineAll);
        ExcelUtil<CuxPoPurchaseLineAll> util = new ExcelUtil<CuxPoPurchaseLineAll>(CuxPoPurchaseLineAll.class);
        return util.exportExcel(list, "purchaseLine");
    }

    /**
     * 获取采购行信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseLine:query')")
    @GetMapping(value = "/{poLineId}")
    public AjaxResult getInfo(@PathVariable("poLineId") Long poLineId)
    {
        return AjaxResult.success(cuxPoPurchaseLineAllService.selectCuxPoPurchaseLineAllById(poLineId));
    }

    /**
     * 新增采购行信息
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseLine:add')")
    @Log(title = "采购行信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CuxPoPurchaseLineAll cuxPoPurchaseLineAll)
    {
        return toAjax(cuxPoPurchaseLineAllService.insertCuxPoPurchaseLineAll(cuxPoPurchaseLineAll));
    }

    /**
     * 修改采购行信息
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseLine:edit')")
    @Log(title = "采购行信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CuxPoPurchaseLineAll cuxPoPurchaseLineAll)
    {
        return toAjax(cuxPoPurchaseLineAllService.updateCuxPoPurchaseLineAll(cuxPoPurchaseLineAll));
    }

    /**
     * 删除采购行信息
     */
    @PreAuthorize("@ss.hasPermi('purchase:purchaseLine:remove')")
    @Log(title = "采购行信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{poLineIds}")
    public AjaxResult remove(@PathVariable Long[] poLineIds)
    {
        return toAjax(cuxPoPurchaseLineAllService.deleteCuxPoPurchaseLineAllByIds(poLineIds));
    }
}
