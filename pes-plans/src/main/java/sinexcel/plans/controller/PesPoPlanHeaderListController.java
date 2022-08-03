package sinexcel.plans.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.plans.domain.PesPoPlanHeaderList;
import sinexcel.plans.service.IPesPoPlanHeaderListService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 采购计划头Controller
 * 
 * @author Zhang Kai
 * @date 2020-11-25
 */
@RestController
@RequestMapping("/plans/poHeader")
public class PesPoPlanHeaderListController extends BaseController
{
    @Autowired
    private IPesPoPlanHeaderListService pesPoPlanHeaderListService;

    /**
     * 查询采购计划头列表
     */
    @PreAuthorize("@ss.hasPermi('plans:poHeader:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesPoPlanHeaderList pesPoPlanHeaderList)
    {
        startPage();
        List<PesPoPlanHeaderList> list = pesPoPlanHeaderListService.selectPesPoPlanHeaderListList(pesPoPlanHeaderList);
        return getDataTable(list);
    }

    /**
     * 生成采购计划
     */
    @PreAuthorize("@ss.hasPermi('plans:poHeader:pr')")
    @Log(title = "生成采购计划", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult pr(@PathVariable Integer ids)
    {
        return toAjax(pesPoPlanHeaderListService.prPesPoPlanHeaderList(ids));
    }
}
