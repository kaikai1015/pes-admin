package sinexcel.web.controller.mes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.SyncDooLinesAllEO;
import sinexcel.quartz.service.ISyncDooLinesAllService;

import java.util.List;

/**
 * 订单行Controller
 *
 * @author Zhang Kai
 * @date 2020-12-22
 */
@RestController
@RequestMapping("/mes/dooLine")
public class SyncDooLinesAllController extends BaseController {

    @Autowired
    private ISyncDooLinesAllService syncDooLinesAllService;

    /**
     * 查询订单行列表
     */
    @GetMapping("/list")
//    @Log(title = "订单行同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncDooLinesAllEO syncDooLinesAll)
    {
        startPage();
        List<SyncDooLinesAllEO> list = syncDooLinesAllService.selectSyncDooLinesAllList(syncDooLinesAll);
        return getDataTable(list);
    }
}
