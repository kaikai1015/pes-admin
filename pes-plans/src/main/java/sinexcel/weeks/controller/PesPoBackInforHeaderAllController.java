package sinexcel.weeks.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.weeks.domain.PesPoBackInforHeaderAll;
import sinexcel.weeks.service.IPesPoBackInforHeaderAllService;
import sinexcel.common.core.page.TableDataInfo;

/**
 *  采购回货计划Controller
 * 
 * @author Zhang Kai
 * @date 2021-07-26
 */
@RestController
@RequestMapping("/weeks/backInfor")
public class PesPoBackInforHeaderAllController extends BaseController
{
    @Autowired
    private IPesPoBackInforHeaderAllService pesPoBackInforHeaderAllService;

    /**
     * 查询 采购回货计划列表
     */
    @PreAuthorize("@ss.hasPermi('weeks:backInfor:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesPoBackInforHeaderAll pesPoBackInforHeaderAll)
    {
        startPage();
        List<PesPoBackInforHeaderAll> list = pesPoBackInforHeaderAllService.selectPesPoBackInforHeaderAllList(pesPoBackInforHeaderAll);
        return getDataTable(list);
    }

    /**
     * 新增 采购回货计划
     */
    @PreAuthorize("@ss.hasPermi('weeks:backInfor:add')")
    @Log(title = " 新增采购回货计划", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PesPoBackInforHeaderAll pesPoBackInforHeaderAll)
    {
        return toAjax(pesPoBackInforHeaderAllService.insertPesPoBackInforHeaderAll(pesPoBackInforHeaderAll));
    }

    /**
     * 删除 采购回货计划
     */
    @PreAuthorize("@ss.hasPermi('weeks:backInfor:remove')")
    @Log(title = " 删除采购回货计划", businessType = BusinessType.DELETE)
	@DeleteMapping("/{headerIds}")
    public AjaxResult remove(@PathVariable Long headerIds)
    {
        return toAjax(pesPoBackInforHeaderAllService.deletePesPoBackInforHeaderAllById(headerIds));
    }

    /**
     * 获取 采购回货计划详细信息
     */
    @PreAuthorize("@ss.hasPermi('weeks:backInfor:query')")
    @GetMapping(value = "/{headerId}")
    public AjaxResult getInfo(@PathVariable("headerId") Long headerId)
    {
        return AjaxResult.success(pesPoBackInforHeaderAllService.selectPesPoBackInforHeaderAllById(headerId));
    }

    /**
     * 修改 采购回货计划
     */
    @PreAuthorize("@ss.hasPermi('weeks:backInfor:edit')")
    @Log(title = " 失效采购回货计划", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesPoBackInforHeaderAll pesPoBackInforHeaderAll)
    {
        return toAjax(pesPoBackInforHeaderAllService.updatePesPoBackInforHeaderAll(pesPoBackInforHeaderAll));
    }
}
