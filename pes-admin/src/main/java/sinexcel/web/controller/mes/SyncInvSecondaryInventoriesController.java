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
import sinexcel.quartz.domain.SyncInvSecondaryInventoriesEO;
import sinexcel.quartz.service.ISyncInvSecondaryInventoriesService;

import java.util.List;

/**
 * 库存库位信息Controller
 *
 * @author Zhang Kai
 * @date 2020-12-15
 */
@Api(tags = "MES：库存库位主数据")
@RestController
@RequestMapping("/mes/inventories")
public class SyncInvSecondaryInventoriesController extends BaseController
{
    @Autowired
    private ISyncInvSecondaryInventoriesService syncInvSecondaryInventoriesService;

    /**
     * 查询库存库位信息列表
     */
    @ApiOperation("查询库存库位主数据")
    @GetMapping("/list")
//    @Log(title = "库存库位同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncInvSecondaryInventoriesEO syncInvSecondaryInventories)
    {
        startPage();
        List<SyncInvSecondaryInventoriesEO> list = syncInvSecondaryInventoriesService.selectSyncInvSecondaryInventoriesList(syncInvSecondaryInventories);
        return getDataTable(list);
    }
}
