package sinexcel.items.controller;

import java.util.ArrayList;
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
import sinexcel.items.domain.PesInvOnhandQuantityNew;
import sinexcel.items.domain.PesInvOnhandQuantityNewPrice;
import sinexcel.items.service.IPesInvOnhandQuantityNewService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * ERP库存现有量Controller
 * 
 * @author Zhang Kai
 * @date 2021-06-28
 */
@RestController
@RequestMapping("/items/onhand")
public class PesInvOnhandQuantityNewController extends BaseController
{
    @Autowired
    private IPesInvOnhandQuantityNewService pesInvOnhandQuantityNewService;

    /**
     * 查询ERP库存现有量列表
     */
    @PreAuthorize("@ss.hasPermi('items:onhand:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesInvOnhandQuantityNew syncInvOnhandQuantityNew)
    {
        List<PesInvOnhandQuantityNew> list = new ArrayList<PesInvOnhandQuantityNew>();
        startPage();
        if("Y".equals(syncInvOnhandQuantityNew.getIsWieFlag())){
            list = pesInvOnhandQuantityNewService.selectSyncInvOnhandQuantityNewSubCodeList(syncInvOnhandQuantityNew);
        }else {
            list = pesInvOnhandQuantityNewService.selectSyncInvOnhandQuantityNewList(syncInvOnhandQuantityNew);
        }
        return getDataTable(list);
    }

    /**
     * 导出ERP库存现有量列表
     */
    @PreAuthorize("@ss.hasPermi('items:onhand:export')")
    @Log(title = "ERP库存现有量", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesInvOnhandQuantityNew pesInvOnhandQuantityNew)
    {

        List<PesInvOnhandQuantityNew> list = new ArrayList<PesInvOnhandQuantityNew>();
        if("Y".equals(pesInvOnhandQuantityNew.getIsWieFlag())){
            list = pesInvOnhandQuantityNewService.selectSyncInvOnhandQuantityNewSubCodeList(pesInvOnhandQuantityNew);
        }else {
            list = pesInvOnhandQuantityNewService.selectSyncInvOnhandQuantityNewList(pesInvOnhandQuantityNew);
        }
        ExcelUtil<PesInvOnhandQuantityNew> util = new ExcelUtil<PesInvOnhandQuantityNew>(PesInvOnhandQuantityNew.class);
        return util.exportExcel(list, "库存现有量汇总");
    }

    @PreAuthorize("@ss.hasPermi('items:onhand:query')")
    @GetMapping("/getOnhandList/list")
    public TableDataInfo getOnhandList(PesInvOnhandQuantityNew syncInvOnhandQuantityNew)
    {
        List<PesInvOnhandQuantityNew> list = pesInvOnhandQuantityNewService.getOnhandList(syncInvOnhandQuantityNew);
        return getDataTable(list);
    }


    /**
     * 查询ERP库存现有量列表
     */
    @PreAuthorize("@ss.hasPermi('items:onhand:list')")
    @GetMapping("/listPrice")
    public TableDataInfo listPrice(PesInvOnhandQuantityNewPrice syncInvOnhandQuantityNew)
    {
        List<PesInvOnhandQuantityNewPrice> list = new ArrayList<PesInvOnhandQuantityNewPrice>();
        startPage();
        if("Y".equals(syncInvOnhandQuantityNew.getIsWieFlag())){
            list = pesInvOnhandQuantityNewService.selectSyncInvOnhandQuantityNewSubCodeListPrice(syncInvOnhandQuantityNew);
        }else {
            list = pesInvOnhandQuantityNewService.selectSyncInvOnhandQuantityNewListPrice(syncInvOnhandQuantityNew);
        }
        return getDataTable(list);
    }

    /**
     * 导出ERP库存现有量列表
     */
    @PreAuthorize("@ss.hasPermi('items:onhand:export')")
    @Log(title = "ERP库存现有量", businessType = BusinessType.EXPORT)
    @GetMapping("/exportPrice")
    public AjaxResult exportPrice(PesInvOnhandQuantityNewPrice pesInvOnhandQuantityNew)
    {

        List<PesInvOnhandQuantityNewPrice> list = new ArrayList<PesInvOnhandQuantityNewPrice>();
        if("Y".equals(pesInvOnhandQuantityNew.getIsWieFlag())){
            list = pesInvOnhandQuantityNewService.selectSyncInvOnhandQuantityNewSubCodeListPrice(pesInvOnhandQuantityNew);
        }else {
            list = pesInvOnhandQuantityNewService.selectSyncInvOnhandQuantityNewListPrice(pesInvOnhandQuantityNew);
        }
        ExcelUtil<PesInvOnhandQuantityNewPrice> util = new ExcelUtil<PesInvOnhandQuantityNewPrice>(PesInvOnhandQuantityNewPrice.class);
        return util.exportExcel(list, "库存现有量汇总");
    }

}
