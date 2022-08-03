package sinexcel.quartz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.CuxMaterialTransactionsPesEO;
import sinexcel.quartz.service.ICuxMaterialTransactionsPesService;
import sinexcel.common.annotation.Log;

import java.util.List;

/**
 * 工单发料Controller
 *
 * @author Zhang Kai
 * @date 2021-03-12
 */
@RestController
@RequestMapping("/quartz/wieMaterialPes")
public class CuxMaterialTransactionsPesController extends BaseController {

    @Autowired
    private ICuxMaterialTransactionsPesService cuxMaterialTransactionsPesService;

    /**
     * 查询工单发料列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:wieMaterialPes:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxMaterialTransactionsPesEO cuxMaterialTransactionsPes)
    {
        startPage();
        List<CuxMaterialTransactionsPesEO> list = cuxMaterialTransactionsPesService.selectCuxMaterialTransactionsPesList(cuxMaterialTransactionsPes);
        return getDataTable(list);
    }

    /**
     * 获取工单发料详细信息
     */
    @PreAuthorize("@ss.hasPermi('quartz:wieMaterialPes:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(cuxMaterialTransactionsPesService.selectCuxMaterialTransactionsByPesId(id));
    }

    /**
     * 修改工单发料
     */
    @PreAuthorize("@ss.hasPermi('quartz:wieMaterialPes:edit')")
    @Log(title = "修改工单发料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CuxMaterialTransactionsPesEO cuxMaterialTransactionsPes)
    {
        return toAjax(cuxMaterialTransactionsPesService.updateCuxMaterialTransactionsPes(cuxMaterialTransactionsPes));
    }

    /**
     * 提交工单发料
     */
    @PreAuthorize("@ss.hasPermi('quartz:wieMaterialPes:erp')")
    @Log(title = "倒扣回写ERP", businessType = BusinessType.ERP)
    @GetMapping("/erp")
    public AjaxResult submitWieToErp(CuxMaterialTransactionsPesEO cuxMaterialTransactionsPes) throws Exception
    {
        return toAjax(cuxMaterialTransactionsPesService.selectSubmitWieToErp(cuxMaterialTransactionsPes));
    }
}
