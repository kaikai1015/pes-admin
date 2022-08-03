package sinexcel.works.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.works.domain.CuxFinWorkMonthsEndHeads;
import sinexcel.works.service.ICuxFinWorkMonthsEndHeadsService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 月结工单操作Controller
 * 
 * @author Zhang Kai
 * @date 2021-05-07
 */
@RestController
@RequestMapping("/works/finEndheads")
public class CuxFinWorkMonthsEndHeadsController extends BaseController
{
    @Autowired
    private ICuxFinWorkMonthsEndHeadsService cuxFinWorkMonthsEndHeadsService;

    /**
     * 查询月结工单操作列表
     */
    @PreAuthorize("@ss.hasPermi('works:finEndheads:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxFinWorkMonthsEndHeads cuxFinWorkMonthsEndHeads)
    {
        startPage();
        List<CuxFinWorkMonthsEndHeads> list = cuxFinWorkMonthsEndHeadsService.selectCuxFinWorkMonthsEndHeadsList(cuxFinWorkMonthsEndHeads);
        return getDataTable(list);
    }

    /**
     * 新增月结工单操作
     */
    @PreAuthorize("@ss.hasPermi('works:finEndheads:add')")
    @Log(title = "月结工单操作", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CuxFinWorkMonthsEndHeads cuxFinWorkMonthsEndHeads)
    {
        cuxFinWorkMonthsEndHeadsService.checkAddAllowed(cuxFinWorkMonthsEndHeads.getLotNum());
        cuxFinWorkMonthsEndHeads.setCreateBy(SecurityUtils.getUsername());
        return toAjax(cuxFinWorkMonthsEndHeadsService.insertCuxFinWorkMonthsEndHeads(cuxFinWorkMonthsEndHeads));
    }


    /**
     * 删除月结工单操作
     */
    @PreAuthorize("@ss.hasPermi('works:finEndheads:remove')")
    @Log(title = "月结工单操作", businessType = BusinessType.DELETE)
	@DeleteMapping("/{lotNums}")
    public AjaxResult remove(@PathVariable Long lotNums)
    {
        cuxFinWorkMonthsEndHeadsService.checkDeletellowed(lotNums);
        return toAjax(cuxFinWorkMonthsEndHeadsService.deleteCuxFinWorkMonthsEndHeadsByIds(lotNums));
    }
}
