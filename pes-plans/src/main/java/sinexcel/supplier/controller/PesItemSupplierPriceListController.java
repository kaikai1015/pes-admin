package sinexcel.supplier.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.constant.UserConstants;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.supplier.domain.PesItemSupplierPriceList;
import sinexcel.supplier.service.IPesItemSupplierPriceListService;

import java.util.List;

/**
 * 报价单Controller
 * 
 * @author Zhang Kai
 * @date 2020-12-20
 */
@RestController
@RequestMapping("/supplier/editItemPrice")
public class PesItemSupplierPriceListController extends BaseController
{
    @Autowired
    private IPesItemSupplierPriceListService pesItemSupplierPriceListService;

    /**
     * 获取报价单详细信息
     */
    @PreAuthorize("@ss.hasPermi('supplier:editItemPrice:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesItemSupplierPriceList pesItemSupplierPriceList)
    {
        List<PesItemSupplierPriceList> list = pesItemSupplierPriceListService.selectPesItemSupplierPriceListList(pesItemSupplierPriceList);
        return getDataTable(list);
    }

    /**
     * 新增报价单
     */
    @PreAuthorize("@ss.hasPermi('supplier:editItemPrice:add')")
    @Log(title = "报价单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PesItemSupplierPriceList pesItemSupplierPriceList)
    {
        if (UserConstants.NOT_UNIQUE.equals(pesItemSupplierPriceListService.checkItemPriceListUnique(pesItemSupplierPriceList)))
        {
            return AjaxResult.error(pesItemSupplierPriceList.getCurrencyCode() + "，"+pesItemSupplierPriceList.getTaxCode()+"，已存在");
        }
        pesItemSupplierPriceList.setCreateBy(SecurityUtils.getUsername());
        return toAjax(pesItemSupplierPriceListService.insertPesItemSupplierPriceList(pesItemSupplierPriceList));
    }

    /**
     * 删除报价单
     */
    @PreAuthorize("@ss.hasPermi('supplier:editItemPrice:remove')")
    @Log(title = "报价单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{itemPriceIds}")
    public AjaxResult remove(@PathVariable Long[] itemPriceIds)
    {
        return toAjax(pesItemSupplierPriceListService.deletePesItemSupplierPriceListByIds(itemPriceIds));
    }
}
