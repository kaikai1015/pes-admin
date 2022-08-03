package sinexcel.items.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.items.domain.CuxItemDemandQuantityList;
import sinexcel.items.service.ICuxItemDemandQuantityListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 物料需求平均备货数量Controller
 * 
 * @author Zhang Kai
 * @date 2021-10-27
 */
@RestController
@RequestMapping("/items/itemDemandList")
public class CuxItemDemandQuantityListController extends BaseController
{
    @Autowired
    private ICuxItemDemandQuantityListService cuxItemDemandQuantityListService;

    /**
     * 查询物料需求平均备货数量列表
     */
    @PreAuthorize("@ss.hasPermi('items:itemDemandList:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxItemDemandQuantityList cuxItemDemandQuantityList)
    {
        startPage();
        List<CuxItemDemandQuantityList> list = cuxItemDemandQuantityListService.selectCuxItemDemandQuantityListList(cuxItemDemandQuantityList);
        return getDataTable(list);
    }

    /**
     * 导出物料需求平均备货数量列表
     */
    @PreAuthorize("@ss.hasPermi('items:itemDemandList:export')")
    @Log(title = "物料需求平均备货数量", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxItemDemandQuantityList cuxItemDemandQuantityList)
    {
        List<CuxItemDemandQuantityList> list = cuxItemDemandQuantityListService.selectCuxItemDemandQuantityListList(cuxItemDemandQuantityList);
        ExcelUtil<CuxItemDemandQuantityList> util = new ExcelUtil<CuxItemDemandQuantityList>(CuxItemDemandQuantityList.class);
        return util.exportExcel(list, "物料需求平均备货数量列表");
    }
}
