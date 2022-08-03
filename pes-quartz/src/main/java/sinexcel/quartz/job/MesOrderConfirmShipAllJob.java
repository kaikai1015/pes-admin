package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.quartz.domain.MesOrderConfirmShipAllEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.MesOrderConfirmShipAllMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.util.ESSWebServiceUtils;
import sinexcel.quartz.util.MesOrderConfirmShipUtils;
import sinexcel.wsc.soap.ess.ESSWebService;
import sinexcel.wsc.soap.ess.State;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component("mesOrderConfirmShipAllJob")
public class MesOrderConfirmShipAllJob {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf11 = new SimpleDateFormat("yyyyMMddHHmmss");
    String lotNumber = null,subinventoryCode = null,statusEss = null,errorInfor = null;

    @Autowired
    private MesOrderConfirmShipAllMapper mesOrderConfirmShipAllMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    public void report() {
        SysJobLog log = new SysJobLog();
        log.setJobName("MesOrderConfirmShipAllJob");
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

        MesOrderConfirmShipAllEO mesOrderConfirmShipAll = new MesOrderConfirmShipAllEO();
        mesOrderConfirmShipAll.setStartUpdateDate(sdf.format(log.getStartTime()));
        mesOrderConfirmShipAll.setEndUpdateDate(sdf.format(log.getStopTime()));

        //遍历订单信息
        List<MesOrderConfirmShipAllEO> orderConfirmShipAllLists = mesOrderConfirmShipAllMapper.getOrderConfirmShipAllList(mesOrderConfirmShipAll);

        sysJobLogMapper.updateLatUpdateDate(log);
        ESSWebService eSSWebService = ESSWebServiceUtils.getESSWebService();
        if(orderConfirmShipAllLists.size() > 0){
            //循环订单
                for(MesOrderConfirmShipAllEO orderConfirmShipAllList:orderConfirmShipAllLists){
                    //判断是否启用批次控制
                    //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
                    //有批次行信息不需要subinventoryCode信息，在批次中体现subinventoryCode信息
                    if(orderConfirmShipAllList.getLotControlCode()!=null&&orderConfirmShipAllList.getLotControlCode()==2){
                        lotNumber = "                    <ship:Lot>\n" +
                                "                        <ship:LotNumber>QC201810</ship:LotNumber>\n" +
                                "                        <ship:SubinventoryCode>"+orderConfirmShipAllList.getSubinventoryCode()+"</ship:SubinventoryCode>\n" +
                                "                        <ship:TransactionQuantity unitCode=\""+orderConfirmShipAllList.getUnitUode()+"\">"+orderConfirmShipAllList.getShippedQuantity()+"</ship:TransactionQuantity>\n" +
                                "                    </ship:Lot>\n";
                        subinventoryCode = "";
                    }else{
                        lotNumber = "";
                        subinventoryCode = "                    <ship:Subinventory>"+orderConfirmShipAllList.getSubinventoryCode()+"</ship:Subinventory>\n";
                    }
                    //ShipmentName取值
                    Date Num = new Date();
                //拼接头报文
                String xmlStr ="<soap:Envelope\n" +
                        "    xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                        "    <soap:Body>\n" +
                        "        <ns1:createAndConfirm\n" +
                        "            xmlns:ns1=\"http://xmlns.oracle.com/apps/scm/shipping/shipConfirm/deliveries/shipmentService/types/\">\n" +
                        "            <ns1:shipment\n" +
                        "                xmlns:ship=\"http://xmlns.oracle.com/apps/scm/shipping/shipConfirm/deliveries/shipmentService/\">\n" +
                        "                <ship:ShipmentName>"+sdf11.format(Num)+"</ship:ShipmentName>\n" +
                        "                <ship:OrganizationCode>"+orderConfirmShipAllList.getOrganizationCode()+"</ship:OrganizationCode>\n" +
                        "                <ship:Waybill>"+orderConfirmShipAllList.getWaybillNumber()+"</ship:Waybill>\n" +
                        "                <ship:SealNumber>"+orderConfirmShipAllList.getSealNumber()+"</ship:SealNumber>\n" +
                        "                <ship:ShipmentLine>\n" +
                        "                    <ship:DeliveryDetailId>"+orderConfirmShipAllList.getDeliveryDetailId()+"</ship:DeliveryDetailId>\n" +
                        "                    <ship:ItemNumber>"+orderConfirmShipAllList.getItemNumber()+"</ship:ItemNumber>\n" +
                        "                    <ship:ShippedQuantity unitCode=\""+orderConfirmShipAllList.getUnitUode()+"\">"+orderConfirmShipAllList.getShippedQuantity()+"</ship:ShippedQuantity>\n" +
                                                subinventoryCode +
                        "                    <ship:DefaultTaxationCountry>China</ship:DefaultTaxationCountry>\n" +
                        "                    <ship:TransactionBusinessCategory>Sales Transaction</ship:TransactionBusinessCategory>\n" +
                                                lotNumber +
                        "                <ship:Attribute10>"+orderConfirmShipAllList.getRemark()+"</ship:Attribute10>\n" +
                        "                </ship:ShipmentLine>\n" +
                        "            </ns1:shipment>\n" +
                        "        </ns1:createAndConfirm>\n" +
                        "    </soap:Body>\n" +
                        "</soap:Envelope>";

                    String shipmentName = null;
                    try {
                        shipmentName = MesOrderConfirmShipUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getOrderConfirmShipUrl(),ConfigUtils.getOrderConfirmShipName(),ConfigUtils.getOrderConfirmShipMethodName()));
                        //开始调用ESS提交进程接口
                        if(shipmentName.equals(sdf11.format(Num))){
                            //提交ESS进程
                            long requestid = ESSWebServiceUtils.submitRequestGeneration(eSSWebService,shipmentName);
                            if(requestid > 0){
                                mesOrderConfirmShipAll.setRequestId(requestid);
                                mesOrderConfirmShipAll.setShimentName(shipmentName);
                                mesOrderConfirmShipAll.setConfirmId(orderConfirmShipAllList.getConfirmId());
                                mesOrderConfirmShipAllMapper.updateErpFlag(mesOrderConfirmShipAll);
                            }else {
                                mesOrderConfirmShipAll.setErpFlag("2");
                                mesOrderConfirmShipAll.setConfirmId(orderConfirmShipAllList.getConfirmId());
                                mesOrderConfirmShipAll.setErrorInfor("【销售发运ID："+orderConfirmShipAllList.getConfirmId()+"；"+"MES主键："+orderConfirmShipAllList.getRemark()+"；"+"销售发运接口运行完毕，提交Perform Shipping Transactions ESS进程失败：】"+shipmentName);
                                //回写ERP成功标识
                                mesOrderConfirmShipAllMapper.updateErpFlag(mesOrderConfirmShipAll);
                            }
                        }else {
                            mesOrderConfirmShipAll.setErpFlag("2");
                            mesOrderConfirmShipAll.setConfirmId(orderConfirmShipAllList.getConfirmId());
                            mesOrderConfirmShipAll.setErrorInfor("【销售发运ID："+orderConfirmShipAllList.getConfirmId()+"；"+"MES主键："+orderConfirmShipAllList.getRemark()+"；"+"销售发运接口运行失败：】"+shipmentName);
                            //回写ERP成功标识
                            mesOrderConfirmShipAllMapper.updateErpFlag(mesOrderConfirmShipAll);
                        }
                    } catch (Exception e) {
                        mesOrderConfirmShipAll.setErpFlag("2");
                        mesOrderConfirmShipAll.setConfirmId(orderConfirmShipAllList.getConfirmId());
                        mesOrderConfirmShipAll.setErrorInfor("【销售发运ID："+orderConfirmShipAllList.getConfirmId()+"；"+"MES主键："+orderConfirmShipAllList.getRemark()+"；"+"销售发运接口运行异常：】"+e.getMessage());
                        //回写ERP成功标识
                        mesOrderConfirmShipAllMapper.updateErpFlag(mesOrderConfirmShipAll);
                    }

                }
        }

        //遍历检查ESS进程运行结果
        List<MesOrderConfirmShipAllEO> requestIds = mesOrderConfirmShipAllMapper.getOrderConfirmShipAllList(mesOrderConfirmShipAll);
        if(requestIds.size()>0){
            for(MesOrderConfirmShipAllEO requestId:requestIds){
                State getStatusEss = null;
                try {
                //不停刷新进程状态
                do{
                    getStatusEss = ESSWebServiceUtils.getEssRequestState(eSSWebService,requestId.getRequestId());
                    statusEss = getStatusEss.value();
                }while ("WAIT".equals(statusEss)||"READY".equals(statusEss)||"RUNNING".equals(statusEss)||"COMPLETED".equals(statusEss));
                //返回值判断
                if("SUCCEEDED".equals(statusEss)){
                    mesOrderConfirmShipAll.setErpFlag("1");
                    mesOrderConfirmShipAll.setShimentName(requestId.getShimentName());
                    mesOrderConfirmShipAll.setRequestId(requestId.getRequestId());
                    mesOrderConfirmShipAll.setConfirmId(requestId.getConfirmId());
                    mesOrderConfirmShipAll.setRequestStatus(statusEss);
                    mesOrderConfirmShipAll.setErrorInfor("OK");
                    //回写ERP成功标识
                    mesOrderConfirmShipAllMapper.updateErpFlag(mesOrderConfirmShipAll);
                }else {
                    //回写ERP失败标识
                    mesOrderConfirmShipAll.setErpFlag("2");
                    mesOrderConfirmShipAll.setShimentName(requestId.getShimentName());
                    mesOrderConfirmShipAll.setRequestId(requestId.getRequestId());
                    mesOrderConfirmShipAll.setConfirmId(requestId.getConfirmId());
                    mesOrderConfirmShipAll.setRequestStatus(statusEss);
                    mesOrderConfirmShipAll.setErrorInfor("【销售发运ID："+requestId.getConfirmId()+"；"+"MES主键："+requestId.getRemark()+"；"+"遍历检查ESS进程运行结果：】"+statusEss);
                    //回写成功标识
                    mesOrderConfirmShipAllMapper.updateErpFlag(mesOrderConfirmShipAll);
                }
                } catch (Exception e) {
                    mesOrderConfirmShipAll.setErpFlag("2");
                    mesOrderConfirmShipAll.setConfirmId(requestId.getConfirmId());
                    mesOrderConfirmShipAll.setRequestStatus(statusEss);
                    mesOrderConfirmShipAll.setErrorInfor("【销售发运ID："+requestId.getConfirmId()+"；"+"MES主键："+requestId.getRemark()+"；"+"ESS进程运行异常：】"+e.getMessage());
                    //回写成功标识
                    mesOrderConfirmShipAllMapper.updateErpFlag(mesOrderConfirmShipAll);
                }
            }
        }
    }
}
