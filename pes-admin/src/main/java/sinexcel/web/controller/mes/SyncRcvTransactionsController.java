package sinexcel.web.controller.mes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.SyncRcvTransactionsEO;
import sinexcel.quartz.service.ISyncRcvTransactionsService;

import java.util.List;

/**
 * PO交易明细Controller
 *
 * @author Zhang Kai
 * @date 2021-01-05
 */
@RestController
@RequestMapping("/mes/rcvTransactions")
public class SyncRcvTransactionsController extends BaseController {
    @Autowired
    private ISyncRcvTransactionsService syncRcvTransactionsService;

    /**
     * 查询PO交易明细列表
     */
    @GetMapping("/list")
//    @Log(title = "PO入库信息同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncRcvTransactionsEO syncRcvTransactions)
    {
        startPage();
        List<SyncRcvTransactionsEO> list = syncRcvTransactionsService.selectSyncRcvTransactionsList(syncRcvTransactions);
        return getDataTable(list);
    }
}
