package sinexcel.items.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.items.domain.PesItemSupplyDemandList;
import sinexcel.items.service.IPesItemSupplyDemandListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 复核项供应和需求Controller
 * 
 * @author Zhang Kai
 * @date 2020-12-03
 */
@RestController
@RequestMapping("/items/supplyDemandList")
public class PesItemSupplyDemandListController extends BaseController
{
    @Autowired
    private IPesItemSupplyDemandListService pesItemSupplyDemandListService;

    /**
     * 查询复核项供应和需求列表
     */
    @PreAuthorize("@ss.hasPermi('items:supplyDemandList:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesItemSupplyDemandList pesItemSupplyDemandList)
    {
        startPage();
        List<PesItemSupplyDemandList> list = pesItemSupplyDemandListService.selectPesItemSupplyDemandListList(pesItemSupplyDemandList);
        return getDataTable(list);
    }

    /**
     * 导出复核项供应和需求列表
     */
    @PreAuthorize("@ss.hasPermi('items:supplyDemandList:export')")
    @Log(title = "复核项供应和需求", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesItemSupplyDemandList pesItemSupplyDemandList)
    {
        List<PesItemSupplyDemandList> list = pesItemSupplyDemandListService.selectPesItemSupplyDemandListList(pesItemSupplyDemandList);
        ExcelUtil<PesItemSupplyDemandList> util = new ExcelUtil<PesItemSupplyDemandList>(PesItemSupplyDemandList.class);
        return util.exportExcel(list, "supplyDemandList");
    }

    /**
     * 获取复核项供应和需求明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('items:supplyDemandList:query')")
    @GetMapping("/orgItemId")
    public AjaxResult getInfo(PesItemSupplyDemandList pesItemSupplyDemandList)
    {
        return AjaxResult.success(pesItemSupplyDemandListService.selectPesItemSupplyDemandListById(pesItemSupplyDemandList));
    }

    /**
     * 获取复核项供应和需求明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('items:supplyDemandList:query')")
    @GetMapping("/query")
    public TableDataInfo getListInfo(PesItemSupplyDemandList pesItemSupplyDemandList)
    {
        List<PesItemSupplyDemandList> list = pesItemSupplyDemandListService.selectPesItemSupplyDemandList(pesItemSupplyDemandList);
        return getDataTable(list);
    }
}
