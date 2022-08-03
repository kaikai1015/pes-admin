package sinexcel.weeks.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.domain.model.LoginUser;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.ServletUtils;
import sinexcel.framework.web.service.TokenService;
import sinexcel.weeks.domain.PesMonthsSalsePlanLines;
import sinexcel.weeks.service.IPesMonthsSalsePlanLinesService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 月度销售计划行Controller
 * 
 * @author Zhang Kai
 * @date 2021-04-21
 */
@RestController
@RequestMapping("/weeks/monthsSalsel")
public class PesMonthsSalsePlanLinesController extends BaseController
{
    @Autowired
    private IPesMonthsSalsePlanLinesService pesMonthsSalsePlanLinesService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询月度销售计划行列表
     */
    @PreAuthorize("@ss.hasPermi('weeks:monthsSalsel:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesMonthsSalsePlanLines pesMonthsSalsePlanLines)
    {
        List<PesMonthsSalsePlanLines> list = new ArrayList<PesMonthsSalsePlanLines>();
        startPage();
        if("0".equals(pesMonthsSalsePlanLines.getFlag())){
        list = pesMonthsSalsePlanLinesService.selectPesMonthsSalsePlanLinesList(pesMonthsSalsePlanLines);
        }else {
            list = pesMonthsSalsePlanLinesService.selectPesMonthsSalsePlanLinesListAll(pesMonthsSalsePlanLines);
        }
        return getDataTable(list);
    }

    /**
     * 新增月度销售计划行
     */
    @PreAuthorize("@ss.hasPermi('weeks:monthsSalsel:add')")
    @Log(title = "月度销售计划行", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PesMonthsSalsePlanLines pesMonthsSalsePlanLines)
    {
        return toAjax(pesMonthsSalsePlanLinesService.insertPesMonthsSalsePlanLine(pesMonthsSalsePlanLines));
    }

    /**
     * 导出月度销售计划行列表
     */
    @PreAuthorize("@ss.hasPermi('weeks:monthsSalsel:export')")
    @Log(title = "月度销售计划行", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesMonthsSalsePlanLines pesMonthsSalsePlanLines)
    {
        List<PesMonthsSalsePlanLines> list = new ArrayList<PesMonthsSalsePlanLines>();
        if("0".equals(pesMonthsSalsePlanLines.getFlag())){
            list = pesMonthsSalsePlanLinesService.selectPesMonthsSalsePlanLinesList(pesMonthsSalsePlanLines);
        }else {
            list = pesMonthsSalsePlanLinesService.selectPesMonthsSalsePlanLinesListAll(pesMonthsSalsePlanLines);
        }
        ExcelUtil<PesMonthsSalsePlanLines> util = new ExcelUtil<PesMonthsSalsePlanLines>(PesMonthsSalsePlanLines.class);
        return util.exportExcel(list, "月度销售计划行");
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<PesMonthsSalsePlanLines> util = new ExcelUtil<PesMonthsSalsePlanLines>(PesMonthsSalsePlanLines.class);
        return util.importTemplateExcel("月度销售计划导入模板");
    }

    @Log(title = "月度销售计划导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('weeks:monthsSalsel:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file,Long id) throws Exception
    {
        ExcelUtil<PesMonthsSalsePlanLines> util = new ExcelUtil<PesMonthsSalsePlanLines>(PesMonthsSalsePlanLines.class);
        List<PesMonthsSalsePlanLines> weeksLists = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = pesMonthsSalsePlanLinesService.importData(weeksLists,id, operName);
        return AjaxResult.success(message);
    }

    @PreAuthorize("@ss.hasPermi('weeks:monthsSalsel:cal')")
    @Log(title = "计算月度销售计划行", businessType = BusinessType.DELETE)
    @DeleteMapping("/handleGet/{id}")
    public AjaxResult handleGet(@PathVariable Long id)
    {
        return toAjax(pesMonthsSalsePlanLinesService.deletePesMonthsSalsePlanLinesByIds(id));
    }

}
