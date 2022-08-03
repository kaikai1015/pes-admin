package sinexcel.lotNums.controller;

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
import sinexcel.lotNums.domain.PesPoOrdersLineList;
import sinexcel.lotNums.service.IPesPoOrdersLineListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 订单采购计划行Controller
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
@RestController
@RequestMapping("/lotNums/ordersMrpL")
public class PesPoOrdersLineListController extends BaseController
{
    @Autowired
    private IPesPoOrdersLineListService pesPoOrdersLineListService;

    /**
     * 查询订单采购计划行列表
     */
    @PreAuthorize("@ss.hasPermi('lotNums:ordersMrpL:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesPoOrdersLineList pesPoOrdersLineList)
    {
        startPage();
        List<PesPoOrdersLineList> list = pesPoOrdersLineListService.selectPesPoOrdersLineListList(pesPoOrdersLineList);
        return getDataTable(list);
    }

    /**
     * 导出订单采购计划行列表
     */
    @PreAuthorize("@ss.hasPermi('lotNums:ordersMrpL:export')")
    @Log(title = "订单采购计划行", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesPoOrdersLineList pesPoOrdersLineList)
    {
        List<PesPoOrdersLineList> list = pesPoOrdersLineListService.selectPesPoOrdersLineListList(pesPoOrdersLineList);
        ExcelUtil<PesPoOrdersLineList> util = new ExcelUtil<PesPoOrdersLineList>(PesPoOrdersLineList.class);
        return util.exportExcel(list, "订单采购计划明细");
    }
}
