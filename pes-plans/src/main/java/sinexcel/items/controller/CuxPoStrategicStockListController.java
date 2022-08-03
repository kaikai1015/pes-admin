package sinexcel.items.controller;

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
import sinexcel.items.domain.CuxPoStrategicStockList;
import sinexcel.items.service.ICuxPoStrategicStockListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 战略备货-采购件Controller
 * 
 * @author Zhang Kai
 * @date 2021-05-18
 */
@RestController
@RequestMapping("/items/stocks")
public class CuxPoStrategicStockListController extends BaseController
{
    @Autowired
    private ICuxPoStrategicStockListService cuxPoStrategicStockListService;

    /**
     * 查询战略备货-采购件列表
     */
    @PreAuthorize("@ss.hasPermi('items:stocks:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxPoStrategicStockList cuxPoStrategicStockList)
    {
        startPage();
        List<CuxPoStrategicStockList> list = cuxPoStrategicStockListService.selectCuxPoStrategicStockListList(cuxPoStrategicStockList);
        return getDataTable(list);
    }

    /**
     * 导出战略备货-采购件列表
     */
    @PreAuthorize("@ss.hasPermi('items:stocks:export')")
    @Log(title = "战略备货-采购件", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxPoStrategicStockList cuxPoStrategicStockList)
    {
        List<CuxPoStrategicStockList> list = cuxPoStrategicStockListService.selectCuxPoStrategicStockListList(cuxPoStrategicStockList);
        ExcelUtil<CuxPoStrategicStockList> util = new ExcelUtil<CuxPoStrategicStockList>(CuxPoStrategicStockList.class);
        return util.exportExcel(list, "战略备货");
    }
}
