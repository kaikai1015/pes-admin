package sinexcel.daysPlan.controller;

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
import sinexcel.common.annotation.RepeatSubmit;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.daysPlan.domain.PesProdLineDaysHeaderAll;
import sinexcel.daysPlan.service.IPesProdLineDaysHeaderAllService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 日计划Controller
 * 
 * @author Zhang Kai
 * @date 2021-06-07
 */
@RestController
@RequestMapping("/daysPlan/headers")
public class PesProdLineDaysHeaderAllController extends BaseController
{
    @Autowired
    private IPesProdLineDaysHeaderAllService pesProdLineDaysHeaderAllService;

    /**
     * 查询日计划列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:headers:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesProdLineDaysHeaderAll pesProdLineDaysHeaderAll)
    {
        startPage();
        List<PesProdLineDaysHeaderAll> list = pesProdLineDaysHeaderAllService.selectPesProdLineDaysHeaderAllList(pesProdLineDaysHeaderAll);
        return getDataTable(list);
    }

    /**
     * 获取日计划详细信息
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:headers:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pesProdLineDaysHeaderAllService.selectPesProdLineDaysHeaderAllById(id));
    }

    /**
     * 新增日计划
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:headers:add')")
    @Log(title = "新增日计划", businessType = BusinessType.INSERT)
    @PostMapping
    @RepeatSubmit
    public AjaxResult add(@RequestBody PesProdLineDaysHeaderAll pesProdLineDaysHeaderAll)
    {
        pesProdLineDaysHeaderAll.setIsWwFlag("N");
        return toAjax(pesProdLineDaysHeaderAllService.insertPesProdLineDaysHeaderAll(pesProdLineDaysHeaderAll));
    }

    /**
     * 删除日计划
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:headers:remove')")
    @Log(title = "删除日计划", businessType = BusinessType.DELETE)
	@DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Long id)
    {
        return toAjax(pesProdLineDaysHeaderAllService.deletePesProdLineDaysHeaderAllById(id));
    }

}
