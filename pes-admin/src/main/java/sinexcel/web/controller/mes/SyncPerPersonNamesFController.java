package sinexcel.web.controller.mes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.SyncPerPersonNamesFEO;
import sinexcel.quartz.service.ISyncPerPersonNamesFService;

import java.util.List;

/**
 * 人员姓名Controller
 *
 * @author Zhang Kai
 * @date 2020-12-17
 */
@RestController
@RequestMapping("/mes/perPersonNames")
public class SyncPerPersonNamesFController extends BaseController {
    @Autowired
    private ISyncPerPersonNamesFService syncPerPersonNamesFService;

    /**
     * 查询人员姓名列表
     */
    @GetMapping("/list")
//    @Log(title = "人员姓名同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncPerPersonNamesFEO syncPerPersonNamesF)
    {
        startPage();
        List<SyncPerPersonNamesFEO> list = syncPerPersonNamesFService.selectSyncPerPersonNamesFList(syncPerPersonNamesF);
        return getDataTable(list);
    }
}
