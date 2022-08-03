package sinexcel.quartz.controller;


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
import sinexcel.quartz.domain.SyncInvMaterialTxnsEO;
import sinexcel.quartz.service.ISyncInvMaterialTxnsService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 库存事务处理明细Controller
 *
 * @author Zhang Kai
 * @date 2021-11-11
 */
@RestController
@RequestMapping("/quartz/SyncInvMaterialTxns")
public class SyncInvMaterialTxnsErpController extends BaseController
{
    @Autowired
    private ISyncInvMaterialTxnsService syncInvMaterialTxnsService;

    /**
     * 查询库存事务处理明细列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:SyncInvMaterialTxns:list')")
    @GetMapping("/list")
    public TableDataInfo list(SyncInvMaterialTxnsEO syncInvMaterialTxns)
    {
        startPage();
        List<SyncInvMaterialTxnsEO> list = syncInvMaterialTxnsService.selectSyncInvMaterialTxnsListErp(syncInvMaterialTxns);
        return getDataTable(list);
    }

    /**
     * 导出库存事务处理明细列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:SyncInvMaterialTxns:export')")
    @Log(title = "库存事务处理明细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SyncInvMaterialTxnsEO syncInvMaterialTxns)
    {
        List<SyncInvMaterialTxnsEO> list = syncInvMaterialTxnsService.selectSyncInvMaterialTxnsListErp(syncInvMaterialTxns);
        ExcelUtil<SyncInvMaterialTxnsEO> util = new ExcelUtil<SyncInvMaterialTxnsEO>(SyncInvMaterialTxnsEO.class);
        return util.exportExcel(list, "库存事务处理明细");
    }
}