package sinexcel.wms.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.daysPlan.domain.PesInvMaterialTxns;
import sinexcel.daysPlan.service.IPesInvMaterialTxnsService;
import sinexcel.quartz.util.WorkMaterialUtils;
import sinexcel.utils.CommonStatic;
import sinexcel.wms.mapper.CuxWmsWorkKouZhangListMapper;
import sinexcel.wms.domain.CuxWmsWorkKouZhangList;
import sinexcel.wms.service.ICuxWmsWorkKouZhangListService;

/**
 * WMS工单扣账逻辑Service业务层处理
 *
 * @author Zhang Kai
 * @date 2021-09-13
 */
@Service
public class CuxWmsWorkKouZhangListServiceImpl implements ICuxWmsWorkKouZhangListService
{
    @Autowired
    private CuxWmsWorkKouZhangListMapper cuxWmsWorkKouZhangListMapper;
    @Autowired
    private IPesInvMaterialTxnsService invMaterialTxnsService;


    String lotNumber = null;
    BigDecimal transaQuantity;

    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    Logger log = LoggerFactory.getLogger(CuxWmsWorkKouZhangListServiceImpl.class);
    /**
     * 查询WMS工单扣账逻辑列表
     *
     * @param cuxWmsWorkKouZhangList WMS工单扣账逻辑
     * @return WMS工单扣账逻辑
     */
    @Override
    public List<CuxWmsWorkKouZhangList> selectCuxWmsWorkKouZhangListList(CuxWmsWorkKouZhangList cuxWmsWorkKouZhangList)
    {
        return cuxWmsWorkKouZhangListMapper.selectCuxWmsWorkKouZhangListList(cuxWmsWorkKouZhangList);
    }

    /**
     * 新增WMS工单扣账逻辑
     *
     * @param cuxWmsWorkKouZhangList WMS工单扣账逻辑
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int insertCuxWmsWorkKouZhangList(CuxWmsWorkKouZhangList cuxWmsWorkKouZhangList)
    {
        cuxWmsWorkKouZhangList.setCreateBy(SecurityUtils.getUsername());
        cuxWmsWorkKouZhangListMapper.deleteCuxWmsWorkKouZhangListByLotNum(cuxWmsWorkKouZhangList.getLotNumber()
                ,cuxWmsWorkKouZhangList.getIsWwFlag());
        return cuxWmsWorkKouZhangListMapper.insertCuxWmsWorkKouZhangList(cuxWmsWorkKouZhangList);
    }

    /**
     * 批量删除WMS工单扣账逻辑
     *
     * @param kouZhangIds 需要删除的WMS工单扣账逻辑ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ)
    public int deleteCuxWmsWorkKouZhangListByIds(Long[] kouZhangIds)
    {
        return cuxWmsWorkKouZhangListMapper.deleteCuxWmsWorkKouZhangListByIds(kouZhangIds);
    }

    @Override
    public List<CuxWmsWorkKouZhangList> selectCuxWmsWorkKouZhangDetailsListList(CuxWmsWorkKouZhangList cuxWmsWorkKouZhangList)
    {
        return cuxWmsWorkKouZhangListMapper.selectCuxWmsWorkKouZhangDetailsListList(cuxWmsWorkKouZhangList);
    }

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public synchronized int  erpCuxWmsWorkKouZhangListByIds(String kouZhangType,Long[] kouZhangIds,String isWwFlag)
    {
        Integer successNum = 0;
        Integer failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        if("1".equals(kouZhangType)||"2".equals(kouZhangType)){
            List<CuxWmsWorkKouZhangList> lists = cuxWmsWorkKouZhangListMapper.erpCuxWmsWorkKouZhangListByIds(kouZhangIds,isWwFlag);
            PushErp pushErp = new PushErp(kouZhangType, isWwFlag, successNum, failureNum, failureMsg, lists).invoke();
            successNum = pushErp.getSuccessNum();
            failureNum = pushErp.getFailureNum();
            if (failureNum > 0)
            {
                failureMsg.insert(0, "很抱歉，扣账失败！共 " + failureNum + " 条数据不正确，错误如下：");
                throw new CustomException(failureMsg.toString());
            }
            else
            {
                successMsg.insert(0, "恭喜您，扣账成功！共 " + successNum + " 条");
            }
        }else {
            throw new CustomException("请选择扣账类型！！！");
        }
        return successNum;
    }

    @Override
    public synchronized int autoErpCuxWmsWorkKouZhangListByIds(String kouZhangType,  String isWwFlag) {
        Integer successNum = 0;
        Integer failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        if("1".equals(kouZhangType)||"2".equals(kouZhangType)){
            List<CuxWmsWorkKouZhangList> lists = cuxWmsWorkKouZhangListMapper.autoErpCuxWmsWorkKouZhangListByIds(isWwFlag);
            PushErp pushErp = new PushErp(kouZhangType, isWwFlag, successNum, failureNum, failureMsg, lists).invoke();
            successNum = pushErp.getSuccessNum();
            failureNum = pushErp.getFailureNum();
            if (failureNum > 0)
            {
                failureMsg.insert(0, "很抱歉，扣账失败！共 " + failureNum + " 条数据不正确，错误如下：");
                log.info("autoErpCuxWmsWorkKouZhangListByIds:"+failureMsg.toString());
                throw new CustomException(failureMsg.toString());
            }
            else
            {
                successMsg.insert(0, "恭喜您，扣账成功！共 " + successNum + " 条");
            }
        }else {
            throw new CustomException("请选择扣账类型！！！");
        }
        return successNum;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertTrancsationList(Long lineId, Long kouZhangId, String kouZhangType,String isWwFlag) {
        //获取需要创建的数据
        List<PesInvMaterialTxns> infoList = cuxWmsWorkKouZhangListMapper.getInsertTrancsationList(lineId,kouZhangId,
                kouZhangType,isWwFlag);
        //创建数据
        infoList.forEach(o->{
            if (StringUtils.equals("2",kouZhangType)){
                //超领扣料
                o.setTransactionSourceType(CommonStatic.INV_SOURCE_TYPE_WIP_BACKFLUSH_XCEED);
            }
            invMaterialTxnsService.insertHandle(o);
        });

    }

    private class PushErp {
        private String kouZhangType;
        private String isWwFlag;
        private Integer successNum;
        private Integer failureNum;
        private StringBuilder failureMsg;
        private List<CuxWmsWorkKouZhangList> lists;

        public PushErp(String kouZhangType, String isWwFlag, Integer successNum, Integer failureNum, StringBuilder failureMsg, List<CuxWmsWorkKouZhangList> lists) {
            this.kouZhangType = kouZhangType;
            this.isWwFlag = isWwFlag;
            this.successNum = successNum;
            this.failureNum = failureNum;
            this.failureMsg = failureMsg;
            this.lists = lists;
        }

        public Integer getSuccessNum() {
            return successNum;
        }

        public Integer getFailureNum() {
            return failureNum;
        }

        public PushErp invoke() {
            if(lists.size() > 0){
                for(CuxWmsWorkKouZhangList list:lists){
                    transaQuantity = "1".equals(kouZhangType)? list.getXianBianQuantity():list.getOverReceiveQuantity();
                    if(transaQuantity.compareTo(BigDecimal.ZERO)==1){
                        String subinventoryCode = ( StringUtils.equals(list.getItemWorkNameFlag(),"4")
                                && !StringUtils.equals(this.isWwFlag,"Y" ) )? "3FCKL001":list.getSubinventoryCode();
                        System.out.println("strat:kouzhang  " + "【工单号："+list.getWorkOrderNumber()+",料号："+list.getItemNumber()+"】");
                        if (StringUtils.isEmpty(subinventoryCode)){
                            failureNum++;
                            String msg ="未匹配到对应的扣料仓库【工单号："+list.getWorkOrderNumber()+",料号："+list.getItemNumber()+"】";
                            failureMsg.append(msg);
                            continue;
                        }
                        if(list.getLotControlCode()== 2){
                            lotNumber = "                    <ns2:TransactionLotInput>\n" +
                                    "                        <ns2:LotNumber>QC201810</ns2:LotNumber>\n" +
                                    "                        <ns2:TransactionQuantity>"+transaQuantity+"</ns2:TransactionQuantity>\n" +
                                    "                    </ns2:TransactionLotInput>\n";
                        }else {
                            lotNumber = "";
                        }
                        //系统时间转换成格林威治时间
                        Calendar cal = Calendar.getInstance();
                        cal.setTimeInMillis(list.getTransactionDate() .getTime()-10000);
                        cal.add(Calendar.HOUR, -8);
                        String xmlStr = "<soap:Envelope\n" +
                                "    xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                                "    xmlns:ns1=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/types/\"\n" +
                                "    xmlns:ns2=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/\">\n" +
                                "    <soap:Body>\n" +
                                "        <ns1:createWorkOrderMaterialTransactions>\n" +
                                "            <ns1:batchInput>\n" +
                                "                <ns2:MaterialTransactionInput>\n" +
                                "                    <ns2:WorkOrderNumber>"+list.getWorkOrderNumber()+"</ns2:WorkOrderNumber>\n" +
                                "                    <ns2:OperationSequence>10</ns2:OperationSequence>\n" +
                                "                    <ns2:TransactionType>MATERIAL_ISSUE</ns2:TransactionType>\n" +
                                "                    <ns2:InventoryItemNumber>"+list.getItemNumber()+"</ns2:InventoryItemNumber>\n" +
                                "                    <ns2:Organization>"+list.getOrganizationCode()+"</ns2:Organization>\n" +
                                "                    <ns2:TransactionQuantity unitCode=\""+list.getUom()+"\">"+transaQuantity+"</ns2:TransactionQuantity>\n" +
                                "                    <ns2:TransactionDate>"+sdf1.format(cal.getTime())+"</ns2:TransactionDate>\n" +
                                "                    <ns2:Subinventory>"+subinventoryCode+"</ns2:Subinventory>\n" +
                                "                    <ns2:SourceHeaderReference>"+kouZhangType+"</ns2:SourceHeaderReference>\n"
                                + lotNumber+
                                "                </ns2:MaterialTransactionInput>\n" +
                                "            </ns1:batchInput>\n" +
                                "        </ns1:createWorkOrderMaterialTransactions>\n" +
                                "    </soap:Body>\n" +
                                "</soap:Envelope>";

                        String scode = null;
                        try {
                            scode = WorkMaterialUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getWorkMaterialUrl(),ConfigUtils.getWorkMaterialName(),ConfigUtils.getWorkMaterialMethodName()));
//                                scode = "COMPLETED";
                            if("COMPLETED".equals(scode)){
                                //ok
                                successNum++;
                                //扣账成功插入出入库记录
                                CuxWmsWorkKouZhangListServiceImpl.this.insertTrancsationList(list.getWorkOrderLineId(),list.getKouZhangId(),kouZhangType, isWwFlag);
                            }else {
                                //回写ERP失败标识
                                failureNum++;
                                String msg ="【工单号："+list.getWorkOrderNumber()+",料号："+list.getItemNumber()+"】";
                                failureMsg.append(msg).append(scode);
                            }
                        } catch (Exception e) {
                            //回写ERP失败标识
                            failureNum++;
                            String msg ="【工单号："+list.getWorkOrderNumber()+",料号："+list.getItemNumber()+"】";
                            failureMsg.append(msg).append(e.getMessage());
                            System.out.println("【工单号："+list.getWorkOrderNumber()+",料号："+list.getItemNumber()+"】"+e.getMessage());
                        }
                    }else{
                        //回写ERP失败标识
                        failureNum++;
                        String msg ="【工单号："+list.getWorkOrderNumber()+",料号："+list.getItemNumber()+"】";
                        failureMsg.append("扣账数量为零,不需要扣账！！！"+msg);
                    }
                }
            }else {
                if (StringUtils.equals(isWwFlag,"N")){
                    throw new CustomException("选中工单不需要扣账！！！");
                }
            }
            return this;
        }
    }
}
