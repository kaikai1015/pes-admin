package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.quartz.domain.CuxMaterialTransactionsVendorEO;
import sinexcel.quartz.mapper.CuxMaterialTransactionsVendorMapper;
import sinexcel.quartz.service.ICuxMaterialTransactionsVendorService;
import sinexcel.quartz.util.WorkMaterialUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CuxMaterialTransactionsVendorServiceImpl implements ICuxMaterialTransactionsVendorService {

    @Autowired
    private CuxMaterialTransactionsVendorMapper cuxMaterialTransactionsVendorMapper;

    /**
     * 查询工单发料
     *
     * @param id 工单发料ID
     * @return 工单发料
     */
    @Override
    public CuxMaterialTransactionsVendorEO selectCuxMaterialTransactionsById(Integer id)
    {
        return cuxMaterialTransactionsVendorMapper.selectCuxMaterialTransactionsById(id);
    }

    /**
     * 查询工单发料列表
     *
     * @param cuxMaterialTransactions 工单发料
     * @return 工单发料
     */
    @Override
    public List<CuxMaterialTransactionsVendorEO> selectCuxMaterialTransactionsList(CuxMaterialTransactionsVendorEO cuxMaterialTransactions)
    {
        return cuxMaterialTransactionsVendorMapper.selectCuxMaterialTransactionsList(cuxMaterialTransactions);
    }

    /**
     * 修改工单发料
     *
     * @param cuxMaterialTransactions 工单发料
     * @return 结果
     */
    @Override
    @Transactional
    public int updateCuxMaterialTransactions(CuxMaterialTransactionsVendorEO cuxMaterialTransactions)
    {
        return cuxMaterialTransactionsVendorMapper.updateCuxMaterialTransactions(cuxMaterialTransactions);
    }

    /**
     * 提交工单发料
     *
     * @param ids 提交工单发料
     * @return 结果
     */
    @Override
    public int selectCuxMaterialTransactionsByIds(Integer[] ids) throws Exception
    {
        SimpleDateFormat sdf11 = new SimpleDateFormat("yyyyMMddHHmmss");
        int failureNum = 0,successNum = 0;
        Date Num = new Date();
        CuxMaterialTransactionsVendorEO cuxMaterialTransactions = new CuxMaterialTransactionsVendorEO();
        StringBuilder failureMsg = new StringBuilder();
        List<CuxMaterialTransactionsVendorEO> cuxMaterialTransactionsVendorLists = cuxMaterialTransactionsVendorMapper.selectCuxMaterialTransactionsByIds(ids);
        if(cuxMaterialTransactionsVendorLists.size()>0){
            for(CuxMaterialTransactionsVendorEO cuxMaterialTransactionsVendorList:cuxMaterialTransactionsVendorLists){
                String lotNumber = cuxMaterialTransactionsVendorList.getLotNumber();
                if(lotNumber == null||lotNumber.isEmpty()){
                    lotNumber = "NULL";
                }
                String xmlStr = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/types/\" xmlns:ns2=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/\">\n" +
                        "<soap:Body>\n" +
                        "<ns1:createWorkOrderMaterialTransactions>\n" +
                        "<ns1:batchInput>\n" +
                        "<ns2:MaterialTransactionInput>\n" +
                        "<ns2:HeaderNumber>HN_001</ns2:HeaderNumber>\n" +
                        "<ns2:WorkOrderNumber>" + cuxMaterialTransactionsVendorList.getWorkOrderNumber() + "</ns2:WorkOrderNumber>\n" +
                        "<ns2:OperationSequence>10</ns2:OperationSequence>\n" +
                        "<ns2:TransactionType>MATERIAL_ISSUE</ns2:TransactionType>\n" +
                        "<ns2:InventoryItemNumber>" + cuxMaterialTransactionsVendorList.getItemNumber() + "</ns2:InventoryItemNumber>\n" +
                        "<ns2:Organization>" + cuxMaterialTransactionsVendorList.getOrganizationCode() + "</ns2:Organization>\n" +
                        "<ns2:TransactionQuantity unitCode=\"" + cuxMaterialTransactionsVendorList.getTransactionUomCode() + "\">" + cuxMaterialTransactionsVendorList.getTranctQty() + "</ns2:TransactionQuantity>\n" +
                        "<ns2:Subinventory>" + cuxMaterialTransactionsVendorList.getSubinventoryCode() + "</ns2:Subinventory>\n" +
                        "<ns2:SourceHeaderReference>" + sdf11.format(Num) + "</ns2:SourceHeaderReference>\n" +
                        "<ns2:TransactionLotInput>\n" +
                        "<ns2:LotNumber>" + lotNumber + "</ns2:LotNumber>\n" +
                        "<ns2:TransactionQuantity>" + cuxMaterialTransactionsVendorList.getTranctQty() + "</ns2:TransactionQuantity>\n" +
                        "</ns2:TransactionLotInput>\n" +
                        "</ns2:MaterialTransactionInput>\n" +
                        "</ns1:batchInput>\n" +
                        "</ns1:createWorkOrderMaterialTransactions>\n" +
                        "</soap:Body>\n" +
                        "</soap:Envelope>";
                //拼接报文，开始发送
                String scode = WorkMaterialUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getWorkMaterialUrl(),ConfigUtils.getWorkMaterialName(),ConfigUtils.getWorkMaterialMethodName()));

                if("COMPLETED".equals(scode)){
                    cuxMaterialTransactions.setCountId("1");
                    cuxMaterialTransactions.setId(cuxMaterialTransactionsVendorList.getId());
                    //回写ERP成功标识
                    successNum++;
                    cuxMaterialTransactionsVendorMapper.updateCountId(cuxMaterialTransactions);
                }else {
                    //回写ERP失败标识
                    cuxMaterialTransactions.setCountId("2");
                    cuxMaterialTransactions.setId(cuxMaterialTransactionsVendorList.getId());
                    //回写成功标识
                    failureNum++;
                    cuxMaterialTransactionsVendorMapper.updateCountId(cuxMaterialTransactions);
                    failureMsg.append("工单号："+cuxMaterialTransactionsVendorList.getWorkOrderNumber()+",料号："+cuxMaterialTransactionsVendorList.getItemNumber());
                }
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，领料失败！共 " + failureNum + " 条数据需要确认，错误如下：");
            throw new CustomException(failureMsg.toString());
        }
        return successNum;
    }
}
