package sinexcel.quartz.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.MesWorkOverMaterialAll;
import sinexcel.quartz.service.IMesWorkOverMaterialAllService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * mes回传工单超耗Controller
 * 
 * @author Zhang Kai
 * @date 2022-04-12
 */
@RestController
@RequestMapping("/quartz/overIssuedMaterials")
public class MesWorkOverMaterialAllController extends BaseController
{
    @Autowired
    private IMesWorkOverMaterialAllService mesWorkOverMaterialAllService;

    /**
     * 查询mes回传工单超耗列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:overIssuedMaterials:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesWorkOverMaterialAll mesWorkOverMaterialAll)
    {
        startPage();
        List<MesWorkOverMaterialAll> list = mesWorkOverMaterialAllService.selectMesWorkOverMaterialAllList(mesWorkOverMaterialAll);
        return getDataTable(list);
    }

    /**
     * 导出mes回传工单超耗列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:overIssuedMaterials:export')")
    @Log(title = "mes回传工单超耗", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MesWorkOverMaterialAll mesWorkOverMaterialAll)
    {
        List<MesWorkOverMaterialAll> list = mesWorkOverMaterialAllService.selectMesWorkOverMaterialAllList(mesWorkOverMaterialAll);
        ExcelUtil<MesWorkOverMaterialAll> util = new ExcelUtil<MesWorkOverMaterialAll>(MesWorkOverMaterialAll.class);
        return util.exportExcel(list, "overIssuedMaterials");
    }

    /**
     * 获取mes回传工单超耗详细信息
     */
    @PreAuthorize("@ss.hasPermi('quartz:overIssuedMaterials:query')")
    @GetMapping(value = "/{materialId}")
    public AjaxResult getInfo(@PathVariable("materialId") Long materialId)
    {
        return AjaxResult.success(mesWorkOverMaterialAllService.selectMesWorkOverMaterialAllById(materialId));
    }
}
