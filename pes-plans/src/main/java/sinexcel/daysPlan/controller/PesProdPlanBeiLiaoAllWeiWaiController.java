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
import sinexcel.daysPlan.domain.PesProdPlanBeiLiaoAllWW;
import sinexcel.daysPlan.service.IPesProdPlanBeiLiaoAllWWService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.daysPlan.service.IPesProdPlanTransferAllService;
import sinexcel.daysPlan.service.IPesProdPlanTransferAllWWService;

import static sinexcel.utils.CommonStatic.INV_SOURCE_CATEGORY_ISSUE;
import static sinexcel.utils.CommonStatic.INV_SOURCE_CATEGORY_OUTSIDE;

/**
 * 生产计划备料单Controller
 * 
 * @author Zhang Kai
 * @date 2021-06-16
 */
@RestController
@RequestMapping("/daysPlan/weiwaibeiLiao")
public class PesProdPlanBeiLiaoAllWeiWaiController extends BaseController
{
    @Autowired
    private IPesProdPlanBeiLiaoAllWWService pesProdPlanBeiLiaoAllService;

    @Autowired
    private IPesProdPlanTransferAllService pesProdPlanTransferAllService;

    /**
     * 查询生产计划备料单列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwaibeiLiao:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesProdPlanBeiLiaoAllWW pesProdPlanBeiLiaoAll)
    {
        startPage();
        List<PesProdPlanBeiLiaoAllWW> list = pesProdPlanBeiLiaoAllService.selectPesProdPlanBeiLiaoAllList(pesProdPlanBeiLiaoAll);
        return getDataTable(list);
    }

    /**
     * 导出生产计划备料单列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwaibeiLiao:export')")
    @Log(title = "委外生产计划备料单导出", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesProdPlanBeiLiaoAllWW pesProdPlanBeiLiaoAll)
    {
        List<PesProdPlanBeiLiaoAllWW> list = pesProdPlanBeiLiaoAllService.selectPesProdPlanBeiLiaoAllList(pesProdPlanBeiLiaoAll);
        ExcelUtil<PesProdPlanBeiLiaoAllWW> util = new ExcelUtil<PesProdPlanBeiLiaoAllWW>(PesProdPlanBeiLiaoAllWW.class);
        return util.exportExcel(list, "委外生产备料单");
    }

    /**
     * 刷新最新数据
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwaibeiLiao:remove')")
    @Log(title = "刷新委外最新数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Long id)
    {
        return toAjax(pesProdPlanBeiLiaoAllService.insertPesProdPlanBeiLiaoAll(id));
    }

    /**
     * 新增生产计划调拨单
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwaiTransferAll:add')")
    @Log(title = "新增委外生产计划调拨单", businessType = BusinessType.INSERT)
    @DeleteMapping("/transferBeiliao/{id}")
    public AjaxResult transferBeiliao(@PathVariable Long id)
    {
        return toAjax(pesProdPlanTransferAllService.insertPesProdPlanTransferAll(id,INV_SOURCE_CATEGORY_OUTSIDE));
    }

}
