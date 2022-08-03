package sinexcel.items.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.constant.UserConstants;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.items.domain.CuxItemBomCho;
import sinexcel.items.service.ICuxItemBomChoService;

/**
 * BOM选配物料结构Controller
 * 
 * @author Zhang Kai
 * @date 2020-12-27
 */
@RestController
@RequestMapping("/items/cho")
public class CuxItemBomChoController extends BaseController
{
    @Autowired
    private ICuxItemBomChoService cuxItemBomChoService;

    /**
     * 查询BOM选配物料结构列表
     */
    @PreAuthorize("@ss.hasPermi('items:cho:list')")
    @GetMapping("/list")
    public AjaxResult list(CuxItemBomCho cuxItemBomCho)
    {
        List<CuxItemBomCho> list = cuxItemBomChoService.selectCuxItemBomChoList(cuxItemBomCho);
        return AjaxResult.success(list);
    }

    /**
     * 获取BOM选配物料结构详细信息
     */
    @PreAuthorize("@ss.hasPermi('items:cho:query')")
    @GetMapping(value = "/{choId}")
    public AjaxResult getInfo(@PathVariable("choId") Long choId)
    {
        return AjaxResult.success(cuxItemBomChoService.selectCuxItemBomChoById(choId));
    }

    /**
     * 修改BOM选配物料结构
     */
    @PreAuthorize("@ss.hasPermi('items:cho:edit')")
    @Log(title = "修改BOM选配物料结构", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CuxItemBomCho cuxItemBomCho)
    {
        return toAjax(cuxItemBomChoService.updateCuxItemBomCho(cuxItemBomCho));
    }

    /**
     * 删除BOM选配物料结构
     */
    @PreAuthorize("@ss.hasPermi('items:cho:remove')")
    @Log(title = "删除BOM选配物料结构", businessType = BusinessType.DELETE)
	@DeleteMapping("/{choIds}")
    public AjaxResult remove(@PathVariable Long choIds)
    {
        return toAjax(cuxItemBomChoService.deleteCuxItemBomChoByIds(choIds));
    }

    /**
     * 查询BOM选配物料结构列表
     */
    @PreAuthorize("@ss.hasPermi('items:cho:query')")
    @Log(title = "BOM展开", businessType = BusinessType.BOM)
    @GetMapping("/bom")
    public AjaxResult bom(CuxItemBomCho cuxItemBomCho)
    {
        return toAjax(cuxItemBomChoService.getValue(cuxItemBomCho));
    }

    /**
     * 添加OM选配组件物料
     */
    @PreAuthorize("@ss.hasPermi('items:cho:add')")
    @Log(title = "添加OM选配组件物料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CuxItemBomCho cuxItemBomCho)
    {
        if (UserConstants.NOT_UNIQUE.equals(cuxItemBomChoService.checkSubItemNumberUnique(cuxItemBomCho)))
        {
            return AjaxResult.error("添加组件：" + cuxItemBomCho.getItemNumber() + "'失败，组件编码已存在");
        }
        return toAjax(cuxItemBomChoService.insertCuxSubItemBomCho(cuxItemBomCho));
    }

    /**
     * 提交ERP按钮操作
     */
    @PreAuthorize("@ss.hasPermi('items:cho:query')")
    @Log(title = "提交ERP操作", businessType = BusinessType.ERP)
    @GetMapping("/erp")
    public AjaxResult erp(CuxItemBomCho cuxItemBomCho)
    {
        return toAjax(cuxItemBomChoService.submitErp(cuxItemBomCho));
    }
}
