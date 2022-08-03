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
//                //统计单身扣料是否全部完成
                int failureNum = 0;
//                StringBuilder failureMsg = new StringBuilder();
//                //得到库存组织
                MesWieWoCompleteAllDKEO orgCode = mesWieWoCompleteAllDKMapper.selectOrgnazationCode(wieWoCompleteDkList.getOrganizationId());
                //工单完工入库和计划数量比例
//                List<MesWieWoCompleteAllDKEO> getWorkDemandLists = mesWieWoCompleteAllDKMapper.getWorkDemandLists(wieWoCompleteDkList);
//                if(getWorkDemandLists.size() > 0){
//                    for(MesWieWoCompleteAllDKEO getWorkDemandList : getWorkDemandLists){
//                        String subinventoryCode = (getWorkDemandList.getItemWorkNameFlag()=="4"||"4".equals(getWorkDemandList.getItemWorkNameFlag()))? "3FCKL001":getWorkDemandList.getSubinventoryCode();
//                        //根据（套数 + 已完工）* 比例 - 已发放 = 扣料数量
//                        MesWieWoCompleteAllDKEO getTranQuantity = mesWieWoCompleteAllDKMapper.getTranQuantity(getWorkDemandList);
//                        if(!(getWorkDemandList.getItemWorkNameFlag()=="4"||"4".equals(getWorkDemandList.getItemWorkNameFlag()))){
//                            if(StringUtils.isNotNull(getTranQuantity)){
//                                transaQuantity = (getTranQuantity.getBasisType()=="2"||"2".equals(getTranQuantity.getBasisType()))? getTranQuantity.getRequiredQuantity():getWorkDemandList.getTransactionQuantity().add(getTranQuantity.getCompletedQuantity()).subtract(getTranQuantity.getIssuedQuantity());
//                                if((transaQuantity.compareTo(BigDecimal.ZERO)==1)&&(getTranQuantity.getRequiredQuantity().compareTo(getTranQuantity.getIssuedQuantity())==1)){
//                                    //判断是否启用批次控制
//                                    //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
//                                    if(getWorkDemandList.getLotControlCode()== 2){
//                                        lotNumber = "                    <ns2:TransactionLotInput>\n" +
//                                                "                        <ns2:LotNumber>QC201810</ns2:LotNumber>\n" +
//                                                "                        <ns2:TransactionQuantity>"+transaQuantity+"</ns2:TransactionQuantity>\n" +
//                                                "                    </ns2:TransactionLotInput>\n";
//                                    }else {
//                                        lotNumber = "";
//                                    }
//
//                                    //系统时间转换成格林威治时间
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
//                                            //回写ERP成功标识
//                                            mesWieWoCompleteAllDk.setErrorInfor("OK");
//                                            mesWieWoCompleteAllDKMapper.updateLineErpFlag(mesWieWoCompleteAllDk);
//                                        }else {
//                                            mesWieWoCompleteAllDk.setErpFlag("2");
//                                            mesWieWoCompleteAllDk.setWieLineId(getWorkDemandList.getWieLineId());
//                                            mesWieWoCompleteAllDk.setTransactionQuantity(transaQuantity);
//                                            //回写ERP失败标识
//                                            failureNum++;
//                                            mesWieWoCompleteAllDk.setErrorInfor("【ID："+getWorkDemandList.getWieLineId()+",工单号："+getWorkDemandList.getWorkOrderNumber()+",料号："+getWorkDemandList.getItemNumber()+",MES主键："+getWorkDemandList.getRemark()+"】"+scode);
//                                            mesWieWoCompleteAllDKMapper.updateLineErpFlag(mesWieWoCompleteAllDk);
//                                        }
//                                    } catch (Exception e) {
//                                        mesWieWoCompleteAllDk.setErpFlag("2");
//                                        mesWieWoCompleteAllDk.setWieLineId(getWorkDemandList.getWieLineId());
//                                        //回写ERP失败标识
//                                        failureNum++;
//                                        mesWieWoCompleteAllDk.setErrorInfor("【ID："+getWorkDemandList.getWieLineId()+",工单号："+getWorkDemandList.getWorkOrderNumber()+",料号："+getWorkDemandList.getItemNumber()+",MES主键："+getWorkDemandList.getRemark()+"】"+e.getMessage());
//                                        mesWieWoCompleteAllDKMapper.updateLineErpFlag(mesWieWoCompleteAllDk);
//                                    }
//                                }else {
//                                    //ERP已经扣料了，实际发料等于0
//                                    mesWieWoCompleteAllDk.setErpFlag("3");
//                                    mesWieWoCompleteAllDk.setWieLineId(getWorkDemandList.getWieLineId());
//                                    mesWieWoCompleteAllDk.setTransactionQuantity(transaQuantity);
//                                    //回写ERP成功标识
//                                    mesWieWoCompleteAllDk.setErrorInfor("OK");
//                                    mesWieWoCompleteAllDKMapper.updateLineErpFlag(mesWieWoCompleteAllDk);
//                                }
//                            }else {
//                                //ERP已经扣料了，实际发料等于0
//                                mesWieWoCompleteAllDk.setErpFlag("3");
//                                mesWieWoCompleteAllDk.setWieLineId(getWorkDemandList.getWieLineId());
//                                mesWieWoCompleteAllDk.setTransactionQuantity(BigDecimal.ZERO);
//                                //回写ERP成功标识
//                                mesWieWoCompleteAllDk.setErrorInfor("OK");
//                                mesWieWoCompleteAllDKMapper.updateLineErpFlag(mesWieWoCompleteAllDk);
//                            }
//                        }else {
//                            //ERP已经扣料了，实际发料等于0
//                            mesWieWoCompleteAllDk.setErpFlag("3");
//                            mesWieWoCompleteAllDk.setWieLineId(getWorkDemandList.getWieLineId());
//                            mesWieWoCompleteAllDk.setTransactionQuantity(BigDecimal.ZERO);
//                            //回写ERP成功标识
//                            mesWieWoCompleteAllDk.setErrorInfor("OK");
//                            mesWieWoCompleteAllDKMapper.updateLineErpFlag(mesWieWoCompleteAllDk);
//                        }
//
//                    }
//                }
//                //根据工单ID，组织ID，Remark再次判断是否还有未扣料的明细，如果有，不能完工入库
//                int getAllErpFlag = mesWieWoCompleteAllDKMapper.getAllErpFlag(wieWoCompleteDkList);
//                //判断是否WMS回传了单身明细，如没有直接完工入库
//                int isDetails = mesWieWoCompleteAllDKMapper.getIsDetails(wieWoCompleteDkList);
//                //判断，failureNum > 0说明单身扣料有错误，需要抛出异常，否则进行进行工单完工入库
//                if((failureNum == 0 && getAllErpFlag > 0)|| isDetails == 0){

                    //                if((((getWorkDemandLists.size() > 0 ? ((successNum == getWorkDemandLists.size())&&failureNum==0) : (mesWieWoCompleteAllDKMapper.getAllErpFlag(wieWoCompleteDkList) > 0 ? true : false))))){//判断是否全部领料完成，没有错误出现
                    //单身发料完成，进行工单完工入库
                    //得到工单完工工序
                    List<MesWieWoCompleteAllDKEO> woOperationSequenceNumber = mesWieWoCompleteAllDKMapper.selectOperSequenceNumber(wieWoCompleteDkList.getWorkOrderId());

                    for(int i = 0; i < woOperationSequenceNumber.size(); i ++){
                        //Json头信息
                        JSONObject requestJsonObject = new JSONObject();
                        requestJsonObject.put("SourceSystemCode", sourceSystemCode);
                        requestJsonObject.put("SourceSystemType", sourceSystemType);
                        List OperationTransactionDetail = new ArrayList<>();

                        int seqNum = woOperationSequenceNumber.get(i).getWoOperationSequenceNumber();
                        //交易时间转换成格林威治时间
                        Calendar cal = Calendar.getInstance();
                        cal.setTimeInMillis(log.getStopTime() .getTime());
                        cal.add(Calendar.HOUR, -8);

                        //把json串拼接
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

                        //判断是否启用批次控制
                        //SYNC_EGP_SYSTEM_ITEMS_B.LOT_CONTROL_CODE: 2 启用； 1 不启用
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
                                mesWieWoCompleteAllDk.setErpFlag("1");
                                mesWieWoCompleteAllDk.setErrorInfor("OK");
                                mesWieWoCompleteAllDk.setWoCompleteId(wieWoCompleteDkList.getWoCompleteId());
                                mesWieWoCompleteAllDKMapper.updateErpFlag(mesWieWoCompleteAllDk);
                            }else {
                                JSONArray dtlList = (JSONArray) responseJsonObject.get("OperationTransactionDetail");
                                JSONObject line = (JSONObject) dtlList.get(0);
                                String ErrorMessages = line.get("ErrorMessages").toString();
                                //回写ERP失败标识
                                mesWieWoCompleteAllDk.setErpFlag("2");
                                mesWieWoCompleteAllDk.setErrorInfor("【完工入库 ID："+wieWoCompleteDkList.getWoCompleteId()+"；工单："+wieWoCompleteDkList.getWorkOrderNumber()+"；"+"MES主键："+wieWoCompleteDkList.getRemark()+"】"+ErrorMessages);
                                mesWieWoCompleteAllDk.setWoCompleteId(wieWoCompleteDkList.getWoCompleteId());
                                mesWieWoCompleteAllDKMapper.updateErpFlag(mesWieWoCompleteAllDk);
                            }
                        } catch (Exception e) {
                            mesWieWoCompleteAllDk.setErpFlag("2");
                            mesWieWoCompleteAllDk.setErrorInfor("【完工入库 ID："+wieWoCompleteDkList.getWoCompleteId()+"；工单："+wieWoCompleteDkList.getWorkOrderNumber()+"；"+"MES主键："+wieWoCompleteDkList.getRemark()+"】"+e.getMessage());
                            mesWieWoCompleteAllDk.setWoCompleteId(wieWoCompleteDkList.getWoCompleteId());
                            mesWieWoCompleteAllDKMapper.updateErpFlag(mesWieWoCompleteAllDk);
                        }
                    }
//                }
//                else {
//                    mesWieWoCompleteAllDk.setErpFlag("2");
//                    mesWieWoCompleteAllDk.setErrorInfor("单身明细存在扣料失败，请查看明细数据！！！");
//                    mesWieWoCompleteAllDk.setWoCompleteId(wieWoCompleteDkList.getWoCompleteId());
//                    mesWieWoCompleteAllDKMapper.updateErpFlag(mesWieWoCompleteAllDk);
//                }


//                }else {
//                    mesWieWoCompleteAllDk.setErpFlag("2");
//                    mesWieWoCompleteAllDKMapper.updateErpFlag(mesWieWoCompleteAllDk);
//                    if(failureNum==0){
//                        failureMsg.insert(0, "【完工入库 ID："+wieWoCompleteDkList.getWoCompleteId()+"；工单："+wieWoCompleteDkList.getWorkOrderNumber()+"；"+"MES主键："+wieWoCompleteDkList.getRemark()+"】"+"很抱歉，没有找到行信息，扣料失败！");
//                    }else {
//                        failureMsg.insert(0, "【完工入库 ID："+wieWoCompleteDkList.getWoCompleteId()+"；工单："+wieWoCompleteDkList.getWorkOrderNumber()+"；"+"MES主键："+wieWoCompleteDkList.getRemark()+"】"+"很抱歉，扣料失败！共 " + failureNum + " 条数据需要确认，错误如下：");
//                    }
//                    throw new Exception(failureMsg.toString());
//                }
            }
        }
    }
}
