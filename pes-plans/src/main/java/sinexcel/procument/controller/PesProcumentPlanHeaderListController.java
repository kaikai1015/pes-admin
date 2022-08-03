package sinexcel.procument.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.procument.domain.PesProcumentPlanHeaderList;
import sinexcel.procument.service.IPesProcumentPlanHeaderListService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 生成采购计划头信息Controller
 * 
 * @author Zhang Kai
 * @date 2020-12-09
 */
@RestController
@RequestMapping("/procument/mrpHeader")
public class PesProcumentPlanHeaderListController extends BaseController
{
    @Autowired
    private IPesProcumentPlanHeaderListService pesProcumentPlanHeaderListService;

    /**
     * 查询生成采购计划头信息列表
     */
    @PreAuthorize("@ss.hasPermi('procument:mrpHeader:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesProcumentPlanHeaderList pesProcumentPlanHeaderList)
    {
        startPage();
        List<PesProcumentPlanHeaderList> list = pesProcumentPlanHeaderListService.selectPesProcumentPlanHeaderListList(pesProcumentPlanHeaderList);
        return getDataTable(list);
    }

    /**
     * 获取生成采购计划头信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('procument:mrpHeader:query')")
    @GetMapping(value = "/{planLotNum}")
    public AjaxResult getInfo(@PathVariable("planLotNum") Long planLotNum)
    {
        return AjaxResult.success(pesProcumentPlanHeaderListService.selectPesProcumentPlanHeaderListById(planLotNum));
    }
}
