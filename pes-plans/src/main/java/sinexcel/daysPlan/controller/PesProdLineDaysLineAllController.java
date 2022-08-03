package sinexcel.daysPlan.controller;

import java.text.ParseException;
import java.util.List;
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
import org.springframework.web.multipart.MultipartFile;
import sinexcel.common.annotation.Log;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.domain.model.LoginUser;
import sinexcel.common.enums.BusinessType;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.DateUtils;
import sinexcel.common.utils.ServletUtils;
import sinexcel.daysPlan.domain.PesProdLineDaysLineAll;
import sinexcel.daysPlan.domain.PesProdLineDaysLineAllPrice;
import sinexcel.daysPlan.service.IPesProdLineDaysHeaderAllService;
import sinexcel.daysPlan.service.IPesProdLineDaysLineAllService;
import sinexcel.common.utils.poi.ExcelUtil;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.framework.web.service.TokenService;

/**
 * 产品线日计划明细Controller
 * 
 * @author Zhang Kai
 * @date 2021-06-07
 */
@RestController
@RequestMapping("/daysPlan/lines")
public class PesProdLineDaysLineAllController extends BaseController
{
    @Autowired
    private IPesProdLineDaysLineAllService pesProdLineDaysLineAllService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private IPesProdLineDaysHeaderAllService pesProdLineDaysHeaderAllService;

    /**
     * 查询产品线日计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:lines:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesProdLineDaysLineAll pesProdLineDaysLineAll)
    {
        startPage();
        List<PesProdLineDaysLineAll> list = pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllList(pesProdLineDaysLineAll);
        return getDataTable(list);
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<PesProdLineDaysLineAll> util = new ExcelUtil<PesProdLineDaysLineAll>(PesProdLineDaysLineAll.class);
        return util.importTemplateExcel("生产日计划明细导入模板");
    }

    @Log(title = "日计划明细导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('daysPlan:lines:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, Long id) throws Exception
    {
        if(!DateUtils.isEffectiveDate()){
            throw new CustomException("可操作时间范围：8:00-18:00，请留意！！！");
        }
        if("1".equals(pesProdLineDaysHeaderAllService.selectPesProdLineDaysHeaderAllById(id).getTransferFlag())){
            throw new CustomException("已经产生调拨单，不允许导入！！！");
        }
        ExcelUtil<PesProdLineDaysLineAll> util = new ExcelUtil<PesProdLineDaysLineAll>(PesProdLineDaysLineAll.class);
        List<PesProdLineDaysLineAll> lists = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String isWwFlag = "N";
        String message = pesProdLineDaysLineAllService.importData(lists,id, operName,isWwFlag);
        return AjaxResult.success(message);
    }

    /**
     * 导出产品线日计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:lines:export')")
    @Log(title = "导出产品线日计划明细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesProdLineDaysLineAll pesProdLineDaysLineAll)
    {
        List<PesProdLineDaysLineAll> list = pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllList(pesProdLineDaysLineAll);
        ExcelUtil<PesProdLineDaysLineAll> util = new ExcelUtil<PesProdLineDaysLineAll>(PesProdLineDaysLineAll.class);
        return util.exportExcel(list, "明细");
    }

    /**
     * 获取产品线日计划明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:lines:query')")
    @GetMapping(value = "/{lineId}")
    public AjaxResult getInfo(@PathVariable("lineId") Long lineId)
    {
        return AjaxResult.success(pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllById(lineId));
    }

    /**
     * 新增产品线日计划明细
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:lines:add')")
    @Log(title = "创建产品线日计划明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PesProdLineDaysLineAll pesProdLineDaysLineAll) throws ParseException {
        if(!DateUtils.isEffectiveDate()){
            throw new CustomException("可操作时间范围：8:00-18:00，请留意！！！");
        }
        if("1".equals(pesProdLineDaysHeaderAllService.selectPesProdLineDaysHeaderAllById(pesProdLineDaysLineAll.getId()).getTransferFlag())){
            throw new CustomException("已经产生调拨单，不允许新增！！！");
        }
        return toAjax(pesProdLineDaysLineAllService.insertPesProdLineDaysLineAll(pesProdLineDaysLineAll));
    }

    /**
     * 修改产品线日计划明细
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:lines:edit')")
    @Log(title = "修改产品线日计划明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesProdLineDaysLineAll pesProdLineDaysLineAll) throws ParseException {
        if(!DateUtils.isEffectiveDate()){
            throw new CustomException("可操作时间范围：8:00-18:00，请留意！！！");
        }
        if("1".equals(pesProdLineDaysHeaderAllService.selectPesProdLineDaysHeaderAllById(pesProdLineDaysLineAll.getId()).getTransferFlag())){
            throw new CustomException("已经产生调拨单，不允许修改！！！");
        }
        return toAjax(pesProdLineDaysLineAllService.updatePesProdLineDaysLineAll(pesProdLineDaysLineAll));
    }

    /**
     * 删除产品线日计划明细
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:lines:remove')")
    @Log(title = "删除产品线日计划明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{lineIds}")
    public AjaxResult remove(@PathVariable Long lineIds) throws ParseException {
        if(!DateUtils.isEffectiveDate()){
            throw new CustomException("可操作时间范围：8:00-18:00，请留意！！！");
        }
        if("1".equals(pesProdLineDaysHeaderAllService.selectPesProdLineDaysHeaderAllById(pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllById(lineIds).getId()).getTransferFlag())){
            throw new CustomException("已经产生调拨单，不允许删除！！！");
        }
        return toAjax(pesProdLineDaysLineAllService.deletePesProdLineDaysLineAllByIds(lineIds));
    }

    @PreAuthorize("@ss.hasPermi('daysPlan:lines:other')")
    @Log(title = "发布日生产计划", businessType = BusinessType.DELETE)
    @DeleteMapping("/daysProdLines/{id}")
    public AjaxResult daysProdLines(@PathVariable Long id) throws ParseException {
        if(!DateUtils.isEffectiveDate()){
            throw new CustomException("可操作时间范围：8:00-18:00，请留意！！！");
        }
        return toAjax(pesProdLineDaysLineAllService.updatedaysProdLines(id));
    }


    /**
     * 查询产品线日计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:lines:list')")
    @GetMapping("/priceList")
    public TableDataInfo priceList(PesProdLineDaysLineAllPrice pesProdLineDaysLineAll)
    {
        startPage();
        List<PesProdLineDaysLineAllPrice> list = pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllListPrice(pesProdLineDaysLineAll);
        return getDataTable(list);
    }

    /**
     * 导出产品线日计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:lines:export')")
    @Log(title = "导出产品线日计划明细", businessType = BusinessType.EXPORT)
    @GetMapping("/priceExport")
    public AjaxResult priceExport(PesProdLineDaysLineAllPrice pesProdLineDaysLineAll)
    {
        List<PesProdLineDaysLineAllPrice> list = pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllListPrice(pesProdLineDaysLineAll);
        ExcelUtil<PesProdLineDaysLineAllPrice> util = new ExcelUtil<PesProdLineDaysLineAllPrice>(PesProdLineDaysLineAllPrice.class);
        return util.exportExcel(list, "明细");
    }

}
