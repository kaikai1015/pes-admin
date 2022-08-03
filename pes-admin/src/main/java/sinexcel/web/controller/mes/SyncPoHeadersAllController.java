package sinexcel.web.controller.mes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.SyncPoHeadersAllEO;
import sinexcel.quartz.service.ISyncPoHeadersAllService;

import java.util.List;

/**
 * PO头信息Controller
 *
 * @author Zhang Kai
 * @date 2020-12-21
 */
@RestController
@RequestMapping("/mes/poHeader")
public class SyncPoHeadersAllController extends BaseController {
    @Autowired
    private ISyncPoHeadersAllService syncPoHeadersAllService;

    /**
     * 查询PO头信息列表
     */
    @GetMapping("/list")
//    @Log(title = "PO头同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncPoHeadersAllEO syncPoHeadersAll)
    {
        startPage();
        List<SyncPoHeadersAllEO> list = syncPoHeadersAllService.selectSyncPoHeadersAllList(syncPoHeadersAll);
        return getDataTable(list);
    }
}
