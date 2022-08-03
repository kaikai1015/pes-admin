package sinexcel.plans.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import sinexcel.plans.domain.PesPlanHeaderList;
import sinexcel.plans.service.IPesPlanHeaderListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 主计划头Controller
 * 
 * @author Zhang Kai
 * @date 2020-11-23
 */
@RestController
@RequestMapping("/plans/pHeader")
public class PesPlanHeaderListController extends BaseController
{
    @Autowired
    private IPesPlanHeaderListService pesPlanHeaderListService;

    /**
     * 查询主计划头列表
     */
    @PreAuthorize("@ss.hasPermi('plans:pHeader:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesPlanHeaderList pesPlanHeaderList)
    {
        startPage();
        List<PesPlanHeaderList> list = pesPlanHeaderListService.selectPesPlanHeaderListList(pesPlanHeaderList);
        return getDataTable(list);
    }

    /**
     * 导出主计划头列表
     */
    @PreAuthorize("@ss.hasPermi('plans:pHeader:export')")
    @Log(title = "主计划头", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesPlanHeaderList pesPlanHeaderList)
    {
        List<PesPlanHeaderList> list = pesPlanHeaderListService.selectPesPlanHeaderListList(pesPlanHeaderList);
        ExcelUtil<PesPlanHeaderList> util = new ExcelUtil<PesPlanHeaderList>(PesPlanHeaderList.class);
        return util.exportExcel(list, "pHeader");
    }

    /**
     * 获取主计划头详细信息
     */
    @PreAuthorize("@ss.hasPermi('plans:pHeader:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(pesPlanHeaderListService.selectPesPlanHeaderListById(id));
    }

    /**
     * 新增主计划头
     */
    @PreAuthorize("@ss.hasPermi('plans:pHeader:add')")
    @Log(title = "主计划头", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PesPlanHeaderList pesPlanHeaderList)
    {
        pesPlanHeaderList.setCreateBy(SecurityUtils.getUsername());
        pesPlanHeaderList.setLastUpdateBy(SecurityUtils.getUsername());
        return toAjax(pesPlanHeaderListService.insertPesPlanHeaderList(pesPlanHeaderList));
    }

    /**
     * 修改主计划头
     */
    @PreAuthorize("@ss.hasPermi('plans:pHeader:edit')")
    @Log(title = "主计划头", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesPlanHeaderList pesPlanHeaderList)
    {
        pesPlanHeaderList.setLastUpdateBy(SecurityUtils.getUsername());
        return toAjax(pesPlanHeaderListService.updatePesPlanHeaderList(pesPlanHeaderList));
    }

    /**
     * 删除主计划头
     */
    @PreAuthorize("@ss.hasPermi('plans:pHeader:remove')")
    @Log(title = "主计划头", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(pesPlanHeaderListService.deletePesPlanHeaderListByIds(ids));
    }
}
