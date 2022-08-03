package sinexcel.quartz.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.common.utils.RestClient;
import sinexcel.quartz.domain.MesRcvPurchaseEO;
import sinexcel.quartz.domain.MesWieWoCompleteAllEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.MesRcvPurchaseMapper;
import sinexcel.quartz.mapper.MesWieWoCompleteAllMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.util.RcvPurchaseUtils;

import java.text.SimpleDateFormat;
import java.util.*;


@Component("mesRcvPurchaseJob")
public class MesRcvPurchaseJob{

    public static final String sourceSystemCode = "EXTERNAL";
    public static final String sourceSystemType = "EXTERNAL";
    public static final String CONTECT_TYPE = "application/vnd.oracle.adf.resourceitem+json";

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    String lotNumber = null;

    @Autowired
    private MesRcvPurchaseMapper mesRcvPurchaseMapper;

    @Autowired
    private MesWieWoCompleteAllMapper mesWieWoCompleteAllMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    Logger logger = LoggerFactory.getLogger(this.getClass());


    public void report() {

        SysJobLog log = new SysJobLog();
        log.setJobName("MesRcvPurchaseJob");
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

        //采购入库接口
        MesRcvPurchaseEO rcvPurchaseEO = new MesRcvPurchaseEO();
        rcvPurchaseEO.setStartUpdateDate(sdf.format(log.getStartTime()));
        rcvPurchaseEO.setEndUpdateDate(sdf.format(log.getStopTime()));

        //工单完工入库
        MesWieWoCompleteAllEO mesWieWoCompleteAll = new MesWieWoCompleteAllEO();
        mesWieWoCompleteAll.setStartUpdateDate(sdf.format(log.getStartTime()));
        mesWieWoCompleteAll.setEndUpdateDate(sdf.format(log.getStopTime()));

        //采购入库接口
        List<MesRcvPurchaseEO> rcvLists = mesRcvPurchaseMapper.getRcvPurchaseList(rcvPurchaseEO);

        sysJobLogMapper.updateLatUpdateDate(log);

        //采购入库接口
        if(rcvLists.size() > 0){
            for(MesRcvPurchaseEO rcvList : rcvLists){
                //判断是否启用批次控制
                //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
                if(rcvList.getLotControlCode()== 2){
                    lotNumber = "\t\t <ns2:StagedTransactionLot>\n" +
                            "\t\t\t\t <ns2:TransactionQuantity>"+rcvList.getQuantity()+"</ns2:TransactionQuantity>\n" +
                            "\t\t\t\t <ns2:LotNumber>QC201810</ns2:LotNumber>\n" +
                            "\t\t </ns2:StagedTransactionLot>\n";
                }else {
                    lotNumber = "";
                }
                String xmlStr = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                        " <soap:Body>\n" +
                        " <ns1:processor xmlns:ns1=\"http://xmlns.oracle.com/apps/scm/receiving/receiptsInterface/transactions/processorServiceV2/types/\">\n" +
                        " <ns1:Receipt xmlns:ns2=\"http://xmlns.oracle.com/apps/scm/receiving/receiptsInterface/transactions/processorServiceV2/\">\n" +
                        "\t <ns2:ReceiptSourceCode>VENDOR</ns2:ReceiptSourceCode>\n" +
                        "\t <ns2:ShipToOrganizationId>"+rcvList.getOrganizationId()+"</ns2:ShipToOrganizationId>\n" +
                        "\t <ns2:VendorId>"+rcvList.getVendorId()+"</ns2:VendorId>\n" +
                        "\t <ns2:BUId>"+rcvList.getBuId()+"</ns2:BUId>\n" +
                        "\t <ns2:EmployeeId>"+rcvList.getEmployeeId()+"</ns2:EmployeeId>\n" +
                        "\t <ns2:StagedReceivingTransaction>\n" +
                        "\t\t <ns2:ReceiptSourceCode>VENDOR</ns2:ReceiptSourceCode>\n" +
                        "\t\t <ns2:SourceDocumentCode>PO</ns2:SourceDocumentCode>\n" +
                        "\t\t <ns2:TransactionType>RECEIVE</ns2:TransactionType>\n" +
                        "\t\t <ns2:AutoTransactCode>DELIVER</ns2:AutoTransactCode>\n" +
                        "\t\t <ns2:ToOrganizationId>"+rcvList.getOrganizationId()+"</ns2:ToOrganizationId>\n" +
                        "\t\t <ns2:TransactionDate>"+ sdf1.format(cal.getTime())+"</ns2:TransactionDate>\n" +
                        "\t\t <ns2:DocumentNumber>"+rcvList.getDocumentNumber()+"</ns2:DocumentNumber>\n" +
                        "\t\t <ns2:DocumentLineNumber>"+rcvList.getDocumentLineNumber()+"</ns2:DocumentLineNumber>\n" +
                        "\t\t <ns2:ItemId>"+rcvList.getInventoryItemId()+"</ns2:ItemId>\n" +
                        "\t\t <ns2:Quantity>"+rcvList.getQuantity()+"</ns2:Quantity>\n" +
                        "\t\t <ns2:UnitOfMeasure>"+rcvList.getUomCode()+"</ns2:UnitOfMeasure>\n" +
                        "\t\t <ns2:SoldtoLeId>"+rcvList.getLegelEntiytyId()+"</ns2:SoldtoLeId>\n" +
                        "\t\t <ns2:Attribute1>"+rcvList.getRemart()+"</ns2:Attribute1>\n" +
                        "\t\t <ns2:Comments>"+rcvList.getRemart()+"</ns2:Comments>\n" +
                        "\t\t <ns2:Subinventory>"+rcvList.getSubinventoryCode()+"</ns2:Subinventory>\n"
                        + lotNumber+
                        "\t </ns2:StagedReceivingTransaction>\n" +
                        " </ns1:Receipt>\n" +
                        " </ns1:processor>\n" +
                        " </soap:Body>\n" +
                        "</soap:Envelope>";

//                System.out.println(xmlStr);
                String scode = null;
                try {
                    scode = RcvPurchaseUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getRcvPurchasUrl(),ConfigUtils.getRcvPurchasName(),ConfigUtils.getRcvPurchasMethodName()));

                    if("SUCCESS".equals(scode)){
                        rcvPurchaseEO.setErpFlag("1");
                        rcvPurchaseEO.setRcvId(rcvList.getRcvId());
                        rcvPurchaseEO.setErrorInfor("OK");
                        //回写ERP成功标识
                        mesRcvPurchaseMapper.updateErpFlag(rcvPurchaseEO);
                    }else {
                        //回写ERP失败标识
                        rcvPurchaseEO.setErpFlag("2");
                        rcvPurchaseEO.setRcvId(rcvList.getRcvId());
                        rcvPurchaseEO.setErrorInfor("【采购入库 ID："+rcvList.getRcvId()+"；"+"MES主键："+rcvList.getRemart()+"；"+"PO单号："+rcvList.getDocumentNumber()+"；"+"PO行号："+rcvList.getDocumentLineNumber()+"；"+"PO行料号："+rcvList.getItemNumber()+"】；"+scode);
                        //回写成功标识
                        mesRcvPurchaseMapper.updateErpFlag(rcvPurchaseEO);
                    }
                } catch (Exception e) {
                    rcvPurchaseEO.setErpFlag("2");
                    rcvPurchaseEO.setRcvId(rcvList.getRcvId());
                    rcvPurchaseEO.setErrorInfor("【采购入库 ID："+rcvList.getRcvId()+"；"+"MES主键："+rcvList.getRemart()+"；"+"PO单号："+rcvList.getDocumentNumber()+"；"+"PO行号："+rcvList.getDocumentLineNumber()+"；"+"PO行料号："+rcvList.getItemNumber()+"】；"+e.getMessage());
                    //回写成功标识
                    mesRcvPurchaseMapper.updateErpFlag(rcvPurchaseEO);
                }
            }
        }
        //工单完工入库
        mesWieWoCompleteAllJob();
    }
    public void mesWieWoCompleteAllJob() {
        List<MesWieWoCompleteAllEO> wieWoCompleteLists = mesWieWoCompleteAllMapper.getWieWoCompleteList();
        //工单完工入库
        if(wieWoCompleteLists.size() > 0){
            for(MesWieWoCompleteAllEO wieWoCompleteList : wieWoCompleteLists){
                //得到工单完工工序
                List<MesWieWoCompleteAllEO> woOperationSequenceNumbers = mesWieWoCompleteAllMapper.selectOperSequenceNumber(wieWoCompleteList);
                for(MesWieWoCompleteAllEO woOperationSequenceNumber : woOperationSequenceNumbers){
                    //Json头信息
                    JSONObject requestJsonObject = new JSONObject();
                    requestJsonObject.put("SourceSystemCode", sourceSystemCode);
                    requestJsonObject.put("SourceSystemType", sourceSystemType);
                    List OperationTransactionDetail = new ArrayList<>();
                    //得到库存组织
                    MesWieWoCompleteAllEO orgCode = mesWieWoCompleteAllMapper.selectOrgnazationCode(wieWoCompleteList.getOrganizationId());

                    //交易时间转换成格林威治时间
                    Calendar cal1 = Calendar.getInstance();
                    cal1.setTimeInMillis(wieWoCompleteList.getTransactionDate() .getTime());
                    cal1.add(Calendar.HOUR, -8);

                    //把json串拼接
                    JSONObject requestJsonLObject = new JSONObject();

                    requestJsonLObject.put("SourceSystemCode", "FUSION_MOBILE");
                    requestJsonLObject.put("OrganizationCode", orgCode.getOrganizationCode());
                    requestJsonLObject.put("TransactionDate", sdf.format(cal1.getTime()));
                    requestJsonLObject.put("TransactionQuantity", wieWoCompleteList.getTransactionQuantity());
                    requestJsonLObject.put("TransactionUnitOfMeasure", wieWoCompleteList.getUomCode());
                    requestJsonLObject.put("ComplSubinventoryCode", wieWoCompleteList.getSubinventoryCode());
                    requestJsonLObject.put("WoOperationSequenceNumber", woOperationSequenceNumber.getWoOperationSequenceNumber());
                    requestJsonLObject.put("WorkOrderNumber", wieWoCompleteList.getWorkOrderNumber());
                    requestJsonLObject.put("FromDispatchState", "READY");
                    requestJsonLObject.put("ToDispatchState", "COMPLETE");

                    OperationTransactionDetail.add(requestJsonLObject);

                    //判断是否启用批次控制
                    //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
                    if (wieWoCompleteList.getLotControlCode()== 2) {
                        List TransactionLot = new ArrayList<>();
                        JSONObject requestJsonLotObject = new JSONObject();
                        requestJsonLotObject.put("LotNumber", "QC201810");
                        requestJsonLotObject.put("TransactionQuantity", wieWoCompleteList.getTransactionQuantity());
                        TransactionLot.add(requestJsonLotObject);
                        requestJsonLObject.put("TransactionLot", TransactionLot);
                    }

                    requestJsonObject.put("OperationTransactionDetail", OperationTransactionDetail);
                    String requestBody = requestJsonObject.toJSONString();

                    //发送POST请求
                    String responseBody = null;
                    try {
                        responseBody = RestClient.postData(ConfigUtils.getWieWoCompleteUrl(), requestBody, CONTECT_TYPE, "UTF-8",ConfigUtils.getErpUser(), ConfigUtils.getErpPass());

//                        logger.info("外协工单完工入库返回值："+responseBody);

                        //返回值解析
                        JSONObject responseJsonObject = JSONObject.parseObject(responseBody);
                        String errorsExistFlag = responseJsonObject.get("ErrorsExistFlag").toString();
                        logger.info("外协工单完工入库返回值标识："+errorsExistFlag);

                        //是否成功判断
                        if("false".equals(errorsExistFlag)){
                            //回写ERP成功标识
                            wieWoCompleteList.setErpFlagWork("1");
                            wieWoCompleteList.setWorkOrderNumber(wieWoCompleteList.getWorkOrderNumber());
                            wieWoCompleteList.setErrorInfor("OK");
                            mesWieWoCompleteAllMapper.updateErpFlag(wieWoCompleteList);
                        }else {
                            JSONArray dtlList = (JSONArray) responseJsonObject.get("OperationTransactionDetail");
                            JSONObject line = (JSONObject) dtlList.get(0);
                            String ErrorMessages = line.get("ErrorMessages").toString();
                            //回写ERP失败标识
                            wieWoCompleteList.setErpFlagWork("2");
                            wieWoCompleteList.setWorkOrderNumber(wieWoCompleteList.getWorkOrderNumber());
                            wieWoCompleteList.setErrorInfor("【完工入库 ID："+wieWoCompleteList.getWoCompleteId()+"；工单号："+wieWoCompleteList.getWorkOrderNumber()+"；"+"MES主键："+wieWoCompleteList.getRemark()+"】；"+ErrorMessages);
                            mesWieWoCompleteAllMapper.updateErpFlag(wieWoCompleteList);
                        }
                    } catch (Exception e) {
                        wieWoCompleteList.setErpFlagWork("2");
                        wieWoCompleteList.setErrorInfor("【完工入库 ID："+wieWoCompleteList.getWoCompleteId()+"；工单号："+wieWoCompleteList.getWorkOrderNumber()+"；"+"MES主键："+wieWoCompleteList.getRemark()+"】；"+e.getMessage());
                        mesWieWoCompleteAllMapper.updateErpFlag(wieWoCompleteList);
                    }
                }
            }
        }
    }
}
