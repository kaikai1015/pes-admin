package sinexcel.wms.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.wms.domain.CuxWmsWorkKouZhangList;
import sinexcel.wms.service.ICuxWmsWorkKouZhangListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * WMS工单扣账逻辑Controller
 * 
 * @author Zhang Kai
 * @date 2021-09-13
 */
@RestController
@RequestMapping("/wms")
public class CuxWmsWorkKouZhangListController extends BaseController
{
    @Autowired
    private ICuxWmsWorkKouZhangListService cuxWmsWorkKouZhangListService;

    /**
     * 查询WMS工单扣账逻辑列表
     */
    @PreAuthorize("@ss.hasPermi('wms:kouZhang:list')")
    @GetMapping("/kouZhang/list")
    public TableDataInfo list(CuxWmsWorkKouZhangList cuxWmsWorkKouZhangList)
    {
        startPage();
        List<CuxWmsWorkKouZhangList> list = cuxWmsWorkKouZhangListService.selectCuxWmsWorkKouZhangListList(cuxWmsWorkKouZhangList);
        return getDataTable(list);
    }
    /**
     * 查询WMS工单扣账逻辑列表
     */
    @PreAuthorize("@ss.hasPermi('wms:wwKouZhang:list')")
    @GetMapping("/wwKouZhang/list")
    public TableDataInfo listWw(CuxWmsWorkKouZhangList cuxWmsWorkKouZhangList)
    {
        startPage();
        Long authByDept = getWwAuthByDept();
        if (authByDept!=null){
            cuxWmsWorkKouZhangList.setProdLineFlag(authByDept.intValue());
        }
        List<CuxWmsWorkKouZhangList> list = cuxWmsWorkKouZhangListService.selectCuxWmsWorkKouZhangListList(cuxWmsWorkKouZhangList);
        return getDataTable(list);
    }

    /**
     * 导出WMS工单扣账逻辑列表
     */
    @PreAuthorize("@ss.hasPermi('wms:kouZhang:export')")
    @Log(title = "工单扣账逻辑", businessType = BusinessType.EXPORT)
    @GetMapping("/kouZhang/export")
    public AjaxResult export(CuxWmsWorkKouZhangList cuxWmsWorkKouZhangList)
    {
        List<CuxWmsWorkKouZhangList> list = cuxWmsWorkKouZhangListService.selectCuxWmsWorkKouZhangListList(cuxWmsWorkKouZhangList);
        ExcelUtil<CuxWmsWorkKouZhangList> util = new ExcelUtil<CuxWmsWorkKouZhangList>(CuxWmsWorkKouZhangList.class);
        return util.exportExcel(list, "工单扣账逻辑");
    }


    /**
     * 新增WMS工单扣账逻辑
     */
    @PreAuthorize("@ss.hasPermi('wms:kouZhang:add')")
    @Log(title = "新增工单扣账逻辑", businessType = BusinessType.INSERT)
    @PostMapping("/kouZhang")
    public AjaxResult add(@RequestBody CuxWmsWorkKouZhangList cuxWmsWorkKouZhangList)
    {
        return toAjax(cuxWmsWorkKouZhangListService.insertCuxWmsWorkKouZhangList(cuxWmsWorkKouZhangList));
    }

    /**
     * 删除WMS工单扣账逻辑
     */
    @PreAuthorize("@ss.hasPermi('wms:kouZhang:remove')")
    @Log(title = "WMS工单扣账逻辑", businessType = BusinessType.DELETE)
	@DeleteMapping("/kouZhang/{kouZhangIds}")
    public AjaxResult remove(@PathVariable Long[] kouZhangIds)
    {
        return toAjax(cuxWmsWorkKouZhangListService.deleteCuxWmsWorkKouZhangListByIds(kouZhangIds));
    }

    /**
     * 查询WMS工单扣账逻辑列表
     */
    @PreAuthorize("@ss.hasPermi('wms:kouZhang:details')")
    @GetMapping("/kouZhang/getKouZhangDetaislList/list")
    public TableDataInfo getKouZhangDetaislList(CuxWmsWorkKouZhangList cuxWmsWorkKouZhangList)
    {
//        startPage();
        List<CuxWmsWorkKouZhangList> list = cuxWmsWorkKouZhangListService.selectCuxWmsWorkKouZhangDetailsListList(cuxWmsWorkKouZhangList);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('wms:kouZhang:erp')")
    @Log(title = "工单扣账逻辑回写ERP", businessType = BusinessType.DELETE)
    @PostMapping("/kouZhang/erpKouZhang/{kouZhangType}/{isWwFlag}")
    public AjaxResult erpKouZhang(@PathVariable String kouZhangType,@RequestParam("workOrderLineIds") Long[] workOrderLineIds
            ,@PathVariable String isWwFlag)
    {
        return toAjax(cuxWmsWorkKouZhangListService.erpCuxWmsWorkKouZhangListByIds(kouZhangType,workOrderLineIds,isWwFlag));
    }
}
