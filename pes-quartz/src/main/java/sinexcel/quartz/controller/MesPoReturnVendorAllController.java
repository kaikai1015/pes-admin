package sinexcel.quartz.controller;

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
import sinexcel.quartz.domain.MesPoReturnVendorAllEO;
import sinexcel.quartz.service.IMesPoReturnVendorAllService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 采购退货Controller
 * 
 * @author Zhang Kai
 * @date 2022-04-12
 */
@RestController
@RequestMapping("/quartz/poReturn")
public class MesPoReturnVendorAllController extends BaseController
{
    @Autowired
    private IMesPoReturnVendorAllService mesPoReturnVendorAllService;

    /**
     * 查询采购退货列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:poReturn:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesPoReturnVendorAllEO mesPoReturnVendorAll)
    {
        startPage();
        List<MesPoReturnVendorAllEO> list = mesPoReturnVendorAllService.selectMesPoReturnVendorAllList(mesPoReturnVendorAll);
        return getDataTable(list);
    }

    /**
     * 导出采购退货列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:poReturn:export')")
    @Log(title = "采购退货", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MesPoReturnVendorAllEO mesPoReturnVendorAll)
    {
        List<MesPoReturnVendorAllEO> list = mesPoReturnVendorAllService.selectMesPoReturnVendorAllList(mesPoReturnVendorAll);
        ExcelUtil<MesPoReturnVendorAllEO> util = new ExcelUtil<MesPoReturnVendorAllEO>(MesPoReturnVendorAllEO.class);
        return util.exportExcel(list, "poReturn");
    }

    /**
     * 获取采购退货详细信息
     */
    @PreAuthorize("@ss.hasPermi('quartz:poReturn:query')")
    @GetMapping(value = "/{returnVendorId}")
    public AjaxResult getInfo(@PathVariable("returnVendorId") Long returnVendorId)
    {
        return AjaxResult.success(mesPoReturnVendorAllService.selectMesPoReturnVendorAllById(returnVendorId));
    }

}
