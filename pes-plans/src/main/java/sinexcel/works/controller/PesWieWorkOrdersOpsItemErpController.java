package sinexcel.works.controller;

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
import sinexcel.common.annotation.Log;
import sinexcel.common.annotation.RepeatSubmit;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.works.domain.PesWieWorkOrdersOpsItemErp;
import sinexcel.works.service.IPesWieWorkOrdersOpsItemErpService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 工单外协物料对照Controller
 *
 * @author Zhang Kai
 * @date 2021-12-13
 */
@RestController
@RequestMapping("/works/ospItem")
public class PesWieWorkOrdersOpsItemErpController extends BaseController
{
    @Autowired
    private IPesWieWorkOrdersOpsItemErpService pesWieWorkOrdersOpsItemErpService;

    /**
     * 查询工单外协物料对照列表
     */
    @PreAuthorize("@ss.hasPermi('works:ospItem:list')")
    @GetMapping("/list/{pesWorkOrderId}")
    public TableDataInfo list(@PathVariable("pesWorkOrderId") Long pesWorkOrderId)
    {
        List<PesWieWorkOrdersOpsItemErp> list = pesWieWorkOrdersOpsItemErpService.selectPesWieWorkOrdersOpsItemErpList(pesWorkOrderId);
        return getDataTable(list);
    }

    /**
     * 导出工单外协物料对照列表
     */
    @PreAuthorize("@ss.hasPermi('works:ospItem:export')")
    @Log(title = "工单外协物料对照", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export()
    {
        List<PesWieWorkOrdersOpsItemErp> list = pesWieWorkOrdersOpsItemErpService.selectPesWieWorkOrdersOpsItemErpListExport();
        ExcelUtil<PesWieWorkOrdersOpsItemErp> util = new ExcelUtil<PesWieWorkOrdersOpsItemErp>(PesWieWorkOrdersOpsItemErp.class);
        return util.exportExcel(list, "工单外协物料对照");
    }

    @PreAuthorize("@ss.hasPermi('works:ospItem:add')")
    @Log(title = "费用物料添加", businessType = BusinessType.INSERT)
    @DeleteMapping("/addOspItem/{wieOpsItemId}/{pesWorkOrderId}")
    @RepeatSubmit
    public AjaxResult addOspItem(@PathVariable Long wieOpsItemId,@PathVariable Long pesWorkOrderId)
    {
        return toAjax(pesWieWorkOrdersOpsItemErpService.addPesWieWorkOrdersOpsItemErpById(wieOpsItemId,pesWorkOrderId));
    }

    /**
     * 查询工单外协物料对照列表
     */
    @PreAuthorize("@ss.hasPermi('works:ospItem:list')")
    @GetMapping("/list/getListOspItem")
    public TableDataInfo getListOspItem(PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp)
    {
        startPage();
        List<PesWieWorkOrdersOpsItemErp> list = pesWieWorkOrdersOpsItemErpService.getSelectPesWieWorkOrdersOpsItemErpList(pesWieWorkOrdersOpsItemErp);
        return getDataTable(list);
    }

    /**
     * 获取工单外协物料对照详细信息
     */
    @PreAuthorize("@ss.hasPermi('works:ospItem:query')")
    @GetMapping(value = "/{wieOpsItemId}")
    public AjaxResult getInfo(@PathVariable("wieOpsItemId") Long wieOpsItemId)
    {
        return AjaxResult.success(pesWieWorkOrdersOpsItemErpService.selectPesWieWorkOrdersOpsItemErpById(wieOpsItemId));
    }

    /**
     * 修改工单外协物料对照
     */
    @PreAuthorize("@ss.hasPermi('works:ospItem:edit')")
    @Log(title = "修改工单外协物料对照", businessType = BusinessType.UPDATE)
    @PutMapping
    @RepeatSubmit
    public AjaxResult edit(@RequestBody PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp)
    {
        return toAjax(pesWieWorkOrdersOpsItemErpService.updatePesWieWorkOrdersOpsItemErp(pesWieWorkOrdersOpsItemErp));
    }

    /**
     * 新增工单外协物料对照
     */
    @PreAuthorize("@ss.hasPermi('works:ospItem:add')")
    @Log(title = "新增工单外协物料对照", businessType = BusinessType.INSERT)
    @PostMapping("/addOspItemList")
    @RepeatSubmit
    public AjaxResult addOspItemList(@RequestBody PesWieWorkOrdersOpsItemErp pesWieWorkOrdersOpsItemErp)
    {
        return toAjax(pesWieWorkOrdersOpsItemErpService.insertPesWieWorkOrdersOpsItemErp(pesWieWorkOrdersOpsItemErp));
    }

    /**
     * 删除工单外协物料对照
     */
    @PreAuthorize("@ss.hasPermi('works:ospItem:remove')")
    @Log(title = "删除工单外协物料对照", businessType = BusinessType.DELETE)
    @DeleteMapping("/{wieOpsItemIds}")
    public AjaxResult remove(@PathVariable Long wieOpsItemIds)
    {
        return toAjax(pesWieWorkOrdersOpsItemErpService.deletePesWieWorkOrdersOpsItemErpById(wieOpsItemIds));
    }

}
