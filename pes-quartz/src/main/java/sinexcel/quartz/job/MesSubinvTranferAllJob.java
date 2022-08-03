//package sinexcel.quartz.job;
//
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import sinexcel.common.utils.ConfigUtils;
//import sinexcel.common.utils.InSoapUtil;
//import sinexcel.common.utils.RestClient;
//import sinexcel.quartz.domain.MesSubinventoryTransferAllEO;
//import sinexcel.quartz.domain.SysJobLog;
//import sinexcel.quartz.mapper.MesSubinventoryTransferAllMapper;
//import sinexcel.quartz.mapper.SysJobLogMapper;
//import sinexcel.quartz.util.WorkMaterialUtils;
//
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//
//@Component("mesSubinvTranferAllJob")
//public class MesSubinvTranferAllJob{
//
//    public static final String CONTECT_TYPE = "application/vnd.oracle.adf.resourceitem+json";
//
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    String lotNumber = null;
//
//    @Autowired
//    private MesSubinventoryTransferAllMapper mesSubinventoryTransferAllMapper;
//
//    @Autowired
//
//    private SysJobLogMapper sysJobLogMapper;
//
//
//    public void report() {
//
//        SysJobLog log = new SysJobLog();
//        log.setJobName("MesSubinvTranferAllJob");
//        log.setStopTime(new Date());
//        //系统时间转换成格林威治时间
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(log.getStopTime().getTime());
//        cal.add(Calendar.HOUR, -8);
//
//        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
//        if (lastSucLog != null) {
//            log.setStartTime(lastSucLog.getToDate());
//        }
//
//        MesSubinventoryTransferAllEO subinventoryTransferAll = new MesSubinventoryTransferAllEO();
//        subinventoryTransferAll.setStartUpdateDate(sdf.format(log.getStartTime()));
//        subinventoryTransferAll.setEndUpdateDate(sdf.format(log.getStopTime()));
//
//
//        List<MesSubinventoryTransferAllEO> subTrnLists = mesSubinventoryTransferAllMapper.getSubinvTranferList(subinventoryTransferAll);
//
//        sysJobLogMapper.updateLatUpdateDate(log);
//
//        if (subTrnLists.size() > 0) {
//
//            int batchCount = 50;//每批处理的条数
//            int batchLastIndex = batchCount - 1;// 每批最后一个的下标
//            for (int index = 0; index < subTrnLists.size(); ) {
//                if (batchLastIndex > (subTrnLists.size() - 1)) {
//                    batchLastIndex = subTrnLists.size() - 1;
//                    batchSyncWorkOrderTransferQuantityList(subTrnLists.subList(index, (batchLastIndex + 1)),sdf.format(cal.getTime()));
//                    break;// 数据插入完毕,退出循环
//                } else {
//                    batchSyncWorkOrderTransferQuantityList(subTrnLists.subList(index, (batchLastIndex + 1)),sdf.format(cal.getTime()));
//                    index = batchLastIndex + 1;// 设置下一批下标
//                    batchLastIndex = index + (batchCount - 1);
//                }
//            }
//        }
//    }
//
//    public void batchSyncWorkOrderTransferQuantityList(List<MesSubinventoryTransferAllEO> lists,String nowTime){
//
//            int failureNum = 0;
//            StringBuilder failureMsg = new StringBuilder();
//            JSONObject requestJsonObject = new JSONObject();
//            List transactionLines = new ArrayList<>();
//            List<MesSubinventoryTransferAllEO> xbcWieMaterialQuantityList = new ArrayList<>();
//            for(MesSubinventoryTransferAllEO subTrnList : lists) {
//                //把json串拼接
//                JSONObject requestJsonLObject = new JSONObject();
//
//                requestJsonLObject.put("OrganizationId", subTrnList.getFromOrganizationId());
//                requestJsonLObject.put("InventoryItemId", subTrnList.getInventoryItemId());
//                requestJsonLObject.put("Subinventory", subTrnList.getSubinventoryCode());
//                requestJsonLObject.put("TransactionTypeId", subTrnList.getTransactionTypeId());
//                requestJsonLObject.put("TransactionUnitOfMeasure", subTrnList.getUomCode());
//                requestJsonLObject.put("TransactionQuantity", subTrnList.getQuantity());
//                requestJsonLObject.put("TransactionDate", nowTime);
//                requestJsonLObject.put("TransferSubinventory", subTrnList.getTransferSubinventoryCode());
//                requestJsonLObject.put("TransactionSourceName", subTrnList.getRemart());
//
//                //判断是否启用批次控制
//                //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
//                if (subTrnList.getLotControlCode() == 2) {
//                    List transactionLots = new ArrayList<>();
//                    JSONObject requestJsonLotObject = new JSONObject();
//                    requestJsonLotObject.put("LotNumber", "QC201810");
//                    requestJsonLotObject.put("TransactionQuantity", subTrnList.getQuantity());
//                    transactionLots.add(requestJsonLotObject);
//                    requestJsonLObject.put("lotItemLots", transactionLots);
//                }
//                transactionLines.add(requestJsonLObject);
//                //添加线边仓调拨数据
//                if(("XBC".equals(subTrnList.getTransferSubinventoryCode())||subTrnList.getTransferSubinventoryCode().startsWith("3"))&&subTrnList.getWorkOrderId().longValue()>0){
//                    MesSubinventoryTransferAllEO selectTransferedQuantity = mesSubinventoryTransferAllMapper.selectTransferedQuantity(subTrnList);
//                    subTrnList.setTransferedQuantity(selectTransferedQuantity.getTransferedQuantity());
//                    xbcWieMaterialQuantityList.add(subTrnList);
//                }
//            }
//
//            requestJsonObject.put("transactionLines", transactionLines);
//            String requestBody = requestJsonObject.toJSONString();
////                System.out.println(requestBody);
//
//            //发送POST请求
//                String responseBody = null;
//                try {
//                    responseBody = RestClient.postData(ConfigUtils.getSubinvTrnUrl(), requestBody, CONTECT_TYPE, "UTF-8",ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
//                //返回值解析
//            JSONObject responseJsonObject = JSONObject.parseObject(responseBody);
//            String returnStatus = responseJsonObject.get("ReturnStatus").toString();
//            //是否成功判断
//            if("SUCCESS".equals(returnStatus)){
//                    //回写ERP成功标识
//                mesSubinventoryTransferAllMapper.updateErpFlagS(lists);
//                //更新调拨数据
//                mesSubinventoryTransferAllMapper.updateWieItemMaterialsTransferQuantityByIds(xbcWieMaterialQuantityList);
//                //工单自动扣账
//                pesWieWorkMaterialsAutoSubmitErp(xbcWieMaterialQuantityList,nowTime);
////                if(("XBC".equals(subTrnList.getTransferSubinventoryCode())||subTrnList.getTransferSubinventoryCode().startsWith("3"))&&subTrnList.getWorkOrderId().longValue()>0){
////                    MesSubinventoryTransferAllEO selectTransferedQuantity = mesSubinventoryTransferAllMapper.selectTransferedQuantity(subTrnList);
////                    subTrnList.setTransferedQuantity(selectTransferedQuantity.getTransferedQuantity());
////                    mesSubinventoryTransferAllMapper.updateWieItemMaterialsTransferQuantityByIds(xbcWieMaterialQuantityList);
////                    //工单自动扣账
////                    pesWieWorkMaterialsAutoSubmitErp(xbcWieMaterialQuantityList,sdf.format(cal.getTime()));
////                }
//            }else {
//                String ErrorExplanation = responseJsonObject.get("ErrorExplanation").toString();
//                    //回写ERP失败标识
////                subTrnList.setErpFlag("2");
//                System.out.println( "调拨异常信息："+ErrorExplanation);
////                mesSubinventoryTransferAllMapper.updateErpFlag(subTrnList);
//            }
//                } catch (Exception e) {
////                    subTrnList.setErpFlag("2");
//                    System.out.println( "调拨异常信息："+e.getMessage());
////                    mesSubinventoryTransferAllMapper.updateErpFlag(subTrnList);
//                }
//    }
//
//    public void pesWieWorkMaterialsAutoSubmitErp(List<MesSubinventoryTransferAllEO> lists,String dateNow) {
//        //工单扣账
//                //判断是否启用批次控制
//                //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
//                if(subTrnList.getLotControlCode()== 2){
//                    lotNumber = "QC201810";
//                }else {
//                    lotNumber = "NULL";
//                }
//
//        String xmlStr = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/types/\" xmlns:ns2=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/\">\n" +
//                "<soap:Body>\n" +
//                "<ns1:createWorkOrderMaterialTransactions>\n" +
//                "<ns1:batchInput>\n" +
//                "<ns2:MaterialTransactionInput>\n" +
//                "<ns2:HeaderNumber>HN_001</ns2:HeaderNumber>\n" +
//                "<ns2:WorkOrderNumber>" + subTrnList.getWorkOrderNumber() + "</ns2:WorkOrderNumber>\n" +
//                "<ns2:OperationSequence>10</ns2:OperationSequence>\n" +
//                "<ns2:TransactionType>MATERIAL_ISSUE</ns2:TransactionType>\n" +
//                "<ns2:InventoryItemNumber>" + subTrnList.getItemNumber() + "</ns2:InventoryItemNumber>\n" +
//                "<ns2:Organization>" + subTrnList.getOrganizationCode() + "</ns2:Organization>\n" +
//                "<ns2:TransactionQuantity unitCode=\"" + subTrnList.getUomCode() + "\">" + subTrnList.getQuantity() + "</ns2:TransactionQuantity>\n" +
//                "<ns2:Subinventory>" + subTrnList.getTransferSubinventoryCode() + "</ns2:Subinventory>\n" +
//                "<ns2:SourceHeaderReference>" + dateNow + "</ns2:SourceHeaderReference>\n" +
//                "<ns2:TransactionLotInput>\n" +
//                "<ns2:LotNumber>" + lotNumber + "</ns2:LotNumber>\n" +
//                "<ns2:TransactionQuantity>" + subTrnList.getQuantity() + "</ns2:TransactionQuantity>\n" +
//                "</ns2:TransactionLotInput>\n" +
//                "</ns2:MaterialTransactionInput>\n" +
//                "</ns1:batchInput>\n" +
//                "</ns1:createWorkOrderMaterialTransactions>\n" +
//                "</soap:Body>\n" +
//                "</soap:Envelope>";
//
//                String scode = null;
//                try {
//                    scode = WorkMaterialUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getWorkMaterialUrl(),ConfigUtils.getWorkMaterialName(),ConfigUtils.getWorkMaterialMethodName()));
//                    if("COMPLETED".equals(scode)){
//                        System.out.println("工单号："+subTrnList.getWorkOrderNumber()+"，组件编码："+subTrnList.getItemNumber()+"，扣账数量："+subTrnList.getQuantity());
//               }
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//    }
//}


package sinexcel.quartz.job;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.common.utils.RestClient;
import sinexcel.quartz.domain.MesSubinventoryTransferAllEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.MesSubinventoryTransferAllMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.util.WorkMaterialUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


@Component("mesSubinvTranferAllJob")
public class MesSubinvTranferAllJob{

    public static final String CONTECT_TYPE = "application/vnd.oracle.adf.resourceitem+json";

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String lotNumber = null;

    @Autowired
    private MesSubinventoryTransferAllMapper mesSubinventoryTransferAllMapper;

    @Autowired

    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    Logger logger = LoggerFactory.getLogger(this.getClass());


    public void report() {

        SysJobLog log = new SysJobLog();
        log.setJobName("MesSubinvTranferAllJob");
        log.setStopTime(new Date());
        //系统时间转换成格林威治时间
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(log.getStopTime() .getTime());
        cal.add(Calendar.HOUR, -8);

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        MesSubinventoryTransferAllEO subinventoryTransferAll = new MesSubinventoryTransferAllEO();
        subinventoryTransferAll.setStartUpdateDate(sdf.format(log.getStartTime()));
        subinventoryTransferAll.setEndUpdateDate(sdf.format(log.getStopTime()));


        List<MesSubinventoryTransferAllEO> subTrnLists = mesSubinventoryTransferAllMapper.getSubinvTranferList(subinventoryTransferAll);

        sysJobLogMapper.updateLatUpdateDate(log);

        if(subTrnLists.size() > 0){
            int failureNum = 0;
            StringBuilder failureMsg = new StringBuilder();
            for(MesSubinventoryTransferAllEO subTrnList : subTrnLists){
                //工单退料
                if(("XBC".equals(subTrnList.getSubinventoryCode())||subTrnList.getSubinventoryCode().startsWith("3"))&&subTrnList.getWorkOrderId().longValue()>0){
//                            MesSubinventoryTransferAllEO selectTransferedQuantity = mesSubinventoryTransferAllMapper.selectTransferedQuantity(subTrnList);
                    subTrnList.setTransferedQuantity(subTrnList.getQuantity());
//                            subTrnList.setOverQuantity(selectTransferedQuantity.getOverQuantity());
                    //工单自动扣账
                    String materialType = "MATERIAL_RETURN";
                    int i = pesWieWorkMaterialsAutoSubmitErp(subTrnList,sdf.format(cal.getTime()),materialType,subTrnList.getSubinventoryCode());
                    if(i > 0){
                        mesSubinventoryTransferAllMapper.updateWieItemReturnMaterialsTransferQuantityByIds(subTrnList);
                    }
                }

                JSONObject requestJsonObject = new JSONObject();
                List transactionLines = new ArrayList<>();
                //把json串拼接
                JSONObject requestJsonLObject = new JSONObject();

                requestJsonLObject.put("OrganizationId", subTrnList.getFromOrganizationId());
                requestJsonLObject.put("InventoryItemId", subTrnList.getInventoryItemId());
                requestJsonLObject.put("Subinventory", subTrnList.getSubinventoryCode());
                requestJsonLObject.put("TransactionTypeId", subTrnList.getTransactionTypeId());
                requestJsonLObject.put("TransactionUnitOfMeasure", subTrnList.getUomCode());
                requestJsonLObject.put("TransactionQuantity", subTrnList.getQuantity());
                requestJsonLObject.put("TransactionDate", sdf.format(cal.getTime()));
                requestJsonLObject.put("TransferSubinventory", subTrnList.getTransferSubinventoryCode());
                requestJsonLObject.put("TransactionSourceName", subTrnList.getRemart());

                transactionLines.add(requestJsonLObject);

                //判断是否启用批次控制
                //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
                if (subTrnList.getLotControlCode()== 2) {
                    List transactionLots = new ArrayList<>();
                    JSONObject requestJsonLotObject = new JSONObject();
                    requestJsonLotObject.put("LotNumber", "QC201810");
                    requestJsonLotObject.put("TransactionQuantity", subTrnList.getQuantity());
                    transactionLots.add(requestJsonLotObject);
                    requestJsonLObject.put("lotItemLots", transactionLots);
                }

                requestJsonObject.put("transactionLines", transactionLines);
                String requestBody = requestJsonObject.toJSONString();
//                System.out.println(requestBody);

                //发送POST请求
                String responseBody = null;
                try {
                    responseBody = RestClient.postData(ConfigUtils.getSubinvTrnUrl(), requestBody, CONTECT_TYPE, "UTF-8",ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
                    //返回值解析
                    JSONObject responseJsonObject = JSONObject.parseObject(responseBody);
                    String returnStatus = responseJsonObject.get("ReturnStatus").toString();
                    //是否成功判断
                    if("SUCCESS".equals(returnStatus)){
                        //回写ERP成功标识
                        subTrnList.setErpFlag("1");
                        subTrnList.setErrorInfor("OK");
                        mesSubinventoryTransferAllMapper.updateErpFlag(subTrnList);
                        logger.info("调拨单："+subTrnList.getRemart()+"，物料编码："+subTrnList.getItemNumber()+"，调拨仓："+subTrnList.getSubinventoryCode()+"，调拨数量："+subTrnList.getQuantity()+"，转移仓："+subTrnList.getTransferSubinventoryCode());
                        //工单扣料
                        if(("XBC".equals(subTrnList.getTransferSubinventoryCode())||subTrnList.getTransferSubinventoryCode().startsWith("3"))&&subTrnList.getWorkOrderId().longValue()>0){
                            MesSubinventoryTransferAllEO selectTransferedQuantity = mesSubinventoryTransferAllMapper.selectTransferedQuantity(subTrnList);
                            subTrnList.setTransferedQuantity(selectTransferedQuantity.getTransferedQuantity());
                            subTrnList.setOverQuantity(selectTransferedQuantity.getOverQuantity());
                            mesSubinventoryTransferAllMapper.updateWieItemMaterialsTransferQuantityByIds(subTrnList);
                            //工单自动扣账
                            String materialType = "MATERIAL_ISSUE";
                            subTrnList.setSourceHeaderReference(sdf.format(cal.getTime()));
                            subTrnList.setTransactionType(materialType);
                            subTrnList.setSubinventoryCode(subTrnList.getTransferSubinventoryCode());
                            //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
                            rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", subTrnList);
//                            pesWieWorkMaterialsAutoSubmitErp(subTrnList,sdf.format(cal.getTime()),materialType,subTrnList.getTransferSubinventoryCode());
                        }
                    }else {
                        String ErrorExplanation = responseJsonObject.get("ErrorExplanation").toString();
                        //回写ERP失败标识
                        subTrnList.setErpFlag("2");
                        subTrnList.setErrorInfor( "【调拨 ID："+subTrnList.getTransferId()+"；"+"MES主键："+subTrnList.getRemart()+"；】"+ErrorExplanation);
                        mesSubinventoryTransferAllMapper.updateErpFlag(subTrnList);
                    }
                } catch (Exception e) {
                    subTrnList.setErpFlag("2");
                    subTrnList.setErrorInfor( "【调拨 ID："+subTrnList.getTransferId()+"；"+"MES主键："+subTrnList.getRemart()+"；】"+e.getMessage());
                    mesSubinventoryTransferAllMapper.updateErpFlag(subTrnList);
                }
            }
        }
    }

    public int pesWieWorkMaterialsAutoSubmitErp(MesSubinventoryTransferAllEO subTrnList,String dateNow,String materialType,String subinventoryCode) {
        //工单扣账
        //判断是否启用批次控制
        //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
        if(subTrnList.getLotControlCode()== 2){
            lotNumber = "QC201810";
        }else {
            lotNumber = "NULL";
        }

        int i = 0;
        String xmlStr = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/types/\" xmlns:ns2=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/\">\n" +
                "<soap:Body>\n" +
                "<ns1:createWorkOrderMaterialTransactions>\n" +
                "<ns1:batchInput>\n" +
                "<ns2:MaterialTransactionInput>\n" +
                "<ns2:HeaderNumber>HN_001</ns2:HeaderNumber>\n" +
                "<ns2:WorkOrderNumber>" + subTrnList.getWorkOrderNumber() + "</ns2:WorkOrderNumber>\n" +
                "<ns2:OperationSequence>10</ns2:OperationSequence>\n" +
                "<ns2:TransactionType>"+materialType+"</ns2:TransactionType>\n" +
                "<ns2:InventoryItemNumber>" + subTrnList.getItemNumber() + "</ns2:InventoryItemNumber>\n" +
                "<ns2:Organization>" + subTrnList.getOrganizationCode() + "</ns2:Organization>\n" +
                "<ns2:TransactionQuantity unitCode=\"" + subTrnList.getUomCode() + "\">" + subTrnList.getQuantity() + "</ns2:TransactionQuantity>\n" +
                "<ns2:Subinventory>" + subinventoryCode + "</ns2:Subinventory>\n" +
                "<ns2:SourceHeaderReference>" + subTrnList.getRemart() + "</ns2:SourceHeaderReference>\n" +
                "<ns2:TransactionLotInput>\n" +
                "<ns2:LotNumber>" + lotNumber + "</ns2:LotNumber>\n" +
                "<ns2:TransactionQuantity>" + subTrnList.getQuantity() + "</ns2:TransactionQuantity>\n" +
                "</ns2:TransactionLotInput>\n" +
                "</ns2:MaterialTransactionInput>\n" +
                "</ns1:batchInput>\n" +
                "</ns1:createWorkOrderMaterialTransactions>\n" +
                "</soap:Body>\n" +
                "</soap:Envelope>";

        String scode = null;
        try {
            scode = WorkMaterialUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getWorkMaterialUrl(),ConfigUtils.getWorkMaterialName(),ConfigUtils.getWorkMaterialMethodName()));
            if("COMPLETED".equals(scode)){
                i = "MATERIAL_ISSUE".equals(materialType)?mesSubinventoryTransferAllMapper.updateWieItemMaterialsIssuedQuantityByIds(subTrnList):mesSubinventoryTransferAllMapper.updateWieItemReturnMaterialsIssuedQuantityByIds(subTrnList);
                logger.info("工单号："+subTrnList.getWorkOrderNumber()+"，组件编码："+subTrnList.getItemNumber()+"，扣账数量："+subTrnList.getQuantity());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return i;
    }

    @RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
    public void mqPesWieWorkMaterialsAutoSubmitErp(MesSubinventoryTransferAllEO subTrnList) {
        //工单扣账
        //判断是否启用批次控制
        //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
        if(subTrnList.getLotControlCode()== 2){
            lotNumber = "QC201810";
        }else {
            lotNumber = "NULL";
        }

        String xmlStr = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/types/\" xmlns:ns2=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/\">\n" +
                "<soap:Body>\n" +
                "<ns1:createWorkOrderMaterialTransactions>\n" +
                "<ns1:batchInput>\n" +
                "<ns2:MaterialTransactionInput>\n" +
                "<ns2:HeaderNumber>HN_001</ns2:HeaderNumber>\n" +
                "<ns2:WorkOrderNumber>" + subTrnList.getWorkOrderNumber() + "</ns2:WorkOrderNumber>\n" +
                "<ns2:OperationSequence>10</ns2:OperationSequence>\n" +
                "<ns2:TransactionType>"+subTrnList.getTransactionType()+"</ns2:TransactionType>\n" +
                "<ns2:InventoryItemNumber>" + subTrnList.getItemNumber() + "</ns2:InventoryItemNumber>\n" +
                "<ns2:Organization>" + subTrnList.getOrganizationCode() + "</ns2:Organization>\n" +
                "<ns2:TransactionQuantity unitCode=\"" + subTrnList.getUomCode() + "\">" + subTrnList.getQuantity() + "</ns2:TransactionQuantity>\n" +
                "<ns2:Subinventory>" + subTrnList.getSubinventoryCode() + "</ns2:Subinventory>\n" +
                "<ns2:SourceHeaderReference>" + subTrnList.getRemart() + "</ns2:SourceHeaderReference>\n" +
                "<ns2:TransactionLotInput>\n" +
                "<ns2:LotNumber>" + lotNumber + "</ns2:LotNumber>\n" +
                "<ns2:TransactionQuantity>" + subTrnList.getQuantity() + "</ns2:TransactionQuantity>\n" +
                "</ns2:TransactionLotInput>\n" +
                "</ns2:MaterialTransactionInput>\n" +
                "</ns1:batchInput>\n" +
                "</ns1:createWorkOrderMaterialTransactions>\n" +
                "</soap:Body>\n" +
                "</soap:Envelope>";

        String scode = null;
        try {
            scode = WorkMaterialUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getWorkMaterialUrl(),ConfigUtils.getWorkMaterialName(),ConfigUtils.getWorkMaterialMethodName()));
            if("COMPLETED".equals(scode)){
                mesSubinventoryTransferAllMapper.updateWieItemMaterialsIssuedQuantityByIds(subTrnList);
                logger.info("【MQ1】Remark："+subTrnList.getRemart()+"，工单号："+subTrnList.getWorkOrderNumber()+"，组件编码："+subTrnList.getItemNumber()+"，扣账数量："+subTrnList.getQuantity());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
    public void mqSencPesWieWorkMaterialsAutoSubmitErp(MesSubinventoryTransferAllEO subTrnList) {
        //工单扣账
        //判断是否启用批次控制
        //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
        if(subTrnList.getLotControlCode()== 2){
            lotNumber = "QC201810";
        }else {
            lotNumber = "NULL";
        }

        String xmlStr = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/types/\" xmlns:ns2=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/\">\n" +
                "<soap:Body>\n" +
                "<ns1:createWorkOrderMaterialTransactions>\n" +
                "<ns1:batchInput>\n" +
                "<ns2:MaterialTransactionInput>\n" +
                "<ns2:HeaderNumber>HN_001</ns2:HeaderNumber>\n" +
                "<ns2:WorkOrderNumber>" + subTrnList.getWorkOrderNumber() + "</ns2:WorkOrderNumber>\n" +
                "<ns2:OperationSequence>10</ns2:OperationSequence>\n" +
                "<ns2:TransactionType>"+subTrnList.getTransactionType()+"</ns2:TransactionType>\n" +
                "<ns2:InventoryItemNumber>" + subTrnList.getItemNumber() + "</ns2:InventoryItemNumber>\n" +
                "<ns2:Organization>" + subTrnList.getOrganizationCode() + "</ns2:Organization>\n" +
                "<ns2:TransactionQuantity unitCode=\"" + subTrnList.getUomCode() + "\">" + subTrnList.getQuantity() + "</ns2:TransactionQuantity>\n" +
                "<ns2:Subinventory>" + subTrnList.getSubinventoryCode() + "</ns2:Subinventory>\n" +
                "<ns2:SourceHeaderReference>" + subTrnList.getRemart() + "</ns2:SourceHeaderReference>\n" +
                "<ns2:TransactionLotInput>\n" +
                "<ns2:LotNumber>" + lotNumber + "</ns2:LotNumber>\n" +
                "<ns2:TransactionQuantity>" + subTrnList.getQuantity() + "</ns2:TransactionQuantity>\n" +
                "</ns2:TransactionLotInput>\n" +
                "</ns2:MaterialTransactionInput>\n" +
                "</ns1:batchInput>\n" +
                "</ns1:createWorkOrderMaterialTransactions>\n" +
                "</soap:Body>\n" +
                "</soap:Envelope>";

        String scode = null;
        try {
            scode = WorkMaterialUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getWorkMaterialUrl(),ConfigUtils.getWorkMaterialName(),ConfigUtils.getWorkMaterialMethodName()));
            if("COMPLETED".equals(scode)){
                mesSubinventoryTransferAllMapper.updateWieItemMaterialsIssuedQuantityByIds(subTrnList);
                logger.info("【MQ2】Remark："+subTrnList.getRemart()+"，工单号："+subTrnList.getWorkOrderNumber()+"，组件编码："+subTrnList.getItemNumber()+"，扣账数量："+subTrnList.getQuantity());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
