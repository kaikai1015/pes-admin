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
import sinexcel.items.domain.PesItemSupplyDemandListDetails;
import sinexcel.items.service.IPesItemSupplyDemandListDetailsService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 复核项供应和需求明细Controller
 * 
 * @author Zhang Kai
 * @date 2021-05-07
 */
@RestController
@RequestMapping("/items/supplyDemandListLineDetails")
public class PesItemSupplyDemandListDetailsController extends BaseController
{
    @Autowired
    private IPesItemSupplyDemandListDetailsService pesItemSupplyDemandListDetailsService;

    /**
     * 查询复核项供应和需求明细列表
     */
    @PreAuthorize("@ss.hasPermi('items:supplyDemandListLineDetails:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesItemSupplyDemandListDetails pesItemSupplyDemandListDetails)
    {
        startPage();
        List<PesItemSupplyDemandListDetails> list = pesItemSupplyDemandListDetailsService.selectPesItemSupplyDemandListDetailsList(pesItemSupplyDemandListDetails);
        return getDataTable(list);
    }

    /**
     * 导出复核项供应和需求明细列表
     */
    @PreAuthorize("@ss.hasPermi('items:supplyDemandListLineDetails:export')")
    @Log(title = "复核项供应和需求明细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesItemSupplyDemandListDetails pesItemSupplyDemandListDetails)
    {
        List<PesItemSupplyDemandListDetails> list = pesItemSupplyDemandListDetailsService.selectPesItemSupplyDemandListDetailsList(pesItemSupplyDemandListDetails);
        ExcelUtil<PesItemSupplyDemandListDetails> util = new ExcelUtil<PesItemSupplyDemandListDetails>(PesItemSupplyDemandListDetails.class);
        return util.exportExcel(list, "供应和需求明细");
    }
}
