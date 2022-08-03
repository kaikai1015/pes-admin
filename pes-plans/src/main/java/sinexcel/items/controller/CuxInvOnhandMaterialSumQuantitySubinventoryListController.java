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
import sinexcel.items.domain.CuxInvOnhandMaterialSumQuantitySubinventoryList;
import sinexcel.items.service.ICuxInvOnhandMaterialSumQuantitySubinventoryListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 库存周波动汇总Controller
 * 
 * @author Zhang Kai
 * @date 2022-05-28
 */
@RestController
@RequestMapping("/items/weekInvMaterialSubList")
public class CuxInvOnhandMaterialSumQuantitySubinventoryListController extends BaseController
{
    @Autowired
    private ICuxInvOnhandMaterialSumQuantitySubinventoryListService cuxInvOnhandMaterialSumQuantitySubinventoryListService;

    /**
     * 查询库存周波动汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:weekInvMaterialSubList:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxInvOnhandMaterialSumQuantitySubinventoryList cuxInvOnhandMaterialSumQuantitySubinventoryList)
    {
        startPage();
        List<CuxInvOnhandMaterialSumQuantitySubinventoryList> list = cuxInvOnhandMaterialSumQuantitySubinventoryListService.selectCuxInvOnhandMaterialSumQuantitySubinventoryListList(cuxInvOnhandMaterialSumQuantitySubinventoryList);
        return getDataTable(list);
    }

    /**
     * 导出库存周波动汇总列表
     */
    @PreAuthorize("@ss.hasPermi('items:weekInvMaterialSubList:export')")
    @Log(title = "库存周波动汇总", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxInvOnhandMaterialSumQuantitySubinventoryList cuxInvOnhandMaterialSumQuantitySubinventoryList)
    {
        List<CuxInvOnhandMaterialSumQuantitySubinventoryList> list = cuxInvOnhandMaterialSumQuantitySubinventoryListService.selectCuxInvOnhandMaterialSumQuantitySubinventoryListList(cuxInvOnhandMaterialSumQuantitySubinventoryList);
        ExcelUtil<CuxInvOnhandMaterialSumQuantitySubinventoryList> util = new ExcelUtil<CuxInvOnhandMaterialSumQuantitySubinventoryList>(CuxInvOnhandMaterialSumQuantitySubinventoryList.class);
        return util.exportExcel(list, "库存周波动汇总");
    }

}
