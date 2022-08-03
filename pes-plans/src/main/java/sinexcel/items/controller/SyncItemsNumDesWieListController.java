package sinexcel.items.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.core.controller.BaseController;
import sinexcel.items.domain.SyncItemsNumDesWieList;
import sinexcel.items.service.ISyncItemsNumDesWieListService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 物料编码和描述快码Controller
 *
 * @author Zhang Kai
 * @date 2021-12-21
 */
@RestController
@RequestMapping("/items/itemWie")
public class SyncItemsNumDesWieListController extends BaseController
{
    @Autowired
    private ISyncItemsNumDesWieListService syncItemsNumDesWieListService;

    /**
     * 查询物料编码和描述快码列表
     */
    @PreAuthorize("@ss.hasPermi('items:itemWie:list')")
    @GetMapping("/list")
    public TableDataInfo list(SyncItemsNumDesWieList syncItemsNumDesWieList)
    {
        startPage();
        List<SyncItemsNumDesWieList> list = syncItemsNumDesWieListService.selectSyncItemsNumDesWieListList(syncItemsNumDesWieList);
        return getDataTable(list);
    }
}
