package sinexcel.items.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.items.domain.CuxWieProdLineList;
import sinexcel.items.service.ICuxWieProdLineListService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 生产线管理Controller
 * 
 * @author Zhang Kai
 * @date 2021-05-18
 */
@RestController
@RequestMapping("/items/wieProdLine")
public class CuxWieProdLineListController extends BaseController
{
    @Autowired
    private ICuxWieProdLineListService cuxWieProdLineListService;

    /**
     * 查询生产线管理列表
     */
    @PreAuthorize("@ss.hasPermi('items:wieProdLine:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxWieProdLineList cuxWieProdLineList)
    {
        startPage();
        List<CuxWieProdLineList> list = cuxWieProdLineListService.selectCuxWieProdLineListList(cuxWieProdLineList);
        return getDataTable(list);
    }
    /**
     * 新增生产线管理
     */
    @PreAuthorize("@ss.hasPermi('items:wieProdLine:add')")
    @Log(title = "生产线管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CuxWieProdLineList cuxWieProdLineList)
    {
        cuxWieProdLineList.setCreateBy(SecurityUtils.getUsername());
        return toAjax(cuxWieProdLineListService.insertCuxWieProdLineList(cuxWieProdLineList));
    }
}
