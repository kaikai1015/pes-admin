package sinexcel.items.controller;

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
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.items.domain.CuxPlaItemBomList;
import sinexcel.items.service.ICuxPlaItemBomListService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * BOM选配平台模型Controller
 * 
 * @author Zhang Kai
 * @date 2020-12-27
 */
@RestController
@RequestMapping("/items/plaList")
public class CuxPlaItemBomListController extends BaseController
{
    @Autowired
    private ICuxPlaItemBomListService cuxPlaItemBomListService;

    /**
     * 查询BOM选配平台模型列表
     */
    @PreAuthorize("@ss.hasPermi('items:plaList:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxPlaItemBomList cuxPlaItemBomList)
    {
        List<CuxPlaItemBomList> list = cuxPlaItemBomListService.selectCuxPlaItemBomListList(cuxPlaItemBomList);
        return getDataTable(list);
    }

    /**
     * 获取BOM选配平台模型详细信息
     */
    @PreAuthorize("@ss.hasPermi('items:plaList:query')")
    @GetMapping("/getPlaList")
    public AjaxResult getInfo(CuxPlaItemBomList cuxPlaItemBomList)
    {
        return AjaxResult.success(cuxPlaItemBomListService.selectCuxPlaItemBomListListByIds(cuxPlaItemBomList));
    }

    @PreAuthorize("@ss.hasPermi('items:plaList:list')")
    @GetMapping("/plaList/list")
    public TableDataInfo plaList(CuxPlaItemBomList cuxPlaItemBomList)
    {
        startPage();
        List<CuxPlaItemBomList> list = cuxPlaItemBomListService.selectCuxPlaItemBomListListByPla(cuxPlaItemBomList);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('items:plaList:export')")
    @Log(title = "导出P料号和C料号关系", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxPlaItemBomList cuxPlaItemBomList)
    {
        List<CuxPlaItemBomList> list = cuxPlaItemBomListService.selectCuxPlaItemBomListListByPla(cuxPlaItemBomList);
        ExcelUtil<CuxPlaItemBomList> util = new ExcelUtil<CuxPlaItemBomList>(CuxPlaItemBomList.class);
        return util.exportExcel(list, "P料号和C料号关系");
    }
}
