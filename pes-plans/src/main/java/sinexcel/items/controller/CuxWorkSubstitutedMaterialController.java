package sinexcel.items.controller;

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
import org.springframework.web.multipart.MultipartFile;
import sinexcel.common.annotation.Log;
import sinexcel.common.annotation.RepeatSubmit;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.domain.model.LoginUser;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.ServletUtils;
import sinexcel.framework.web.service.TokenService;
import sinexcel.items.domain.CuxWorkSubstitutedMaterial;
import sinexcel.items.service.ICuxWorkSubstitutedMaterialService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 物料替代信息Controller
 * 
 * @author Zhang Kai
 * @date 2021-05-14
 */
@RestController
@RequestMapping("/items/substituted")
public class CuxWorkSubstitutedMaterialController extends BaseController
{
    @Autowired
    private ICuxWorkSubstitutedMaterialService cuxWorkSubstitutedMaterialService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询物料替代信息列表
     */
    @PreAuthorize("@ss.hasPermi('items:substituted:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxWorkSubstitutedMaterial cuxWorkSubstitutedMaterial)
    {
        startPage();
        List<CuxWorkSubstitutedMaterial> list = cuxWorkSubstitutedMaterialService.selectCuxWorkSubstitutedMaterialList(cuxWorkSubstitutedMaterial);
        return getDataTable(list);
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<CuxWorkSubstitutedMaterial> util = new ExcelUtil<CuxWorkSubstitutedMaterial>(CuxWorkSubstitutedMaterial.class);
        return util.importTemplateExcel("物料替代信息导入模板");
    }

    @Log(title = "物料替代信息导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('weeks:workImport:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<CuxWorkSubstitutedMaterial> util = new ExcelUtil<CuxWorkSubstitutedMaterial>(CuxWorkSubstitutedMaterial.class);
        List<CuxWorkSubstitutedMaterial> substitutes = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = cuxWorkSubstitutedMaterialService.importData(substitutes, operName);
        return AjaxResult.success(message);
    }

    /**
     * 新增物料替代信息
     */
    @PreAuthorize("@ss.hasPermi('items:substituted:add')")
    @Log(title = "物料替代信息", businessType = BusinessType.INSERT)
    @PostMapping
    @RepeatSubmit
    public AjaxResult add(@RequestBody CuxWorkSubstitutedMaterial cuxWorkSubstitutedMaterial)
    {
        //判断添加的替代关系是否唯一
        cuxWorkSubstitutedMaterialService.checkAddAllowed(cuxWorkSubstitutedMaterial);
        cuxWorkSubstitutedMaterial.setCreateBy(SecurityUtils.getUsername());
        return toAjax(cuxWorkSubstitutedMaterialService.insertCuxWorkSubstitutedMaterial(cuxWorkSubstitutedMaterial));
    }

//    /**
//     * 新增物料替代信息
//     */
////    @PreAuthorize("@ss.hasPermi('items:substituted:addBatch')")
//    @Log(title = "批量物料替代信息", businessType = BusinessType.INSERT)
//    @PostMapping("addBatch")
//    @RepeatSubmit
//    public AjaxResult addBatch(@RequestBody List<CuxWorkSubstitutedMaterial> infoList)
//    {
//        return cuxWorkSubstitutedMaterialService.inserBatchtCuxWorkSubstitutedMaterial(infoList);
//    }

    /**
     * 删除物料替代信息
     */
    @PreAuthorize("@ss.hasPermi('items:substituted:remove')")
    @Log(title = "物料替代信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{workSubIds}")
    public AjaxResult remove(@PathVariable Long[] workSubIds)
    {
        return toAjax(cuxWorkSubstitutedMaterialService.deleteCuxWorkSubstitutedMaterialByIds(workSubIds));
    }

    /**
     * 导出替代料维护关系列表
     */
    @PreAuthorize("@ss.hasPermi('items:substituted:export')")
    @Log(title = "导出替代料维护关系", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CuxWorkSubstitutedMaterial cuxWorkSubstitutedMaterial)
    {
        List<CuxWorkSubstitutedMaterial> list = cuxWorkSubstitutedMaterialService.selectCuxWorkSubstitutedMaterialList(cuxWorkSubstitutedMaterial);
        ExcelUtil<CuxWorkSubstitutedMaterial> util = new ExcelUtil<CuxWorkSubstitutedMaterial>(CuxWorkSubstitutedMaterial.class);
        return util.exportExcel(list, "替代料维护关系");
    }
}
