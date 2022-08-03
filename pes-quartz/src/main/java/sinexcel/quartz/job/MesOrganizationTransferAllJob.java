package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.quartz.domain.MesOrganizationTransferAllEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.MesOrganizationTransferAllMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.util.MiscellaneousTrnUtils;

import java.text.SimpleDateFormat;
import java.util.*;


@Component("mesOrganizationTransferAllJob")
public class MesOrganizationTransferAllJob{

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    SimpleDateFormat sdf11 = new SimpleDateFormat("yyyyMMddHHmmss");

    String lotNumber = null;

    @Autowired
    private MesOrganizationTransferAllMapper mesOrganizationTransferAllMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;


    public void report() {

        SysJobLog log = new SysJobLog();
        log.setJobName("MesOrganizationTransferAllJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        MesOrganizationTransferAllEO mesOrganizationTransferAll = new MesOrganizationTransferAllEO();
        mesOrganizationTransferAll.setStartUpdateDate(sdf.format(log.getStartTime()));
        mesOrganizationTransferAll.setEndUpdateDate(sdf.format(log.getStopTime()));


        List<MesOrganizationTransferAllEO> organizationTransferLists = mesOrganizationTransferAllMapper.getOrganizationTransferList(mesOrganizationTransferAll);

        sysJobLogMapper.updateLatUpdateDate(log);

        if(organizationTransferLists.size() > 0){
            for(MesOrganizationTransferAllEO organizationTransferList : organizationTransferLists){
                Date Num = new Date();
                //判断是否启用批次控制
                //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
                if(organizationTransferList.getLotControlCode()==2){
                    lotNumber = "                <stag:StagedInventoryTransactionLot>\n" +
                            "                    <stag:LotNumber>QC201810</stag:LotNumber>\n" +
                            "                    <stag:TransactionQuantity>"+organizationTransferList.getTransactionQuantity()+"</stag:TransactionQuantity>\n" +
                            "                </stag:StagedInventoryTransactionLot>\n";
                }else {
                    lotNumber = "";
                }
                //交易时间转换成格林威治时间
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(organizationTransferList.getTransactionDate() .getTime());
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
                        "                <stag:SourceCode>账户别名</stag:SourceCode>\n" +
                        "                <stag:SourceLineId>1</stag:SourceLineId>\n" +
                        "                <stag:SourceHeaderId>1</stag:SourceHeaderId>\n" +
                        "                <stag:ProcessCode>1</stag:ProcessCode>\n" +
                        "                <stag:TransactionMode>3</stag:TransactionMode>\n" +
                        "                <stag:InventoryItemId>"+organizationTransferList.getInventoryItemId()+"</stag:InventoryItemId>\n" +
                        "                <stag:OrganizationId>"+organizationTransferList.getOrganizationId()+"</stag:OrganizationId>\n" +
                        "                <stag:TransactionQuantity>"+organizationTransferList.getTransactionQuantity()+"</stag:TransactionQuantity>\n" +
                        "                <stag:TransactionUOM>"+organizationTransferList.getTransactionUom()+"</stag:TransactionUOM>\n" +
                        "                <stag:TransactionDate>"+sdf1.format(cal.getTime())+"</stag:TransactionDate>\n" +
                        "                <stag:SubinventoryCode>"+organizationTransferList.getSubinventoryCode()+"</stag:SubinventoryCode>\n" +
                        "                <stag:TransactionTypeId>"+organizationTransferList.getTransactionTypeId()+"</stag:TransactionTypeId>\n" +
                        "                <stag:UseCurrentCost>"+organizationTransferList.getUseCurrentCost()+"</stag:UseCurrentCost>\n" +
                        "                <stag:Attribute10>"+organizationTransferList.getRemark()+"</stag:Attribute10>\n" +
                        "                <stag:TransferSubinventory>"+organizationTransferList.getTransferSubinventory()+"</stag:TransferSubinventory>\n" +
                        "                <stag:TransferOrganization>"+organizationTransferList.getTransferOganizationId()+"</stag:TransferOrganization>\n"
                                             + lotNumber+
                        "            </typ:interfaceRows>\n" +
                        "            <typ:headerId>"+sdf11.format(Num)+"</typ:headerId>\n" +
                        "            <typ:validationLevel>1</typ:validationLevel>\n" +
                        "            <typ:tableType>1</typ:tableType>\n" +
                        "        </typ:insertAndProcessInterfaceRows>\n" +
                        "    </soapenv:Body>\n" +
                        "</soapenv:Envelope>";
                String scode = null;
                try {
                    scode = MiscellaneousTrnUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getMiscellaneousUrl(),ConfigUtils.getMiscellaneousName(),ConfigUtils.getMiscellaneousMethodName()));
                //返回值判断
                if("0".equals(scode)){
                    mesOrganizationTransferAll.setErpFlag("1");
                    mesOrganizationTransferAll.setOrgTransferId(organizationTransferList.getOrgTransferId());
                    mesOrganizationTransferAll.setErrorInfor("OK");
                    //回写ERP成功标识
                    mesOrganizationTransferAllMapper.updateErpFlag(mesOrganizationTransferAll);
                }else {
                    //回写ERP失败标识
                    mesOrganizationTransferAll.setErpFlag("2");
                    mesOrganizationTransferAll.setOrgTransferId(organizationTransferList.getOrgTransferId());
                    mesOrganizationTransferAll.setErrorInfor("【组织间转移ID："+organizationTransferList.getOrgTransferId()+"；"+"MES主键："+organizationTransferList.getRemark()+"数据回传ERP失败】；"+scode);
                    //回写成功标识
                    mesOrganizationTransferAllMapper.updateErpFlag(mesOrganizationTransferAll);
                }
                } catch (Exception e) {
                    mesOrganizationTransferAll.setErpFlag("2");
                    mesOrganizationTransferAll.setOrgTransferId(organizationTransferList.getOrgTransferId());
                    mesOrganizationTransferAll.setErrorInfor("【组织间转移ID："+organizationTransferList.getOrgTransferId()+"；"+"MES主键："+organizationTransferList.getRemark()+"接口运行异常】；"+e.getMessage());
                    //回写成功标识
                    mesOrganizationTransferAllMapper.updateErpFlag(mesOrganizationTransferAll);
                }
            }
        }
    }
}
