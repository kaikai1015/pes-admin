package sinexcel.items.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.items.service.IPesItemBomFanChaService;
import sinexcel.items.domain.PesItemBomFanChaEO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items/fanCha")
public class PesItemBomFanChaController extends BaseController {

    @Autowired
    private IPesItemBomFanChaService pesItemBomFanChaService;

    @PreAuthorize("@ss.hasPermi('items:fanCha:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesItemBomFanChaEO pesItemBomFanChaEO)
    {
        List<PesItemBomFanChaEO> list = new ArrayList<PesItemBomFanChaEO>();
        startPage();
        if("Y".equals(pesItemBomFanChaEO.getIsWieFlag())){
            list = pesItemBomFanChaService.selectPesItemBomFanChaEOListAll(pesItemBomFanChaEO);
        }else {
            list = pesItemBomFanChaService.selectPesItemBomFanChaEOList(pesItemBomFanChaEO);
        }
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('items:fanCha:export')")
    @Log(title = "导出BOM反查", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesItemBomFanChaEO pesItemBomFanChaEO)
    {
        List<PesItemBomFanChaEO> list = new ArrayList<PesItemBomFanChaEO>();
        if("Y".equals(pesItemBomFanChaEO.getIsWieFlag())){
            list = pesItemBomFanChaService.selectPesItemBomFanChaEOListAll(pesItemBomFanChaEO);
        }else {
            list = pesItemBomFanChaService.selectPesItemBomFanChaEOList(pesItemBomFanChaEO);
        }
        ExcelUtil<PesItemBomFanChaEO> util = new ExcelUtil<PesItemBomFanChaEO>(PesItemBomFanChaEO.class);
        return util.exportExcel(list, "导出BOM反查");
    }
}
