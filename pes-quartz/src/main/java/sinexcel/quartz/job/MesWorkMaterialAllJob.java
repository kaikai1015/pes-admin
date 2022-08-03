package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.quartz.domain.MesWorkMaterialAllEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.MesWorkMaterialAllMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.util.WorkMaterialUtils;

import java.text.SimpleDateFormat;
import java.util.*;


@Component("mesWorkMaterialAllJob")
public class MesWorkMaterialAllJob{

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    String lotNumber = null;

    @Autowired
    private MesWorkMaterialAllMapper workMaterialAllMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;


    public void report() {

        SysJobLog log = new SysJobLog();
        log.setJobName("MesWorkMaterialAllJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        MesWorkMaterialAllEO workMaterialAllEO = new MesWorkMaterialAllEO();
        workMaterialAllEO.setStartUpdateDate(sdf.format(log.getStartTime()));
        workMaterialAllEO.setEndUpdateDate(sdf.format(log.getStopTime()));


        List<MesWorkMaterialAllEO> materialLists = workMaterialAllMapper.getWorkMaterialList(workMaterialAllEO);

        sysJobLogMapper.updateLatUpdateDate(log);

        if(materialLists.size() > 0){
            for(MesWorkMaterialAllEO materialList : materialLists){
                MesWorkMaterialAllEO orgCode = workMaterialAllMapper.selectOrgnazationCode(materialList.getOrganizationId());
                //判断是否启用批次控制
                //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
                if(materialList.getLotControlCode()== 2){
                    lotNumber = "                    <ns2:TransactionLotInput>\n" +
                            "                        <ns2:LotNumber>QC201810</ns2:LotNumber>\n" +
                            "                        <ns2:TransactionQuantity>"+materialList.getTransactionQuantity()+"</ns2:TransactionQuantity>\n" +
                            "                    </ns2:TransactionLotInput>\n";
                }else {
                    lotNumber = "";
                }

                //交易时间转换成格林威治时间
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(log.getStopTime() .getTime());
                cal.add(Calendar.HOUR, -8);
                String xmlStr = "<soap:Envelope\n" +
                        "    xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                        "    xmlns:ns1=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/types/\"\n" +
                        "    xmlns:ns2=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/\">\n" +
                        "    <soap:Body>\n" +
                        "        <ns1:createWorkOrderMaterialTransactions>\n" +
                        "            <ns1:batchInput>\n" +
                        "                <ns2:MaterialTransactionInput>\n" +
                        "                    <ns2:WorkOrderNumber>"+materialList.getWorkOrderNumber()+"</ns2:WorkOrderNumber>\n" +
                        "                    <ns2:OperationSequence>"+materialList.getOperationSequence()+"</ns2:OperationSequence>\n" +
                        "                    <ns2:TransactionType>"+materialList.getTransactionType()+"</ns2:TransactionType>\n" +
                        "                    <ns2:InventoryItemNumber>"+materialList.getItemNumber()+"</ns2:InventoryItemNumber>\n" +
                        "                    <ns2:Organization>"+orgCode.getOrganizationCode()+"</ns2:Organization>\n" +
                        "                    <ns2:TransactionQuantity unitCode=\""+materialList.getUomCode()+"\">"+materialList.getTransactionQuantity()+"</ns2:TransactionQuantity>\n" +
                        "                    <ns2:TransactionDate>"+sdf1.format(cal.getTime())+"</ns2:TransactionDate>\n" +
                        "                    <ns2:SourceHeaderReference>" + materialList.getRemark() + "</ns2:SourceHeaderReference>\n" +
                        "                    <ns2:Subinventory>"+materialList.getSubinventoryCode()+"</ns2:Subinventory>\n"
                                                + lotNumber+
                        "                </ns2:MaterialTransactionInput>\n" +
                        "            </ns1:batchInput>\n" +
                        "        </ns1:createWorkOrderMaterialTransactions>\n" +
                        "    </soap:Body>\n" +
                        "</soap:Envelope>";

                String scode = null;
                try {
                    scode = WorkMaterialUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getWorkMaterialUrl(),ConfigUtils.getWorkMaterialName(),ConfigUtils.getWorkMaterialMethodName()));

                if("COMPLETED".equals(scode)){
                    workMaterialAllEO.setErpFlag("1");
                    workMaterialAllEO.setMaterialId(materialList.getMaterialId());
                    workMaterialAllEO.setErrorInfor("OK");
                    //回写ERP成功标识
                    workMaterialAllMapper.updateErpFlag(workMaterialAllEO);
                }else {
                    //回写ERP失败标识
                    workMaterialAllEO.setErpFlag("2");
                    workMaterialAllEO.setErrorInfor("【工单超耗ID："+materialList.getMaterialId()+"；"+"MES主键："+materialList.getRemark()+"；】"+scode);
                    workMaterialAllEO.setMaterialId(materialList.getMaterialId());
                    //回写成功标识
                    workMaterialAllMapper.updateErpFlag(workMaterialAllEO);
                }
                } catch (Exception e) {
                    workMaterialAllEO.setErpFlag("2");
                    workMaterialAllEO.setErrorInfor("【工单超耗ID："+materialList.getMaterialId()+"；"+"MES主键："+materialList.getRemark()+"；】"+e.getMessage());
                    workMaterialAllEO.setMaterialId(materialList.getMaterialId());
                    //回写成功标识
                    workMaterialAllMapper.updateErpFlag(workMaterialAllEO);
                }
            }
        }
    }
}
