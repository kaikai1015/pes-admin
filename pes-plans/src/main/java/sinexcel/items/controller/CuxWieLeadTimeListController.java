package sinexcel.items.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.items.domain.CuxWieLeadTimeList;
import sinexcel.items.service.ICuxWieLeadTimeListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 生产提前期Controller
 * 
 * @author Zhang Kai
 * @date 2020-11-30
 */
@RestController
@RequestMapping("/items/wieLeadTime")
public class CuxWieLeadTimeListController extends BaseController
{
    @Autowired
    private ICuxWieLeadTimeListService cuxWieLeadTimeListService;

    /**
     * 查询生产提前期列表
     */
    @PreAuthorize("@ss.hasPermi('items:wieLeadTime:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxWieLeadTimeList cuxWieLeadTimeList)
    {
        startPage();
        List<CuxWieLeadTimeList> list = cuxWieLeadTimeListService.selectCuxWieLeadTimeListList(cuxWieLeadTimeList);
        return getDataTable(list);
    }

    /**
     * 导出生产提前期列表
     */
    @PreAuthorize("@ss.hasPermi('items:wieLeadTime:export')")
    @Log(title = "生产提前期", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxWieLeadTimeList cuxWieLeadTimeList)
    {
        List<CuxWieLeadTimeList> list = cuxWieLeadTimeListService.selectCuxWieLeadTimeListList(cuxWieLeadTimeList);
        ExcelUtil<CuxWieLeadTimeList> util = new ExcelUtil<CuxWieLeadTimeList>(CuxWieLeadTimeList.class);
        return util.exportExcel(list, "wieLeadTime");
    }

    /**
     * 新增生产提前期
     */
    @PreAuthorize("@ss.hasPermi('items:wieLeadTime:add')")
    @Log(title = "新增生产提前期", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CuxWieLeadTimeList cuxWieLeadTimeList)
    {
        return toAjax(cuxWieLeadTimeListService.insertCuxWieLeadTimeList(cuxWieLeadTimeList));
    }
}
