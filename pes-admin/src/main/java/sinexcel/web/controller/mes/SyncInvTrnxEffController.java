package sinexcel.web.controller.mes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.SyncInvTrnxEffEO;
import sinexcel.quartz.service.SyncInvTrnxEffService;

import java.util.List;

@RestController
@RequestMapping("/mes/invTrxEff")
public class SyncInvTrnxEffController extends BaseController {

    @Autowired
    private SyncInvTrnxEffService syncInvTrnxEffService;

    /**
     * 查询PO头信息列表
     */
    @GetMapping("/list")
//    @Log(title = "库存弹性域同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncInvTrnxEffEO syncInvTrnxEff)
    {
        startPage();
        List<SyncInvTrnxEffEO> list = syncInvTrnxEffService.selectSyncInvTrnxEffList(syncInvTrnxEff);
        return getDataTable(list);
    }
}
