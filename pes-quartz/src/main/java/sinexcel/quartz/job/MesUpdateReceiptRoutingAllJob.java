package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.quartz.domain.MesUpdateReceiptRoutingAllEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.MesUpdateReceiptRoutingAllMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.util.purchaseUtils;

import java.text.SimpleDateFormat;
import java.util.*;


@Component("mesUpdateReceiptRoutingAllJob")
public class MesUpdateReceiptRoutingAllJob{

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private MesUpdateReceiptRoutingAllMapper mesUpdateReceiptRoutingAllMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;


    public void report() {

        SysJobLog log = new SysJobLog();
        log.setJobName("MesUpdateReceiptRoutingAllJob");
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

        MesUpdateReceiptRoutingAllEO mesUpdateReceiptRoutingAll = new MesUpdateReceiptRoutingAllEO();
        mesUpdateReceiptRoutingAll.setStartUpdateDate(sdf.format(log.getStartTime()));
        mesUpdateReceiptRoutingAll.setEndUpdateDate(sdf.format(log.getStopTime()));


        List<MesUpdateReceiptRoutingAllEO> updateReceiptRoutingLists = mesUpdateReceiptRoutingAllMapper.getUpdateReceiptRoutingList(mesUpdateReceiptRoutingAll);

        sysJobLogMapper.updateLatUpdateDate(log);

        if(updateReceiptRoutingLists.size() > 0){
            for(MesUpdateReceiptRoutingAllEO updateReceiptRoutingList : updateReceiptRoutingLists){
                String lineDetails = "";
                mesUpdateReceiptRoutingAll.setOrderNumber(updateReceiptRoutingList.getOrderNumber());
                List<MesUpdateReceiptRoutingAllEO> getLines = mesUpdateReceiptRoutingAllMapper.getLinesList(mesUpdateReceiptRoutingAll);
                if(getLines.size()>0){
                    for(MesUpdateReceiptRoutingAllEO getLine : getLines){
                        //行信息循环行数据
                        lineDetails += "                <ns2:PurchaseOrderEntryLine>\n" +
                                "                    <ns2:LineNumber>"+getLine.getLineNumber()+"</ns2:LineNumber>\n" +
                                "                    <ns2:Action>CHANGE</ns2:Action>\n" +
                                "                    <ns2:PurchaseOrderEntrySchedule>\n" +
                                "                        <ns2:ScheduleNumber>"+getLine.getScheduleNumber()+"</ns2:ScheduleNumber>\n" +
                                "                        <ns2:ShipToLocationCode>"+getLine.getShipToLocationCode()+"</ns2:ShipToLocationCode>\n" +
                                "                        <ns2:ShipToOrganizationId>"+getLine.getShipToOrganizationId()+"</ns2:ShipToOrganizationId>\n" +
                                "                        <ns2:ReceiptRoutingId>3</ns2:ReceiptRoutingId>\n" +
                                "                        <ns2:Action>CHANGE</ns2:Action>\n" +
                                "                    </ns2:PurchaseOrderEntrySchedule>\n" +
                                "                </ns2:PurchaseOrderEntryLine>\n";
                    }
                }
                //头信息
                String xmlStr = "<soap:Envelope\n" +
                        "    xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                        "    <soap:Body\n" +
                        "        xmlns:ns1=\"http://xmlns.oracle.com/apps/prc/po/editDocument/purchaseOrderServiceV2/types/\">\n" +
                        "        <ns1:changePurchaseOrder>\n" +
                        "            <ns1:changeOrderEntry\n" +
                        "                xmlns:ns2=\"http://xmlns.oracle.com/apps/prc/po/editDocument/purchaseOrderServiceV2/\">\n" +
                        "                <ns2:OrderNumber>"+updateReceiptRoutingList.getOrderNumber()+"</ns2:OrderNumber>\n" +
                        "                <ns2:SoldToLegalEntityId>"+updateReceiptRoutingList.getSoldToLegalEntityId()+"</ns2:SoldToLegalEntityId>\n" +
                        "                <ns2:ChangeOrderDescription>接收方式修改</ns2:ChangeOrderDescription>\n" +
                        "                <ns2:ApprovalActionCode>BYPASS</ns2:ApprovalActionCode>\n" +
                        "                <!--ApprovalActionCode valid values: NONE, BYPASS, SUBMIT-->\n" +
                                                lineDetails +
                        "            </ns1:changeOrderEntry>\n" +
                        "        </ns1:changePurchaseOrder>\n" +
                        "    </soap:Body>\n" +
                        "</soap:Envelope>";

                String scode = null;
                try {
                    scode = purchaseUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getPurchasUrl(),ConfigUtils.getPurchasName(),ConfigUtils.getPurchasMethodName()));

                if("SUCCESS".equals(scode)){
                    mesUpdateReceiptRoutingAll.setErpFlag("1");
                    mesUpdateReceiptRoutingAll.setErrorInfor("OK");
                    mesUpdateReceiptRoutingAll.setOrderNumber(updateReceiptRoutingList.getOrderNumber());
                    //回写ERP成功标识
                    mesUpdateReceiptRoutingAllMapper.updateErpFlag(mesUpdateReceiptRoutingAll);
                }else {
                    //回写ERP失败标识
                    mesUpdateReceiptRoutingAll.setErpFlag("2");
                    mesUpdateReceiptRoutingAll.setErrorInfor("【PO编号："+updateReceiptRoutingList.getOrderNumber()+"；"+"；"+"PO行号："+updateReceiptRoutingList.getLineNumber()+"；"+"；"+"PO行料号："+updateReceiptRoutingList.getItemNumber()+"；】"+scode);
                    mesUpdateReceiptRoutingAll.setOrderNumber(updateReceiptRoutingList.getOrderNumber());
                    //回写成功标识
                    mesUpdateReceiptRoutingAllMapper.updateErpFlag(mesUpdateReceiptRoutingAll);
                }
                } catch (Exception e) {
                    //回写ERP失败标识
                    mesUpdateReceiptRoutingAll.setErpFlag("2");
                    mesUpdateReceiptRoutingAll.setErrorInfor("【PO编号："+updateReceiptRoutingList.getOrderNumber()+"；"+"；"+"PO行号："+updateReceiptRoutingList.getLineNumber()+"；"+"；"+"PO行料号："+updateReceiptRoutingList.getItemNumber()+"；】"+e.getMessage());
                    mesUpdateReceiptRoutingAll.setOrderNumber(updateReceiptRoutingList.getOrderNumber());
                    //回写成功标识
                    mesUpdateReceiptRoutingAllMapper.updateErpFlag(mesUpdateReceiptRoutingAll);
                }
            }
        }
    }
}
