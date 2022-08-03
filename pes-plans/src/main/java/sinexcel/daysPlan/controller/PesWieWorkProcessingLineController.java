package sinexcel.daysPlan.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.daysPlan.domain.PesInvMaterialTxns;
import sinexcel.daysPlan.domain.PesWieWorkProcessingLine;
import sinexcel.daysPlan.service.IPesWieWorkProcessingLineService;

/**
 * 工单生产进度明细Controller
 * 
 * @author Zhang Kai
 * @date 2021-11-03
 */
@RestController
@Api
@RequestMapping("/daysPlan/proces/line")
public class PesWieWorkProcessingLineController extends BaseController
{
    @Autowired
    private IPesWieWorkProcessingLineService pesWieWorkProcessingLineService;

    /**
     * 查询工单生产进度明细列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:proces:line:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesWieWorkProcessingLine pesWieWorkProcessingLine)
    {
        startPage();
        List<PesWieWorkProcessingLine> list = pesWieWorkProcessingLineService.selectPesWieWorkProcessingLineList(pesWieWorkProcessingLine);
        return getDataTable(list);
    }

    /**
     * 导出工单生产进度明细列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:proces:line:export')")
    @Log(title = "工单生产进度明细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesWieWorkProcessingLine pesWieWorkProcessingLine)
    {
        List<PesWieWorkProcessingLine> list = pesWieWorkProcessingLineService.selectPesWieWorkProcessingLineList(pesWieWorkProcessingLine);
        ExcelUtil<PesWieWorkProcessingLine> util = new ExcelUtil<PesWieWorkProcessingLine>(PesWieWorkProcessingLine.class);
        return util.exportExcel(list, "line");
    }

    /**
     * 获取工单生产进度明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:proces:line:query')")
    @GetMapping(value = "/{workOrderId}")
    public AjaxResult getInfo(@PathVariable("workOrderId") Long workOrderId)
    {
        return AjaxResult.success(pesWieWorkProcessingLineService.selectPesWieWorkProcessingLineById(workOrderId));
    }

    /**
     * 新增工单生产进度明细
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:proces:line:add')")
    @Log(title = "工单生产进度明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PesWieWorkProcessingLine pesWieWorkProcessingLine)
    {
        return toAjax(pesWieWorkProcessingLineService.insertPesWieWorkProcessingLine(pesWieWorkProcessingLine));
    }

    /**
     * 修改工单生产进度明细
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:proces:line:edit')")
    @Log(title = "工单生产进度明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesWieWorkProcessingLine pesWieWorkProcessingLine)
    {
        return toAjax(pesWieWorkProcessingLineService.updatePesWieWorkProcessingLine(pesWieWorkProcessingLine));
    }

    /**
     * 删除工单生产进度明细
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:proces:line:remove')")
    @Log(title = "工单生产进度明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{workOrderIds}")
    public AjaxResult remove(@PathVariable Long[] workOrderIds)
    {
        return toAjax(pesWieWorkProcessingLineService.deletePesWieWorkProcessingLineByIds(workOrderIds));
    }

    /**
     * 批量新增工单生产进度明细
     */
    @PreAuthorize("@ss.hasPermi('system:txns:addBatch')")
    @Log(title = "批量新增工单生产进度明细", businessType = BusinessType.INSERT)
    @PostMapping("/addBatch")
    @ApiOperation(value = "批量新增工单生产进度明细", tags = "批量新增工单生产进度明细")
    public AjaxResult addBatch(@RequestBody List<PesWieWorkProcessingLine> infoList)
    {
        return pesWieWorkProcessingLineService.insertBatchAndVerify(infoList);
    }
    /**
     * 初始化riders库存事务处理明细key
     */
    @Log(title = "初始化riders工单生产进度明细key", businessType = BusinessType.OTHER)
    @ApiOperation(value = "初始化riders工单生产进度明细key", tags = "初始化riders工单生产进度明细key")
    @GetMapping("intiKey")
    public AjaxResult intiKey()
    {
        return toAjax(pesWieWorkProcessingLineService.intiKey());
    }
}
