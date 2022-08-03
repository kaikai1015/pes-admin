package sinexcel.web.controller.mes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.SyncInvMaterialTxnsEO;
import sinexcel.quartz.service.ISyncInvMaterialTxnsService;

import java.util.List;

/**
 * 库存事务处理明细Controller
 *
 * @author Zhang Kai
 * @date 2020-12-31
 */
@RestController
@RequestMapping("/mes/invTxns")
public class SyncInvMaterialTxnsController extends BaseController {
    @Autowired
    private ISyncInvMaterialTxnsService syncInvMaterialTxnsService;

    /**
     * 查询库存事务处理明细列表
     */
    @GetMapping("/list")
//    @Log(title = "库存事务处理明细同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncInvMaterialTxnsEO syncInvMaterialTxns)
    {
        startPage();
        List<SyncInvMaterialTxnsEO> list = syncInvMaterialTxnsService.selectSyncInvMaterialTxnsList(syncInvMaterialTxns);
        return getDataTable(list);
    }
}
