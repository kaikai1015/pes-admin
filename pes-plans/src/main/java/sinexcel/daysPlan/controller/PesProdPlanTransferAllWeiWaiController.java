package sinexcel.daysPlan.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.daysPlan.domain.PesProdPlanTransferAllWW;
import sinexcel.daysPlan.service.IPesProdPlanTransferAllWWService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 生产计划调拨单Controller
 * 
 * @author Zhang Kai
 * @date 2021-07-01
 */
@RestController
@RequestMapping("/daysPlan/weiwaiTransferAll")
public class PesProdPlanTransferAllWeiWaiController extends BaseController
{
    @Autowired
    private IPesProdPlanTransferAllWWService pesProdPlanTransferAllService;

    /**
     * 查询生产计划调拨单列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwaiTransferAll:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesProdPlanTransferAllWW pesProdPlanTransferAll)
    {
        startPage();
        List<PesProdPlanTransferAllWW> list = pesProdPlanTransferAllService.selectPesProdPlanTransferAllList(pesProdPlanTransferAll);
        return getDataTable(list);
    }

    /**
     * 导出生产计划调拨单列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwaiTransferAll:export')")
    @Log(title = "导出委外生产计划调拨单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesProdPlanTransferAllWW pesProdPlanTransferAll)
    {
        List<PesProdPlanTransferAllWW> list = pesProdPlanTransferAllService.selectPesProdPlanTransferAllList(pesProdPlanTransferAll);
        ExcelUtil<PesProdPlanTransferAllWW> util = new ExcelUtil<PesProdPlanTransferAllWW>(PesProdPlanTransferAllWW.class);
        return util.exportExcel(list, "委外生产计划调拨单");
    }

    /**
     * 删除生产计划调拨单
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwaiTransferAll:remove')")
    @Log(title = "委外生产计划调拨单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{planTransferIds}")
    public AjaxResult remove(@PathVariable Long[] planTransferIds)
    {
        return toAjax(pesProdPlanTransferAllService.deletePesProdPlanTransferAllByIds(planTransferIds));
    }
}
