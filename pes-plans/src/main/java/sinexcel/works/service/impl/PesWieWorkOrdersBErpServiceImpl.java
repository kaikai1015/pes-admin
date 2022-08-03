package sinexcel.works.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.*;
import sinexcel.utils.GetPesWorkNumberUtils;
import sinexcel.works.mapper.PesWieWorkOrdersBErpMapper;
import sinexcel.works.domain.PesWieWorkOrdersBErp;
import sinexcel.works.service.IPesWieWorkOrderOperationErpService;
import sinexcel.works.service.IPesWieWorkOrdersBErpService;
import sinexcel.works.service.IPesWieWorkOrdersOpsItemErpService;

/**
 * PES工单管理Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-11-24
 */
@Service
public class PesWieWorkOrdersBErpServiceImpl implements IPesWieWorkOrdersBErpService 
{
    @Autowired
    private PesWieWorkOrdersBErpMapper pesWieWorkOrdersBErpMapper;

    @Autowired
    private IPesWieWorkOrderOperationErpService pesWieWorkOrderOperationErpService;

    @Autowired
    private IPesWieWorkOrdersOpsItemErpService pesWieWorkOrdersOpsItemErpService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final Integer workOrderStatusId = 10005;
    public static final String serialTrackingFlag = "false";
    public static final String explosionFlag = "false";
    public static final String firmPlannedFlag = "true";
    public static final String sourceSystemType = "EXTERNAL";
    public static final String workOrderType = "NON_STANDARD";
    public static final String reWorkOrderType = "REWORK";
    public static final String CONTECT_TYPE = "application/vnd.oracle.adf.resourceitem+json";

    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    /**
     * 查询PES工单管理
     *
     * @param pesWorkOrderId PES工单管理ID
     * @return PES工单管理
     */
    @Override
    public PesWieWorkOrdersBErp selectPesWieWorkOrdersBErpById(Long pesWorkOrderId)
    {
        return pesWieWorkOrdersBErpMapper.selectPesWieWorkOrdersBErpById(pesWorkOrderId);
    }

    /**
     * 查询PES工单管理列表
     * 
     * @param pesWieWorkOrdersBErp PES工单管理
     * @return PES工单管理
     */
    @Override
    public List<PesWieWorkOrdersBErp> selectPesWieWorkOrdersBErpList(PesWieWorkOrdersBErp pesWieWorkOrdersBErp)
    {
        return pesWieWorkOrdersBErpMapper.selectPesWieWorkOrdersBErpList(pesWieWorkOrdersBErp);
    }

    /**
     * 修改PES工单管理
     * 
     * @param pesWieWorkOrdersBErp PES工单管理
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int updatePesWieWorkOrdersBErp(PesWieWorkOrdersBErp pesWieWorkOrdersBErp)
    {
        PesWieWorkOrdersBErp pesWieWorkOrdersBErps = pesWieWorkOrdersBErpMapper.selectPesWieWorkOrdersBErpById(pesWieWorkOrdersBErp.getPesWorkOrderId());
        if(pesWieWorkOrdersBErps.getWorkOrderNumber().contains("FG")&&pesWieWorkOrdersBErps.getWorkOrderStatusId() <=10004&&!pesWieWorkOrdersBErp.getWorkOrderStatusId().equals(pesWieWorkOrdersBErps.getWorkOrderStatusId())){
            throw new CustomException("返工工单当前状态，不能修改！！！");
        }
        if(pesWieWorkOrdersBErp.getWorkOrderStatusId()==10002){
            throw new CustomException("已完成状态自动处理，无需人为操作！！！");
        }
        if(pesWieWorkOrdersBErps.getWorkOrderId().longValue()==0&&pesWieWorkOrdersBErp.getWorkOrderStatusId()==10004){
            throw new CustomException("此工单未回传，不能直接发放，请稍后重试！！！");
        }
        if(StringUtils.isNull(pesWieWorkOrdersBErps.getWorkCenterId())){
            PesWieWorkOrdersBErp wieWorkCenterId = pesWieWorkOrdersBErpMapper.selectWieWorkCenterId(pesWieWorkOrdersBErp);
            pesWieWorkOrdersBErp.setWorkCenterId(wieWorkCenterId.getWorkCenterId());
        }
        if(pesWieWorkOrdersBErp.getWorkOrderStatusId()==10006&&pesWieWorkOrdersBErps.getWorkOrderStatusId()<10007){
            throw new CustomException("不允许删除已经生效的工单！！！");
        }
        if(StringUtils.isNotNull(pesWieWorkOrdersBErps.getWorkCenterId())&&pesWieWorkOrdersBErp.getWorkCenterId().longValue() != pesWieWorkOrdersBErps.getWorkCenterId().longValue()){
            throw new CustomException("不允许此处进行工作中心的修改！！！");
        }
        if((pesWieWorkOrdersBErps.getWorkOrderStatusId() == 10006||pesWieWorkOrdersBErps.getWorkOrderStatusId() == 10000||pesWieWorkOrdersBErps.getWorkOrderStatusId() == 10001)||(pesWieWorkOrdersBErp.getWorkOrderStatusId() == 10006&&pesWieWorkOrdersBErps.getWorkOrderStatusId()<=10005&&pesWieWorkOrdersBErps.getWorkOrderId()!=0)&&(pesWieWorkOrdersBErp.getWorkOrderStatusId() <= 10002&&pesWieWorkOrdersBErps.getWorkOrderId()==0)){
            throw new CustomException("当前状态不允许操作");
        }
//        if(pesWieWorkOrdersBErps.getCompletedQuantity().compareTo(BigDecimal.ZERO)==1&&pesWieWorkOrdersBErp.getPlannedStartQuantity().compareTo(pesWieWorkOrdersBErps.getPlannedStartQuantity().subtract(pesWieWorkOrdersBErps.getCompletedQuantity())) == 1){
//            throw new CustomException("可修改数量只能小于未完工数据！！！");
//        }
        if(pesWieWorkOrdersBErps.getCompletedQuantity().compareTo(pesWieWorkOrdersBErp.getPlannedStartQuantity())==1){
            throw new CustomException("开工数量不能小于已完工数量！！！");
        }
        pesWieWorkOrdersBErp.setCreateBy(SecurityUtils.getUsername());
        pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
        pesWieWorkOrdersBErp.setRemark("变更记录"+(pesWieWorkOrdersBErp.getWorkOrderStatusId()==10000? pesWieWorkOrdersBErp.getRemark():(pesWieWorkOrdersBErp.getWorkOrderStatusId()==10006? pesWieWorkOrdersBErp.getRemark():"")));
        pesWieWorkOrdersBErp.setErpFlag("0");
        pesWieWorkOrdersBErp.setErpType(1);
        pesWieWorkOrdersBErp.setWorkVersionNumber(pesWieWorkOrdersBErp.getWorkVersionNumber()+1);
        //跟新行表的日期和数量
        pesWieWorkOrdersBErpMapper.insertPesWieWorkOrdersBErpByWorkOrderMaterialId(pesWieWorkOrdersBErp);
        //头表信息更新
        pesWieWorkOrdersBErpMapper.updatePesWieWorkOrdersBErp(pesWieWorkOrdersBErp);
        if(StringUtils.isNull(pesWieWorkOrdersBErps.getWorkCenterId())){
            //根据新的工作中心创建工单工序和工单单身。
            pesWieWorkOrdersBErp.setLotNumFlag("N");
            pesWieWorkOrderOperationErpService.insertPesWieWorkOrderOperationErp(pesWieWorkOrdersBErp.getPesWorkOrderId(),pesWieWorkOrdersBErp.getLotNumFlag());
            pesWieWorkOrdersBErp.setRemark("工作中心添加");
        }
        //变更记录插入回传记录表
        pesWieWorkOrdersBErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersBErp);
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int releasedWieWorkOrdersBErpByIds(Long[] pesWorkOrderIds)
    {
        int successNum = 0;
        int failureNum = 0;
        StringBuilder failureMsg = new StringBuilder();

        Long wx = 300000004927942L;
       for(Long pesWorkOrderId:pesWorkOrderIds){
            PesWieWorkOrdersBErp pesWieWorkOrdersBErp = pesWieWorkOrdersBErpMapper.selectPesWieWorkOrdersBErpById(pesWorkOrderId);
            if (pesWieWorkOrdersBErp.getWorkOrderId().longValue() > 0&&pesWieWorkOrdersBErp.getWorkOrderStatusId() == 10005&&StringUtils.isNotNull(pesWieWorkOrdersBErp.getWorkCenterId())&&pesWieWorkOrdersBErp.getPlannedStartQuantity().compareTo(BigDecimal.ZERO)==1) {
                if (wx.equals(pesWieWorkOrdersBErp.getWorkCenterId())) {
                    //发放前需要验证外协的是否存在供应商
                    boolean flag = pesWieWorkOrderOperationErpService.selectPesWieWorkOrdersOperationErpListById(pesWorkOrderId);
                    if (flag) {
                        pesWieWorkOrdersBErp.setCreateBy(SecurityUtils.getUsername());
                        pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
                        pesWieWorkOrdersBErp.setWorkOrderStatusId(10004);
                        pesWieWorkOrdersBErp.setRemark("工单发放");
                        pesWieWorkOrdersBErp.setErpFlag("0");
                        pesWieWorkOrdersBErp.setErpType(1);
                        successNum++;
                        //变更记录插入回传记录表
                        pesWieWorkOrdersBErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersBErp);
                        pesWieWorkOrdersBErp.setWorkVersionNumber(pesWieWorkOrdersBErp.getWorkVersionNumber() + 1);
                        pesWieWorkOrdersBErpMapper.updatePesWieWorkOrdersBErp(pesWieWorkOrdersBErp);
                    }else {
                        failureNum++;
                        String msg = "【工单号：" + pesWieWorkOrdersBErp.getWorkOrderNumber() + "费用料号不完整，请先维护】";
                        failureMsg.append(msg);
                    }

                }else {
                    pesWieWorkOrdersBErp.setCreateBy(SecurityUtils.getUsername());
                    pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
                    pesWieWorkOrdersBErp.setWorkOrderStatusId(10004);
                    pesWieWorkOrdersBErp.setRemark("工单发放");
                    pesWieWorkOrdersBErp.setErpFlag("0");
                    pesWieWorkOrdersBErp.setErpType(1);
                    //变更记录插入回传记录表
                    pesWieWorkOrdersBErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersBErp);
                    pesWieWorkOrdersBErp.setWorkVersionNumber(pesWieWorkOrdersBErp.getWorkVersionNumber() + 1);
                    pesWieWorkOrdersBErpMapper.updatePesWieWorkOrdersBErp(pesWieWorkOrdersBErp);
                    successNum++;
                }
            }
        }
        if(failureNum>0){
            throw new CustomException(failureMsg.toString());
        }
        return successNum;
    }

    /**
     * 批量删除PES工单管理
     * 
     * @param pesWorkOrderIds 需要删除的PES工单管理ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int deletePesWieWorkOrdersBErpByIds(Long[] pesWorkOrderIds)
    {
        int successNum = 0;
        for (Long pesWorkOrderId:pesWorkOrderIds){
            PesWieWorkOrdersBErp pesWieWorkOrdersBErp= pesWieWorkOrdersBErpMapper.selectPesWieWorkOrdersBErpById(pesWorkOrderId);
            if(pesWieWorkOrdersBErp.getWorkOrderStatusId()==10007&&StringUtils.isNotNull(pesWieWorkOrdersBErp.getWorkCenterId())){
                pesWieWorkOrdersBErp.setCreateBy(SecurityUtils.getUsername());
                pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
                pesWieWorkOrdersBErp.setRemark("发布生效记录");
                pesWieWorkOrdersBErp.setErpFlag("0");
                pesWieWorkOrdersBErp.setErpType(1);
                pesWieWorkOrdersBErp.setWorkOrderStatusId(10005);
                pesWieWorkOrdersBErpMapper.deletePesWieWorkOrdersBErpByIds(pesWieWorkOrdersBErp);
                successNum++;
                //删除记录插入回传记录表
                pesWieWorkOrdersBErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersBErp);
            }
        }
        return successNum;
    }

    //接口回传
    @Override
    public int handleSubmitErpPesWieWorkOrdersBErpByIdsJob(String endName)
    {
        List<PesWieWorkOrdersBErp> pesWieWorkOrdersBErp = pesWieWorkOrdersBErpMapper.handleSubmitErpPesWieWorkOrdersBErpByIdsJob();
        if(pesWieWorkOrdersBErp.size() > 0){
            List<Long> pesWorkOrderIds = pesWieWorkOrdersBErp.stream().map(PesWieWorkOrdersBErp::getPesWorkOrderId).collect(Collectors.toList());
            for(Long pesWorkOrderId:pesWorkOrderIds){
                handleSubmitErpIds(pesWorkOrderId,endName);
            }
        }
        return 1;
    }

    //接口变更
    @Override
    public int updateSubmitErpPesWieWorkOrdersBErpByIdsJob(String endName)
    {
        List<PesWieWorkOrdersBErp> pesWieWorkOrdersBErp = pesWieWorkOrdersBErpMapper.updateSubmitErpPesWieWorkOrdersBErpByIdsJob();
        List<Long> pesWorkOrderIds = pesWieWorkOrdersBErp.stream().map(PesWieWorkOrdersBErp::getPesWorkOrderId).collect(Collectors.toList());
        for(Long pesWorkOrderId:pesWorkOrderIds){
            updateErpPesWieWorkOrdersBErpByIds(pesWorkOrderId,endName);
        }
        return 1;
    }

    /**
     * PES工单回传ERP
     * 
     * @param pesWorkOrderIds PES工单管理ID
     * @return 结果
     */
    @Override
    public int handleSubmitErpPesWieWorkOrdersBErpByIds(Long[] pesWorkOrderIds)
    {
        Arrays.asList(pesWorkOrderIds).forEach(pesWorkOrderId -> {
            handleSubmitErpIds(pesWorkOrderId,"userName");
        });
        return 1;
    }

    public int handleSubmitErpIds(Long pesWorkOrderId,String endName)
    {
        //第一步回传PES工单头信息
        PesWieWorkOrdersBErp pesWieWorkOrdersBErp= pesWieWorkOrdersBErpMapper.selectPesWieWorkOrdersBErpById(pesWorkOrderId);
        if(StringUtils.isNotNull(pesWieWorkOrdersBErp)&&pesWieWorkOrdersBErp.getWorkOrderId().longValue()==0&&pesWieWorkOrdersBErp.getWorkOrderStatusId()==10005&&pesWieWorkOrdersBErp.getCreateDate().compareTo(pesWieWorkOrdersBErp.getErpSubmitDate())==0){
            //交易时间转换成格林威治时间
            Calendar cal1 = Calendar.getInstance();
            cal1.setTimeInMillis(pesWieWorkOrdersBErp.getPlannedStartDate() .getTime());
            Calendar cal11 = Calendar.getInstance();
            cal11.setTimeInMillis(pesWieWorkOrdersBErp.getPlannedCompletionDate() .getTime());

            //Json头信息
            JSONObject requestJsonObject = new JSONObject();
            requestJsonObject.put("OrganizationId", pesWieWorkOrdersBErp.getOrganizationId());
            requestJsonObject.put("WorkOrderNumber", pesWieWorkOrdersBErp.getWorkOrderNumber());
            requestJsonObject.put("InventoryItemId", pesWieWorkOrdersBErp.getInventoryItemId());
            requestJsonObject.put("WorkOrderStatusId", workOrderStatusId);
            requestJsonObject.put("PlannedStartQuantity", pesWieWorkOrdersBErp.getPlannedStartQuantity());
            requestJsonObject.put("SerialTrackingFlag", serialTrackingFlag);
            requestJsonObject.put("PlannedStartDate", sdf1.format(cal1.getTime()));
//            requestJsonObject.put("PlannedCompletionDate", sdf1.format(cal11.getTime()));
            requestJsonObject.put("ExplosionFlag", explosionFlag);
            requestJsonObject.put("FirmPlannedFlag", firmPlannedFlag);
            requestJsonObject.put("WorkOrderDescription", pesWieWorkOrdersBErp.getCustomerName());
            requestJsonObject.put("WorkOrderPriority", pesWieWorkOrdersBErp.getOrderNumber());
            requestJsonObject.put("SourceSystemType", sourceSystemType);
            if(pesWieWorkOrdersBErp.getWorkOrderNumber().contains("FG")){
                PesWieWorkOrdersBErp getSupplySubinventory = pesWieWorkOrdersBErpMapper.selectSupplySubinventoryById(pesWieWorkOrdersBErp);
                requestJsonObject.put("WorkOrderType",reWorkOrderType);
                List workOrderAssemblyComponent = new ArrayList<>();
                JSONObject requestJsonAssemObject = new JSONObject();
                requestJsonAssemObject.put("SupplySubinventory",StringUtils.isNull(getSupplySubinventory)?null:getSupplySubinventory.getSupplySubinventory());
//                if(pesWieWorkOrdersBErpMapper.getPitemNumLotControlCodeByIds(pesWieWorkOrdersBErp).getLotControlCode()== 2){
//                if(2== 2){
//                    List workOrderAssemblyComponentLot = new ArrayList<>();
//                    JSONObject requestJsonAssemObjectLot = new JSONObject();
//                    requestJsonAssemObjectLot.put("LotNumber","QC201810");
//                    requestJsonAssemObjectLot.put("AssociatedQuantity",pesWieWorkOrdersBErp.getPlannedStartQuantity());
//                    workOrderAssemblyComponentLot.add(requestJsonAssemObjectLot);
//                    requestJsonAssemObject.put("WorkOrderAssemblyComponentLot", workOrderAssemblyComponentLot);
//                }
                workOrderAssemblyComponent.add(requestJsonAssemObject);
                requestJsonObject.put("WorkOrderAssemblyComponent", workOrderAssemblyComponent);
            }else {
                requestJsonObject.put("WorkOrderType",workOrderType);
            }

            //Json转换
            String requestBody = requestJsonObject.toJSONString();

            pesWieWorkOrdersBErp.setErpType(0);
            try {
                //发送POST请求
                String responseBody = RestClient.postData(ConfigUtils.getWieWorksUrl(), requestBody, CONTECT_TYPE, "UTF-8",ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
                //返回值解析
                JSONObject responseJsonObject = JSONObject.parseObject(responseBody);
                Object workOrderId = responseJsonObject.get("WorkOrderId");

                //调用成功
                if (StringUtils.isNotNull(workOrderId)) {
                    pesWieWorkOrdersBErp.setWorkOrderId(Long.valueOf(String.valueOf(workOrderId)));
                    pesWieWorkOrdersBErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                    pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
                    if(pesWieWorkOrdersBErp.getWorkOrderNumber().contains("FG")){
                        JSONArray workOrderAssemblyComponentArray = responseJsonObject.getJSONArray("WorkOrderAssemblyComponent");
                        JSONObject responseWorkOrderAssemblyComponentArray = JSONObject.parseObject(workOrderAssemblyComponentArray.get(0).toString());
                        Object woOperationMaterialId = responseWorkOrderAssemblyComponentArray.get("WoOperationMaterialId");
                        pesWieWorkOrdersBErp.setWoOperationMaterialId(Long.valueOf(String.valueOf(woOperationMaterialId)));
                        //跟新返工单身
                        pesWieWorkOrdersBErpMapper.updatePesWieWorkOrdersBMaterialErpByWorkOrderId(pesWieWorkOrdersBErp);
                    }
                    pesWieWorkOrdersBErp.setRemark("OK");
                    pesWieWorkOrdersBErp.setErpFlag("1");
                    pesWieWorkOrdersBErpMapper.updatePesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersBErp);
                    //回传成功插入回传记录表
                    pesWieWorkOrdersBErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersBErp);
                    //PES工单头信息回传成功，开始回传PES工序信息
                    logger.info("************************PES自定义工单回传ERP开始************************");
                    logger.info("工单号："+pesWieWorkOrdersBErp.getWorkOrderNumber());
                    pesWieWorkOrderOperationErpService.handleSubmitErpPesOperationByIds(pesWorkOrderId,endName);

                }else {
                    pesWieWorkOrdersBErp.setWorkOrderId(0L);
                    pesWieWorkOrdersBErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                    pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
                    pesWieWorkOrdersBErp.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+responseBody, 0, 4000));
                    pesWieWorkOrdersBErp.setErpFlag("2");
                    pesWieWorkOrdersBErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersBErp);
                }

            } catch (JSONException ex) {
                pesWieWorkOrdersBErp.setWorkOrderId(0L);
                pesWieWorkOrdersBErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
                pesWieWorkOrdersBErp.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+ex.getMessage(), 0, 4000));
                pesWieWorkOrdersBErp.setErpFlag("2");
                pesWieWorkOrdersBErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersBErp);

            } catch (Exception ex) {
                pesWieWorkOrdersBErp.setWorkOrderId(0L);
                pesWieWorkOrdersBErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
                pesWieWorkOrdersBErp.setErpFlag("2");
                pesWieWorkOrdersBErp.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+ex.getMessage(), 0, 4000));
                pesWieWorkOrdersBErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersBErp);
            }
        }
//        else {
//            throw new CustomException("工单：请在回传信息查看！！！");
//        }
        return 1;
    }

    /**
     * 生成PES工单管理信息
     *
     * @param lineNums PES工单管理ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int insertPesWieWorkOrdersBErp(Long[] lineNums)
    {
        PesWieWorkOrdersBErp pesWieWorkOrdersBErp = new PesWieWorkOrdersBErp();
        for(Long lineNum :lineNums){
            //创建工单头信息
            pesWieWorkOrdersBErp.setSourceLineNum(lineNum);
            pesWieWorkOrdersBErp.setCreateBy(SecurityUtils.getUsername());
            pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
            pesWieWorkOrdersBErp.setWorkOrderNumber(GetPesWorkNumberUtils.getWorkNumber());
            //创建PES工单头信息
            pesWieWorkOrdersBErp.setWorkOrderStatusId(10007);
            pesWieWorkOrdersBErp.setLotNumFlag("Y");
            pesWieWorkOrdersBErpMapper.insertPesWieWorkOrdersBErp(pesWieWorkOrdersBErp);
            //根据返回来的pesWorkOrderId主键创建工单工序和工单单身。
            pesWieWorkOrderOperationErpService.insertPesWieWorkOrderOperationErp(pesWieWorkOrdersBErp.getPesWorkOrderId(),pesWieWorkOrdersBErp.getLotNumFlag());
        }
            //pes工单创建完成，修改计划池数据的状态
        return pesWieWorkOrdersBErpMapper.updatePesWieWorkOrdersBErpByLineNums(lineNums);
    }

    @Override
    public int updateErpPesWieWorkOrdersBErpByIds(Long pesWorkOrderIds,String endName)
    {
        PesWieWorkOrdersBErp pesWieWorkOrdersBErp = pesWieWorkOrdersBErpMapper.selectPesWieWorkOrdersBErpById(pesWorkOrderIds);
        if(pesWieWorkOrdersBErpMapper.selectCountUpdateOperation(pesWorkOrderIds) == 0){
            //WorkOrderId>0,标识已经回传了ERP才能做变更，10006标识PES已经删除了，不能回传ERP，更新日期大于创建日期回传提交日期标识有跟新
            if(StringUtils.isNotNull(pesWieWorkOrdersBErp)&&pesWieWorkOrdersBErp.getWorkOrderId().longValue() > 0&&(pesWieWorkOrdersBErp.getWorkOrderStatusId()!=10006)&&(pesWieWorkOrdersBErp.getLastUpdateDate().compareTo(pesWieWorkOrdersBErp.getCreateDate()) > 0)&&(pesWieWorkOrdersBErp.getLastUpdateDate().compareTo(pesWieWorkOrdersBErp.getErpSubmitDate()) > 0)){
                //获取URL
                String getUpdateWorUrl = ConfigUtils.getEndWieWoUrl().replace("{WorkOrderId}",String.valueOf(pesWieWorkOrdersBErp.getWorkOrderId()));

                //交易时间转换成格林威治时间
                Calendar cal1 = Calendar.getInstance();
                cal1.setTimeInMillis(pesWieWorkOrdersBErp.getPlannedStartDate() .getTime());

                //Json头信息
                JSONObject requestJsonObject = new JSONObject();
                if(pesWieWorkOrdersBErp.getWorkOrderStatusId()==10000){
                    requestJsonObject.put("WorkOrderStatusId", pesWieWorkOrdersBErp.getWorkOrderStatusId());
                    requestJsonObject.put("CanceledReason", pesWieWorkOrdersBErp.getRemark());
                }
                if(pesWieWorkOrdersBErp.getWorkOrderStatusId()==10001||pesWieWorkOrdersBErp.getWorkOrderStatusId()==10002){
                    requestJsonObject.put("WorkOrderStatusId", pesWieWorkOrdersBErp.getWorkOrderStatusId());
                }
                if(pesWieWorkOrdersBErp.getWorkOrderStatusId().intValue() > 10002){
                    requestJsonObject.put("PlannedStartQuantity", pesWieWorkOrdersBErp.getPlannedStartQuantity());
                    requestJsonObject.put("WorkOrderStatusId", pesWieWorkOrdersBErp.getWorkOrderStatusId());
                    requestJsonObject.put("PlannedStartDate", sdf1.format(cal1.getTime()));
                }
                //Json转换
                String requestBody = requestJsonObject.toJSONString();

                try {
                    //发送POST请求
                    int sta = RestClient.patchData(getUpdateWorUrl, requestBody, CONTECT_TYPE, "UTF-8",ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
                    //调用成功
                    if (sta == 200 || sta == 201) {
                        pesWieWorkOrdersBErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                        pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
                        pesWieWorkOrdersBErp.setRemark("OK");
                        pesWieWorkOrdersBErp.setErpFlag("1");
                        pesWieWorkOrdersBErp.setErpType(1);
                        //变更成功跟新日期
                        pesWieWorkOrdersBErpMapper.updateSubmitDatePesWieWorkOrdersBErp(pesWieWorkOrdersBErp);
                        //回传成功插入回传记录表
                        pesWieWorkOrdersBErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersBErp);
                        logger.info("工单变更：工单号："+pesWieWorkOrdersBErp.getWorkOrderNumber());
                    }else {
                        pesWieWorkOrdersBErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                        pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
                        pesWieWorkOrdersBErp.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+sta, 0, 4000));
                        pesWieWorkOrdersBErp.setErpFlag("2");
                        pesWieWorkOrdersBErp.setErpType(1);
                        //回传成功插入回传记录表
                        pesWieWorkOrdersBErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersBErp);
                    }

                } catch (JSONException ex) {
                    pesWieWorkOrdersBErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                    pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
                    pesWieWorkOrdersBErp.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+ex.getMessage(), 0, 4000));
                    pesWieWorkOrdersBErp.setErpFlag("2");
                    pesWieWorkOrdersBErp.setErpType(1);
                    //回传成功插入回传记录表
                    pesWieWorkOrdersBErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersBErp);

                } catch (Exception ex) {
                    pesWieWorkOrdersBErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                    pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
                    pesWieWorkOrdersBErp.setErpFlag("2");
                    pesWieWorkOrdersBErp.setErpType(1);
                    pesWieWorkOrdersBErp.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+ex.getMessage(), 0, 4000));
                    //回传成功插入回传记录表
                    pesWieWorkOrdersBErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersBErp);
                }
            }
        }else {
            pesWieWorkOrdersBErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
            pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
            pesWieWorkOrdersBErp.setErpFlag("2");
            pesWieWorkOrdersBErp.setErpType(1);
            pesWieWorkOrdersBErp.setRemark("工序存在更新数据未回传");
            //回传成功插入回传记录表
            pesWieWorkOrdersBErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrdersBErp);
        }
        return 1;
    }

    /**
     * 新增PES工单管理
     *
     * @param pesWieWorkOrdersBErp PES工单管理
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int insertAddPesWieWorkOrdersBErp(PesWieWorkOrdersBErp pesWieWorkOrdersBErp)
    {
//        pesWieWorkOrdersBErp.setWorkOrderNumber((null==pesWieWorkOrdersBErp.getCreateType()||StringUtils.isEmpty(pesWieWorkOrdersBErp.getCreateType()))?GetPesWorkNumberUtils.getWorkNumber():(pesWieWorkOrdersBErp.getCreateType()+GetPesWorkNumberUtils.getWorkNumber()));
        if("Y".equals(pesWieWorkOrdersBErp.getLinesLotsFlag())){
            PesWieWorkOrdersBErp getLinesData = pesWieWorkOrdersBErpMapper.selectSourceLinesData(pesWieWorkOrdersBErp.getSourceLineNum());
            if (StringUtils.isNotNull(getLinesData)){
                pesWieWorkOrdersBErp.setWorkOrderNumber(GetPesWorkNumberUtils.getWorkNumber());
                pesWieWorkOrdersBErp.setOrganizationId(getLinesData.getOrganizationId());
                pesWieWorkOrdersBErp.setSourceLineNum(getLinesData.getSourceLineNum());
                pesWieWorkOrdersBErp.setWorkItemLevel(getLinesData.getWorkItemLevel());
                pesWieWorkOrdersBErp.setInventoryItemId(getLinesData.getInventoryItemId());
                pesWieWorkOrdersBErp.setpItemNumber(getLinesData.getpItemNumber());
                pesWieWorkOrdersBErp.setpItemDescription(getLinesData.getpItemDescription());
                pesWieWorkOrdersBErp.setWorkOrderType(getLinesData.getWorkOrderType());
                pesWieWorkOrdersBErp.setUomCode(getLinesData.getUomCode());
                pesWieWorkOrdersBErp.setPlannedStartQuantity(getLinesData.getPlannedStartQuantity());
                pesWieWorkOrdersBErp.setPlannedStartDate(getLinesData.getPlannedStartDate());
                pesWieWorkOrdersBErp.setPlannedCompletionDate(getLinesData.getPlannedCompletionDate());
                pesWieWorkOrdersBErp.setLevelTreeCode(getLinesData.getLevelTreeCode());
                pesWieWorkOrdersBErp.setParentLevelTreeCode(getLinesData.getParentLevelTreeCode());
                pesWieWorkOrdersBErp.setOrderNumber(getLinesData.getOrderNumber());
                pesWieWorkOrdersBErp.setOrderNumberLine(getLinesData.getOrderNumberLine());
                pesWieWorkOrdersBErp.setContractNumber(getLinesData.getContractNumber());
                pesWieWorkOrdersBErp.setCustomerName(getLinesData.getCustomerName());
                pesWieWorkOrdersBErp.setWorkOrderStatusId(10007);
                pesWieWorkOrdersBErp.setWorkOrderId(0L);
                pesWieWorkOrdersBErp.setpItemVersionNumber(0);
                pesWieWorkOrdersBErp.setWorkVersionNumber(0);
                pesWieWorkOrdersBErp.setCompletedQuantity(BigDecimal.ZERO);
                pesWieWorkOrdersBErp.setPlanName(SecurityUtils.getUsername());
                pesWieWorkOrdersBErp.setCreateType("Y");
                pesWieWorkOrdersBErp.setLotNumFlag("Y");
                pesWieWorkOrdersBErp.setWorkCenterId(getLinesData.getWorkCenterId());
            }else {
                throw new CustomException("输入的计划批次行号未查询到数据，请核对："+pesWieWorkOrdersBErp.getSourceLineNum());
            }
        }else {
            PesWieWorkOrdersBErp wieWorkCenterId = pesWieWorkOrdersBErpMapper.selectWieWorkCenterId(pesWieWorkOrdersBErp);
            pesWieWorkOrdersBErp.setWorkCenterId(wieWorkCenterId.getWorkCenterId());
            pesWieWorkOrdersBErp.setWorkOrderNumber(pesWieWorkOrdersBErp.getWorkCenterId().longValue() == 300000049805474L?pesWieWorkOrdersBErp.getWorkOrderNumber():(pesWieWorkOrdersBErp.getCreateType()+GetPesWorkNumberUtils.getWorkNumber()));
            PesWieWorkOrdersBErp getPitemNumberDescription = pesWieWorkOrdersBErpMapper.selectPitemNumberDescriptionByItemOrgIds(pesWieWorkOrdersBErp);
            if(StringUtils.isNull(getPitemNumberDescription)){
                throw new CustomException("输入的物料类型不对，只允许：BCP,WWBCP,FG,INTER_COMPANY_FEE");
            }
            pesWieWorkOrdersBErp.setInventoryItemId(getPitemNumberDescription.getInventoryItemId());
            pesWieWorkOrdersBErp.setWorkOrderType(getPitemNumberDescription.getWorkOrderType());
            pesWieWorkOrdersBErp.setpItemNumber(getPitemNumberDescription.getpItemNumber());
            pesWieWorkOrdersBErp.setpItemDescription(getPitemNumberDescription.getpItemDescription());
            pesWieWorkOrdersBErp.setUomCode(getPitemNumberDescription.getUomCode());
            pesWieWorkOrdersBErp.setWorkItemLevel(0);
            pesWieWorkOrdersBErp.setPlanName(SecurityUtils.getUsername());
            pesWieWorkOrdersBErp.setCustomerName(StringUtils.isEmpty(pesWieWorkOrdersBErp.getCustomerName())?pesWieWorkOrdersBErp.getRemark():pesWieWorkOrdersBErp.getCustomerName());
            pesWieWorkOrdersBErp.setOrderNumber(StringUtils.isNull(pesWieWorkOrdersBErp.getOrderNumber())?pesWieWorkOrdersBErp.getWorkOrderNumber().replaceAll("[a-zA-Z]",""):pesWieWorkOrdersBErp.getOrderNumber());
            pesWieWorkOrdersBErp.setOrderNumberLine(0);
            pesWieWorkOrdersBErp.setContractNumber(pesWieWorkOrdersBErp.getWorkOrderNumber());
            pesWieWorkOrdersBErp.setSourceLineNum(Long.parseLong(DateUtils.dateTimeNow()));
            pesWieWorkOrdersBErp.setLevelTreeCode(DateUtils.dateTimeNow());
            pesWieWorkOrdersBErp.setParentLevelTreeCode(DateUtils.dateTimeNow());
            pesWieWorkOrdersBErp.setWorkOrderId(0L);
            pesWieWorkOrdersBErp.setpItemVersionNumber(0);
            pesWieWorkOrdersBErp.setCompletedQuantity(BigDecimal.ZERO);
            pesWieWorkOrdersBErp.setPlannedCompletionDate(DateUtils.parseDate(DateUtils.getNextDay(pesWieWorkOrdersBErp.getPlannedStartDate(),3)));
            pesWieWorkOrdersBErp.setLotNumFlag("BZ".equals(pesWieWorkOrdersBErp.getCreateType())?"Y":"N");
        }
        pesWieWorkOrdersBErp.setCreateBy(SecurityUtils.getUsername());
        pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
        pesWieWorkOrdersBErp.setWorkOrderTypeId(pesWieWorkOrdersBErp.getLotNumFlag());
        //创建工单
        pesWieWorkOrdersBErpMapper.insertAddPesWieWorkOrdersBErp(pesWieWorkOrdersBErp);
        //根据返回来的pesWorkOrderId主键创建工单工序和工单单身。
        pesWieWorkOrderOperationErpService.insertPesWieWorkOrderOperationErp(pesWieWorkOrdersBErp.getPesWorkOrderId(),pesWieWorkOrdersBErp.getLotNumFlag());

        if("N".equals(pesWieWorkOrdersBErp.getBomDataFlag())||"FG".equals(pesWieWorkOrdersBErp.getCreateType())||"ZH".equals(pesWieWorkOrdersBErp.getCreateType())){
            pesWieWorkOrdersBErpMapper.deletPesWieWorkMaterialByIds(pesWieWorkOrdersBErp.getPesWorkOrderId());
        }
        if("FG".equals(pesWieWorkOrdersBErp.getCreateType())){
            if(pesWieWorkOrdersBErpMapper.allowRetormWorksQuantitys(pesWieWorkOrdersBErp) > 0){
                pesWieWorkOrdersBErpMapper.updatePesWieWorkMaterialByIds(pesWieWorkOrdersBErp);
            }else {
                throw new CustomException("返工仓库存不足，请确认！！！");
            }
        }
        return 1;
    }


    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int copyErpPesWieWorkOrdersBErpByIds(Long pesWorkOrderIds)
    {
        PesWieWorkOrdersBErp pesWieWorkOrdersBErp = pesWieWorkOrdersBErpMapper.selectPesWieWorkOrdersBErpById(pesWorkOrderIds);
        if(pesWieWorkOrdersBErp.getWorkOrderStatusId() == 10004&&pesWieWorkOrdersBErp.getWorkCenterCode()==2){
            throw new CustomException("外协工单已经发放，已经生成PO，不允许复制，工单号："+pesWieWorkOrdersBErp.getWorkOrderNumber());
        }
        pesWieWorkOrdersBErp.setWorkItemLevel(0);
        pesWieWorkOrdersBErp.setCreateBy(SecurityUtils.getUsername());
        pesWieWorkOrdersBErp.setCreateDate(DateUtils.getNowDate());
        pesWieWorkOrdersBErp.setWorkOrderId(0L);
        pesWieWorkOrdersBErp.setpItemVersionNumber(0);
        pesWieWorkOrdersBErp.setWorkVersionNumber(0);
        pesWieWorkOrdersBErp.setCompletedQuantity(BigDecimal.ZERO);
        pesWieWorkOrdersBErp.setWorkOrderNumber(GetPesWorkNumberUtils.getWorkNumber());
        pesWieWorkOrdersBErp.setWorkOrderStatusId(10007);
        pesWieWorkOrdersBErp.setPlanName(SecurityUtils.getUsername());

        pesWieWorkOrdersBErp.setLotNumFlag(pesWieWorkOrdersBErp.getWorkOrderTypeId());


        //创建工单
        pesWieWorkOrdersBErpMapper.insertAddPesWieWorkOrdersBErp(pesWieWorkOrdersBErp);
        //根据返回来的pesWorkOrderId主键创建工单工序和工单单身。
        return pesWieWorkOrderOperationErpService.insertPesWieWorkOrderOperationErp(pesWieWorkOrdersBErp.getPesWorkOrderId(),pesWieWorkOrdersBErp.getLotNumFlag());
    }

    @Override
    public List<PesWieWorkOrdersBErp> selectHandle(PesWieWorkOrdersBErp pesWieWorkOrdersBErp)
    {
        return pesWieWorkOrdersBErpMapper.selectHandle(pesWieWorkOrdersBErp);
    }
}
