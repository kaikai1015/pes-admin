package sinexcel.items.controller;

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
import org.springframework.web.multipart.MultipartFile;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.domain.model.LoginUser;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.ServletUtils;
import sinexcel.framework.web.service.TokenService;
import sinexcel.items.domain.PesItemTechniquesCodeAll;
import sinexcel.items.service.IPesItemTechniquesCodeAllService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 编码工艺属性Controller
 * 
 * @author Zhang Kai
 * @date 2021-06-24
 */
@RestController
@RequestMapping("/items/techniquesCode")
public class PesItemTechniquesCodeAllController extends BaseController
{
    @Autowired
    private IPesItemTechniquesCodeAllService pesItemTechniquesCodeAllService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询编码工艺属性列表
     */
    @PreAuthorize("@ss.hasPermi('items:techniquesCode:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesItemTechniquesCodeAll pesItemTechniquesCodeAll)
    {
        startPage();
        List<PesItemTechniquesCodeAll> list = pesItemTechniquesCodeAllService.selectPesItemTechniquesCodeAllList(pesItemTechniquesCodeAll);
        return getDataTable(list);
    }

    /**
     * 导出编码工艺属性列表
     */
    @PreAuthorize("@ss.hasPermi('items:techniquesCode:export')")
    @Log(title = "导出编码工艺属性", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesItemTechniquesCodeAll pesItemTechniquesCodeAll)
    {
        List<PesItemTechniquesCodeAll> list = pesItemTechniquesCodeAllService.selectPesItemTechniquesCodeAllList(pesItemTechniquesCodeAll);
        ExcelUtil<PesItemTechniquesCodeAll> util = new ExcelUtil<PesItemTechniquesCodeAll>(PesItemTechniquesCodeAll.class);
        return util.exportExcel(list, "编码工艺属性");
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<PesItemTechniquesCodeAll> util = new ExcelUtil<PesItemTechniquesCodeAll>(PesItemTechniquesCodeAll.class);
        return util.importTemplateExcel("编码工艺属性导入模板");
    }

    @Log(title = "编码工艺属性导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('items:techniquesCode:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<PesItemTechniquesCodeAll> util = new ExcelUtil<PesItemTechniquesCodeAll>(PesItemTechniquesCodeAll.class);
        List<PesItemTechniquesCodeAll> lists = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = pesItemTechniquesCodeAllService.importData(lists,operName);
        return AjaxResult.success(message);
    }

    /**
     * 获取编码工艺属性详细信息
     */
    @PreAuthorize("@ss.hasPermi('items:techniquesCode:query')")
    @GetMapping(value = "/{techniquesCodeId}")
    public AjaxResult getInfo(@PathVariable("techniquesCodeId") Long techniquesCodeId)
    {
        return AjaxResult.success(pesItemTechniquesCodeAllService.selectPesItemTechniquesCodeAllById(techniquesCodeId));
    }

    /**
     * 新增编码工艺属性
     */
    @PreAuthorize("@ss.hasPermi('items:techniquesCode:add')")
    @Log(title = "新增编码工艺属性", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PesItemTechniquesCodeAll pesItemTechniquesCodeAll)
    {
        return toAjax(pesItemTechniquesCodeAllService.insertPesItemTechniquesCodeAll(pesItemTechniquesCodeAll));
    }

    /**
     * 修改编码工艺属性
     */
    @PreAuthorize("@ss.hasPermi('items:techniquesCode:edit')")
    @Log(title = "修改编码工艺属性", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesItemTechniquesCodeAll pesItemTechniquesCodeAll)
    {
        return toAjax(pesItemTechniquesCodeAllService.updatePesItemTechniquesCodeAll(pesItemTechniquesCodeAll));
    }

    /**
     * 删除编码工艺属性
     */
    @PreAuthorize("@ss.hasPermi('items:techniquesCode:remove')")
    @Log(title = "删除编码工艺属性", businessType = BusinessType.DELETE)
	@DeleteMapping("/{techniquesCodeIds}")
    public AjaxResult remove(@PathVariable Long[] techniquesCodeIds)
    {
        return toAjax(pesItemTechniquesCodeAllService.deletePesItemTechniquesCodeAllByIds(techniquesCodeIds));
    }
}
