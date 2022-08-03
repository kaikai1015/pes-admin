package sinexcel.works.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.core.controller.BaseController;
import sinexcel.works.domain.PesWorkPlanHeaderList;
import sinexcel.works.service.IPesWorkPlanHeaderListService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 生产计划池Controller
 * 
 * @author Zhang Kai
 * @date 2021-04-16
 */
@RestController
@RequestMapping("/works/worksHeader")
public class PesWorkPlanHeaderListController extends BaseController
{
    @Autowired
    private IPesWorkPlanHeaderListService pesWorkPlanHeaderListService;

    /**
     * 查询生产计划池列表
     */
    @PreAuthorize("@ss.hasPermi('works:worksHeader:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesWorkPlanHeaderList pesWorkPlanHeaderList)
    {
        startPage();
        List<PesWorkPlanHeaderList> list = pesWorkPlanHeaderListService.selectPesWorkPlanHeaderListList(pesWorkPlanHeaderList);
        return getDataTable(list);
    }
}
