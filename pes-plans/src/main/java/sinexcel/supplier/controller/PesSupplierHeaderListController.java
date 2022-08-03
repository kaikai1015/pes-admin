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
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.supplier.domain.PesSupplierHeaderList;
import sinexcel.supplier.service.IPesSupplierHeaderListService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 供应商基础信息Controller
 * 
 * @author Zhang Kai
 * @date 2020-12-17
 */
@RestController
@RequestMapping("/supplier/headerList")
public class PesSupplierHeaderListController extends BaseController
{
    @Autowired
    private IPesSupplierHeaderListService pesSupplierHeaderListService;

    /**
     * 查询供应商基础信息列表
     */
    @PreAuthorize("@ss.hasPermi('supplier:headerList:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesSupplierHeaderList pesSupplierHeaderList)
    {
        startPage();
        List<PesSupplierHeaderList> list = pesSupplierHeaderListService.selectPesSupplierHeaderListList(pesSupplierHeaderList);
        return getDataTable(list);
    }


    /**
     * 新增供应商基础信息
     */
    @PreAuthorize("@ss.hasPermi('supplier:headerList:add')")
    @Log(title = "供应商基础信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PesSupplierHeaderList pesSupplierHeaderList)
    {
        if (UserConstants.NOT_UNIQUE.equals(pesSupplierHeaderListService.checkSupplierNumberUnique(pesSupplierHeaderList.getSupplierNumber())))
        {
            return AjaxResult.error("创建供应商：" + pesSupplierHeaderList.getSupplierName() + "'失败，供应商编码已存在");
        }
        pesSupplierHeaderList.setCreateBy(SecurityUtils.getUsername());
        return toAjax(pesSupplierHeaderListService.insertPesSupplierHeaderList(pesSupplierHeaderList));
    }

    /**
     * 导出供应商基础信息列表
     */
    @PreAuthorize("@ss.hasPermi('supplier:headerList:export')")
    @Log(title = "供应商基础信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesSupplierHeaderList pesSupplierHeaderList)
    {
        List<PesSupplierHeaderList> list = pesSupplierHeaderListService.selectPesSupplierHeaderListList(pesSupplierHeaderList);
        ExcelUtil<PesSupplierHeaderList> util = new ExcelUtil<PesSupplierHeaderList>(PesSupplierHeaderList.class);
        return util.exportExcel(list, "供应商基础信息");
    }
    /**
     * 获取供应商基础信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('supplier:headerList:query')")
    @GetMapping(value = "/{supplierId}")
    public AjaxResult getInfo(@PathVariable("supplierId") Long supplierId)
    {
        return AjaxResult.success(pesSupplierHeaderListService.selectPesSupplierHeaderListById(supplierId));
    }

    /**
     * 修改供应商基础信息
     */
    @PreAuthorize("@ss.hasPermi('supplier:headerList:edit')")
    @Log(title = "供应商基础信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesSupplierHeaderList pesSupplierHeaderList)
    {
        pesSupplierHeaderList.setLastUpdateBy(SecurityUtils.getUsername());
        return toAjax(pesSupplierHeaderListService.updatePesSupplierHeaderList(pesSupplierHeaderList));
    }

    /**
     * 获取供应商列表
     */
    @PreAuthorize("@ss.hasPermi('supplier:headerList:list')")
    @GetMapping("/getAllSupplier")
    public AjaxResult getAllSupplier()
    {
        List<PesSupplierHeaderList> suppliers = pesSupplierHeaderListService.getAllSupplier();
        return AjaxResult.success(suppliers);
    }
}
