package sinexcel.weeks.controller;

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
import sinexcel.weeks.domain.CuxWieWorkImportDataList;
import sinexcel.weeks.service.ICuxWieWorkImportDataListService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 排程欠料导入数据Controller
 * 
 * @author Zhang Kai
 * @date 2021-11-05
 */
@RestController
    @RequestMapping("/weeks/importData")
public class CuxWieWorkImportDataListController extends BaseController
{
    @Autowired
    private ICuxWieWorkImportDataListService cuxWieWorkImportDataListService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询排程欠料导入数据列表
     */
    @PreAuthorize("@ss.hasPermi('weeks:importData:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxWieWorkImportDataList cuxWieWorkImportDataList)
    {
        startPage();
        List<CuxWieWorkImportDataList> list = cuxWieWorkImportDataListService.selectCuxWieWorkImportDataListList(cuxWieWorkImportDataList);
        return getDataTable(list);
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<CuxWieWorkImportDataList> util = new ExcelUtil<CuxWieWorkImportDataList>(CuxWieWorkImportDataList.class);
        return util.importTemplateExcel("工单排程导入模板");
    }

    @Log(title = "工单排程导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('weeks:importData:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file,Long lotNumber) throws Exception
    {
        ExcelUtil<CuxWieWorkImportDataList> util = new ExcelUtil<CuxWieWorkImportDataList>(CuxWieWorkImportDataList.class);
        List<CuxWieWorkImportDataList> weeksLists = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = cuxWieWorkImportDataListService.importData(weeksLists, operName,lotNumber);
        return AjaxResult.success(message);
    }

}
