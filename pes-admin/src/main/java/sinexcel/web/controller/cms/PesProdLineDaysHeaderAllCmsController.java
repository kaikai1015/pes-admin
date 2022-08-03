package sinexcel.web.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.daysPlan.domain.PesProdLineDaysHeaderAll;
import sinexcel.daysPlan.service.IPesProdLineDaysHeaderAllService;

import java.util.List;

@RestController
@RequestMapping("/pes/daysPlan/headers")
public class PesProdLineDaysHeaderAllCmsController extends BaseController {

    @Autowired
    private IPesProdLineDaysHeaderAllService pesProdLineDaysHeaderAllService;

    /**
     * 查询日计划列表
     */
    @GetMapping("/list")
    public TableDataInfo list(PesProdLineDaysHeaderAll pesProdLineDaysHeaderAll)
    {
        startPage();
        List<PesProdLineDaysHeaderAll> list = pesProdLineDaysHeaderAllService.selectPesProdLineDaysHeaderAllList(pesProdLineDaysHeaderAll);
        return getDataTable(list);
    }
}