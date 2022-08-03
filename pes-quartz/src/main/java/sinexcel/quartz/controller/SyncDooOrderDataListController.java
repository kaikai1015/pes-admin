package sinexcel.quartz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.quartz.domain.SyncDooOrderDataListEO;
import sinexcel.quartz.service.ISyncDooOrderDataListService;
import sinexcel.common.annotation.Log;

import java.util.List;

/**
 * MRP计算计划员查看订单信息Controller
 *
 * @author Zhang Kai
 * @date 2021-12-26
 */
@RestController
@RequestMapping("/quartz/DooList")
public class SyncDooOrderDataListController extends BaseController
{
    @Autowired
    private ISyncDooOrderDataListService syncDooOrderDataListService;

    /**
     * 查询MRP计算计划员查看订单信息列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:DooList:list')")
    @GetMapping("/list")
    public TableDataInfo list(SyncDooOrderDataListEO syncDooOrderDataList)
    {
        startPage();
        List<SyncDooOrderDataListEO> list = syncDooOrderDataListService.selectSyncDooOrderDataListList(syncDooOrderDataList);
        return getDataTable(list);
    }

    /**
     * 导出MRP计算计划员查看订单信息列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:DooList:export')")
    @Log(title = "导出MRP计算计划员查看订单信息列表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SyncDooOrderDataListEO syncDooOrderDataList)
    {
        List<SyncDooOrderDataListEO> list = syncDooOrderDataListService.selectSyncDooOrderDataListList(syncDooOrderDataList);
        ExcelUtil<SyncDooOrderDataListEO> util = new ExcelUtil<SyncDooOrderDataListEO>(SyncDooOrderDataListEO.class);
        return util.exportExcel(list, "订单信息列表");
    }

}