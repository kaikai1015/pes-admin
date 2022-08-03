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
import sinexcel.quartz.domain.SyncHzPartiesEO;
import sinexcel.quartz.service.ISyncHzPartiesService;

import java.util.List;

/**
 * 供应商信息Controller
 *
 * @author Zhang Kai
 * @date 2020-12-15
 */
@Api(tags = "MES：供应商信息主数据")
@RestController
@RequestMapping("/mes/parties")
public class SyncHzPartiesController extends BaseController {

    @Autowired
    private ISyncHzPartiesService syncHzPartiesService;

    /**
     * 查询供应商信息列表
     */
    @ApiOperation("查询供应商信息主数据")
    @GetMapping("/list")
//    @Log(title = "供应商信息同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncHzPartiesEO syncHzParties)
    {
        startPage();
        List<SyncHzPartiesEO> list = syncHzPartiesService.selectSyncHzPartiesList(syncHzParties);
        return getDataTable(list);
    }
}
