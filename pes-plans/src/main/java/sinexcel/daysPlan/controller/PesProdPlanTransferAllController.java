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
import sinexcel.daysPlan.domain.PesProdPlanTransferAll;
import sinexcel.daysPlan.service.IPesProdPlanTransferAllService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 生产计划调拨单Controller
 * 
 * @author Zhang Kai
 * @date 2021-07-01
 */
@RestController
@RequestMapping("/daysPlan/transferAll")
public class PesProdPlanTransferAllController extends BaseController
{
    @Autowired
    private IPesProdPlanTransferAllService pesProdPlanTransferAllService;

    /**
     * 查询生产计划调拨单列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:transferAll:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesProdPlanTransferAll pesProdPlanTransferAll)
    {
        startPage();
        List<PesProdPlanTransferAll> list = pesProdPlanTransferAllService.selectPesProdPlanTransferAllList(pesProdPlanTransferAll);
        return getDataTable(list);
    }

    /**
     * 导出生产计划调拨单列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:transferAll:export')")
    @Log(title = "导出生产计划调拨单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesProdPlanTransferAll pesProdPlanTransferAll)
    {
        List<PesProdPlanTransferAll> list = pesProdPlanTransferAllService.selectPesProdPlanTransferAllList(pesProdPlanTransferAll);
        ExcelUtil<PesProdPlanTransferAll> util = new ExcelUtil<PesProdPlanTransferAll>(PesProdPlanTransferAll.class);
        return util.exportExcel(list, "transferAll");
    }

    /**
     * 删除生产计划调拨单
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:transferAll:remove')")
    @Log(title = "生产计划调拨单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{planTransferIds}")
    public AjaxResult remove(@PathVariable Long[] planTransferIds)
    {
        return toAjax(pesProdPlanTransferAllService.deletePesProdPlanTransferAllByIds(planTransferIds));
    }
}
