package sinexcel.weeks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.weeks.domain.PesPoInbound;
import sinexcel.weeks.service.IPesPoInboundService;

import java.util.List;

@RestController
@RequestMapping("/weeks/poInbound")
public class PesPoInboundController extends BaseController {

    @Autowired
    private IPesPoInboundService pesPoInboundService;

    /**
     * 查询采购回货计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('weeks:poInbound:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesPoInbound pesPoInbound)
    {
        startPage();
        List<PesPoInbound> list = pesPoInboundService.selectPesPoInboundList(pesPoInbound);
        return getDataTable(list);
    }
}
