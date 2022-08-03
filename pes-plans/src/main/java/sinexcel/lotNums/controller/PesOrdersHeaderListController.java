package sinexcel.lotNums.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.core.controller.BaseController;
import sinexcel.lotNums.domain.PesOrdersHeaderList;
import sinexcel.lotNums.service.IPesOrdersHeaderListService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 订单批次计划Controller
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
@RestController
@RequestMapping("/lotNums/ordersHeader")
public class PesOrdersHeaderListController extends BaseController
{
    @Autowired
    private IPesOrdersHeaderListService pesOrdersHeaderListService;

    /**
     * 查询订单批次计划列表
     */
    @PreAuthorize("@ss.hasPermi('lotNums:ordersHeader:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesOrdersHeaderList pesOrdersHeaderList)
    {
        startPage();
        List<PesOrdersHeaderList> list = pesOrdersHeaderListService.selectPesOrdersHeaderListList(pesOrdersHeaderList);
        return getDataTable(list);
    }
}
