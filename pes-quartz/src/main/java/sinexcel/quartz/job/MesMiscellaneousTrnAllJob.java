package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.quartz.domain.MesMiscellaneousTrnAllEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.MesMiscellaneousTrnAllMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.util.MiscellaneousTrnUtils;

import java.text.SimpleDateFormat;
import java.util.*;


@Component("mesMiscellaneousTrnAllJob")
public class MesMiscellaneousTrnAllJob{

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    SimpleDateFormat sdf11 = new SimpleDateFormat("yyyyMMddHHmmss");

    String unitCostFlag = null,lotNumber = null;

    @Autowired
    private MesMiscellaneousTrnAllMapper mesMiscellaneousTrnAllMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;


    public void report(){

        SysJobLog log = new SysJobLog();
        log.setJobName("MesMiscellaneousTrnAllJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        MesMiscellaneousTrnAllEO mesMiscellaneousTrnAll = new MesMiscellaneousTrnAllEO();
        mesMiscellaneousTrnAll.setStartUpdateDate(sdf.format(log.getStartTime()));
        mesMiscellaneousTrnAll.setEndUpdateDate(sdf.format(log.getStopTime()));


        List<MesMiscellaneousTrnAllEO> miscellaneousTrnLists = mesMiscellaneousTrnAllMapper.getMiscellaneousTrnList(mesMiscellaneousTrnAll);

        sysJobLogMapper.updateLatUpdateDate(log);

        if(miscellaneousTrnLists.size() > 0){
            String scode = null;
            StringBuilder failureMsg = new StringBuilder();
            for(MesMiscellaneousTrnAllEO miscellaneousTrnList : miscellaneousTrnLists){
                //transactionSourceId
                MesMiscellaneousTrnAllEO transactionSourceId = mesMiscellaneousTrnAllMapper.selectTransactionSourceId(miscellaneousTrnList.getOrganizationId());
                //TransactionHeaderId，TransactionInterfaceId，headerId
                Date Num = new Date();
                //是否使用当前成本
                if("N".equals(miscellaneousTrnList.getUseCurrentCost())){
                    unitCostFlag = "                <stag:TransactionCostIdentifier>"+sdf11.format(Num)+"</stag:TransactionCostIdentifier>\n" +
                            "                <stag:StagedInventoryTransactionCost>\n" +
                            "                    <stag:Cost>"+miscellaneousTrnList.getUnitCost()+"</stag:Cost>\n" +
                            "                    <stag:CostComponentCode>"+miscellaneousTrnList.getCostComponentCode()+"</stag:CostComponentCode>\n" +
                            "                </stag:StagedInventoryTransactionCost>\n";
                }else {
                    unitCostFlag = "";
                }
                //判断是否启用批次控制
                //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
                if(miscellaneousTrnList.getLotControlCode()==2){
                    lotNumber = "                <stag:StagedInventoryTransactionLot>\n" +
                            "                    <stag:LotNumber>QC201810</stag:LotNumber>\n" +
                            "                    <stag:TransactionQuantity>"+miscellaneousTrnList.getTransactionQuantity()+"</stag:TransactionQuantity>\n" +
                            "                </stag:StagedInventoryTransactionLot>\n";
                }else {
                    lotNumber = "";
                }
                //交易时间转换成格林威治时间
//                Calendar cal = Calendar.getInstance();
//                cal.setTimeInMillis(miscellaneousTrnList.getTransactionDate() .getTime());
//                cal.add(Calendar.HOUR, -8);
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(log.getStopTime() .getTime());
                cal.add(Calendar.HOUR, -8);

                String xmlStr = "<soapenv:Envelope\n" +
                        "    xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                        "    xmlns:typ=\"http://xmlns.oracle.com/apps/scm/inventory/materialTransactions/pendingTransactions/transactionManagerServiceV2/types/\"\n" +
                        "    xmlns:stag=\"http://xmlns.oracle.com/apps/scm/inventory/materialTransactions/pendingTransactions/stagedInventoryTransactionServiceV2/\">\n" +
                        "    <soapenv:Header/>\n" +
                        "    <soapenv:Body>\n" +
                        "        <typ:insertAndProcessInterfaceRows>\n" +
                        "            <typ:interfaceRows>\n" +
                        "                <stag:TransactionHeaderId>"+sdf11.format(Num)+"</stag:TransactionHeaderId>\n" +
                        "                <stag:TransactionInterfaceId>"+sdf11.format(Num)+"</stag:TransactionInterfaceId>\n" +
                        "                <stag:SourceCode>"+miscellaneousTrnList.getSourceCode()+"</stag:SourceCode>\n" +
                        "                <stag:SourceLineId>1</stag:SourceLineId>\n" +
                        "                <stag:SourceHeaderId>1</stag:SourceHeaderId>\n" +
                        "                <stag:ProcessCode>1</stag:ProcessCode>\n" +
                        "                <stag:TransactionMode>3</stag:TransactionMode>\n" +
                        "                <stag:InventoryItemId>"+miscellaneousTrnList.getInventoryItemId()+"</stag:InventoryItemId>\n" +
                        "                <stag:OrganizationId>"+miscellaneousTrnList.getOrganizationId()+"</stag:OrganizationId>\n" +
                        "                <stag:TransactionQuantity>"+miscellaneousTrnList.getTransactionQuantity()+"</stag:TransactionQuantity>\n" +
                        "                <stag:TransactionUOM>"+miscellaneousTrnList.getUomCode()+"</stag:TransactionUOM>\n" +
                        "                <stag:TransactionDate>"+sdf1.format(cal.getTime())+"</stag:TransactionDate>\n" +
                        "                <stag:SubinventoryCode>"+miscellaneousTrnList.getSubinventoryCode()+"</stag:SubinventoryCode>\n" +
                        "                <stag:TransactionSourceTypeId>"+miscellaneousTrnList.getTransactionSourceTypeId()+"</stag:TransactionSourceTypeId>\n" +
                        "                <stag:TransactionTypeId>"+miscellaneousTrnList.getTransactionTypeId()+"</stag:TransactionTypeId>\n" +
                        "                <stag:TransactionSourceId>"+transactionSourceId.getTransactionSourceId()+"</stag:TransactionSourceId>\n" +
                        "                <stag:TransactionSourceName>"+miscellaneousTrnList.getRemark()+"</stag:TransactionSourceName>\n" +
                        "                <stag:TransactionReference>"+miscellaneousTrnList.getWmsRemarkDescription()+"</stag:TransactionReference>\n" +
                        "                <stag:Attribute1>"+miscellaneousTrnList.getContractNumber()+"</stag:Attribute1>\n" +
                        "                <stag:Attribute2>"+miscellaneousTrnList.getShProject()+"</stag:Attribute2>\n" +
                        "                <stag:Attribute3>"+miscellaneousTrnList.getShDepartment()+"</stag:Attribute3>\n" +
                        "                <stag:Attribute4>"+miscellaneousTrnList.getShEmployee()+"</stag:Attribute4>\n" +
                        "                <stag:Attribute5>"+miscellaneousTrnList.getShWwSupplier()+"</stag:Attribute5>\n" +
                        "                <stag:Attribute6>"+miscellaneousTrnList.getShTextContractNum()+"</stag:Attribute6>\n" +
                        "                <stag:Attribute7>"+miscellaneousTrnList.getShProductLine()+"</stag:Attribute7>\n" +
                        "                <stag:Attribute10>"+miscellaneousTrnList.getRemark()+"</stag:Attribute10>\n" +
                        "                <stag:UseCurrentCost>"+miscellaneousTrnList.getUseCurrentCost()+"</stag:UseCurrentCost>\n"
                                            + unitCostFlag
                                            + lotNumber+
                        "            </typ:interfaceRows>\n" +
                        "            <typ:headerId>"+sdf11.format(Num)+"</typ:headerId>\n" +
                        "            <typ:validationLevel>1</typ:validationLevel>\n" +
                        "            <typ:tableType>1</typ:tableType>\n" +
                        "        </typ:insertAndProcessInterfaceRows>\n" +
                        "    </soapenv:Body>\n" +
                        "</soapenv:Envelope>";

                try {
                    scode = MiscellaneousTrnUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getMiscellaneousUrl(),ConfigUtils.getMiscellaneousName(),ConfigUtils.getMiscellaneousMethodName()));
                    //返回值判断
                    if("0".equals(scode)){
                        mesMiscellaneousTrnAll.setErpFlag("1");
                        mesMiscellaneousTrnAll.setErrorInfor("OK");
                        mesMiscellaneousTrnAll.setTransactionId(miscellaneousTrnList.getTransactionId());
                        //回写ERP成功标识
                        mesMiscellaneousTrnAllMapper.updateErpFlag(mesMiscellaneousTrnAll);
                    }else {
                        //回写ERP失败标识
                        mesMiscellaneousTrnAll.setErpFlag("2");
                        mesMiscellaneousTrnAll.setErrorInfor("【杂项事务处理ID："+miscellaneousTrnList.getTransactionId()+"；"+"MES主键："+miscellaneousTrnList.getRemark()+"】"+scode);
                        mesMiscellaneousTrnAll.setTransactionId(miscellaneousTrnList.getTransactionId());
                        //回写成功标识
                        mesMiscellaneousTrnAllMapper.updateErpFlag(mesMiscellaneousTrnAll);
                    }
                } catch (Exception e) {
                    mesMiscellaneousTrnAll.setErpFlag("2");
                    mesMiscellaneousTrnAll.setErrorInfor("【杂项事务处理ID："+miscellaneousTrnList.getTransactionId()+"；"+"MES主键："+miscellaneousTrnList.getRemark()+"】"+e.getMessage());
                    mesMiscellaneousTrnAll.setTransactionId(miscellaneousTrnList.getTransactionId());
                    //回写成功标识
                    mesMiscellaneousTrnAllMapper.updateErpFlag(mesMiscellaneousTrnAll);
                }
            }
        }
    }
}
