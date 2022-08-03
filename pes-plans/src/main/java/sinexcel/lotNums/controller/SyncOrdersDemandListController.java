package sinexcel.lotNums.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.lotNums.domain.SyncOrdersDemandList;
import sinexcel.lotNums.service.IPesWieOrdersLineListService;
import sinexcel.lotNums.service.ISyncOrdersDemandListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.plans.service.IPlanLineBomService;

/**
 * 订单需求收集Controller
 * 
 * @author Zhang Kai
 * @date 2021-04-23
 */
@RestController
@RequestMapping("/lotNums/ordersLists")
public class SyncOrdersDemandListController extends BaseController
{
    @Autowired
    private ISyncOrdersDemandListService syncOrdersDemandListService;

    @Autowired
    private IPlanLineBomService planLineBomService;

    @Autowired
    private IPesWieOrdersLineListService pesWieOrdersLineListService;

    /**
     * 查询订单需求收集列表
     */
    @PreAuthorize("@ss.hasPermi('lotNums:ordersLists:list')")
    @GetMapping("/list")
    public TableDataInfo list(SyncOrdersDemandList syncOrdersDemandList)
    {
        startPage();
        List<SyncOrdersDemandList> list = syncOrdersDemandListService.selectSyncOrdersDemandListList(syncOrdersDemandList);
        return getDataTable(list);
    }

    /**
     * 导出订单需求收集列表
     */
    @PreAuthorize("@ss.hasPermi('lotNums:ordersLists:export')")
    @Log(title = "订单需求收集", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SyncOrdersDemandList syncOrdersDemandList)
    {
        List<SyncOrdersDemandList> list = syncOrdersDemandListService.selectSyncOrdersDemandListList(syncOrdersDemandList);
        ExcelUtil<SyncOrdersDemandList> util = new ExcelUtil<SyncOrdersDemandList>(SyncOrdersDemandList.class);
        return util.exportExcel(list, "ordersLists");
    }

    /**
     * 计算订单需求收集详细信息
     *
     */
    @PreAuthorize("@ss.hasPermi('lotNums:ordersLists:query')")
    @Log(title = "需求计划计算", businessType = BusinessType.BOM)
    @GetMapping("/mrpOrders/{planLotNum}")
    public AjaxResult mrpOrdersLists(@PathVariable("planLotNum") Long planLotNum)
    {
        //订单需求计算计算之前删除相依需求的数据存储最新的数据
        syncOrdersDemandListService.deleteSyncOrdersDemandListByIds();
        //相依需求计算
        planLineBomService.selectPesPlanLineListById(planLotNum);
        //MPS和MRP计算
        return toAjax(pesWieOrdersLineListService.mrpSyncOrdersDemandListByIds(planLotNum));
    }
}
