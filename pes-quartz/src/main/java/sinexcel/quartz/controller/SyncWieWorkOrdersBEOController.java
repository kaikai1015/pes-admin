package sinexcel.quartz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.quartz.domain.SyncWieWorkOrdersBEO;
import sinexcel.quartz.service.ISyncWieWorkOrdersBService;

import java.util.List;

/**
 * 工单信息数据Controller
 *
 * @author Zhang Kai
 * @date 2020-12-17
 */
@RestController
@RequestMapping("/quartz/workHeadersDatas")
public class SyncWieWorkOrdersBEOController extends BaseController {

    @Autowired
    private ISyncWieWorkOrdersBService syncWieWorkOrdersBService;

    /**
     * 查询工单信息数据列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:workHeadersDatas:list')")
    @GetMapping("/list")
    public TableDataInfo list(SyncWieWorkOrdersBEO syncWieWorkOrdersB)
    {
        startPage();
        List<SyncWieWorkOrdersBEO> list = syncWieWorkOrdersBService.selectSyncWieWorkOrdersBList(syncWieWorkOrdersB);
        return getDataTable(list);
    }

    /**
     * 导出工单信息数据列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:workHeadersDatas:export')")
    @Log(title = "工单信息数据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SyncWieWorkOrdersBEO syncWieWorkOrdersB)
    {
        List<SyncWieWorkOrdersBEO> list = syncWieWorkOrdersBService.selectSyncWieWorkOrdersBList(syncWieWorkOrdersB);
        ExcelUtil<SyncWieWorkOrdersBEO> util = new ExcelUtil<SyncWieWorkOrdersBEO>(SyncWieWorkOrdersBEO.class);
        return util.exportExcel(list, "工单信息数据");
    }
}
