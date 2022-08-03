package sinexcel.weeks.controller;

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
import sinexcel.weeks.domain.CuxWorkOrdersQtDetailsQl;
import sinexcel.weeks.service.ICuxWorkOrdersQtDetailsQlService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 欠料查询Controller
 * 
 * @author Zhang Kai
 * @date 2021-03-11
 */
@RestController
@RequestMapping("/weeks/workQt")
public class CuxWorkOrdersQtDetailsQlController extends BaseController
{
    @Autowired
    private ICuxWorkOrdersQtDetailsQlService cuxWorkOrdersQtDetailsQlService;

    /**
     * 查询欠料查询列表
     */
    @PreAuthorize("@ss.hasPermi('weeks:workQt:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxWorkOrdersQtDetailsQl cuxWorkOrdersQtDetailsQl)
    {
        startPage();
        List<CuxWorkOrdersQtDetailsQl> list = cuxWorkOrdersQtDetailsQlService.selectCuxWorkOrdersQtDetailsQlList(cuxWorkOrdersQtDetailsQl);
        return getDataTable(list);
    }

    /**
     * 导出欠料查询列表
     */
    @PreAuthorize("@ss.hasPermi('weeks:workQt:export')")
    @Log(title = "欠料查询", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxWorkOrdersQtDetailsQl cuxWorkOrdersQtDetailsQl)
    {
        List<CuxWorkOrdersQtDetailsQl> list = cuxWorkOrdersQtDetailsQlService.selectCuxWorkOrdersQtDetailsQlList(cuxWorkOrdersQtDetailsQl);
        ExcelUtil<CuxWorkOrdersQtDetailsQl> util = new ExcelUtil<CuxWorkOrdersQtDetailsQl>(CuxWorkOrdersQtDetailsQl.class);
        return util.exportExcel(list, "欠料明细");
    }
}
