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
import sinexcel.lotNums.domain.PesWieOrdersLineList;
import sinexcel.lotNums.service.IPesWieOrdersLineListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 订单生产计划Controller
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
@RestController
@RequestMapping("/lotNums/ordersMps")
public class PesWieOrdersLineListController extends BaseController
{
    @Autowired
    private IPesWieOrdersLineListService pesWieOrdersLineListService;

    /**
     * 查询订单生产计划列表
     */
    @PreAuthorize("@ss.hasPermi('lotNums:ordersMps:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesWieOrdersLineList pesWieOrdersLineList)
    {
        startPage();
        List<PesWieOrdersLineList> list = pesWieOrdersLineListService.selectPesWieOrdersLineListList(pesWieOrdersLineList);
        return getDataTable(list);
    }

    /**
     * 导出订单生产计划列表
     */
    @PreAuthorize("@ss.hasPermi('lotNums:ordersMps:export')")
    @Log(title = "订单生产计划", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesWieOrdersLineList pesWieOrdersLineList)
    {
        List<PesWieOrdersLineList> list = pesWieOrdersLineListService.selectPesWieOrdersLineListList(pesWieOrdersLineList);
        ExcelUtil<PesWieOrdersLineList> util = new ExcelUtil<PesWieOrdersLineList>(PesWieOrdersLineList.class);
        return util.exportExcel(list, "订单生产计划明细");
    }

}
