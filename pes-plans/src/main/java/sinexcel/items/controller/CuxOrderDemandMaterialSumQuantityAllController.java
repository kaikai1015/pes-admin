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
import sinexcel.items.domain.CuxOrderDemandMaterialSumQuantityAll;
import sinexcel.items.service.ICuxOrderDemandMaterialSumQuantityAllService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 工单已发料数据汇总Controller
 * 
 * @author Zhang Kai
 * @date 2022-05-07
 */
@RestController
@RequestMapping("/items/OrderDemands")
public class CuxOrderDemandMaterialSumQuantityAllController extends BaseController
{
    @Autowired
    private ICuxOrderDemandMaterialSumQuantityAllService cuxOrderDemandMaterialSumQuantityAllService;

    /**
     * 查询工单已发料数据汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:OrderDemands:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxOrderDemandMaterialSumQuantityAll cuxOrderDemandMaterialSumQuantityAll)
    {
        startPage();
        List<CuxOrderDemandMaterialSumQuantityAll> list = cuxOrderDemandMaterialSumQuantityAllService.selectCuxOrderDemandMaterialSumQuantityAllList(cuxOrderDemandMaterialSumQuantityAll);
        return getDataTable(list);
    }

    /**
     * 导出工单已发料数据汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:OrderDemands:export')")
    @Log(title = "工单已发料数据汇总", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxOrderDemandMaterialSumQuantityAll cuxOrderDemandMaterialSumQuantityAll)
    {
        List<CuxOrderDemandMaterialSumQuantityAll> list = cuxOrderDemandMaterialSumQuantityAllService.selectCuxOrderDemandMaterialSumQuantityAllList(cuxOrderDemandMaterialSumQuantityAll);
        ExcelUtil<CuxOrderDemandMaterialSumQuantityAll> util = new ExcelUtil<CuxOrderDemandMaterialSumQuantityAll>(CuxOrderDemandMaterialSumQuantityAll.class);
        return util.exportExcel(list, "工单已发料数据汇总");
    }

}
