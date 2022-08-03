package sinexcel.weeks.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.domain.model.LoginUser;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.ServletUtils;
import sinexcel.framework.web.service.TokenService;
import sinexcel.weeks.domain.PesPoItemBackInforDetails;
import sinexcel.weeks.service.IPesPoBackInforHeaderAllService;
import sinexcel.weeks.service.IPesPoItemBackInforDetailsService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 采购回货计划明细Controller
 * 
 * @author Zhang Kai
 * @date 2021-07-26
 */
@RestController
@RequestMapping("/weeks/details")
public class PesPoItemBackInforDetailsController extends BaseController
{
    @Autowired
    private IPesPoItemBackInforDetailsService pesPoItemBackInforDetailsService;

    @Autowired
    private IPesPoBackInforHeaderAllService pesPoBackInforHeaderAllService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询采购回货计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('weeks:details:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesPoItemBackInforDetails pesPoItemBackInforDetails)
    {
        startPage();
        List<PesPoItemBackInforDetails> list = pesPoItemBackInforDetailsService.selectPesPoItemBackInforDetailsList(pesPoItemBackInforDetails);
        return getDataTable(list);
    }

    /**
     * 导出采购回货计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('weeks:details:export')")
    @Log(title = "导出采购回货计划明细列表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesPoItemBackInforDetails pesPoItemBackInforDetails)
    {
        String [] createDate = pesPoBackInforHeaderAllService.selectPesPoBackInforHeaderAllById(pesPoItemBackInforDetails.getHeaderId());
        List<PesPoItemBackInforDetails> list = pesPoItemBackInforDetailsService.selectPesPoItemBackInforDetailsListPOInbound(pesPoItemBackInforDetails);
        ExcelUtil<PesPoItemBackInforDetails> util = new ExcelUtil<PesPoItemBackInforDetails>(PesPoItemBackInforDetails.class);
        return util.exportExcelPo(list, "回货计划明细",createDate);
    }

    /**
     * 获取采购回货计划明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('weeks:details:query')")
    @GetMapping(value = "/{itemBackId}")
    public AjaxResult getInfo(@PathVariable("itemBackId") Long itemBackId)
    {
        return AjaxResult.success(pesPoItemBackInforDetailsService.selectPesPoItemBackInforDetailsById(itemBackId));
    }

    /**
     * 修改采购回货计划明细
     */
    @PreAuthorize("@ss.hasPermi('weeks:details:edit')")
    @Log(title = "修改采购回货计划明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesPoItemBackInforDetails pesPoItemBackInforDetails)
    {
        return toAjax(pesPoItemBackInforDetailsService.updatePesPoItemBackInforDetails(pesPoItemBackInforDetails));
    }

    /**
     * 修改采购回货计划明细
     */
    @PreAuthorize("@ss.hasPermi('weeks:details:editPO')")
    @Log(title = "采购回货计划数量", businessType = BusinessType.UPDATE)
    @PutMapping("/editPO")
    public AjaxResult editPO(@RequestBody PesPoItemBackInforDetails pesPoItemBackInforDetails)
    {
        return toAjax(pesPoItemBackInforDetailsService.updatePesPoItemBackInforDetailsPO(pesPoItemBackInforDetails));
    }

    /**
     * 删除采购回货计划明细
     */
    @PreAuthorize("@ss.hasPermi('weeks:details:remove')")
    @Log(title = "删除采购回货计划明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{itemBackIds}")
    public AjaxResult remove(@PathVariable Long[] itemBackIds)
    {
        return toAjax(pesPoItemBackInforDetailsService.deletePesPoItemBackInforDetailsByIds(itemBackIds));
    }

    @GetMapping("/importTemplate/{headerId}")
    public AjaxResult importTemplate(@PathVariable Long headerId)
    {
        String [] createDate = pesPoBackInforHeaderAllService.selectPesPoBackInforHeaderAllById(headerId);
        ExcelUtil<PesPoItemBackInforDetails> util = new ExcelUtil<PesPoItemBackInforDetails>(PesPoItemBackInforDetails.class);
        return util.importPoTemplateExcel("回货计划明细导入模板",createDate);
    }

    @Log(title = "回货计划明细导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('weeks:details:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, Long headerId) throws Exception
    {
        ExcelUtil<PesPoItemBackInforDetails> util = new ExcelUtil<PesPoItemBackInforDetails>(PesPoItemBackInforDetails.class);
        List<PesPoItemBackInforDetails> lists = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = pesPoItemBackInforDetailsService.importData(lists,headerId, operName);
        return AjaxResult.success(message);
    }
}
