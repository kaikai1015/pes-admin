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
import sinexcel.items.domain.SyncInvOnhandQuantityNewPriceEO;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.items.service.ISyncInvOnhandQuantityNewPriceService;

/**
 * ERP库存现有量Controller
 *
 * @author Zhang Kai
 * @date 2021-06-28
 */
@RestController
@RequestMapping("/items/onhandCst")
public class SyncInvOnhandQuantityNewPriceController extends BaseController
{
    @Autowired
    private ISyncInvOnhandQuantityNewPriceService syncInvOnhandQuantityNewPriceService;

    /**
     * 查询ERP库存现有量列表
     */
    @PreAuthorize("@ss.hasPermi('items:onhandCst:list')")
    @GetMapping("/list")
    public TableDataInfo list(SyncInvOnhandQuantityNewPriceEO syncInvOnhandQuantityNewPriceEO)
    {
        startPage();
        List<SyncInvOnhandQuantityNewPriceEO> list = syncInvOnhandQuantityNewPriceService.selectSyncInvOnhandQuantityNewList(syncInvOnhandQuantityNewPriceEO);
        return getDataTable(list);
    }

    /**
     * 导出ERP库存现有量列表
     */
    @PreAuthorize("@ss.hasPermi('items:onhandCst:export')")
    @Log(title = "ERP库存账龄表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SyncInvOnhandQuantityNewPriceEO syncInvOnhandQuantityNewPriceEO)
    {

        List<SyncInvOnhandQuantityNewPriceEO> list = syncInvOnhandQuantityNewPriceService.selectSyncInvOnhandQuantityNewList(syncInvOnhandQuantityNewPriceEO);
        ExcelUtil<SyncInvOnhandQuantityNewPriceEO> util = new ExcelUtil<SyncInvOnhandQuantityNewPriceEO>(SyncInvOnhandQuantityNewPriceEO.class);
        return util.exportExcel(list, "ERP库存账龄表");
    }

}
