package sinexcel.plans.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.plans.domain.CuxPoLeadTimeList;
import sinexcel.plans.service.ICuxPoLeadTimeListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 采购提前期全表Controller
 * 
 * @author Zhang Kai
 * @date 2020-11-27
 */
@RestController
@RequestMapping("/plans/poLeadTime")
public class CuxPoLeadTimeListController extends BaseController
{
    @Autowired
    private ICuxPoLeadTimeListService cuxPoLeadTimeListService;

    /**
     * 查询采购提前期全表列表
     */
    @PreAuthorize("@ss.hasPermi('plans:poLeadTime:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxPoLeadTimeList cuxPoLeadTimeList)
    {
        startPage();
        List<CuxPoLeadTimeList> list = cuxPoLeadTimeListService.selectCuxPoLeadTimeListList(cuxPoLeadTimeList);
        return getDataTable(list);
    }

    /**
     * 导出采购提前期全表列表
     */
    @PreAuthorize("@ss.hasPermi('plans:poLeadTime:export')")
    @Log(title = "采购提前期全表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxPoLeadTimeList cuxPoLeadTimeList)
    {
        List<CuxPoLeadTimeList> list = cuxPoLeadTimeListService.selectCuxPoLeadTimeListList(cuxPoLeadTimeList);
        ExcelUtil<CuxPoLeadTimeList> util = new ExcelUtil<CuxPoLeadTimeList>(CuxPoLeadTimeList.class);
        return util.exportExcel(list, "poLeadTime");
    }

    /**
     * 新增采购提前期全表
     */
    @PreAuthorize("@ss.hasPermi('plans:poLeadTime:add')")
    @Log(title = "新增采购提前期全表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CuxPoLeadTimeList cuxPoLeadTimeList)
    {
        return toAjax(cuxPoLeadTimeListService.insertCuxPoLeadTimeList(cuxPoLeadTimeList));
    }
}
