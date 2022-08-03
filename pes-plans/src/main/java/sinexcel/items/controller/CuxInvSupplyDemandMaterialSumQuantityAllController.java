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
import sinexcel.items.domain.CuxInvSupplyDemandMaterialSumQuantityAllEO;
import sinexcel.items.service.ICuxInvSupplyDemandMaterialSumQuantityAllService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 其它出入数据汇总Controller
 *
 * @author Zhang Kai
 * @date 2022-05-07
 */
@RestController
@RequestMapping("/items/InvSupplyDemandMaterial")
public class CuxInvSupplyDemandMaterialSumQuantityAllController extends BaseController
{
    @Autowired
    private ICuxInvSupplyDemandMaterialSumQuantityAllService cuxInvSupplyDemandMaterialSumQuantityAllService;

    /**
     * 查询其它出入数据汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:InvSupplyDemandMaterial:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxInvSupplyDemandMaterialSumQuantityAllEO cuxInvSupplyDemandMaterialSumQuantityAllEO)
    {
        startPage();
        List<CuxInvSupplyDemandMaterialSumQuantityAllEO> list = cuxInvSupplyDemandMaterialSumQuantityAllService.selectCuxInvSupplyDemandMaterialSumQuantityAllList(cuxInvSupplyDemandMaterialSumQuantityAllEO);
        return getDataTable(list);
    }

    /**
     * 导出其它出入数据汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:InvSupplyDemandMaterial:export')")
    @Log(title = "库存各模块按月汇总计算", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxInvSupplyDemandMaterialSumQuantityAllEO cuxInvSupplyDemandMaterialSumQuantityAllEO)
    {
        List<CuxInvSupplyDemandMaterialSumQuantityAllEO> list = cuxInvSupplyDemandMaterialSumQuantityAllService.selectCuxInvSupplyDemandMaterialSumQuantityAllList(cuxInvSupplyDemandMaterialSumQuantityAllEO);
        ExcelUtil<CuxInvSupplyDemandMaterialSumQuantityAllEO> util = new ExcelUtil<CuxInvSupplyDemandMaterialSumQuantityAllEO>(CuxInvSupplyDemandMaterialSumQuantityAllEO.class);
        return util.exportExcel(list, "库存各模块按月汇总计算");
    }

}
