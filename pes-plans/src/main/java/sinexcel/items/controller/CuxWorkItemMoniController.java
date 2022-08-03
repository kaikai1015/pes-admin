package sinexcel.items.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.items.domain.CuxWorkItemMoni;
import sinexcel.items.service.ICuxWorkItemMoniService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 模拟物料齐套Controller
 * 
 * @author Zhang Kai
 * @date 2021-04-11
 */
@RestController
@RequestMapping("/items/moni")
public class CuxWorkItemMoniController extends BaseController
{
    @Autowired
    private ICuxWorkItemMoniService cuxWorkItemMoniService;

    /**
     * 查询模拟物料齐套列表
     */
    @PreAuthorize("@ss.hasPermi('items:moni:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxWorkItemMoni cuxWorkItemMoni)
    {
        startPage();
        List<CuxWorkItemMoni> list = cuxWorkItemMoniService.selectCuxWorkItemMoniList(cuxWorkItemMoni);
        return getDataTable(list);
    }

    /**
     * 导出模拟物料齐套列表
     */
    @PreAuthorize("@ss.hasPermi('items:moni:export')")
    @Log(title = "模拟物料齐套", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxWorkItemMoni cuxWorkItemMoni)
    {
        List<CuxWorkItemMoni> list = cuxWorkItemMoniService.selectCuxWorkItemMoniList(cuxWorkItemMoni);
        ExcelUtil<CuxWorkItemMoni> util = new ExcelUtil<CuxWorkItemMoni>(CuxWorkItemMoni.class);
        return util.exportExcel(list, "模拟物料齐套");
    }

    /**
     * 计算模拟物料齐套列表
     */
    @PreAuthorize("@ss.hasPermi('items:moni:list')")
    @Log(title = "计算模拟物料齐套", businessType = BusinessType.BOM)
    @GetMapping("/bomMoni")
    public AjaxResult bomMoni(CuxWorkItemMoni cuxWorkItemMoni)
    {
        cuxWorkItemMoni.setLevel(0);
        cuxWorkItemMoniService.deleteCuxWorkItemMoniByIds();
        return toAjax(cuxWorkItemMoniService.bomMoni(cuxWorkItemMoni));
    }
}
