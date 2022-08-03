package sinexcel.weeks.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.weeks.domain.CuxWieWorkQianliaoHeader;
import sinexcel.weeks.service.ICuxWieWorkQianliaoHeaderService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 排程欠料头信息Controller
 * 
 * @author Zhang Kai
 * @date 2021-11-05
 */
@RestController
@RequestMapping("/weeks/header")
public class CuxWieWorkQianliaoHeaderController extends BaseController
{
    @Autowired
    private ICuxWieWorkQianliaoHeaderService cuxWieWorkQianliaoHeaderService;

    /**
     * 查询排程欠料头信息列表
     */
    @PreAuthorize("@ss.hasPermi('weeks:header:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxWieWorkQianliaoHeader cuxWieWorkQianliaoHeader)
    {
        startPage();
        List<CuxWieWorkQianliaoHeader> list = cuxWieWorkQianliaoHeaderService.selectCuxWieWorkQianliaoHeaderList(cuxWieWorkQianliaoHeader);
        return getDataTable(list);
    }


    /**
     * 新增排程欠料头信息
     */
    @PreAuthorize("@ss.hasPermi('weeks:header:add')")
    @Log(title = "排程欠料头信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CuxWieWorkQianliaoHeader cuxWieWorkQianliaoHeader)
    {
        return toAjax(cuxWieWorkQianliaoHeaderService.insertCuxWieWorkQianliaoHeader(cuxWieWorkQianliaoHeader));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('weeks:header:srm')")
    @Log(title = "发放回货计划至SRM", businessType = BusinessType.DELETE)
    @DeleteMapping("/srm/{lotNumber}")
    public AjaxResult remove(@PathVariable Long lotNumber)
    {
        return toAjax(cuxWieWorkQianliaoHeaderService.deleteCuxWieWorkQianliaoHeaderById(lotNumber));
    }

}
