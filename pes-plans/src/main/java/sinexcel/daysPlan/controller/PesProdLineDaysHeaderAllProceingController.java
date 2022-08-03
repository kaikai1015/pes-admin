package sinexcel.daysPlan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.daysPlan.domain.PesProdLineDaysHeaderAll;
import sinexcel.daysPlan.service.IPesProdLineDaysHeaderAllService;

import java.util.List;

/**
 * 生产进度Controller
 *
 * @author Zhang Kai
 * @date 2021-06-07
 */
@RestController
@RequestMapping("/daysPlan/processing")
public class PesProdLineDaysHeaderAllProceingController extends BaseController {

    @Autowired
    private IPesProdLineDaysHeaderAllService pesProdLineDaysHeaderAllService;

    /**
     * 生产进度
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:processing:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesProdLineDaysHeaderAll pesProdLineDaysHeaderAll)
    {
        startPage();
        List<PesProdLineDaysHeaderAll> list = pesProdLineDaysHeaderAllService.selectPesProdLineDaysHeaderAllList(pesProdLineDaysHeaderAll);
        return getDataTable(list);
    }
}
