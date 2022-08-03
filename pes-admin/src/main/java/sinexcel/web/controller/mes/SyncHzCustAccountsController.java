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
import sinexcel.common.enums.BusinessType;
import sinexcel.quartz.service.ISyncHzCustAccountsService;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.quartz.domain.SyncHzCustAccountsEO;

/**
 * 客户账户Controller
 * 
 * @author Zhang Kai
 * @date 2020-12-15
 */
@Api(tags = "MES：客户主数据")
@RestController
@RequestMapping("/mes/accounts")
public class SyncHzCustAccountsController extends BaseController
{
    @Autowired
    private ISyncHzCustAccountsService syncHzCustAccountsService;

    /**
     * 查询客户账户列表
     */
    @ApiOperation("查询客户主数据")
    @GetMapping("/list")
//    @Log(title = "客户账户同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncHzCustAccountsEO syncHzCustAccounts)
    {
        startPage();
        List<SyncHzCustAccountsEO> list = syncHzCustAccountsService.selectSyncHzCustAccountsList(syncHzCustAccounts);
        return getDataTable(list);
    }
}
