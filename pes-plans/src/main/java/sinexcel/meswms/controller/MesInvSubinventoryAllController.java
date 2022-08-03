package sinexcel.meswms.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sinexcel.common.annotation.Log;
import sinexcel.common.constant.UserConstants;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.domain.model.LoginUser;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.ServletUtils;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.framework.web.service.TokenService;
import sinexcel.meswms.domain.MesInvSubinventoryAll;
import sinexcel.meswms.service.IMesInvSubinventoryAllService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * mes工单单身指定仓库Controller
 * 
 * @author Zhang Kai
 * @date 2021-03-10
 */
@RestController
@RequestMapping("/meswms/invSubinventoryAll")
public class MesInvSubinventoryAllController extends BaseController
{
    @Autowired
    private IMesInvSubinventoryAllService mesInvSubinventoryAllService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询mes工单单身指定仓库列表
     */
    @PreAuthorize("@ss.hasPermi('meswms:invSubinventoryAll:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesInvSubinventoryAll mesInvSubinventoryAll)
    {
        startPage();
        List<MesInvSubinventoryAll> list = mesInvSubinventoryAllService.selectMesInvSubinventoryAllList(mesInvSubinventoryAll);
        return getDataTable(list);
    }

    /**
     * 获取mes工单单身指定仓库详细信息
     */
    @PreAuthorize("@ss.hasPermi('meswms:invSubinventoryAll:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mesInvSubinventoryAllService.selectMesInvSubinventoryAllById(id));
    }

    /**
     * 新增mes工单单身指定仓库
     */
    @PreAuthorize("@ss.hasPermi('meswms:invSubinventoryAll:add')")
    @Log(title = "mes工单单身指定仓库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesInvSubinventoryAll mesInvSubinventoryAll)
    {
        if (UserConstants.NOT_UNIQUE.equals(mesInvSubinventoryAllService.checkUnique(mesInvSubinventoryAll)))
        {
            return AjaxResult.error("当前组织下的料号："+mesInvSubinventoryAll.getItemNumber() +"，已存在");
        }
        mesInvSubinventoryAll.setCreateBy(SecurityUtils.getUsername());
        return toAjax(mesInvSubinventoryAllService.insertMesInvSubinventoryAll(mesInvSubinventoryAll));
    }

    /**
     * 修改mes工单单身指定仓库
     */
    @PreAuthorize("@ss.hasPermi('meswms:invSubinventoryAll:edit')")
    @Log(title = "mes工单单身指定仓库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesInvSubinventoryAll mesInvSubinventoryAll)
    {
        mesInvSubinventoryAll.setCreateBy(SecurityUtils.getUsername());
        return toAjax(mesInvSubinventoryAllService.updateMesInvSubinventoryAll(mesInvSubinventoryAll));
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<MesInvSubinventoryAll> util = new ExcelUtil<MesInvSubinventoryAll>(MesInvSubinventoryAll.class);
        return util.importTemplateExcel("MES指定仓导入模板");
    }

    @Log(title = "MES指定仓导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('meswms:invSubinventoryAll:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<MesInvSubinventoryAll> util = new ExcelUtil<MesInvSubinventoryAll>(MesInvSubinventoryAll.class);
        List<MesInvSubinventoryAll> mesInvSubinventoryAllLists = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = mesInvSubinventoryAllService.importData(mesInvSubinventoryAllLists, operName);
        return AjaxResult.success(message);
    }
}
