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
import sinexcel.items.domain.PesItemSupplyDemandQty;
import sinexcel.items.service.IPesItemSupplyDemandQtyService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 供应和需求汇总Controller
 * 
 * @author Zhang Kai
 * @date 2021-04-19
 */
@RestController
@RequestMapping("/items/supplyDemandSum")
public class PesItemSupplyDemandQtyController extends BaseController
{
    @Autowired
    private IPesItemSupplyDemandQtyService pesItemSupplyDemandQtyService;

    /**
     * 查询供应和需求汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:supplyDemandSum:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesItemSupplyDemandQty pesItemSupplyDemandQty)
    {
        startPage();
        List<PesItemSupplyDemandQty> list = pesItemSupplyDemandQtyService.selectPesItemSupplyDemandQtyList(pesItemSupplyDemandQty);
        return getDataTable(list);
    }

    /**
     * 导出供应和需求汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:supplyDemandSum:export')")
    @Log(title = "供应和需求汇总", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesItemSupplyDemandQty pesItemSupplyDemandQty)
    {
        List<PesItemSupplyDemandQty> list = pesItemSupplyDemandQtyService.selectPesItemSupplyDemandQtyList(pesItemSupplyDemandQty);
        ExcelUtil<PesItemSupplyDemandQty> util = new ExcelUtil<PesItemSupplyDemandQty>(PesItemSupplyDemandQty.class);
        return util.exportExcel(list, "供应和需求汇总");
    }
}
