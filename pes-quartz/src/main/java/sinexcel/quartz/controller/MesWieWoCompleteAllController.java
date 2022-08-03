package sinexcel.quartz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.quartz.domain.MesWieWoCompleteAllDKEO;
import sinexcel.quartz.service.IMesWieWoCompleteAllService;

import java.util.List;

/**
 * MES工单完工入库回写ERPController
 *
 * @author Zhang Kai
 * @date 2021-07-22
 */
@RestController
@RequestMapping("/quartz/wieWoCompleteAll")
public class MesWieWoCompleteAllController extends BaseController {

    @Autowired
    private IMesWieWoCompleteAllService mesWieWoCompleteAllService;

    /**
     * 查询MES工单完工入库回写ERP列表
     */
    @PreAuthorize("@ss.hasPermi('quartz:wieWoCompleteAll:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesWieWoCompleteAllDKEO mesWieWoCompleteAll)
    {
        startPage();
        List<MesWieWoCompleteAllDKEO> list = mesWieWoCompleteAllService.selectMesWieWoCompleteAllList(mesWieWoCompleteAll);
        return getDataTable(list);
    }
}
