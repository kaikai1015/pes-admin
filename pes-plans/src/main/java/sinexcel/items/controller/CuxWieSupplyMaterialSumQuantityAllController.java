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
import sinexcel.items.domain.CuxWieSupplyMaterialSumQuantityAll;
import sinexcel.items.service.ICuxWieSupplyMaterialSumQuantityAllService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 工单入库数据汇总Controller
 * 
 * @author Zhang Kai
 * @date 2022-05-07
 */
@RestController
@RequestMapping("/items/WieSupplyMaterial")
public class CuxWieSupplyMaterialSumQuantityAllController extends BaseController
{
    @Autowired
    private ICuxWieSupplyMaterialSumQuantityAllService cuxWieSupplyMaterialSumQuantityAllService;

    /**
     * 查询工单入库数据汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:WieSupplyMaterial:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxWieSupplyMaterialSumQuantityAll cuxWieSupplyMaterialSumQuantityAll)
    {
        startPage();
        List<CuxWieSupplyMaterialSumQuantityAll> list = cuxWieSupplyMaterialSumQuantityAllService.selectCuxWieSupplyMaterialSumQuantityAllList(cuxWieSupplyMaterialSumQuantityAll);
        return getDataTable(list);
    }

    /**
     * 导出工单入库数据汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:WieSupplyMaterial:export')")
    @Log(title = "工单入库数据汇总", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxWieSupplyMaterialSumQuantityAll cuxWieSupplyMaterialSumQuantityAll)
    {
        List<CuxWieSupplyMaterialSumQuantityAll> list = cuxWieSupplyMaterialSumQuantityAllService.selectCuxWieSupplyMaterialSumQuantityAllList(cuxWieSupplyMaterialSumQuantityAll);
        ExcelUtil<CuxWieSupplyMaterialSumQuantityAll> util = new ExcelUtil<CuxWieSupplyMaterialSumQuantityAll>(CuxWieSupplyMaterialSumQuantityAll.class);
        return util.exportExcel(list, "工单入库数据汇总");
    }

}
