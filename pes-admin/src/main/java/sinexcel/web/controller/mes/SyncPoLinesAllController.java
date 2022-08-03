package sinexcel.web.controller.mes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.SyncPoLinesAllEO;
import sinexcel.quartz.service.ISyncPoLinesAllService;

import java.util.List;

/**
 * PO行信息Controller
 *
 * @author Zhang Kai
 * @date 2020-12-21
 */
@RestController
@RequestMapping("/mes/poLine")
public class SyncPoLinesAllController extends BaseController {
    @Autowired
    private ISyncPoLinesAllService syncPoLinesAllService;

    /**
     * 查询PO行信息列表
     */
    @GetMapping("/list")
//    @Log(title = "PO行同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncPoLinesAllEO syncPoLinesAll)
    {
        startPage();
        List<SyncPoLinesAllEO> list = syncPoLinesAllService.selectSyncPoLinesAllList(syncPoLinesAll);
        return getDataTable(list);
    }
}
