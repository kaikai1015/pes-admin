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
import sinexcel.items.domain.CuxWieDemandMaterialSumQuantityAll;
import sinexcel.items.service.ICuxWieDemandMaterialSumQuantityAllService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 工单发料数据汇总Controller
 * 
 * @author Zhang Kai
 * @date 2022-05-07
 */
@RestController
@RequestMapping("/items/WieDemandMaterials")
public class CuxWieDemandMaterialSumQuantityAllController extends BaseController
{
    @Autowired
    private ICuxWieDemandMaterialSumQuantityAllService cuxWieDemandMaterialSumQuantityAllService;

    /**
     * 查询工单发料数据汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:WieDemandMaterials:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxWieDemandMaterialSumQuantityAll cuxWieDemandMaterialSumQuantityAll)
    {
        startPage();
        List<CuxWieDemandMaterialSumQuantityAll> list = cuxWieDemandMaterialSumQuantityAllService.selectCuxWieDemandMaterialSumQuantityAllList(cuxWieDemandMaterialSumQuantityAll);
        return getDataTable(list);
    }

    /**
     * 导出工单发料数据汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:WieDemandMaterials:export')")
    @Log(title = "工单发料数据汇总", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxWieDemandMaterialSumQuantityAll cuxWieDemandMaterialSumQuantityAll)
    {
        List<CuxWieDemandMaterialSumQuantityAll> list = cuxWieDemandMaterialSumQuantityAllService.selectCuxWieDemandMaterialSumQuantityAllList(cuxWieDemandMaterialSumQuantityAll);
        ExcelUtil<CuxWieDemandMaterialSumQuantityAll> util = new ExcelUtil<CuxWieDemandMaterialSumQuantityAll>(CuxWieDemandMaterialSumQuantityAll.class);
        return util.exportExcel(list, "工单发料数据汇总");
    }

}
