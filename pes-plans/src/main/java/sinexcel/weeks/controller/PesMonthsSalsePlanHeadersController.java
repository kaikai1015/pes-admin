package sinexcel.weeks.controller;

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
import sinexcel.weeks.domain.PesMonthsSalsePlanHeaders;
import sinexcel.weeks.service.IPesMonthsSalsePlanHeadersService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 月度销售计划头Controller
 * 
 * @author Zhang Kai
 * @date 2021-04-21
 */
@RestController
@RequestMapping("/weeks/monthsSalseh")
public class PesMonthsSalsePlanHeadersController extends BaseController
{
    @Autowired
    private IPesMonthsSalsePlanHeadersService pesMonthsSalsePlanHeadersService;

    /**
     * 查询月度销售计划头列表
     */
    @PreAuthorize("@ss.hasPermi('weeks:monthsSalseh:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesMonthsSalsePlanHeaders pesMonthsSalsePlanHeaders)
    {
        startPage();
        List<PesMonthsSalsePlanHeaders> list = pesMonthsSalsePlanHeadersService.selectPesMonthsSalsePlanHeadersList(pesMonthsSalsePlanHeaders);
        return getDataTable(list);
    }

    /**
     * 新增月度销售计划头
     */
    @PreAuthorize("@ss.hasPermi('weeks:monthsSalseh:add')")
    @Log(title = "创建月度销售计划头", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PesMonthsSalsePlanHeaders pesMonthsSalsePlanHeaders)
    {
        return toAjax(pesMonthsSalsePlanHeadersService.insertPesMonthsSalsePlanHeaders(pesMonthsSalsePlanHeaders));
    }

    /**
     * 获取月度销售计划头详细信息
     */
    @PreAuthorize("@ss.hasPermi('weeks:monthsSalseh:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pesMonthsSalsePlanHeadersService.selectPesMonthsSalsePlanHeadersById(id));
    }

    /**
     * 删除月度销售计划头
     */
    @PreAuthorize("@ss.hasPermi('weeks:monthsSalseh:remove')")
    @Log(title = "月度销售计划头", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long ids)
    {
        pesMonthsSalsePlanHeadersService.checkDeleteAllowed(ids);
        return toAjax(pesMonthsSalsePlanHeadersService.deletePesMonthsSalsePlanHeadersByIds(ids));
    }
}
