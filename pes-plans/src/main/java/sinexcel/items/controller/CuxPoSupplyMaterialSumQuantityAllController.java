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
import sinexcel.items.domain.CuxPoSupplyMaterialSumQuantityAll;
import sinexcel.items.service.ICuxPoSupplyMaterialSumQuantityAllService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * PO入库数据汇总Controller
 * 
 * @author Zhang Kai
 * @date 2022-05-06
 */
@RestController
@RequestMapping("/items/POInvCalSum")
public class CuxPoSupplyMaterialSumQuantityAllController extends BaseController
{
    @Autowired
    private ICuxPoSupplyMaterialSumQuantityAllService cuxPoSupplyMaterialSumQuantityAllService;

    /**
     * 查询PO入库数据汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:POInvCalSum:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxPoSupplyMaterialSumQuantityAll cuxPoSupplyMaterialSumQuantityAll)
    {
        startPage();
        List<CuxPoSupplyMaterialSumQuantityAll> list = cuxPoSupplyMaterialSumQuantityAllService.selectCuxPoSupplyMaterialSumQuantityAllList(cuxPoSupplyMaterialSumQuantityAll);
        return getDataTable(list);
    }

    /**
     * 导出PO入库数据汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:POInvCalSum:export')")
    @Log(title = "PO入库数据汇总", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxPoSupplyMaterialSumQuantityAll cuxPoSupplyMaterialSumQuantityAll)
    {
        List<CuxPoSupplyMaterialSumQuantityAll> list = cuxPoSupplyMaterialSumQuantityAllService.selectCuxPoSupplyMaterialSumQuantityAllList(cuxPoSupplyMaterialSumQuantityAll);
        ExcelUtil<CuxPoSupplyMaterialSumQuantityAll> util = new ExcelUtil<CuxPoSupplyMaterialSumQuantityAll>(CuxPoSupplyMaterialSumQuantityAll.class);
        return util.exportExcel(list, "PO入库数据汇总");
    }
}
