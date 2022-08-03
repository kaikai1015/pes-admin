package sinexcel.works.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.works.domain.PesWieWorkSubmitErpInforList;
import sinexcel.works.service.IPesWieWorkSubmitErpInforListService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * PES自定义工单回传ERP日志Controller
 * 
 * @author Zhang Kai
 * @date 2021-11-29
 */
@RestController
@RequestMapping("/works/submitErpInfor")
public class PesWieWorkSubmitErpInforListController extends BaseController
{
    @Autowired
    private IPesWieWorkSubmitErpInforListService pesWieWorkSubmitErpInforListService;

    /**
     * 查询PES自定义工单回传ERP日志列表
     */
    @PreAuthorize("@ss.hasPermi('works:submitErpInfor:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesWieWorkSubmitErpInforList pesWieWorkSubmitErpInforList)
    {
        startPage();
        List<PesWieWorkSubmitErpInforList> list = pesWieWorkSubmitErpInforListService.selectPesWieWorkSubmitErpInforListList(pesWieWorkSubmitErpInforList);
        return getDataTable(list);
    }

    /**
     * 删除pes自定义工单单身数据
     */
    @PreAuthorize("@ss.hasPermi('works:submitErpInfor:remove')")
    @Log(title = "工单回传异常数据清除", businessType = BusinessType.DELETE)
    @DeleteMapping("/delSubmitErpInfor")
    public AjaxResult remove()
    {
        return toAjax(pesWieWorkSubmitErpInforListService.deleteSelectPesWieWorkSubmitErpInforListList());
    }
}
