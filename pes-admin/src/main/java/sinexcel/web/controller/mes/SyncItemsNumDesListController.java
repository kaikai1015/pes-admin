package sinexcel.web.controller.mes;

import java.util.List;

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
import sinexcel.quartz.domain.SyncItemNumsDescLisEO;
import sinexcel.quartz.service.ISyncItemsNumDesListService;

/**
 * 物料编码和描述快码Controller
 * 
 * @author Zhang Kai
 * @date 2020-12-14
 */
@Api(tags = "MES：物料主数据")
@RestController
@RequestMapping("/mes/itemInfor")
public class SyncItemsNumDesListController extends BaseController
{
    @Autowired
    private ISyncItemsNumDesListService syncItemsNumDesListService;

    /**
     * 查询物料编码和描述快码列表
     */
    @ApiOperation("查询物料主数据")
    @GetMapping("/list")
//    @Log(title = "物料主数据同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncItemNumsDescLisEO syncItemsNumDesList)
    {
        startPage();
        List<SyncItemNumsDescLisEO> list = syncItemsNumDesListService.selectSyncItemsNumDesListList(syncItemsNumDesList);
        return getDataTable(list);
    }
}
