package sinexcel.web.controller.mes;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.domain.SyncPerAllPeopleFEO;
import sinexcel.quartz.service.ISyncPerAllPeopleFService;

import java.util.List;

/**
 * 供应商信息Controller
 *
 * @author Zhang Kai
 * @date 2020-12-15
 */
@Api(tags = "MES：人员编码主数据")
@RestController
@RequestMapping("/mes/perAllPeople")
public class SyncPerAllPeopleFController extends BaseController
{
    @Autowired
    private ISyncPerAllPeopleFService syncPerAllPeopleFService;

    /**
     * 人员编码主数据
     */
    @ApiOperation("查询人员编码主数据")
    @GetMapping("/list")
//    @Log(title = "人员编码同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncPerAllPeopleFEO syncPerAllPeopleF)
    {
        startPage();
        List<SyncPerAllPeopleFEO> list = syncPerAllPeopleFService.selectSyncPerAllPeopleFList(syncPerAllPeopleF);
        return getDataTable(list);
    }
}
