package sinexcel.works.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.domain.model.LoginUser;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.ServletUtils;
import sinexcel.framework.web.service.TokenService;
import sinexcel.works.domain.CuxFinWorkMonthsEndList;
import sinexcel.works.service.ICuxFinWorkMonthsEndListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 月结工单批量操行Controller
 * 
 * @author Zhang Kai
 * @date 2021-05-07
 */
@RestController
@RequestMapping("/works/finEndLine")
public class CuxFinWorkMonthsEndListController extends BaseController
{
    @Autowired
    private ICuxFinWorkMonthsEndListService cuxFinWorkMonthsEndListService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询月结工单批量操行列表
     */
    @PreAuthorize("@ss.hasPermi('works:finEndLine:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxFinWorkMonthsEndList cuxFinWorkMonthsEndList)
    {
        startPage();
        List<CuxFinWorkMonthsEndList> list = cuxFinWorkMonthsEndListService.selectCuxFinWorkMonthsEndListList(cuxFinWorkMonthsEndList);
        return getDataTable(list);
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<CuxFinWorkMonthsEndList> util = new ExcelUtil<CuxFinWorkMonthsEndList>(CuxFinWorkMonthsEndList.class);
        return util.importTemplateExcel("月结工单明细导入模板");
    }

    @Log(title = "月结工单明细导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('works:finEndLine:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, Long lotNum) throws Exception
    {
        ExcelUtil<CuxFinWorkMonthsEndList> util = new ExcelUtil<CuxFinWorkMonthsEndList>(CuxFinWorkMonthsEndList.class);
        List<CuxFinWorkMonthsEndList> lineLists = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = cuxFinWorkMonthsEndListService.importData(lineLists,lotNum, operName);
        return AjaxResult.success(message);
    }

    @PreAuthorize("@ss.hasPermi('works:finEndLine:import')")
    @Log(title = "月结工单批量提交ERP", businessType = BusinessType.ERP)
    @DeleteMapping("/getHandleWieErp/{lotNum}")
    public AjaxResult getHandleWieErp(@PathVariable Long lotNum)
    {
        return toAjax(cuxFinWorkMonthsEndListService.getHandleWieErp(lotNum));
    }
}
