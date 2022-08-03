package sinexcel.web.controller.mes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.SyncInvTransactionTypeTlEO;
import sinexcel.quartz.service.SyncInvTransactionTypeTlService;

import java.util.List;

@RestController
@RequestMapping("/mes/InvTransactionType")
public class SyncInvTransactionTypeTlController extends BaseController {

    @Autowired
    private SyncInvTransactionTypeTlService syncInvTransactionTypeTlService;

    /**
     * 查询PO头信息列表
     */
    @GetMapping("/list")
//    @Log(title = "PO头信息同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncInvTransactionTypeTlEO syncInvTransactionTypeTl)
    {
        startPage();
        List<SyncInvTransactionTypeTlEO> list = syncInvTransactionTypeTlService.selectSyncInvTransactionTypeTlList(syncInvTransactionTypeTl);
        return getDataTable(list);
    }
}