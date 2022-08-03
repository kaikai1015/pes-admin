package sinexcel.works.controller;

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
import sinexcel.works.domain.PesWorkPlanLineList;
import sinexcel.works.service.IPesWorkPlanLineListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 生产计划池行信息Controller
 * 
 * @author Zhang Kai
 * @date 2021-04-16
 */
@RestController
@RequestMapping("/works/worksLines")
public class PesWorkPlanLineListController extends BaseController
{
    @Autowired
    private IPesWorkPlanLineListService pesWorkPlanLineListService;

    /**
     * 查询生产计划池行信息列表
     */
    @PreAuthorize("@ss.hasPermi('works:worksLines:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesWorkPlanLineList pesWorkPlanLineList)
    {
        startPage();
        List<PesWorkPlanLineList> list = pesWorkPlanLineListService.selectPesWorkPlanLineListList(pesWorkPlanLineList);
        return getDataTable(list);
    }

    /**
     * 导出生产计划池行信息列表
     */
    @PreAuthorize("@ss.hasPermi('works:worksLines:export')")
    @Log(title = "生产计划池行信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesWorkPlanLineList pesWorkPlanLineList)
    {
        List<PesWorkPlanLineList> list = pesWorkPlanLineListService.selectPesWorkPlanLineListList(pesWorkPlanLineList);
        ExcelUtil<PesWorkPlanLineList> util = new ExcelUtil<PesWorkPlanLineList>(PesWorkPlanLineList.class);
        return util.exportExcel(list, "worksLines");
    }

    /**
     * 生产计划池行信息
     */
    @PreAuthorize("@ss.hasPermi('works:worksLines:remove')")
    @Log(title = "工单计划", businessType = BusinessType.DELETE)
	@DeleteMapping("/{lineNums}")
    public AjaxResult wieWorksLines(@PathVariable Long[] lineNums)
    {
        return toAjax(pesWorkPlanLineListService.wieWorkPlanLineListByIds(lineNums));
    }


    /**
     * 失效生产计划池行信息
     */
    @PreAuthorize("@ss.hasPermi('works:worksLines:remove')")
    @Log(title = "失效生产计划池数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/deleteWorksLines/{lineNums}")
    public AjaxResult deleteWorksLines(@PathVariable Long[] lineNums)
    {
        return toAjax(pesWorkPlanLineListService.deleteWorksLines(lineNums));
    }
}
