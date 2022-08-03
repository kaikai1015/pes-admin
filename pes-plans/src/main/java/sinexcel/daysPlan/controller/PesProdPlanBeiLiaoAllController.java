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
import sinexcel.daysPlan.domain.PesProdPlanBeiLiaoAll;
import sinexcel.daysPlan.service.IPesProdPlanBeiLiaoAllService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.daysPlan.service.IPesProdPlanTransferAllService;

import static sinexcel.utils.CommonStatic.INV_SOURCE_CATEGORY_ISSUE;

/**
 * 生产计划备料单Controller
 * 
 * @author Zhang Kai
 * @date 2021-06-16
 */
@RestController
@RequestMapping("/daysPlan/beiLiao")
public class PesProdPlanBeiLiaoAllController extends BaseController
{
    @Autowired
    private IPesProdPlanBeiLiaoAllService pesProdPlanBeiLiaoAllService;

    @Autowired
    private IPesProdPlanTransferAllService pesProdPlanTransferAllService;

    /**
     * 查询生产计划备料单列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:beiLiao:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesProdPlanBeiLiaoAll pesProdPlanBeiLiaoAll)
    {
        startPage();
        List<PesProdPlanBeiLiaoAll> list = pesProdPlanBeiLiaoAllService.selectPesProdPlanBeiLiaoAllList(pesProdPlanBeiLiaoAll);
        return getDataTable(list);
    }

    /**
     * 导出生产计划备料单列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:beiLiao:export')")
    @Log(title = "生产计划备料单导出", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesProdPlanBeiLiaoAll pesProdPlanBeiLiaoAll)
    {
        List<PesProdPlanBeiLiaoAll> list = pesProdPlanBeiLiaoAllService.selectPesProdPlanBeiLiaoAllList(pesProdPlanBeiLiaoAll);
        ExcelUtil<PesProdPlanBeiLiaoAll> util = new ExcelUtil<PesProdPlanBeiLiaoAll>(PesProdPlanBeiLiaoAll.class);
        return util.exportExcel(list, "生产备料单");
    }

    /**
     * 刷新最新数据
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:beiLiao:remove')")
    @Log(title = "刷新最新数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Long id)
    {
        return toAjax(pesProdPlanBeiLiaoAllService.insertPesProdPlanBeiLiaoAll(id));
    }

    /**
     * 新增生产计划调拨单
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:transferAll:add')")
    @Log(title = "新增生产计划调拨单", businessType = BusinessType.INSERT)
    @DeleteMapping("/transferBeiliao/{id}")
    public AjaxResult transferBeiliao(@PathVariable Long id)
    {
        return toAjax(pesProdPlanTransferAllService.insertPesProdPlanTransferAll(id,INV_SOURCE_CATEGORY_ISSUE));
    }

}
