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
import sinexcel.quartz.domain.SyncPozSuppliersEO;
import sinexcel.quartz.service.ISyncPozSuppliersService;

import java.util.List;

/**
 * 供应商信息Controller
 *
 * @author Zhang Kai
 * @date 2020-12-15
 */
@Api(tags = "MES：供应商主数据")
@RestController
@RequestMapping("/mes/suppliers")
public class SyncPozSuppliersController extends BaseController
{
    @Autowired
    private ISyncPozSuppliersService syncPozSuppliersService;

    /**
     * 查询供应商信息列表
     */
    @ApiOperation("查询供应商主数据")
    @GetMapping("/list")
//    @Log(title = "供应商同步MES", businessType = BusinessType.OTHER)
    public TableDataInfo list(SyncPozSuppliersEO syncPozSuppliers)
    {
        startPage();
        List<SyncPozSuppliersEO> list = syncPozSuppliersService.selectSyncPozSuppliersList(syncPozSuppliers);
        return getDataTable(list);
    }
}
