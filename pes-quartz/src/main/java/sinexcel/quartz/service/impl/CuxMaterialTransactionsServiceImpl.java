package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.quartz.domain.CuxMaterialTransactionsEO;
import sinexcel.quartz.mapper.CuxMaterialTransactionsMapper;
import sinexcel.quartz.service.ICuxMaterialTransactionsService;
import sinexcel.quartz.util.WorkMaterialUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 工单发料Service业务层处理
 *
 * @author Zhang Kai
 * @date 2021-03-12
 */
@Service
public class CuxMaterialTransactionsServiceImpl implements ICuxMaterialTransactionsService {

    @Autowired
    private CuxMaterialTransactionsMapper cuxMaterialTransactionsMapper;

    /**
     * 查询工单发料
     *
     * @param id 工单发料ID
     * @return 工单发料
     */
    @Override
    public CuxMaterialTransactionsEO selectCuxMaterialTransactionsById(Integer id)
    {
        return cuxMaterialTransactionsMapper.selectCuxMaterialTransactionsById(id);
    }

    /**
     * 查询工单发料列表
     *
     * @param cuxMaterialTransactions 工单发料
     * @return 工单发料
     */
    @Override
    public List<CuxMaterialTransactionsEO> selectCuxMaterialTransactionsList(CuxMaterialTransactionsEO cuxMaterialTransactions)
    {
        return cuxMaterialTransactionsMapper.selectCuxMaterialTransactionsList(cuxMaterialTransactions);
    }

    /**
     * 修改工单发料
     *
     * @param cuxMaterialTransactions 工单发料
     * @return 结果
     */
    @Override
    @Transactional
    public int updateCuxMaterialTransactions(CuxMaterialTransactionsEO cuxMaterialTransactions)
    {
        return cuxMaterialTransactionsMapper.updateCuxMaterialTransactions(cuxMaterialTransactions);
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date Num = new Date();
        CuxMaterialTransactionsEO cuxMaterialTransactions = new CuxMaterialTransactionsEO();
        int failureNum = 0,successNum = 0;
        StringBuilder failureMsg = new StringBuilder();
        List<CuxMaterialTransactionsEO> cuxMaterialTransactionsLists = cuxMaterialTransactionsMapper.selectCuxMaterialTransactionsByIds(ids);
        if(cuxMaterialTransactionsLists.size()>0){
            for(CuxMaterialTransactionsEO cuxMaterialTransactionsList:cuxMaterialTransactionsLists){
                String lotNum = cuxMaterialTransactionsList.getLotNumber();
                if(lotNum == null||lotNum.isEmpty()){
                    lotNum = "NULL";
                }
                    String xmlStr = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/types/\" xmlns:ns2=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/\">\n" +
                            "<soap:Body>\n" +
                            "<ns1:createWorkOrderMaterialTransactions>\n" +
                            "<ns1:batchInput>\n" +
                            "<ns2:MaterialTransactionInput>\n" +
                            "<ns2:HeaderNumber>HN_001</ns2:HeaderNumber>\n" +
                            "<ns2:WorkOrderNumber>" + cuxMaterialTransactionsList.getWorkOrderNumber() + "</ns2:WorkOrderNumber>\n" +
                            "<ns2:OperationSequence>10</ns2:OperationSequence>\n" +
                            "<ns2:TransactionType>MATERIAL_ISSUE</ns2:TransactionType>\n" +
                            "<ns2:InventoryItemNumber>" + cuxMaterialTransactionsList.getItemNumber() + "</ns2:InventoryItemNumber>\n" +
                            "<ns2:Organization>" + cuxMaterialTransactionsList.getOrganizationCode() + "</ns2:Organization>\n" +
                            "<ns2:TransactionQuantity unitCode=\"" + cuxMaterialTransactionsList.getTransactionUomCode() + "\">" + cuxMaterialTransactionsList.getTranctQty() + "</ns2:TransactionQuantity>\n" +
                            "<ns2:Subinventory>" + cuxMaterialTransactionsList.getSubinventoryCode() + "</ns2:Subinventory>\n" +
                            "<ns2:SourceHeaderReference>" + sdf.format(Num) + "</ns2:SourceHeaderReference>\n" +
                            "<ns2:TransactionLotInput>\n" +
                            "<ns2:LotNumber>" + lotNum + "</ns2:LotNumber>\n" +
                            "<ns2:TransactionQuantity>" + cuxMaterialTransactionsList.getTranctQty() + "</ns2:TransactionQuantity>\n" +
                            "</ns2:TransactionLotInput>\n" +
                            "</ns2:MaterialTransactionInput>\n" +
                            "</ns1:batchInput>\n" +
                            "</ns1:createWorkOrderMaterialTransactions>\n" +
                            "</soap:Body>\n" +
                            "</soap:Envelope>";
                    String scode = WorkMaterialUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getWorkMaterialUrl(),ConfigUtils.getWorkMaterialName(),ConfigUtils.getWorkMaterialMethodName()));

                    if("COMPLETED".equals(scode)){
                        cuxMaterialTransactions.setCountId("1");
                        cuxMaterialTransactions.setId(cuxMaterialTransactionsList.getId());
                        //回写ERP成功标识
                        cuxMaterialTransactionsMapper.updateCountId(cuxMaterialTransactions);
                        successNum++;
                    }else {
                        //回写ERP失败标识
                        cuxMaterialTransactions.setCountId("2");
                        cuxMaterialTransactions.setId(cuxMaterialTransactionsList.getId());
                        //回写成功标识
                        cuxMaterialTransactionsMapper.updateCountId(cuxMaterialTransactions);
                        failureNum++;
                        failureMsg.append("工单号："+cuxMaterialTransactionsList.getWorkOrderNumber()+",料号："+cuxMaterialTransactionsList.getItemNumber());
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
