package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.quartz.domain.MesRmaOrderDeliverAllEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.MesRmaOrderDeliverAllMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.util.RcvPurchaseUtils;

import java.text.SimpleDateFormat;
import java.util.*;


@Component("mesRmaOrderDeliverAllJob")
public class MesRmaOrderDeliverAllJob{

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    String lotNumber = null;

    @Autowired
    private MesRmaOrderDeliverAllMapper mesRmaOrderDeliverAllMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;


    public void report() {

        SysJobLog log = new SysJobLog();
        log.setJobName("MesRmaOrderDeliverAllJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        MesRmaOrderDeliverAllEO mesRmaOrderDeliverAll = new MesRmaOrderDeliverAllEO();
        mesRmaOrderDeliverAll.setStartUpdateDate(sdf.format(log.getStartTime()));
        mesRmaOrderDeliverAll.setEndUpdateDate(sdf.format(log.getStopTime()));


        List<MesRmaOrderDeliverAllEO> rmaOrderDeliverLists = mesRmaOrderDeliverAllMapper.getRmaOrderDeliverLists(mesRmaOrderDeliverAll);

        sysJobLogMapper.updateLatUpdateDate(log);

        if(rmaOrderDeliverLists.size() > 0){
            for(MesRmaOrderDeliverAllEO rmaOrderDeliverList : rmaOrderDeliverLists){
                //ReceiptAdviceHeaderId，ReceiptAdviceLineId
                MesRmaOrderDeliverAllEO receiptAdvice = mesRmaOrderDeliverAllMapper.getReceiptAdviceID(rmaOrderDeliverList);
                //判断是否启用批次控制
                //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
                if(rmaOrderDeliverList.getLotControlCode()== 2){
                    lotNumber = "                    <ns2:StagedTransactionLot>\n" +
                            "                        <ns2:LotNumber>QC201810</ns2:LotNumber>\n" +
                            "                        <ns2:TransactionQuantity>"+rmaOrderDeliverList.getTransactionQuantity()+"</ns2:TransactionQuantity>\n" +
                            "                    </ns2:StagedTransactionLot>\n";
                }else {
                    lotNumber = "";
                }

                //交易时间转换成格林威治时间
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(rmaOrderDeliverList.getTransactionDate() .getTime());
                cal.add(Calendar.HOUR, -8);
                String xmlStr = "<soap:Envelope\n" +
                        "    xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                        "    <soap:Body>\n" +
                        "        <ns1:processor\n" +
                        "            xmlns:ns1=\"http://xmlns.oracle.com/apps/scm/receiving/receiptsInterface/transactions/processorServiceV2/types/\">\n" +
                        "            <ns1:Receipt\n" +
                        "                xmlns:ns2=\"http://xmlns.oracle.com/apps/scm/receiving/receiptsInterface/transactions/processorServiceV2/\">\n" +
                        "                <ns2:ReceiptSourceCode>CUSTOMER</ns2:ReceiptSourceCode>\n" +
                        "                <ns2:ShipToOrganizationId>"+rmaOrderDeliverList.getOrganizationId()+"</ns2:ShipToOrganizationId>\n" +
                        "                <ns2:CustomerId>"+rmaOrderDeliverList.getCustomerId()+"</ns2:CustomerId>\n" +
                        "                <ns2:BUId>"+rmaOrderDeliverList.getBuId()+"</ns2:BUId>\n" +
                        "                <ns2:EmployeeId>"+rmaOrderDeliverList.getEmployeeId()+"</ns2:EmployeeId>\n" +
                        "                <ns2:StagedReceivingTransaction>\n" +
                        "                    <ns2:ReceiptSourceCode>CUSTOMER</ns2:ReceiptSourceCode>\n" +
                        "                    <ns2:DestinationTypeCode>INVENTORY</ns2:DestinationTypeCode>\n" +
                        "                    <ns2:SourceDocumentCode>RMA</ns2:SourceDocumentCode>\n" +
                        "                    <ns2:TransactionType>RECEIVE</ns2:TransactionType>\n" +
                        "                    <ns2:AutoTransactCode>DELIVER</ns2:AutoTransactCode>\n" +
                        "                    <ns2:ToOrganizationId>"+rmaOrderDeliverList.getOrganizationId()+"</ns2:ToOrganizationId>\n" +
                        "                    <ns2:TransactionDate>"+ sdf1.format(cal.getTime())+"</ns2:TransactionDate>\n" +
                        "                    <ns2:ReceiptAdviceHeaderId>"+receiptAdvice.getShipmentHeaderId()+"</ns2:ReceiptAdviceHeaderId>\n" +
                        "                    <ns2:ReceiptAdviceLineId>"+receiptAdvice.getShipmentLineId()+"</ns2:ReceiptAdviceLineId>\n" +
                        "                    <ns2:ItemId>"+rmaOrderDeliverList.getInventoryItemId()+"</ns2:ItemId>\n" +
                        "                    <ns2:Quantity>"+rmaOrderDeliverList.getTransactionQuantity()+"</ns2:Quantity>\n" +
                        "                    <ns2:UnitOfMeasure>"+rmaOrderDeliverList.getTransactionUom()+"</ns2:UnitOfMeasure>\n" +
                        "                    <ns2:Subinventory>"+rmaOrderDeliverList.getSubinventoryCode()+"</ns2:Subinventory>\n" +
                        "                    <ns2:Attribute1>"+rmaOrderDeliverList.getRemark()+"</ns2:Attribute1>\n" +
                        "                    <ns2:Comments>"+rmaOrderDeliverList.getRemark()+"</ns2:Comments>\n"
                                                + lotNumber+
                        "                </ns2:StagedReceivingTransaction>\n" +
                        "            </ns1:Receipt>\n" +
                        "        </ns1:processor>\n" +
                        "    </soap:Body>\n" +
                        "</soap:Envelope>";

                String scode = null;
                try {
                    scode = RcvPurchaseUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getRcvPurchasUrl(),ConfigUtils.getRcvPurchasName(),ConfigUtils.getRcvPurchasMethodName()));

                if("SUCCESS".equals(scode)){
                    mesRmaOrderDeliverAll.setErpFlag("1");
                    mesRmaOrderDeliverAll.setRmaId(rmaOrderDeliverList.getRmaId());
                    mesRmaOrderDeliverAll.setErrorInfor("OK");
                    //回写ERP成功标识
                    mesRmaOrderDeliverAllMapper.updateErpFlag(mesRmaOrderDeliverAll);
                }else {
                    //回写ERP失败标识
                    mesRmaOrderDeliverAll.setErpFlag("2");
                    mesRmaOrderDeliverAll.setRmaId(rmaOrderDeliverList.getRmaId());
                    mesRmaOrderDeliverAll.setErrorInfor("【退货ID:"+rmaOrderDeliverList.getRmaId()+"；RMA单号:"+rmaOrderDeliverList.getRmaOrderNumber()+"；RMA行号:"+rmaOrderDeliverList.getRmaOrderLineNumber()+"；料号:"+rmaOrderDeliverList.getItemNumber()+"；MES主键:"+rmaOrderDeliverList.getRemark()+"；错误日志：】"+scode);
                    //回写ERP失败标识
                    mesRmaOrderDeliverAllMapper.updateErpFlag(mesRmaOrderDeliverAll);
                }
                } catch (Exception e) {
                    mesRmaOrderDeliverAll.setErpFlag("2");
                    mesRmaOrderDeliverAll.setRmaId(rmaOrderDeliverList.getRmaId());
                    mesRmaOrderDeliverAll.setErrorInfor("【退货ID:"+rmaOrderDeliverList.getRmaId()+"；RMA单号:"+rmaOrderDeliverList.getRmaOrderNumber()+"；RMA行号:"+rmaOrderDeliverList.getRmaOrderLineNumber()+"；料号:"+rmaOrderDeliverList.getItemNumber()+"；MES主键:"+rmaOrderDeliverList.getRemark()+"；错误日志：】"+e.getMessage());
                    //回写ERP失败标识
                    mesRmaOrderDeliverAllMapper.updateErpFlag(mesRmaOrderDeliverAll);
                }
            }
        }
    }
}
