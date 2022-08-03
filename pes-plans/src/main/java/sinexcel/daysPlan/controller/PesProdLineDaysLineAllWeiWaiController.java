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
import sinexcel.daysPlan.domain.PesProdLineDaysLineAllWW;
import sinexcel.daysPlan.domain.PesProdLineDaysLineAllWWPrice;
import sinexcel.daysPlan.service.IPesProdLineDaysHeaderAllWWService;
import sinexcel.daysPlan.service.IPesProdLineDaysLineAllWWService;
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
@RequestMapping("/daysPlan/weiwail")
public class PesProdLineDaysLineAllWeiWaiController extends BaseController
{
    @Autowired
    private IPesProdLineDaysLineAllWWService pesProdLineDaysLineAllService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private IPesProdLineDaysHeaderAllWWService pesProdLineDaysHeaderAllService;

    /**
     * 查询产品线日计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwail:list')")
    @GetMapping("/list")
    public TableDataInfo list(PesProdLineDaysLineAllWW pesProdLineDaysLineAll)
    {
        startPage();
        Long authByDept = getWwAuthByDept();
        if (authByDept!=null){
            pesProdLineDaysLineAll.setProdLineFlag(authByDept.intValue());
        }
        List<PesProdLineDaysLineAllWW> list = pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllList(pesProdLineDaysLineAll);
        return getDataTable(list);
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<PesProdLineDaysLineAllWW> util = new ExcelUtil<PesProdLineDaysLineAllWW>(PesProdLineDaysLineAllWW.class);
        return util.importTemplateExcel("委外生产日计划明细导入模板");
    }

    @Log(title = "委外日计划明细导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwail:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, Long id) throws Exception
    {
        if(!DateUtils.isEffectiveDate()){
            throw new CustomException("可操作时间范围：8:00-18:00，请留意！！！");
        }
        if("1".equals(pesProdLineDaysHeaderAllService.selectPesProdLineDaysHeaderAllById(id).getTransferFlag())){
            throw new CustomException("委外日计划已经产生调拨单，不允许导入！！！");
        }
        ExcelUtil<PesProdLineDaysLineAllWW> util = new ExcelUtil<PesProdLineDaysLineAllWW>(PesProdLineDaysLineAllWW.class);
        List<PesProdLineDaysLineAllWW> lists = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String isWwFlag = "Y";
        String message = pesProdLineDaysLineAllService.importData(lists,id, operName,isWwFlag);
        return AjaxResult.success(message);
    }

    /**
     * 导出产品线日计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwail:export')")
    @Log(title = "导出产品线委外日计划明细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PesProdLineDaysLineAllWW pesProdLineDaysLineAll)
    {
        List<PesProdLineDaysLineAllWW> list = pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllList(pesProdLineDaysLineAll);
        ExcelUtil<PesProdLineDaysLineAllWW> util = new ExcelUtil<PesProdLineDaysLineAllWW>(PesProdLineDaysLineAllWW.class);
        return util.exportExcel(list, "明细");
    }

    /**
     * 获取产品线日计划明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwail:query')")
    @GetMapping(value = "/{lineId}")
    public AjaxResult getInfo(@PathVariable("lineId") Long lineId)
    {
        return AjaxResult.success(pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllById(lineId));
    }

    /**
     * 新增产品线日计划明细
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwail:add')")
    @Log(title = "创建产品线委外日计划明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PesProdLineDaysLineAllWW pesProdLineDaysLineAll) throws ParseException
    {
        if(!DateUtils.isEffectiveDate()){
            throw new CustomException("可操作时间范围：8:00-18:00，请留意！！！");
        }
        if("1".equals(pesProdLineDaysHeaderAllService.selectPesProdLineDaysHeaderAllById(pesProdLineDaysLineAll.getId()).getTransferFlag())){
            throw new CustomException("委外日计划已经产生调拨单，不允许新增！！！");
        }
        return toAjax(pesProdLineDaysLineAllService.insertPesProdLineDaysLineAll(pesProdLineDaysLineAll));
    }

    /**
     * 修改产品线日计划明细
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwail:edit')")
    @Log(title = "修改产品线委外日计划明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PesProdLineDaysLineAllWW pesProdLineDaysLineAll) throws ParseException
    {
        if(!DateUtils.isEffectiveDate()){
            throw new CustomException("可操作时间范围：8:00-18:00，请留意！！！");
        }
        if("1".equals(pesProdLineDaysHeaderAllService.selectPesProdLineDaysHeaderAllById(pesProdLineDaysLineAll.getId()).getTransferFlag())){
            throw new CustomException("委外日计划已经产生调拨单，不允许修改！！！");
        }
        return toAjax(pesProdLineDaysLineAllService.updatePesProdLineDaysLineAll(pesProdLineDaysLineAll));
    }

    /**
     * 删除产品线日计划明细
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwail:remove')")
    @Log(title = "删除产品线委外日计划明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{lineIds}")
    public AjaxResult remove(@PathVariable Long lineIds) throws ParseException
    {
        if(!DateUtils.isEffectiveDate()){
            throw new CustomException("可操作时间范围：8:00-18:00，请留意！！！");
        }
        if("1".equals(pesProdLineDaysHeaderAllService.selectPesProdLineDaysHeaderAllById(pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllById(lineIds).getId()).getTransferFlag())){
            throw new CustomException("委外日计划已经产生调拨单，不允许修改！！！");
        }
        return toAjax(pesProdLineDaysLineAllService.deletePesProdLineDaysLineAllByIds(lineIds));
    }

    @PreAuthorize("@ss.hasPermi('daysPlan:weiwail:other')")
    @Log(title = "发布委外日生产计划", businessType = BusinessType.DELETE)
    @DeleteMapping("/daysProdLinesww/{id}")
    public AjaxResult daysProdLinesww(@PathVariable Long id) throws ParseException {
        if(!DateUtils.isEffectiveDate()){
            throw new CustomException("可操作时间范围：8:00-18:00，请留意！！！");
        }
        return toAjax(pesProdLineDaysLineAllService.updatedaysProdLinesww(id));
    }

    /**
     * 查询产品线日计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwail:list')")
    @GetMapping("/listPrice")
    public TableDataInfo listPrice(PesProdLineDaysLineAllWWPrice pesProdLineDaysLineAll)
    {
        startPage();
        Long authByDept = getWwAuthByDept();
        if (authByDept!=null){
            pesProdLineDaysLineAll.setProdLineFlag(authByDept.intValue());
        }
        List<PesProdLineDaysLineAllWWPrice> list = pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllListPrice(pesProdLineDaysLineAll);
        return getDataTable(list);
    }

    /**
     * 导出产品线日计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('daysPlan:weiwail:export')")
    @Log(title = "导出产品线委外日计划明细", businessType = BusinessType.EXPORT)
    @GetMapping("/exportPrice")
    public AjaxResult exportPrice(PesProdLineDaysLineAllWWPrice pesProdLineDaysLineAll)
    {
        List<PesProdLineDaysLineAllWWPrice> list = pesProdLineDaysLineAllService.selectPesProdLineDaysLineAllListPrice(pesProdLineDaysLineAll);
        ExcelUtil<PesProdLineDaysLineAllWWPrice> util = new ExcelUtil<PesProdLineDaysLineAllWWPrice>(PesProdLineDaysLineAllWWPrice.class);
        return util.exportExcel(list, "明细");
    }
}
