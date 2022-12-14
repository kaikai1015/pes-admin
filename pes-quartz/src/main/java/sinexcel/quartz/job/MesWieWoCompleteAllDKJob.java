package sinexcel.quartz.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.common.utils.RestClient;
import sinexcel.common.utils.StringUtils;
import sinexcel.quartz.domain.MesWieWoCompleteAllDKEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.MesWieWoCompleteAllDKMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.util.WorkMaterialUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


@Component("mesWieWoCompleteAllDKJob")
public class MesWieWoCompleteAllDKJob{

    public static final String sourceSystemCode = "EXTERNAL";
    public static final String sourceSystemType = "EXTERNAL";
    public static final String lotNumbers = "QC201810";
    public static final String CONTECT_TYPE = "application/vnd.oracle.adf.resourceitem+json";

    String lotNumber = null;
    BigDecimal transaQuantity;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    @Autowired
    private MesWieWoCompleteAllDKMapper mesWieWoCompleteAllDKMapper;

    @Autowired

    private SysJobLogMapper sysJobLogMapper;


    public void report() {

        SysJobLog log = new SysJobLog();
        log.setJobName("MesWieWoCompleteAllDKJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        MesWieWoCompleteAllDKEO mesWieWoCompleteAllDk = new MesWieWoCompleteAllDKEO();
        mesWieWoCompleteAllDk.setStartUpdateDate(sdf.format(log.getStartTime()));
        mesWieWoCompleteAllDk.setEndUpdateDate(sdf.format(log.getStopTime()));


        List<MesWieWoCompleteAllDKEO> wieWoCompleteDkLists = mesWieWoCompleteAllDKMapper.getWieWoCompleteList(mesWieWoCompleteAllDk);

        sysJobLogMapper.updateLatUpdateDate(log);

        if(wieWoCompleteDkLists.size() > 0){
            for(MesWieWoCompleteAllDKEO wieWoCompleteDkList : wieWoCompleteDkLists){
//                //????????????????????????????????????
                int failureNum = 0;
//                StringBuilder failureMsg = new StringBuilder();
//                //??????????????????
                MesWieWoCompleteAllDKEO orgCode = mesWieWoCompleteAllDKMapper.selectOrgnazationCode(wieWoCompleteDkList.getOrganizationId());
                //???????????????????????????????????????
//                List<MesWieWoCompleteAllDKEO> getWorkDemandLists = mesWieWoCompleteAllDKMapper.getWorkDemandLists(wieWoCompleteDkList);
//                if(getWorkDemandLists.size() > 0){
//                    for(MesWieWoCompleteAllDKEO getWorkDemandList : getWorkDemandLists){
//                        String subinventoryCode = (getWorkDemandList.getItemWorkNameFlag()=="4"||"4".equals(getWorkDemandList.getItemWorkNameFlag()))? "3FCKL001":getWorkDemandList.getSubinventoryCode();
//                        //??????????????? + ????????????* ?????? - ????????? = ????????????
//                        MesWieWoCompleteAllDKEO getTranQuantity = mesWieWoCompleteAllDKMapper.getTranQuantity(getWorkDemandList);
//                        if(!(getWorkDemandList.getItemWorkNameFlag()=="4"||"4".equals(getWorkDemandList.getItemWorkNameFlag()))){
//                            if(StringUtils.isNotNull(getTranQuantity)){
//                                transaQuantity = (getTranQuantity.getBasisType()=="2"||"2".equals(getTranQuantity.getBasisType()))? getTranQuantity.getRequiredQuantity():getWorkDemandList.getTransactionQuantity().add(getTranQuantity.getCompletedQuantity()).subtract(getTranQuantity.getIssuedQuantity());
//                                if((transaQuantity.compareTo(BigDecimal.ZERO)==1)&&(getTranQuantity.getRequiredQuantity().compareTo(getTranQuantity.getIssuedQuantity())==1)){
//                                    //??????????????????????????????
//                                    //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 ????????? 1 ?????????
//                                    if(getWorkDemandList.getLotControlCode()== 2){
//                                        lotNumber = "                    <ns2:TransactionLotInput>\n" +
//                                                "                        <ns2:LotNumber>QC201810</ns2:LotNumber>\n" +
//                                                "                        <ns2:TransactionQuantity>"+transaQuantity+"</ns2:TransactionQuantity>\n" +
//                                                "                    </ns2:TransactionLotInput>\n";
//                                    }else {
//                                        lotNumber = "";
//                                    }
//
//                                    //???????????????????????????????????????
//                                    Calendar cal = Calendar.getInstance();
//                                    cal.setTimeInMillis(log.getStopTime() .getTime());
//                                    cal.add(Calendar.HOUR, -8);
//                                    String xmlStr = "<soap:Envelope\n" +
//                                            "    xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
//                                            "    xmlns:ns1=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/types/\"\n" +
//                                            "    xmlns:ns2=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/\">\n" +
//                                            "    <soap:Body>\n" +
//                                            "        <ns1:createWorkOrderMaterialTransactions>\n" +
//                                            "            <ns1:batchInput>\n" +
//                                            "                <ns2:MaterialTransactionInput>\n" +
//                                            "                    <ns2:WorkOrderNumber>"+getWorkDemandList.getWorkOrderNumber()+"</ns2:WorkOrderNumber>\n" +
//                                            "                    <ns2:OperationSequence>10</ns2:OperationSequence>\n" +
//                                            "                    <ns2:TransactionType>MATERIAL_ISSUE</ns2:TransactionType>\n" +
//                                            "                    <ns2:InventoryItemNumber>"+getWorkDemandList.getItemNumber()+"</ns2:InventoryItemNumber>\n" +
//                                            "                    <ns2:Organization>"+orgCode.getOrganizationCode()+"</ns2:Organization>\n" +
//                                            "                    <ns2:TransactionQuantity unitCode=\""+getWorkDemandList.getUomCode()+"\">"+transaQuantity+"</ns2:TransactionQuantity>\n" +
//                                            "                    <ns2:TransactionDate>"+sdf1.format(cal.getTime())+"</ns2:TransactionDate>\n" +
//                                            "                    <ns2:Subinventory>"+subinventoryCode+"</ns2:Subinventory>\n" +
//                                            "                    <ns2:SourceHeaderReference>"+getWorkDemandList.getRemark()+"</ns2:SourceHeaderReference>\n"
//                                            + lotNumber+
//                                            "                </ns2:MaterialTransactionInput>\n" +
//                                            "            </ns1:batchInput>\n" +
//                                            "        </ns1:createWorkOrderMaterialTransactions>\n" +
//                                            "    </soap:Body>\n" +
//                                            "</soap:Envelope>";
//
//                                    String scode = null;
//                                    try {
//                                        scode = WorkMaterialUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getWorkMaterialUrl(),ConfigUtils.getWorkMaterialName(),ConfigUtils.getWorkMaterialMethodName()));
//                                        if("COMPLETED".equals(scode)){
//                                            mesWieWoCompleteAllDk.setErpFlag("1");
//                                            mesWieWoCompleteAllDk.setWieLineId(getWorkDemandList.getWieLineId());
//                                            mesWieWoCompleteAllDk.setTransactionQuantity(transaQuantity);
//                                            //??????ERP????????????
//                                            mesWieWoCompleteAllDk.setErrorInfor("OK");
//                                            mesWieWoCompleteAllDKMapper.updateLineErpFlag(mesWieWoCompleteAllDk);
//                                        }else {
//                                            mesWieWoCompleteAllDk.setErpFlag("2");
//                                            mesWieWoCompleteAllDk.setWieLineId(getWorkDemandList.getWieLineId());
//                                            mesWieWoCompleteAllDk.setTransactionQuantity(transaQuantity);
//                                            //??????ERP????????????
//                                            failureNum++;
//                                            mesWieWoCompleteAllDk.setErrorInfor("???ID???"+getWorkDemandList.getWieLineId()+",????????????"+getWorkDemandList.getWorkOrderNumber()+",?????????"+getWorkDemandList.getItemNumber()+",MES?????????"+getWorkDemandList.getRemark()+"???"+scode);
//                                            mesWieWoCompleteAllDKMapper.updateLineErpFlag(mesWieWoCompleteAllDk);
//                                        }
//                                    } catch (Exception e) {
//                                        mesWieWoCompleteAllDk.setErpFlag("2");
//                                        mesWieWoCompleteAllDk.setWieLineId(getWorkDemandList.getWieLineId());
//                                        //??????ERP????????????
//                                        failureNum++;
//                                        mesWieWoCompleteAllDk.setErrorInfor("???ID???"+getWorkDemandList.getWieLineId()+",????????????"+getWorkDemandList.getWorkOrderNumber()+",?????????"+getWorkDemandList.getItemNumber()+",MES?????????"+getWorkDemandList.getRemark()+"???"+e.getMessage());
//                                        mesWieWoCompleteAllDKMapper.updateLineErpFlag(mesWieWoCompleteAllDk);
//                                    }
//                                }else {
//                                    //ERP????????????????????????????????????0
//                                    mesWieWoCompleteAllDk.setErpFlag("3");
//                                    mesWieWoCompleteAllDk.setWieLineId(getWorkDemandList.getWieLineId());
//                                    mesWieWoCompleteAllDk.setTransactionQuantity(transaQuantity);
//                                    //??????ERP????????????
//                                    mesWieWoCompleteAllDk.setErrorInfor("OK");
//                                    mesWieWoCompleteAllDKMapper.updateLineErpFlag(mesWieWoCompleteAllDk);
//                                }
//                            }else {
//                                //ERP????????????????????????????????????0
//                                mesWieWoCompleteAllDk.setErpFlag("3");
//                                mesWieWoCompleteAllDk.setWieLineId(getWorkDemandList.getWieLineId());
//                                mesWieWoCompleteAllDk.setTransactionQuantity(BigDecimal.ZERO);
//                                //??????ERP????????????
//                                mesWieWoCompleteAllDk.setErrorInfor("OK");
//                                mesWieWoCompleteAllDKMapper.updateLineErpFlag(mesWieWoCompleteAllDk);
//                            }
//                        }else {
//                            //ERP????????????????????????????????????0
//                            mesWieWoCompleteAllDk.setErpFlag("3");
//                            mesWieWoCompleteAllDk.setWieLineId(getWorkDemandList.getWieLineId());
//                            mesWieWoCompleteAllDk.setTransactionQuantity(BigDecimal.ZERO);
//                            //??????ERP????????????
//                            mesWieWoCompleteAllDk.setErrorInfor("OK");
//                            mesWieWoCompleteAllDKMapper.updateLineErpFlag(mesWieWoCompleteAllDk);
//                        }
//
//                    }
//                }
//                //????????????ID?????????ID???Remark???????????????????????????????????????????????????????????????????????????
//                int getAllErpFlag = mesWieWoCompleteAllDKMapper.getAllErpFlag(wieWoCompleteDkList);
//                //????????????WMS???????????????????????????????????????????????????
//                int isDetails = mesWieWoCompleteAllDKMapper.getIsDetails(wieWoCompleteDkList);
//                //?????????failureNum > 0???????????????????????????????????????????????????????????????????????????????????????
//                if((failureNum == 0 && getAllErpFlag > 0)|| isDetails == 0){

                    //                if((((getWorkDemandLists.size() > 0 ? ((successNum == getWorkDemandLists.size())&&failureNum==0) : (mesWieWoCompleteAllDKMapper.getAllErpFlag(wieWoCompleteDkList) > 0 ? true : false))))){//???????????????????????????????????????????????????
                    //?????????????????????????????????????????????
                    //????????????????????????
                    List<MesWieWoCompleteAllDKEO> woOperationSequenceNumber = mesWieWoCompleteAllDKMapper.selectOperSequenceNumber(wieWoCompleteDkList.getWorkOrderId());

                    for(int i = 0; i < woOperationSequenceNumber.size(); i ++){
                        //Json?????????
                        JSONObject requestJsonObject = new JSONObject();
                        requestJsonObject.put("SourceSystemCode", sourceSystemCode);
                        requestJsonObject.put("SourceSystemType", sourceSystemType);
                        List OperationTransactionDetail = new ArrayList<>();

                        int seqNum = woOperationSequenceNumber.get(i).getWoOperationSequenceNumber();
                        //???????????????????????????????????????
                        Calendar cal = Calendar.getInstance();
                        cal.setTimeInMillis(log.getStopTime() .getTime());
                        cal.add(Calendar.HOUR, -8);

                        //???json?????????
                        JSONObject requestJsonLObject = new JSONObject();

                        requestJsonLObject.put("SourceSystemCode", "FUSION_MOBILE");
                        requestJsonLObject.put("OrganizationCode", orgCode.getOrganizationCode());
                        requestJsonLObject.put("TransactionDate", sdf.format(cal.getTime()));
                        requestJsonLObject.put("TransactionQuantity", wieWoCompleteDkList.getTransactionQuantity());
                        requestJsonLObject.put("TransactionUnitOfMeasure", wieWoCompleteDkList.getUomCode());
                        requestJsonLObject.put("ComplSubinventoryCode", wieWoCompleteDkList.getSubinventoryCode());
                        requestJsonLObject.put("WoOperationSequenceNumber", seqNum);
                        requestJsonLObject.put("WorkOrderNumber", wieWoCompleteDkList.getWorkOrderNumber());
                        requestJsonLObject.put("FromDispatchState", "READY");
                        requestJsonLObject.put("ToDispatchState", "COMPLETE");

                        OperationTransactionDetail.add(requestJsonLObject);

                        //??????????????????????????????
                        //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 ????????? 1 ?????????
                        if (wieWoCompleteDkList.getLotControlCode()== 2) {
                            List TransactionLot = new ArrayList<>();
                            JSONObject requestJsonLotObject = new JSONObject();
                            requestJsonLotObject.put("LotNumber", lotNumbers);
                            requestJsonLotObject.put("TransactionQuantity", wieWoCompleteDkList.getTransactionQuantity());
                            TransactionLot.add(requestJsonLotObject);
                            requestJsonLObject.put("TransactionLot", TransactionLot);
                        }

                        requestJsonObject.put("OperationTransactionDetail", OperationTransactionDetail);
                        String requestBody = requestJsonObject.toJSONString();

                        //??????POST??????
                        String responseBody = null;
                        try {
                            responseBody = RestClient.postData(ConfigUtils.getWieWoCompleteUrl(), requestBody, CONTECT_TYPE, "UTF-8",ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
                            //???????????????
                            JSONObject responseJsonObject = JSONObject.parseObject(responseBody);
                            String errorsExistFlag = responseJsonObject.get("ErrorsExistFlag").toString();
                            //??????????????????
                            if("false".equals(errorsExistFlag)){
                                //??????ERP????????????
                                mesWieWoCompleteAllDk.setErpFlag("1");
                                mesWieWoCompleteAllDk.setErrorInfor("OK");
                                mesWieWoCompleteAllDk.setWoCompleteId(wieWoCompleteDkList.getWoCompleteId());
                                mesWieWoCompleteAllDKMapper.updateErpFlag(mesWieWoCompleteAllDk);
                            }else {
                                JSONArray dtlList = (JSONArray) responseJsonObject.get("OperationTransactionDetail");
                                JSONObject line = (JSONObject) dtlList.get(0);
                                String ErrorMessages = line.get("ErrorMessages").toString();
                                //??????ERP????????????
                                mesWieWoCompleteAllDk.setErpFlag("2");
                                mesWieWoCompleteAllDk.setErrorInfor("??????????????? ID???"+wieWoCompleteDkList.getWoCompleteId()+"????????????"+wieWoCompleteDkList.getWorkOrderNumber()+"???"+"MES?????????"+wieWoCompleteDkList.getRemark()+"???"+ErrorMessages);
                                mesWieWoCompleteAllDk.setWoCompleteId(wieWoCompleteDkList.getWoCompleteId());
                                mesWieWoCompleteAllDKMapper.updateErpFlag(mesWieWoCompleteAllDk);
                            }
                        } catch (Exception e) {
                            mesWieWoCompleteAllDk.setErpFlag("2");
                            mesWieWoCompleteAllDk.setErrorInfor("??????????????? ID???"+wieWoCompleteDkList.getWoCompleteId()+"????????????"+wieWoCompleteDkList.getWorkOrderNumber()+"???"+"MES?????????"+wieWoCompleteDkList.getRemark()+"???"+e.getMessage());
                            mesWieWoCompleteAllDk.setWoCompleteId(wieWoCompleteDkList.getWoCompleteId());
                            mesWieWoCompleteAllDKMapper.updateErpFlag(mesWieWoCompleteAllDk);
                        }
                    }
//                }
//                else {
//                    mesWieWoCompleteAllDk.setErpFlag("2");
//                    mesWieWoCompleteAllDk.setErrorInfor("???????????????????????????????????????????????????????????????");
//                    mesWieWoCompleteAllDk.setWoCompleteId(wieWoCompleteDkList.getWoCompleteId());
//                    mesWieWoCompleteAllDKMapper.updateErpFlag(mesWieWoCompleteAllDk);
//                }


//                }else {
//                    mesWieWoCompleteAllDk.setErpFlag("2");
//                    mesWieWoCompleteAllDKMapper.updateErpFlag(mesWieWoCompleteAllDk);
//                    if(failureNum==0){
//                        failureMsg.insert(0, "??????????????? ID???"+wieWoCompleteDkList.getWoCompleteId()+"????????????"+wieWoCompleteDkList.getWorkOrderNumber()+"???"+"MES?????????"+wieWoCompleteDkList.getRemark()+"???"+"???????????????????????????????????????????????????");
//                    }else {
//                        failureMsg.insert(0, "??????????????? ID???"+wieWoCompleteDkList.getWoCompleteId()+"????????????"+wieWoCompleteDkList.getWorkOrderNumber()+"???"+"MES?????????"+wieWoCompleteDkList.getRemark()+"???"+"?????????????????????????????? " + failureNum + " ???????????????????????????????????????");
//                    }
//                    throw new Exception(failureMsg.toString());
//                }
            }
        }
    }
}
