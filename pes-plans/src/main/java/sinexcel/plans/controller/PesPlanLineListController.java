package sinexcel.plans.controller;

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
import sinexcel.plans.domain.PesPlanLineList;
import sinexcel.plans.service.IPesPlanLineListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.plans.service.IPlanLineBomService;

/**
 * 主计划行Controller
 * 
 * @author Zhang Kai
 * @date 2020-11-20
 */
@RestController
@RequestMapping("/plans/pLine")
public class PesPlanLineListController extends BaseController
{
    @Autowired
    private IPesPlanLineListService pesPlanLineListService;

    @Autowired
    private IPlanLineBomService planLineBomService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询主计划行列表
     */
    @PreAuthorize("@ss.hasPermi('plans:pLine:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesPlanLineList pesPlanLineList)
    {
        startPage();
        List<PesPlanLineList> list = pesPlanLineListService.selectPesPlanLineListList(pesPlanLineList);
        return getDataTable(list);
    }
    /**
     * MRP计算相依需求
     */
    @PreAuthorize("@ss.hasPermi('plans:pLine:query')")
    @GetMapping(value = "/{planLotNum}")
    public AjaxResult getMrpInfo(@PathVariable("planLotNum") Long planLotNum)
    {
        planLineBomService.checkPlotNumActive(planLotNum);
        //计算之前删除历史相依需求的数据，每次只是保留最新的数据
        planLineBomService.deleteSyncDemandListLists();
        return toAjax(planLineBomService.selectPesPlanLineListById(planLotNum));
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<PesPlanLineList> util = new ExcelUtil<PesPlanLineList>(PesPlanLineList.class);
        return util.importTemplateExcel("主计划明细导入模板");
    }

    @Log(title = "主计划明细导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('plans:pLine:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file,Long planLotNum) throws Exception
    {
        ExcelUtil<PesPlanLineList> util = new ExcelUtil<PesPlanLineList>(PesPlanLineList.class);
        List<PesPlanLineList> plines = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = pesPlanLineListService.importData(plines,planLotNum, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出主计划行列表
     */
    @PreAuthorize("@ss.hasPermi('plans:pLine:export')")
    @Log(title = "主计划行", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesPlanLineList pesPlanLineList)
    {
        List<PesPlanLineList> list = pesPlanLineListService.selectPesPlanLineListList(pesPlanLineList);
        ExcelUtil<PesPlanLineList> util = new ExcelUtil<PesPlanLineList>(PesPlanLineList.class);
        return util.exportExcel(list, "销售备货计划明细");
    }

}
