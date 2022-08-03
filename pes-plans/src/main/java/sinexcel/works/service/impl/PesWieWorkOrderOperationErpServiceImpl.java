package sinexcel.works.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.*;
import sinexcel.works.mapper.PesWieWorkOrderOperationErpMapper;
import sinexcel.works.domain.PesWieWorkOrderOperationErp;
import sinexcel.works.service.IPesWieWoOperationMaterialsErpService;
import sinexcel.works.service.IPesWieWorkOrderOperationErpService;
import sinexcel.works.service.IPesWieWorkOrderOperationResourceErpService;

/**
 * pes自定义工单工序数据Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2021-11-26
 */
@Service
public class PesWieWorkOrderOperationErpServiceImpl implements IPesWieWorkOrderOperationErpService 
{
    @Autowired
    private PesWieWorkOrderOperationErpMapper pesWieWorkOrderOperationErpMapper;

    @Autowired
    private IPesWieWoOperationMaterialsErpService pesWieWoOperationMaterialsErpService;

    @Autowired
    private IPesWieWorkOrderOperationResourceErpService pesWieWorkOrderOperationResourceErpService;

    public static final Long workCenterId = 300000004927935L;
    public static final Long workCenterIdOps = 300000004927942L;
    public static final String countPointOperationFlag = "true";
    public static final String autoTransactFlag = "false";
    public static final String shippingDocumentsFlag = "false";
    public static final String operationDescriptionF = "仓管员发料过程";
    public static final String operationDescriptionS = "仓库完工入库工序";
    public static final String operationDescriptionOpsF = "委外发料工序";
    public static final String operationDescriptionOpsS = "外协工序";
    public static final String operationDescriptionOpsT = "委外完工工序";
    public static final String CONTECT_TYPE = "application/vnd.oracle.adf.resourceitem+json";

    /**
     * 查询pes自定义工单工序数据列表
     * 
     * @param pesWieWorkOrderOperationErp pes自定义工单工序数据
     * @return pes自定义工单工序数据
     */
    @Override
    public List<PesWieWorkOrderOperationErp> selectPesWieWorkOrderOperationErpList(PesWieWorkOrderOperationErp pesWieWorkOrderOperationErp)
    {
        return pesWieWorkOrderOperationErpMapper.selectPesWieWorkOrderOperationErpList(pesWieWorkOrderOperationErp);
    }

    /**
     * 新增pes自定义工单工序数据
     * 
     * @param pesWorkOrderId pes自定义工单工序数据
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int insertPesWieWorkOrderOperationErp(Long pesWorkOrderId,String lotNumFlag)
    {
        Long ck = 300000004927935L;
        Long wx = 300000004927942L;
        Long dy = 300000050266293L;
        Long free = 300000049805474L;
        PesWieWorkOrderOperationErp pesWieWorkOrderOperationErp = pesWieWorkOrderOperationErpMapper.selectPesWieWorkOrderOperationErp(pesWorkOrderId);
        if(StringUtils.isNull(pesWieWorkOrderOperationErp.getWorkCenterCode())){
            throw new CustomException("存在不完整的工作中心，请先维护工作中心。");
        }
        Long ospItemId = pesWieWorkOrderOperationErp.getOspItemId();
        Long ospSupplyId = pesWieWorkOrderOperationErp.getSupplierId();
        pesWieWorkOrderOperationErp.setOspItemId(0L);
        pesWieWorkOrderOperationErp.setSupplierId(0L);
        String ospItemNumber = pesWieWorkOrderOperationErp.getOspItemNumber();
        String ospSupplyName = pesWieWorkOrderOperationErp.getSupplierName();
        pesWieWorkOrderOperationErp.setOspItemNumber(null);
        pesWieWorkOrderOperationErp.setSupplierName(null);
        pesWieWorkOrderOperationErp.setPesWorkOrderId(pesWorkOrderId);
        pesWieWorkOrderOperationErp.setCreateBy(SecurityUtils.getUsername());
        pesWieWorkOrderOperationErp.setCreateDate(DateUtils.getNowDate());
        if(pesWieWorkOrderOperationErp.getWorkCenterCode() == 1){
            //厂内工单
//            pesWieWorkOrderOperationErp.setWorkCenterId(ck);
            pesWieWorkOrderOperationErp.setOperationSequenceNumber(10);
            pesWieWorkOrderOperationErp.setStandardOperationCode("CK01");
            pesWieWorkOrderOperationErp.setOperationType("IN_HOUSE");
            pesWieWorkOrderOperationErp.setOperationName("发料");
            //创建10发料工序
            pesWieWorkOrderOperationErpMapper.insertPesWieWorkOrderOperationErp(pesWieWorkOrderOperationErp);
            //根据返回来的pesWorkOrderOperationId和pesWorkOrderId创建工单单身明细
            pesWieWoOperationMaterialsErpService.insertPesWieWoOperationMaterialsErp(pesWieWorkOrderOperationErp.getPesWorkOrderOperationId(),pesWieWorkOrderOperationErp.getWorkCenterCode());
            pesWieWorkOrderOperationErp.setOperationSequenceNumber(100);
            pesWieWorkOrderOperationErp.setStandardOperationCode("CK02");
            pesWieWorkOrderOperationErp.setOperationType("IN_HOUSE");
            pesWieWorkOrderOperationErp.setOperationName("完工");
        }
        if(pesWieWorkOrderOperationErp.getWorkCenterCode() == 2){
            //委外工单
//            pesWieWorkOrderOperationErp.setWorkCenterId(wx);
            pesWieWorkOrderOperationErp.setOperationSequenceNumber(10);
            pesWieWorkOrderOperationErp.setStandardOperationCode("WX02");
            pesWieWorkOrderOperationErp.setOperationType("IN_HOUSE");
            pesWieWorkOrderOperationErp.setOperationName("委外发料");
            //创建10委外发料工序
            pesWieWorkOrderOperationErpMapper.insertPesWieWorkOrderOperationErp(pesWieWorkOrderOperationErp);
            //根据返回来的pesWorkOrderOperationId和pesWorkOrderId创建工单单身明细
            pesWieWoOperationMaterialsErpService.insertPesWieWoOperationMaterialsErp(pesWieWorkOrderOperationErp.getPesWorkOrderOperationId(),pesWieWorkOrderOperationErp.getWorkCenterCode());
            //创建20委外发料工序
            pesWieWorkOrderOperationErp.setOperationSequenceNumber(20);
            pesWieWorkOrderOperationErp.setStandardOperationCode("WX01");
            pesWieWorkOrderOperationErp.setOperationType("SUPPLIER");
            pesWieWorkOrderOperationErp.setOperationName("外协工序");
            pesWieWorkOrderOperationErp.setOspItemId(ospItemId);
            pesWieWorkOrderOperationErp.setSupplierId(ospSupplyId);
            pesWieWorkOrderOperationErp.setOspItemNumber(ospItemNumber);
            pesWieWorkOrderOperationErp.setSupplierName(ospSupplyName);
            pesWieWorkOrderOperationErpMapper.insertPesWieWorkOrderOperationErp(pesWieWorkOrderOperationErp);
            //创建100委外发料工序
            pesWieWorkOrderOperationErp.setOperationSequenceNumber(100);
            pesWieWorkOrderOperationErp.setStandardOperationCode("WX03");
            pesWieWorkOrderOperationErp.setOperationType("IN_HOUSE");
            pesWieWorkOrderOperationErp.setOperationName("委外完工");
        }
        if(pesWieWorkOrderOperationErp.getWorkCenterCode() == 3){
            //惠州电源工单
//            pesWieWorkOrderOperationErp.setWorkCenterId(dy);
            pesWieWorkOrderOperationErp.setOperationSequenceNumber(10);
            pesWieWorkOrderOperationErp.setStandardOperationCode("HZDY_01");
            pesWieWorkOrderOperationErp.setOperationType("IN_HOUSE");
            pesWieWorkOrderOperationErp.setOperationName("惠州电源加工");
            //创建10发料工序
            pesWieWorkOrderOperationErpMapper.insertPesWieWorkOrderOperationErp(pesWieWorkOrderOperationErp);
            //根据返回来的pesWorkOrderOperationId和pesWorkOrderId创建工单单身明细
            pesWieWoOperationMaterialsErpService.insertPesWieWoOperationMaterialsErp(pesWieWorkOrderOperationErp.getPesWorkOrderOperationId(),pesWieWorkOrderOperationErp.getWorkCenterCode());
            pesWieWorkOrderOperationErp.setOperationSequenceNumber(100);
            pesWieWorkOrderOperationErp.setStandardOperationCode("CK02");
            pesWieWorkOrderOperationErp.setOperationType("IN_HOUSE");
            pesWieWorkOrderOperationErp.setOperationName("完工");
            pesWieWorkOrderOperationErp.setWorkCenterId(pesWieWorkOrderOperationErp.getOrganizationId().longValue() == 300000004669869L?300000004927935L:pesWieWorkOrderOperationErp.getOrganizationId().longValue() == 300000004669879L?300000004937822L:300000040192899L);
        }
        if(pesWieWorkOrderOperationErp.getWorkCenterCode() == 4){
            //惠州电源工单费用料号
//            pesWieWorkOrderOperationErp.setWorkCenterId(free);
            pesWieWorkOrderOperationErp.setOperationSequenceNumber(10);
            pesWieWorkOrderOperationErp.setStandardOperationCode("INTER_FEE_1");
            pesWieWorkOrderOperationErp.setOperationType("IN_HOUSE");
            pesWieWorkOrderOperationErp.setOperationName("内部代加工工序");
            //创建10发料工序
            pesWieWorkOrderOperationErpMapper.insertPesWieWorkOrderOperationErp(pesWieWorkOrderOperationErp);
        }
        //插入100工序
        pesWieWorkOrderOperationErp.setOspItemId(0L);
        pesWieWorkOrderOperationErp.setSupplierId(0L);
        pesWieWorkOrderOperationErp.setOspItemNumber(null);
        pesWieWorkOrderOperationErp.setSupplierName(null);
        //创建100完工工序
        if(pesWieWorkOrderOperationErp.getWorkCenterCode()==1||pesWieWorkOrderOperationErp.getWorkCenterCode()==2||pesWieWorkOrderOperationErp.getWorkCenterCode()==3){
            pesWieWorkOrderOperationErpMapper.insertPesWieWorkOrderOperationErp(pesWieWorkOrderOperationErp);
        }
        //创建100完工工序,厂内生产工单需要创建资源工时
        return ((pesWieWorkOrderOperationErp.getWorkCenterCode()==1&&"Y".equals(lotNumFlag)||pesWieWorkOrderOperationErp.getWorkCenterCode()==4))?pesWieWorkOrderOperationResourceErpService.insertResourcePesWieWorkOrderOperationErpByOperationId(pesWieWorkOrderOperationErp.getPesWorkOrderId(),pesWieWorkOrderOperationErp.getPesWorkOrderOperationId()):1;
    }

    //接口回传
    @Override
    public int handleSubmitErpPesWieWorkOrdersBErpByIdsJob(String endName)
    {
        List<PesWieWorkOrderOperationErp> pesWieWorkOrdersBErp = pesWieWorkOrderOperationErpMapper.handleSubmitErpPesWieWorkOrdersBErpByIdsJob();
        if(pesWieWorkOrdersBErp.size() > 0){
            List<Long> pesWorkOrderIds = pesWieWorkOrdersBErp.stream().map(PesWieWorkOrderOperationErp::getPesWorkOrderId).collect(Collectors.toList());
            for(Long pesWorkOrderId:pesWorkOrderIds){
                handleSubmitErpPesOperationByIds(pesWorkOrderId,endName);
            }
        }
        return 1;
    }

    @Override
    public int handleSubmitErpPesOperationByIds(Long pesWorkOrderId,String endName)
    {
        Long ck = 300000004927935L;
        Long ck1 = 300000004937822L;
        Long ck2 = 300000040192899L;
        Long free = 300000049805474L;
        List<PesWieWorkOrderOperationErp> pesWieWorkOrderOperationErps= pesWieWorkOrderOperationErpMapper.selectPesWieWorkOrderOperationErpById(pesWorkOrderId);
       if(pesWieWorkOrderOperationErps.size() > 0){
           for(PesWieWorkOrderOperationErp pesWieWorkOrderOperationErp:pesWieWorkOrderOperationErps){

               //先获取API地址
               String getUpdWorkOperationUrl = ConfigUtils.getWieWorksOperationUrl().replace("{WorkOrderId}",String.valueOf(pesWieWorkOrderOperationErp.getWorkOrderId()));


               //Json头信息
               JSONObject requestJsonObject = new JSONObject();
               requestJsonObject.put("WorkOrderId", pesWieWorkOrderOperationErp.getWorkOrderId());
               requestJsonObject.put("OperationSequenceNumber", pesWieWorkOrderOperationErp.getOperationSequenceNumber());
               requestJsonObject.put("StandardOperationCode", pesWieWorkOrderOperationErp.getStandardOperationCode());
               requestJsonObject.put("OperationType", pesWieWorkOrderOperationErp.getOperationType());
               requestJsonObject.put("OperationName", pesWieWorkOrderOperationErp.getOperationName());
               if(pesWieWorkOrderOperationErp.getWorkCenterCode() == 1){
                   requestJsonObject.put("OperationDescription", pesWieWorkOrderOperationErp.getOperationSequenceNumber() == 10?operationDescriptionF:operationDescriptionS);
                   requestJsonObject.put("WorkCenterId", pesWieWorkOrderOperationErp.getWorkOrderId());
               }
               if(pesWieWorkOrderOperationErp.getWorkCenterCode() == 2){
                   requestJsonObject.put("OperationDescription", pesWieWorkOrderOperationErp.getOperationSequenceNumber() == 10?operationDescriptionOpsF:(pesWieWorkOrderOperationErp.getOperationSequenceNumber() == 20?operationDescriptionOpsS:operationDescriptionOpsT));
                   requestJsonObject.put("WorkCenterId", pesWieWorkOrderOperationErp.getWorkOrderId());
               }
               if("SUPPLIER".equals(pesWieWorkOrderOperationErp.getOperationType())&&pesWieWorkOrderOperationErp.getWorkCenterCode() == 2){
                   requestJsonObject.put("OSPItemId", pesWieWorkOrderOperationErp.getOspItemId());
                   requestJsonObject.put("SupplierId", pesWieWorkOrderOperationErp.getSupplierId());
                   requestJsonObject.put("SupplierSiteId", pesWieWorkOrderOperationErp.getSupplierSiteId());
                   requestJsonObject.put("ShippingDocumentsFlag", shippingDocumentsFlag);
               }
               if(pesWieWorkOrderOperationErp.getWorkCenterCode() == 3){
                   requestJsonObject.put("OperationDescription", "惠州电源加工工序");
                   requestJsonObject.put("WorkCenterId", pesWieWorkOrderOperationErp.getWorkOrderId());
               }
               if(pesWieWorkOrderOperationErp.getWorkCenterCode() == 4){
                   requestJsonObject.put("OperationDescription", "内部代加工工序");
                   requestJsonObject.put("WorkCenterId", pesWieWorkOrderOperationErp.getWorkOrderId());
               }
               if(pesWieWorkOrderOperationErp.getWorkCenterCode() == 2&&pesWieWorkOrderOperationErp.getOperationSequenceNumber() == 10){
                   requestJsonObject.put("CountPointOperationFlag",autoTransactFlag);
                   requestJsonObject.put("AutoTransactFlag",countPointOperationFlag);
               }else {
                   requestJsonObject.put("CountPointOperationFlag",countPointOperationFlag);
                   requestJsonObject.put("AutoTransactFlag",autoTransactFlag);
               }

               //Json转换
               String requestBody = requestJsonObject.toJSONString();
               try {
                   //发送POST请求
                   String responseBody = RestClient.postData(getUpdWorkOperationUrl, requestBody, CONTECT_TYPE, "UTF-8",ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
                   //返回值解析
                   JSONObject responseJsonObject = JSONObject.parseObject(responseBody);
                   Object workOrderOperationId = responseJsonObject.get("WorkOrderOperationId");

                   pesWieWorkOrderOperationErp.setErpType(0);
                   //调用成功
                   if (StringUtils.isNotNull(workOrderOperationId)) {
                       pesWieWorkOrderOperationErp.setWorkOrderOperationId(Long.valueOf(String.valueOf(workOrderOperationId)));
                       pesWieWorkOrderOperationErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                       pesWieWorkOrderOperationErp.setCreateDate(DateUtils.getNowDate());
                       pesWieWorkOrderOperationErp.setRemark("OK");
                       pesWieWorkOrderOperationErp.setErpFlag("1");
                       pesWieWorkOrderOperationErpMapper.updatePesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrderOperationErp);
                       //回传成功插入回传记录表
                       pesWieWorkOrderOperationErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrderOperationErp);
                       System.out.println("工序："+pesWieWorkOrderOperationErp.getOperationSequenceNumber());
                       if(pesWieWorkOrderOperationErp.getOperationSequenceNumber()==10){
                           pesWieWorkOrderOperationErpMapper.updatePesWieWorkOrdersBErpByWorkOrderOperationId(pesWieWorkOrderOperationErp);
                           //PES工单工序信息回传成功，开始回传PES单身明细信息
                           pesWieWoOperationMaterialsErpService.handleSubmitErpPesOperationMaterialByIds(pesWorkOrderId,endName);
                       }
                       if((ck.equals(pesWieWorkOrderOperationErp.getWorkCenterId())||ck1.equals(pesWieWorkOrderOperationErp.getWorkCenterId())||ck2.equals(pesWieWorkOrderOperationErp.getWorkCenterId())||free.equals(pesWieWorkOrderOperationErp.getWorkCenterId()))&&pesWieWorkOrderOperationErp.getOperationSequenceNumber()==100){
                           //PES工单100工序回传成功，开始回传PES资源工时信息
                           pesWieWorkOrderOperationResourceErpService.handleSubmitErpPesOperationMaterialResourceByIds(pesWieWorkOrderOperationErp.getPesWorkOrderOperationId(),endName);
                       }
                   }else {
                       pesWieWorkOrderOperationErp.setWorkOrderOperationId(0L);
                       pesWieWorkOrderOperationErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                       pesWieWorkOrderOperationErp.setCreateDate(DateUtils.getNowDate());
                       pesWieWorkOrderOperationErp.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+responseBody, 0, 4000));
                       pesWieWorkOrderOperationErp.setErpFlag("2");
                       pesWieWorkOrderOperationErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrderOperationErp);
                   }

               } catch (JSONException ex) {
                   pesWieWorkOrderOperationErp.setWorkOrderOperationId(0L);
                   pesWieWorkOrderOperationErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                   pesWieWorkOrderOperationErp.setCreateDate(DateUtils.getNowDate());
                   pesWieWorkOrderOperationErp.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+ex.getMessage(), 0, 4000));
                   pesWieWorkOrderOperationErp.setErpFlag("2");
                   pesWieWorkOrderOperationErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrderOperationErp);

               } catch (Exception ex) {
                   pesWieWorkOrderOperationErp.setWorkOrderOperationId(0L);
                   pesWieWorkOrderOperationErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                   pesWieWorkOrderOperationErp.setCreateDate(DateUtils.getNowDate());
                   pesWieWorkOrderOperationErp.setErpFlag("2");
                   pesWieWorkOrderOperationErp.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+ex.getMessage(), 0, 4000));
                   pesWieWorkOrderOperationErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrderOperationErp);
               }
           }
       }

        return 1;
    }

    @Override
    public boolean selectPesWieWorkOrdersOperationErpListById(Long pesWorkOrderId)
    {
        PesWieWorkOrderOperationErp pesWieWorkOrderOperationErp = pesWieWorkOrderOperationErpMapper.selectPesWieWorkOrdersOperationErpListById(pesWorkOrderId);
        return StringUtils.isNull(pesWieWorkOrderOperationErp.getOspItemId())?false:true;
    }

    @Override
    public int updateSubmitErpPesWieWorkOrdersOperationBErpByIdsJob(String endName)
    {
        List<PesWieWorkOrderOperationErp> pesWieWorkOrderOperationErps = pesWieWorkOrderOperationErpMapper.selectUpdatePesWieWorkOrdersOperationErpList();
        if(pesWieWorkOrderOperationErps.size() > 0){
            for(PesWieWorkOrderOperationErp pesWieWorkOrderOperationErp:pesWieWorkOrderOperationErps){

                //先获取API地址
                String getUpdWorkOperationUrl = ConfigUtils.getUpdateWieWorksOperationUrl().replace("{WorkOrderId}",String.valueOf(pesWieWorkOrderOperationErp.getWorkOrderId())).replace("{WorkOrderOperationId}",String.valueOf(pesWieWorkOrderOperationErp.getWorkOrderOperationId()));


                //Json头信息
                JSONObject requestJsonObject = new JSONObject();
                requestJsonObject.put("OSPItemId", pesWieWorkOrderOperationErp.getOspItemId());
                requestJsonObject.put("SupplierId", pesWieWorkOrderOperationErp.getSupplierId());
                requestJsonObject.put("SupplierSiteId", pesWieWorkOrderOperationErp.getSupplierSiteId());
                requestJsonObject.put("ShippingDocumentsFlag", shippingDocumentsFlag);

                //Json转换
                String requestBody = requestJsonObject.toJSONString();
                pesWieWorkOrderOperationErp.setErpType(1);
                try {
                    //发送POST请求
                    int responseBodySta = RestClient.patchData(getUpdWorkOperationUrl, requestBody, CONTECT_TYPE, "UTF-8",ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
                    //调用成功
                    if (responseBodySta==200) {
                        pesWieWorkOrderOperationErp.setCreateDate(DateUtils.getNowDate());
                        pesWieWorkOrderOperationErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                        pesWieWorkOrderOperationErp.setRemark("OK");
                        pesWieWorkOrderOperationErp.setErpFlag("1");
                        //回传成功插入回传记录表
                        pesWieWorkOrderOperationErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrderOperationErp);
                        //回传成功更新erp_submit_date
                        pesWieWorkOrderOperationErpMapper.updatePesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrderOperationErp);
                        System.out.println("工序序号："+pesWieWorkOrderOperationErp.getOperationSequenceNumber()+"，费用料号："+pesWieWorkOrderOperationErp.getOspItemNumber()+"，外协供应商："+pesWieWorkOrderOperationErp.getSupplierName());
                    }else {
                        pesWieWorkOrderOperationErp.setCreateDate(DateUtils.getNowDate());
                        pesWieWorkOrderOperationErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                        pesWieWorkOrderOperationErp.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+responseBodySta, 0, 4000));
                        pesWieWorkOrderOperationErp.setErpFlag("2");
                        //回传成功插入回传记录表
                        pesWieWorkOrderOperationErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrderOperationErp);
                    }

                } catch (JSONException ex) {
                    pesWieWorkOrderOperationErp.setCreateDate(DateUtils.getNowDate());
                    pesWieWorkOrderOperationErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                    pesWieWorkOrderOperationErp.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+ex.getMessage(), 0, 4000));
                    pesWieWorkOrderOperationErp.setErpFlag("2");
                    //回传成功插入回传记录表
                    pesWieWorkOrderOperationErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrderOperationErp);

                } catch (Exception ex) {
                    pesWieWorkOrderOperationErp.setCreateBy("userName".equals(endName)?SecurityUtils.getUsername():"INTG_ADMIN");
                    pesWieWorkOrderOperationErp.setCreateDate(DateUtils.getNowDate());
                    pesWieWorkOrderOperationErp.setRemark(StringUtils.substring("报文："+requestBody+"，异常信息："+ex.getMessage(), 0, 4000));
                    pesWieWorkOrderOperationErp.setErpFlag("2");
                    //回传成功插入回传记录表
                    pesWieWorkOrderOperationErpMapper.insertPesWieWorkOrdersBErpByWorkOrderId(pesWieWorkOrderOperationErp);
                }
            }
        }
        return 1;
    }

    @Override
    public PesWieWorkOrderOperationErp selectPesWieWorkOrderOperationOspErpById(Long pesWorkOrderOperationId)
    {
        return pesWieWorkOrderOperationErpMapper.selectPesWieWorkOrderOperationOspErpById(pesWorkOrderOperationId);
    }
}
