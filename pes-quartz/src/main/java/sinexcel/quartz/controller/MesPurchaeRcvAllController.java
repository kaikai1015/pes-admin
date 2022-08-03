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
import sinexcel.quartz.domain.MesRcvPurchaseEO;
import sinexcel.quartz.service.IMesPurchaeRcvAllService;

import java.util.List;

/**
 * 杂入，杂出Controller
 *
 * @author Zhang Kai
 * @date 2021-07-22
 */
@RestController
@RequestMapping("/quartz/rcvPurchase")
public class MesPurchaeRcvAllController extends BaseController {
    @Autowired
    private IMesPurchaeRcvAllService mesPurchaeRcvAllService;
    /**
     * 查询杂入，杂出列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:rcvPurchase:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesRcvPurchaseEO mesPurchaeRcvAll)
    {
        startPage();
        List<MesRcvPurchaseEO> list = mesPurchaeRcvAllService.selectMesPurchaeRcvAllList(mesPurchaeRcvAll);
        return getDataTable(list);
    }

    /**
     * 导出采购入库接口列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:rcvPurchase:export')")
    @Log(title = "采购入库接口", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MesRcvPurchaseEO mesPurchaeRcvAll)
    {
        List<MesRcvPurchaseEO> list = mesPurchaeRcvAllService.selectMesPurchaeRcvAllList(mesPurchaeRcvAll);
        ExcelUtil<MesRcvPurchaseEO> util = new ExcelUtil<MesRcvPurchaseEO>(MesRcvPurchaseEO.class);
        return util.exportExcel(list, "采购入库接口列表");
    }
}
