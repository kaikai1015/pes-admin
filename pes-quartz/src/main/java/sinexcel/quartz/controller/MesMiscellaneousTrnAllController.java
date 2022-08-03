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
import sinexcel.quartz.domain.MesMiscellaneousTrnAllEO;
import sinexcel.quartz.service.IMesMiscellaneousTrnAllService;

import java.util.List;

/**
 * 杂入，杂出Controller
 *
 * @author Zhang Kai
 * @date 2021-07-22
 */
@RestController
@RequestMapping("/quartz/miscellaneous")
public class MesMiscellaneousTrnAllController extends BaseController {
    @Autowired
    private IMesMiscellaneousTrnAllService mesMiscellaneousTrnAllService;
    /**
     * 查询杂入，杂出列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:miscellaneous:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesMiscellaneousTrnAllEO mesMiscellaneousTrnAll)
    {
        startPage();
        List<MesMiscellaneousTrnAllEO> list = mesMiscellaneousTrnAllService.selectMesMiscellaneousTrnAllList(mesMiscellaneousTrnAll);
        return getDataTable(list);
    }

    /**
     * 导出杂入，杂出列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:miscellaneous:export')")
    @Log(title = "杂入，杂出", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MesMiscellaneousTrnAllEO mesMiscellaneousTrnAll)
    {
        List<MesMiscellaneousTrnAllEO> list = mesMiscellaneousTrnAllService.selectMesMiscellaneousTrnAllList(mesMiscellaneousTrnAll);
        ExcelUtil<MesMiscellaneousTrnAllEO> util = new ExcelUtil<MesMiscellaneousTrnAllEO>(MesMiscellaneousTrnAllEO.class);
        return util.exportExcel(list, "杂入杂出列表");
    }
}
