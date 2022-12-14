package sinexcel.quartz.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.common.utils.RestClient;
import sinexcel.quartz.domain.MesPoReturnVendorAllEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.MesPoReturnVendorAllMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.util.RcvPurchaseUtils;

import java.text.SimpleDateFormat;
import java.util.*;


@Component("mesPoReturnVendorAllJob")
public class MesPoReturnVendorAllJob{

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    public static final String CONTECT_TYPE = "application/vnd.oracle.adf.resourceitem+json";

    String lotNumbers = null;


    @Autowired
    private MesPoReturnVendorAllMapper mesPoReturnVendorAllMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;


    public void report() {

        SysJobLog log = new SysJobLog();
        log.setJobName("MesPoReturnVendorAllJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        MesPoReturnVendorAllEO mesPoReturnVendorAll = new MesPoReturnVendorAllEO();
        mesPoReturnVendorAll.setStartUpdateDate(sdf.format(log.getStartTime()));
        mesPoReturnVendorAll.setEndUpdateDate(sdf.format(log.getStopTime()));


        List<MesPoReturnVendorAllEO> poReturnVendorLists = mesPoReturnVendorAllMapper.getPoReturnVendorList(mesPoReturnVendorAll);

        sysJobLogMapper.updateLatUpdateDate(log);

        if(poReturnVendorLists.size() > 0){
            for(MesPoReturnVendorAllEO poReturnVendorList : poReturnVendorLists){
                //?????????????????????????????????????????????????????????????????????
                if(mesPoReturnVendorAllMapper.getWieOrderList(poReturnVendorList) > 0 ? true : false){
                    //Json?????????
                    JSONObject requestJsonObject = new JSONObject();
                    requestJsonObject.put("SourceSystemCode", "EXTERNAL");
                    requestJsonObject.put("SourceSystemType", "EXTERNAL");
                    List OperationTransactionDetail = new ArrayList<>();
                    //??????????????????
                    MesPoReturnVendorAllEO orgCode = mesPoReturnVendorAllMapper.selectOrgnazationCode(poReturnVendorList.getOrganizationId());
                    //????????????????????????
                    List<MesPoReturnVendorAllEO> woOperationSequenceNumbers = mesPoReturnVendorAllMapper.selectOperSequenceNumber(poReturnVendorList);
                    for (MesPoReturnVendorAllEO woOperationSequenceNumber:woOperationSequenceNumbers){
                        //???????????????????????????????????????
                        Calendar cal1 = Calendar.getInstance();
                        cal1.setTimeInMillis(log.getStopTime() .getTime());
                        cal1.add(Calendar.HOUR, -8);

                        //???json?????????
                        JSONObject requestJsonLObject = new JSONObject();

                        requestJsonLObject.put("SourceSystemCode", "FUSION_MOBILE");
                        requestJsonLObject.put("OrganizationCode", orgCode.getOrganizationCode());
                        requestJsonLObject.put("TransactionDate", sdf.format(cal1.getTime()));
                        requestJsonLObject.put("TransactionQuantity", poReturnVendorList.getQuantity());
                        requestJsonLObject.put("TransactionUnitOfMeasure", poReturnVendorList.getUnitOfMeasure());
                        requestJsonLObject.put("ComplSubinventoryCode", poReturnVendorList.getSubinventoryCode());
                        requestJsonLObject.put("WoOperationSequenceNumber", woOperationSequenceNumber.getWoOperationSequenceNumber());
                        requestJsonLObject.put("WorkOrderNumber", woOperationSequenceNumber.getWorkOrderNumber());
                        requestJsonLObject.put("FromDispatchState", "COMPLETE");
                        requestJsonLObject.put("ToDispatchState", "READY");

                        OperationTransactionDetail.add(requestJsonLObject);

                        //??????????????????????????????
                        //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 ????????? 1 ?????????
                        if (woOperationSequenceNumber.getLotControlCode()== 2) {
                            List TransactionLot = new ArrayList<>();
                            JSONObject requestJsonLotObject = new JSONObject();
                            requestJsonLotObject.put("LotNumber", "QC201810");
                            requestJsonLotObject.put("TransactionQuantity", poReturnVendorList.getQuantity());
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
                                poReturnVendorList.setErpFlagWork("1");
                                poReturnVendorList.setWorkOrderNumber(woOperationSequenceNumber.getWorkOrderNumber());
                                poReturnVendorList.setErrorInfor("OK");
                                mesPoReturnVendorAllMapper.updateErpFlagWork(poReturnVendorList);
                                //????????????
                                if(!("1".equals(poReturnVendorList.getErpFlag()))){
                                    mesPoReturnVendorAll(poReturnVendorList);
                                }
                            }else {
                                JSONArray dtlList = (JSONArray) responseJsonObject.get("OperationTransactionDetail");
                                JSONObject line = (JSONObject) dtlList.get(0);
                                String ErrorMessages = line.get("ErrorMessages").toString();
                                //??????ERP????????????
                                poReturnVendorList.setErpFlagWork("2");
                                poReturnVendorList.setWorkOrderNumber(woOperationSequenceNumber.getWorkOrderNumber());
                                poReturnVendorList.setErrorInfor("??????????????? ID???"+poReturnVendorList.getReturnVendorId()+"???????????????"+poReturnVendorList.getWorkOrderNumber()+"???"+"MES?????????"+poReturnVendorList.getRemark()+"??????"+ErrorMessages);
                                mesPoReturnVendorAllMapper.updateErpFlagWork(poReturnVendorList);
                                //????????????
                                if(("0".equals(poReturnVendorList.getErpFlag()))||("2".equals(poReturnVendorList.getErpFlag()))){
                                    mesPoReturnVendorAll(poReturnVendorList);
                                }
                            }
                        } catch (Exception e) {
                            poReturnVendorList.setErpFlagWork("2");
                            poReturnVendorList.setWorkOrderNumber(woOperationSequenceNumber.getWorkOrderNumber());
                            poReturnVendorList.setErrorInfor("??????????????? ID???"+poReturnVendorList.getReturnVendorId()+"???????????????"+poReturnVendorList.getWorkOrderNumber()+"???"+"MES?????????"+poReturnVendorList.getRemark()+"??????"+e.getMessage());
                            mesPoReturnVendorAllMapper.updateErpFlagWork(poReturnVendorList);
                        }
                    }

                }else {
                    //????????????
                    if(("0".equals(poReturnVendorList.getErpFlag()))||("2".equals(poReturnVendorList.getErpFlag()))){
                        mesPoReturnVendorAll(poReturnVendorList);
                    }
                }
            }
        }
    }
    public void mesPoReturnVendorAll(MesPoReturnVendorAllEO poReturnVendorList){
        //???????????????????????????????????????
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(poReturnVendorList.getTransactionDate() .getTime());
        cal.add(Calendar.HOUR, -8);
        //??????????????????????????????
        //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 ????????? 1 ?????????
        if(poReturnVendorList.getLotControlCode()== 2){
            lotNumbers = "\t\t <ns2:StagedTransactionLot>\n" +
                    "\t\t\t\t <ns2:TransactionQuantity>"+poReturnVendorList.getQuantity()+"</ns2:TransactionQuantity>\n" +
                    "\t\t\t\t <ns2:LotNumber>QC201810</ns2:LotNumber>\n" +
                    "\t\t </ns2:StagedTransactionLot>\n";
        }else {
            lotNumbers = "";
        }
        String xmlStr = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <soap:Body>\n" +
                "        <ns1:processor xmlns:ns1=\"http://xmlns.oracle.com/apps/scm/receiving/receiptsInterface/transactions/processorServiceV2/types/\">\n" +
                "            <ns1:Receipt xmlns:ns2=\"http://xmlns.oracle.com/apps/scm/receiving/receiptsInterface/transactions/processorServiceV2/\">\n" +
                "                <ns2:StagedReceivingTransaction>\n" +
                "                    <ns2:TransactionType>RETURN TO VENDOR</ns2:TransactionType>\n" +
                "                    <ns2:ParentTransactionId>"+poReturnVendorList.getParentTransactionId()+"</ns2:ParentTransactionId>\n" +
                "                    <ns2:ReceiptSourceCode>VENDOR</ns2:ReceiptSourceCode>\n" +
                "                    <ns2:SourceDocumentCode>PO</ns2:SourceDocumentCode>\n" +
                "                    <ns2:DocumentNumber>"+poReturnVendorList.getDocumentNumber()+"</ns2:DocumentNumber>\n" +
                "                    <ns2:DocumentLineNumber>"+poReturnVendorList.getDocumentLineNumber()+"</ns2:DocumentLineNumber>\n" +
                "                    <ns2:ToOrganizationId>"+poReturnVendorList.getOrganizationId()+"</ns2:ToOrganizationId>\n" +
                "                    <ns2:Quantity>"+poReturnVendorList.getQuantity()+"</ns2:Quantity>\n" +
                "                    <ns2:UnitOfMeasure>"+poReturnVendorList.getUnitOfMeasure()+"</ns2:UnitOfMeasure>\n" +
                "                    <ns2:TransactionDate>"+sdf1.format(cal.getTime())+"</ns2:TransactionDate>\n" +
                "                    <ns2:Attribute1>"+poReturnVendorList.getWmsQualityName()+"</ns2:Attribute1>\n" +
                "                    <ns2:Comments>"+poReturnVendorList.getWmsReasonInfor()+"</ns2:Comments>\n" +
                lotNumbers+
                "                </ns2:StagedReceivingTransaction>\n" +
                "            </ns1:Receipt>\n" +
                "        </ns1:processor>\n" +
                "    </soap:Body>\n" +
                "</soap:Envelope>";

        String scode = null;
        try {
            scode = RcvPurchaseUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getRcvPurchasUrl(),ConfigUtils.getRcvPurchasName(),ConfigUtils.getRcvPurchasMethodName()));

            if("SUCCESS".equals(scode)){
                poReturnVendorList.setErpFlag("1");
                poReturnVendorList.setErrorInfor("OK");
                //??????ERP????????????
                mesPoReturnVendorAllMapper.updateErpFlag(poReturnVendorList);
            }else {
                //??????ERP????????????
                poReturnVendorList.setErpFlag("2");
                poReturnVendorList.setErrorInfor("???PO??????ID???"+poReturnVendorList.getReturnVendorId()+"???"+"MES?????????"+poReturnVendorList.getRemark()+"???"+"PO?????????"+poReturnVendorList.getDocumentNumber()+"???"+"PO?????????"+poReturnVendorList.getDocumentLineNumber()+"???"+"PO????????????"+poReturnVendorList.getItemNumber()+"??????"+scode);
                //??????????????????
                mesPoReturnVendorAllMapper.updateErpFlag(poReturnVendorList);
            }
        } catch (Exception e) {
            //??????ERP????????????
            poReturnVendorList.setErpFlag("2");
            poReturnVendorList.setErrorInfor("???PO??????ID???"+poReturnVendorList.getReturnVendorId()+"???"+"MES?????????"+poReturnVendorList.getRemark()+"???"+"PO?????????"+poReturnVendorList.getDocumentNumber()+"???"+"PO?????????"+poReturnVendorList.getDocumentLineNumber()+"???"+"PO????????????"+poReturnVendorList.getItemNumber()+"??????"+e.getMessage());
            //??????????????????
            mesPoReturnVendorAllMapper.updateErpFlag(poReturnVendorList);
        }
    }
}
