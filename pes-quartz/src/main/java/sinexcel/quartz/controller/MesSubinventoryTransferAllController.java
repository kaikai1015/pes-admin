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
import sinexcel.quartz.domain.MesSubinventoryTransferAllEO;
import sinexcel.quartz.service.IMesSubinventoryTransferAllService;

import java.util.List;

/**
 * 调拨子库存转移Controller
 *
 * @author Zhang Kai
 * @date 2021-07-22
 */
@RestController
@RequestMapping("/quartz/subinventoryTransferAll")
public class MesSubinventoryTransferAllController extends BaseController {

    @Autowired
    private IMesSubinventoryTransferAllService mesSubinventoryTransferAllService;

    /**
     * 查询调拨子库存转移列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:subinventoryTransferAll:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesSubinventoryTransferAllEO mesSubinventoryTransferAll)
    {
        startPage();
        List<MesSubinventoryTransferAllEO> list = mesSubinventoryTransferAllService.selectMesSubinventoryTransferAllList(mesSubinventoryTransferAll);
        return getDataTable(list);
    }
    /**
     * 导出调拨子库存转移列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:subinventoryTransferAll:export')")
    @Log(title = "导出调拨子库存转移", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MesSubinventoryTransferAllEO mesSubinventoryTransferAll)
    {
        List<MesSubinventoryTransferAllEO> list = mesSubinventoryTransferAllService.selectMesSubinventoryTransferAllList(mesSubinventoryTransferAll);
        ExcelUtil<MesSubinventoryTransferAllEO> util = new ExcelUtil<MesSubinventoryTransferAllEO>(MesSubinventoryTransferAllEO.class);
        return util.exportExcel(list, "调拨子库存转移");
    }
}
