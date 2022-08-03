package sinexcel.lotNums.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.core.controller.BaseController;
import sinexcel.lotNums.domain.PesPoOrdersHeaderList;
import sinexcel.lotNums.service.IPesPoOrdersHeaderListService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 订单采购计划头Controller
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
@RestController
@RequestMapping("/lotNums/ordersMrpH")
public class PesPoOrdersHeaderListController extends BaseController
{
    @Autowired
    private IPesPoOrdersHeaderListService pesPoOrdersHeaderListService;

    /**
     * 查询订单采购计划头列表
     */
    @PreAuthorize("@ss.hasPermi('lotNums:ordersMrpH:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesPoOrdersHeaderList pesPoOrdersHeaderList)
    {
        startPage();
        List<PesPoOrdersHeaderList> list = pesPoOrdersHeaderListService.selectPesPoOrdersHeaderListList(pesPoOrdersHeaderList);
        return getDataTable(list);
    }

}
