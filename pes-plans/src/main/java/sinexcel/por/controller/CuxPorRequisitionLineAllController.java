package sinexcel.por.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.por.domain.CuxPorRequisitionLineAll;
import sinexcel.por.service.ICuxPorRequisitionLineAllService;
import sinexcel.common.core.page.TableDataInfo;

/**
 * 管理请购行信息Controller
 * 
 * @author Zhang Kai
 * @date 2021-01-15
 */
@RestController
@RequestMapping("/por/requisitionLine")
public class CuxPorRequisitionLineAllController extends BaseController
{
    @Autowired
    private ICuxPorRequisitionLineAllService cuxPorRequisitionLineAllService;

    /**
     * 查询管理请购行信息列表
     */
    @PreAuthorize("@ss.hasPermi('por:requisitionLine:list')")
    @GetMapping("/list")
    public TableDataInfo list(CuxPorRequisitionLineAll cuxPorRequisitionLineAll)
    {
        startPage();
        List<CuxPorRequisitionLineAll> list = cuxPorRequisitionLineAllService.selectCuxPorRequisitionLineAllList(cuxPorRequisitionLineAll);
        return getDataTable(list);
    }


    /**
     * 删除管理请购行信息
     */
    @PreAuthorize("@ss.hasPermi('por:requisitionLine:remove')")
    @Log(title = "管理请购行信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{requisitioningLineIds}")
    public AjaxResult remove(@PathVariable Long[] requisitioningLineIds)
    {
        return toAjax(cuxPorRequisitionLineAllService.deleteCuxPorRequisitionLineAllByIds(requisitioningLineIds));
    }
}
