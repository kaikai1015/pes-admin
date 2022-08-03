package sinexcel.web.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.daysPlan.domain.PesProdLineDaysLineAll;
import sinexcel.daysPlan.service.IPesProdLineDaysLineAllService;

import java.util.List;

@RestController
@RequestMapping("/pes/daysPlan/lines")
public class PesProdLineDaysLineAllCmsController extends BaseController {

    @Autowired
    private IPesProdLineDaysLineAllService pesProdLineDaysLineAllService;

    /**
     * 查询产品线日计划明细列表
     */
    @GetMapping("/list")
    public TableDataInfo list(PesProdLineDaysLineAll pesProdLineDaysLineAll)
    {
        startPage();
        List<PesProdLineDaysLineAll> list = pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllList(pesProdLineDaysLineAll);
        return getDataTable(list);
    }
}