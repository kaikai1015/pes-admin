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
import sinexcel.common.annotation.RepeatSubmit;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.items.domain.SyncItemsNumDesBuyerList;
import sinexcel.items.service.ISyncItemsNumDesBuyerListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 物料编码和描述快码Controller
 * 
 * @author Zhang Kai
 * @date 2021-12-21
 */
@RestController
@RequestMapping("/items/itemBuyer")
public class SyncItemsNumDesBuyerListController extends BaseController
{
    @Autowired
    private ISyncItemsNumDesBuyerListService syncItemsNumDesBuyerListService;

    /**
     * 查询物料编码和描述快码列表
     */
    @PreAuthorize("@ss.hasPermi('items:itemBuyer:list')")
    @GetMapping("/list")
    public TableDataInfo list(SyncItemsNumDesBuyerList syncItemsNumDesBuyerList)
    {
        startPage();
        List<SyncItemsNumDesBuyerList> list = syncItemsNumDesBuyerListService.selectSyncItemsNumDesBuyerListList(syncItemsNumDesBuyerList);
        return getDataTable(list);
    }

    /**
     * 导出物料编码和描述快码列表
     */
    @PreAuthorize("@ss.hasPermi('items:itemBuyer:export')")
    @Log(title = "物料编码和描述快码", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SyncItemsNumDesBuyerList syncItemsNumDesBuyerList)
    {
        List<SyncItemsNumDesBuyerList> list = syncItemsNumDesBuyerListService.selectSyncItemsNumDesBuyerListList(syncItemsNumDesBuyerList);
        ExcelUtil<SyncItemsNumDesBuyerList> util = new ExcelUtil<SyncItemsNumDesBuyerList>(SyncItemsNumDesBuyerList.class);
        return util.exportExcel(list, "对照表");
    }

    /**
     * 获取物料编码和描述快码详细信息
     */
    @PreAuthorize("@ss.hasPermi('items:itemBuyer:query')")
    @GetMapping(value = "/{organizationId}/{inventoryItemId}")
    public AjaxResult getInfo(@PathVariable("organizationId") Long organizationId,@PathVariable("inventoryItemId") Long inventoryItemId)
    {
        return AjaxResult.success(syncItemsNumDesBuyerListService.selectSyncItemsNumDesBuyerListById(organizationId,inventoryItemId));
    }

    /**
     * 修改物料编码和描述快码
     */
    @PreAuthorize("@ss.hasPermi('items:itemBuyer:edit')")
    @Log(title = "物料编码和描述快码", businessType = BusinessType.UPDATE)
    @PutMapping
    @RepeatSubmit
    public AjaxResult edit(@RequestBody SyncItemsNumDesBuyerList syncItemsNumDesBuyerList)
    {
        return toAjax(syncItemsNumDesBuyerListService.updateSyncItemsNumDesBuyerList(syncItemsNumDesBuyerList));
    }
}
