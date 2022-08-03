package sinexcel.lotNums.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.lotNums.domain.PesWieOrdersHeaderList;
import sinexcel.lotNums.service.IPesWieOrdersHeaderListService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 订单生产计划头Controller
 * 
 * @author Zhang Kai
 * @date 2021-04-25
 */
@RestController
@RequestMapping("/lotNums/ordersMpsH")
public class PesWieOrdersHeaderListController extends BaseController
{
    @Autowired
    private IPesWieOrdersHeaderListService pesWieOrdersHeaderListService;

    /**
     * 查询订单生产计划头列表
     */
    @PreAuthorize("@ss.hasPermi('lotNums:ordersMpsH:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesWieOrdersHeaderList pesWieOrdersHeaderList)
    {
        startPage();
        List<PesWieOrdersHeaderList> list = pesWieOrdersHeaderListService.selectPesWieOrdersHeaderListList(pesWieOrdersHeaderList);
        return getDataTable(list);
    }

    /**
     * 发放生产计划
     */
    @PreAuthorize("@ss.hasPermi('lotNums:ordersMpsH:work')")
    @Log(title = "发放订单生产计划", businessType = BusinessType.DELETE)
    @DeleteMapping("/{planLotNum}")
    public AjaxResult workOrdersHeader(@PathVariable Long planLotNum)
    {
        return toAjax(pesWieOrdersHeaderListService.workOrdersHeader(planLotNum));
    }

}
