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
import sinexcel.items.domain.CuxOtherSupplyMaterialSumQuantityAll;
import sinexcel.items.service.ICuxOtherSupplyMaterialSumQuantityAllService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 其它出入数据汇总Controller
 * 
 * @author Zhang Kai
 * @date 2022-05-07
 */
@RestController
@RequestMapping("/items/OtherSupplyMaterial")
public class CuxOtherSupplyMaterialSumQuantityAllController extends BaseController
{
    @Autowired
    private ICuxOtherSupplyMaterialSumQuantityAllService cuxOtherSupplyMaterialSumQuantityAllService;

    /**
     * 查询其它出入数据汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:OtherSupplyMaterial:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxOtherSupplyMaterialSumQuantityAll cuxOtherSupplyMaterialSumQuantityAll)
    {
        startPage();
        List<CuxOtherSupplyMaterialSumQuantityAll> list = cuxOtherSupplyMaterialSumQuantityAllService.selectCuxOtherSupplyMaterialSumQuantityAllList(cuxOtherSupplyMaterialSumQuantityAll);
        return getDataTable(list);
    }

    /**
     * 导出其它出入数据汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:OtherSupplyMaterial:export')")
    @Log(title = "其它出入数据汇总", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxOtherSupplyMaterialSumQuantityAll cuxOtherSupplyMaterialSumQuantityAll)
    {
        List<CuxOtherSupplyMaterialSumQuantityAll> list = cuxOtherSupplyMaterialSumQuantityAllService.selectCuxOtherSupplyMaterialSumQuantityAllList(cuxOtherSupplyMaterialSumQuantityAll);
        ExcelUtil<CuxOtherSupplyMaterialSumQuantityAll> util = new ExcelUtil<CuxOtherSupplyMaterialSumQuantityAll>(CuxOtherSupplyMaterialSumQuantityAll.class);
        return util.exportExcel(list, "其它出入数据汇总");
    }

}
