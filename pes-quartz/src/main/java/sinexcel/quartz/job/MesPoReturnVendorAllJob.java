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
                //判断是否外协工单，有需要先工单退货，在外协退料
                if(mesPoReturnVendorAllMapper.getWieOrderList(poReturnVendorList) > 0 ? true : false){
                    //Json头信息
                    JSONObject requestJsonObject = new JSONObject();
                    requestJsonObject.put("SourceSystemCode", "EXTERNAL");
                    requestJsonObject.put("SourceSystemType", "EXTERNAL");
                    List OperationTransactionDetail = new ArrayList<>();
                    //得到库存组织
                    MesPoReturnVendorAllEO orgCode = mesPoReturnVendorAllMapper.selectOrgnazationCode(poReturnVendorList.getOrganizationId());
                    //得到工单完工工序
                    List<MesPoReturnVendorAllEO> woOperationSequenceNumbers = mesPoReturnVendorAllMapper.selectOperSequenceNumber(poReturnVendorList);
                    for (MesPoReturnVendorAllEO woOperationSequenceNumber:woOperationSequenceNumbers){
                        //交易时间转换成格林威治时间
                        Calendar cal1 = Calendar.getInstance();
                        cal1.setTimeInMillis(log.getStopTime() .getTime());
                        cal1.add(Calendar.HOUR, -8);

                        //把json串拼接
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

                        //判断是否启用批次控制
                        //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
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

                        //发送POST请求
                        String responseBody = null;
                        try {
                            responseBody = RestClient.postData(ConfigUtils.getWieWoCompleteUrl(), requestBody, CONTECT_TYPE, "UTF-8",ConfigUtils.getErpUser(), ConfigUtils.getErpPass());
                            //返回值解析
                            JSONObject responseJsonObject = JSONObject.parseObject(responseBody);
                            String errorsExistFlag = responseJsonObject.get("ErrorsExistFlag").toString();
                            //是否成功判断
                            if("false".equals(errorsExistFlag)){
                                //回写ERP成功标识
                                poReturnVendorList.setErpFlagWork("1");
                                poReturnVendorList.setWorkOrderNumber(woOperationSequenceNumber.getWorkOrderNumber());
                                poReturnVendorList.setErrorInfor("OK");
                                mesPoReturnVendorAllMapper.updateErpFlagWork(poReturnVendorList);
                                //采购退货
                                if(!("1".equals(poReturnVendorList.getErpFlag()))){
                                    mesPoReturnVendorAll(poReturnVendorList);
                                }
                            }else {
                                JSONArray dtlList = (JSONArray) responseJsonObject.get("OperationTransactionDetail");
                                JSONObject line = (JSONObject) dtlList.get(0);
                                String ErrorMessages = line.get("ErrorMessages").toString();
                                //回写ERP失败标识
                                poReturnVendorList.setErpFlagWork("2");
                                poReturnVendorList.setWorkOrderNumber(woOperationSequenceNumber.getWorkOrderNumber());
                                poReturnVendorList.setErrorInfor("【工单退货 ID："+poReturnVendorList.getReturnVendorId()+"；工单号："+poReturnVendorList.getWorkOrderNumber()+"；"+"MES主键："+poReturnVendorList.getRemark()+"】；"+ErrorMessages);
                                mesPoReturnVendorAllMapper.updateErpFlagWork(poReturnVendorList);
                                //采购退货
                                if(("0".equals(poReturnVendorList.getErpFlag()))||("2".equals(poReturnVendorList.getErpFlag()))){
                                    mesPoReturnVendorAll(poReturnVendorList);
                                }
                            }
                        } catch (Exception e) {
                            poReturnVendorList.setErpFlagWork("2");
                            poReturnVendorList.setWorkOrderNumber(woOperationSequenceNumber.getWorkOrderNumber());
                            poReturnVendorList.setErrorInfor("【工单退货 ID："+poReturnVendorList.getReturnVendorId()+"；工单号："+poReturnVendorList.getWorkOrderNumber()+"；"+"MES主键："+poReturnVendorList.getRemark()+"】；"+e.getMessage());
                            mesPoReturnVendorAllMapper.updateErpFlagWork(poReturnVendorList);
                        }
                    }

                }else {
                    //采购退货
                    if(("0".equals(poReturnVendorList.getErpFlag()))||("2".equals(poReturnVendorList.getErpFlag()))){
                        mesPoReturnVendorAll(poReturnVendorList);
                    }
                }
            }
        }
    }
    public void mesPoReturnVendorAll(MesPoReturnVendorAllEO poReturnVendorList){
        //交易时间转换成格林威治时间
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(poReturnVendorList.getTransactionDate() .getTime());
        cal.add(Calendar.HOUR, -8);
        //判断是否启用批次控制
        //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
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
                //回写ERP成功标识
                mesPoReturnVendorAllMapper.updateErpFlag(poReturnVendorList);
            }else {
                //回写ERP失败标识
                poReturnVendorList.setErpFlag("2");
                poReturnVendorList.setErrorInfor("【PO退货ID："+poReturnVendorList.getReturnVendorId()+"；"+"MES主键："+poReturnVendorList.getRemark()+"；"+"PO单号："+poReturnVendorList.getDocumentNumber()+"；"+"PO行号："+poReturnVendorList.getDocumentLineNumber()+"；"+"PO行料号："+poReturnVendorList.getItemNumber()+"】；"+scode);
                //回写成功标识
                mesPoReturnVendorAllMapper.updateErpFlag(poReturnVendorList);
            }
        } catch (Exception e) {
            //回写ERP失败标识
            poReturnVendorList.setErpFlag("2");
            poReturnVendorList.setErrorInfor("【PO退货ID："+poReturnVendorList.getReturnVendorId()+"；"+"MES主键："+poReturnVendorList.getRemark()+"；"+"PO单号："+poReturnVendorList.getDocumentNumber()+"；"+"PO行号："+poReturnVendorList.getDocumentLineNumber()+"；"+"PO行料号："+poReturnVendorList.getItemNumber()+"】；"+e.getMessage());
            //回写成功标识
            mesPoReturnVendorAllMapper.updateErpFlag(poReturnVendorList);
        }
    }
}
