package sinexcel.daysPlan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.daysPlan.domain.PesProdProcessing;
import sinexcel.daysPlan.service.IPesProdProcessingService;

import java.util.ArrayList;
import java.util.List;

/**
 * 发料进度Controller
 * 
 * @author Zhang Kai
 * @date 2021-09-08
 */
@RestController
@RequestMapping("/daysPlan/prod")
public class PesProdProcessingController extends BaseController
{
    @Autowired
    private IPesProdProcessingService pesProdProcessingService;

    /**
     * 查询发料进度列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:prod:processing:list')")
    @GetMapping("/processing/list")
    public TableDataInfo list(PesProdProcessing pesProdProcessing)
    {
        List<PesProdProcessing> list = new ArrayList<PesProdProcessing>();
        startPage();
        if("Y".equals(pesProdProcessing.getIsWwFlag())){
            Long authByDept = getWwAuthByDept();
            if (authByDept!=null){
                pesProdProcessing.setProdLineFlag(authByDept.intValue());
            }
            list = pesProdProcessingService.selectPesProdProcessingListWw(pesProdProcessing);
        }else {
            list = pesProdProcessingService.selectPesProdProcessingList(pesProdProcessing);
        }

        return getDataTable(list);
    }
    /**
     * 查询发料进度列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:wwProcess:prodLine')")
    @GetMapping("/wwProcessing/list")
    public TableDataInfo wwList(PesProdProcessing pesProdProcessing)
    {
        startPage();
        Long authByDept = getWwAuthByDept();
        if (authByDept!=null){
            pesProdProcessing.setProdLineFlag(authByDept.intValue());
        }
        List<PesProdProcessing> list = pesProdProcessingService.selectPesProdProcessingList(pesProdProcessing);
        return getDataTable(list);
    }

    /**
     * 导出发料进度列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:prod:processing:export')")
    @Log(title = "发料进度", businessType = BusinessType.EXPORT)
    @GetMapping("/processing/export")
    public AjaxResult export(PesProdProcessing pesProdProcessing)
    {
        List<PesProdProcessing> list = new ArrayList<PesProdProcessing>();
        if("Y".equals(pesProdProcessing.getIsWwFlag())){
            Long authByDept = getWwAuthByDept();
            if (authByDept!=null){
                pesProdProcessing.setProdLineFlag(authByDept.intValue());
            }
            list = pesProdProcessingService.selectPesProdProcessingListWw(pesProdProcessing);
        }else {
            list = pesProdProcessingService.selectPesProdProcessingList(pesProdProcessing);
        }
        ExcelUtil<PesProdProcessing> util = new ExcelUtil<PesProdProcessing>(PesProdProcessing.class);
        return util.exportExcel(list, "发料进度列表");
    }

    /**
     * 获取发料进度详细信息
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:prod:processing:query')")
    @GetMapping(value = "/processing/{organizationId}")
    public AjaxResult getInfo(@PathVariable("organizationId") Long organizationId)
    {
        return AjaxResult.success(pesProdProcessingService.selectPesProdProcessingById(organizationId));
    }

    /**
     * 新增发料进度
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:prod:processing:add')")
    @Log(title = "发料进度", businessType = BusinessType.INSERT)
    @PostMapping(value = "/processing")
    public AjaxResult add(@RequestBody PesProdProcessing pesProdProcessing)
    {
        return toAjax(pesProdProcessingService.insertPesProdProcessing(pesProdProcessing));
    }

    /**
     * 修改发料进度
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:prod:processing:edit')")
    @Log(title = "发料进度", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesProdProcessing pesProdProcessing)
    {
        return toAjax(pesProdProcessingService.updatePesProdProcessing(pesProdProcessing));
    }

    /**
     * 删除发料进度
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:prod:processing:remove')")
    @Log(title = "发料进度", businessType = BusinessType.DELETE)
	@DeleteMapping("/processing/{organizationIds}")
    public AjaxResult remove(@PathVariable Long[] organizationIds)
    {
        return toAjax(pesProdProcessingService.deletePesProdProcessingByIds(organizationIds));
    }
}
