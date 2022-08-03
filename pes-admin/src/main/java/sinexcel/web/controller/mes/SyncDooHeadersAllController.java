package sinexcel.web.controller.mes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.SyncDooHeadersAllEO;
import sinexcel.quartz.service.ISyncDooHeadersAllService;

import java.util.List;

/**
 * 订单头Controller
 *
 * @author Zhang Kai
 * @date 2020-12-22
 */
@RestController
@RequestMapping("/mes/dooHeader")
public class SyncDooHeadersAllController extends BaseController {

    @Autowired
    private ISyncDooHeadersAllService syncDooHeadersAllService;

    /**
     * 查询订单头列表
     */
    @GetMapping("/list")
//    @Log(title = "订单头同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncDooHeadersAllEO syncDooHeadersAll)
    {
        startPage();
        List<SyncDooHeadersAllEO> list = syncDooHeadersAllService.selectSyncDooHeadersAllList(syncDooHeadersAll);
        return getDataTable(list);
    }
}
