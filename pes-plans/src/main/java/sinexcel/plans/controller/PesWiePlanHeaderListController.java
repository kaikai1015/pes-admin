package sinexcel.plans.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.plans.domain.PesWiePlanHeaderList;
import sinexcel.plans.service.IPesWiePlanHeaderListService;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.works.service.IPesWorkPlanHeaderListService;

/**
 * 生产计划头Controller
 * 
 * @author Zhang Kai
 * @date 2020-11-25
 */
@RestController
@RequestMapping("/plans/wieHeader")
public class PesWiePlanHeaderListController extends BaseController
{
    @Autowired
    private IPesWiePlanHeaderListService pesWiePlanHeaderListService;

    @Autowired
    private IPesWorkPlanHeaderListService pesWorkPlanHeaderListService;

    /**
     * 查询生产计划头列表
     */
    @PreAuthorize("@ss.hasPermi('plans:wieHeader:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesWiePlanHeaderList pesWiePlanHeaderList)
    {
        startPage();
        List<PesWiePlanHeaderList> list = pesWiePlanHeaderListService.selectPesWiePlanHeaderListList(pesWiePlanHeaderList);
        return getDataTable(list);
    }

    /**
     * 发放生产计划
     */
    @PreAuthorize("@ss.hasPermi('plans:wieHeader:work')")
    @Log(title = "发放生产计划", businessType = BusinessType.DELETE)
    @DeleteMapping("/{planLotNum}")
    public AjaxResult workWieHeader(@PathVariable Long planLotNum)
    {
        return toAjax(pesWorkPlanHeaderListService.getWorkWieHeader(planLotNum));
    }

}
