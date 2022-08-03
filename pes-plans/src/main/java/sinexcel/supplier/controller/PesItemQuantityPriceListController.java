package sinexcel.supplier.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.constant.UserConstants;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.supplier.domain.PesItemQuantityPriceList;
import sinexcel.supplier.service.IPesItemQuantityPriceListService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 分量计价Controller
 * 
 * @author Zhang Kai
 * @date 2020-12-24
 */
@RestController
@RequestMapping("/supplier/basicQuantityForm")
public class PesItemQuantityPriceListController extends BaseController
{
    @Autowired
    private IPesItemQuantityPriceListService pesItemQuantityPriceListService;

    /**
     * 查询分量计价列表
     */
    @PreAuthorize("@ss.hasPermi('supplier:basicQuantityForm:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesItemQuantityPriceList pesItemQuantityPriceList)
    {
        startPage();
        List<PesItemQuantityPriceList> list = pesItemQuantityPriceListService.selectPesItemQuantityPriceListList(pesItemQuantityPriceList);
        return getDataTable(list);
    }

    /**
     * 新增分量计价
     */
    @PreAuthorize("@ss.hasPermi('supplier:basicQuantityForm:add')")
    @Log(title = "分量计价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PesItemQuantityPriceList pesItemQuantityPriceList)
    {
        if (UserConstants.NOT_UNIQUE.equals(pesItemQuantityPriceListService.checkItemQuantityListOAUnique(pesItemQuantityPriceList.getItemPriceId())))
        {
            return AjaxResult.error(pesItemQuantityPriceList.getItemPriceId() +"：报价单已经提交审批，不能添加！");
        }
        if (UserConstants.NOT_UNIQUE.equals(pesItemQuantityPriceListService.checkItemQuantityListUnique(pesItemQuantityPriceList)))
        {
            return AjaxResult.error(pesItemQuantityPriceList.getItemPriceId() + "，"+pesItemQuantityPriceList.getPriceList() + "，"+pesItemQuantityPriceList.getQuantity()+"，已存在");
        }
        pesItemQuantityPriceList.setCreateBy(SecurityUtils.getUsername());
        return toAjax(pesItemQuantityPriceListService.insertPesItemQuantityPriceList(pesItemQuantityPriceList));
    }

    /**
     * 删除分量计价
     */
    @PreAuthorize("@ss.hasPermi('supplier:basicQuantityForm:remove')")
    @Log(title = "分量计价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{quantityPriceId}")
    public AjaxResult remove(@PathVariable Long quantityPriceId)
    {
        if (UserConstants.NOT_UNIQUE.equals(pesItemQuantityPriceListService.checkItemQuantityListDelete(quantityPriceId)))
        {
            return AjaxResult.error("关联报价单已经提交审批，不能删除！");
        }
        return toAjax(pesItemQuantityPriceListService.deletePesItemQuantityPriceListByIds(quantityPriceId));
    }
}
