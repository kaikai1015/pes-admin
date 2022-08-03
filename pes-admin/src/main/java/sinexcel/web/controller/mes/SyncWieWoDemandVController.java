package sinexcel.web.controller.mes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.SyncWieWoDemandVEO;
import sinexcel.quartz.service.ISyncWieWoDemandVService;

import java.util.List;

/**
 * 工单行信息Controller
 *
 * @author Zhang Kai
 * @date 2020-12-17
 */
@RestController
@RequestMapping("/mes/wieMaterial")
public class SyncWieWoDemandVController extends BaseController {

    @Autowired
    private ISyncWieWoDemandVService syncWieWoDemandVService;

    /**
     * 查询工单行信息列表
     */
    @GetMapping("/list")
//    @Log(title = "工单行信息同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncWieWoDemandVEO syncWieWoDemandV)
    {
        startPage();
        List<SyncWieWoDemandVEO> list = syncWieWoDemandVService.selectSyncWieWoDemandVList(syncWieWoDemandV);
        return getDataTable(list);
    }
}
