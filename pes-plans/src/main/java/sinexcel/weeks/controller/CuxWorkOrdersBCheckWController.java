package sinexcel.weeks.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.framework.web.service.TokenService;
import org.springframework.web.multipart.MultipartFile;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.domain.model.LoginUser;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.ServletUtils;
import sinexcel.weeks.domain.CuxWorkOrdersBCheckW;
import sinexcel.weeks.domain.CuxWorkOrdersQtDetailsQl;
import sinexcel.weeks.service.ICuxWorkOrdersBCheckWService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.weeks.service.ICuxWorkOrdersQtDetailsQlService;

/**
 * 周计划导入Controller
 * 
 * @author Zhang Kai
 * @date 2021-03-11
 */
@RestController
@RequestMapping("/weeks/workImport")
public class CuxWorkOrdersBCheckWController extends BaseController
{
    @Autowired
    private ICuxWorkOrdersBCheckWService cuxWorkOrdersBCheckWService;

    @Autowired
    private ICuxWorkOrdersQtDetailsQlService cuxWorkOrdersQtDetailsQlService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询周计划导入列表
     */
    @PreAuthorize("@ss.hasPermi('weeks:workImport:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxWorkOrdersBCheckW cuxWorkOrdersBCheckW)
    {
        startPage();
        List<CuxWorkOrdersBCheckW> list = cuxWorkOrdersBCheckWService.selectCuxWorkOrdersBCheckWList(cuxWorkOrdersBCheckW);
        return getDataTable(list);
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<CuxWorkOrdersBCheckW> util = new ExcelUtil<CuxWorkOrdersBCheckW>(CuxWorkOrdersBCheckW.class);
        return util.importTemplateExcel("周计划导入模板");
    }

    @Log(title = "周计划导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('weeks:workImport:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<CuxWorkOrdersBCheckW> util = new ExcelUtil<CuxWorkOrdersBCheckW>(CuxWorkOrdersBCheckW.class);
        List<CuxWorkOrdersBCheckW> weeksLists = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = cuxWorkOrdersBCheckWService.importData(weeksLists, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出周计划导入列表
     */
    @PreAuthorize("@ss.hasPermi('weeks:workImport:export')")
    @Log(title = "周计划导入", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxWorkOrdersBCheckW cuxWorkOrdersBCheckW)
    {
        List<CuxWorkOrdersBCheckW> list = cuxWorkOrdersBCheckWService.selectCuxWorkOrdersBCheckWList(cuxWorkOrdersBCheckW);
        ExcelUtil<CuxWorkOrdersBCheckW> util = new ExcelUtil<CuxWorkOrdersBCheckW>(CuxWorkOrdersBCheckW.class);
        return util.exportExcel(list, "周计划信息");
    }

    /**
     * 欠料查询
     */
    @PreAuthorize("@ss.hasPermi('weeks:workImport:remove')")
    @Log(title = "欠料计算", businessType = BusinessType.DELETE)
    @GetMapping("/qianLiao")
    public AjaxResult qtWorkImport(CuxWorkOrdersQtDetailsQl cuxWorkOrdersQtDetailsQl)
    {
        if (StringUtils.isNull(cuxWorkOrdersQtDetailsQl.getLotNum()))
        {
            throw new CustomException("请输入要计算的批次！！！");
        }
        cuxWorkOrdersQtDetailsQl.setCreateBy(SecurityUtils.getUsername());
        return toAjax(cuxWorkOrdersQtDetailsQlService.qtWorkImport(cuxWorkOrdersQtDetailsQl));
    }

}
