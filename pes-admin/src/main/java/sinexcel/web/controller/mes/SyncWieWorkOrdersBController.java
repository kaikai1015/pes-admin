package sinexcel.web.controller.mes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.SyncWieWorkOrdersBEO;
import sinexcel.quartz.service.ISyncWieWorkOrdersBService;

import java.util.List;

/**
 * 工单信息数据Controller
 *
 * @author Zhang Kai
 * @date 2020-12-17
 */
@RestController
@RequestMapping("/mes/wieWork")
public class SyncWieWorkOrdersBController extends BaseController {

    @Autowired
    private ISyncWieWorkOrdersBService syncWieWorkOrdersBService;

    /**
     * 查询工单信息数据列表
     */
    @GetMapping("/list")
//    @Log(title = "工单信息同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncWieWorkOrdersBEO syncWieWorkOrdersB)
    {
        startPage();
        List<SyncWieWorkOrdersBEO> list = syncWieWorkOrdersBService.selectSyncWieWorkOrdersBList(syncWieWorkOrdersB);
        return getDataTable(list);
    }
}
