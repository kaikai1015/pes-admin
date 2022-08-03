package sinexcel.quartz.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.MesWieWoCompleteLinesAll;
import sinexcel.quartz.service.IMesWieWoCompleteLinesAllService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 工单单身扣料明细Controller
 * 
 * @author Zhang Kai
 * @date 2021-08-26
 */
@RestController
@RequestMapping("/quartz/MesWieWoCompleteLinesAll")
public class MesWieWoCompleteLinesAllController extends BaseController
{
    @Autowired
    private IMesWieWoCompleteLinesAllService mesWieWoCompleteLinesAllService;

    /**
     * 查询工单单身扣料明细列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:MesWieWoCompleteLinesAll:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesWieWoCompleteLinesAll mesWieWoCompleteLinesAll)
    {
        startPage();
        List<MesWieWoCompleteLinesAll> list = mesWieWoCompleteLinesAllService.selectMesWieWoCompleteLinesAllList(mesWieWoCompleteLinesAll);
        return getDataTable(list);
    }

    /**
     * 导出工单单身扣料明细列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:MesWieWoCompleteLinesAll:export')")
    @Log(title = "导出工单单身扣料明细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MesWieWoCompleteLinesAll mesWieWoCompleteLinesAll)
    {
        List<MesWieWoCompleteLinesAll> list = mesWieWoCompleteLinesAllService.selectMesWieWoCompleteLinesAllList(mesWieWoCompleteLinesAll);
        ExcelUtil<MesWieWoCompleteLinesAll> util = new ExcelUtil<MesWieWoCompleteLinesAll>(MesWieWoCompleteLinesAll.class);
        return util.exportExcel(list, "工单单身扣料明细");
    }

}
