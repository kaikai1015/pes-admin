package sinexcel.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.exception.CustomException;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.common.utils.StringUtils;
import sinexcel.quartz.domain.CuxMaterialTransactionsEO;
import sinexcel.quartz.domain.CuxMaterialTransactionsPesEO;
import sinexcel.quartz.mapper.CuxMaterialTransactionsPesMapper;
import sinexcel.quartz.service.ICuxMaterialTransactionsPesService;
import sinexcel.quartz.util.WorkMaterialUtils;

import java.math.BigDecimal;
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
public class CuxMaterialTransactionsServicePesImpl implements ICuxMaterialTransactionsPesService {

    @Autowired
    private CuxMaterialTransactionsPesMapper cuxMaterialTransactionsPesMapper;

    /**
     * 查询工单发料
     *
     * @param id 工单发料ID
     * @return 工单发料
     */
    @Override
    public CuxMaterialTransactionsPesEO selectCuxMaterialTransactionsByPesId(Integer id)
    {
        return cuxMaterialTransactionsPesMapper.selectCuxMaterialTransactionsByPesId(id);
    }

    /**
     * 查询工单发料列表
     *
     * @param cuxMaterialTransactionsPes 工单发料
     * @return 工单发料
     */
    @Override
    public List<CuxMaterialTransactionsPesEO> selectCuxMaterialTransactionsPesList(CuxMaterialTransactionsPesEO cuxMaterialTransactionsPes)
    {
        if(StringUtils.isNull(cuxMaterialTransactionsPes.getPlanStartQuantity())){
            cuxMaterialTransactionsPes.setPlanStartQuantity(BigDecimal.valueOf(0));
        }
        return cuxMaterialTransactionsPesMapper.selectCuxMaterialTransactionsPesList(cuxMaterialTransactionsPes);
    }

    /**
     * 修改工单发料
     *
     * @param cuxMaterialTransactionsPes 工单发料
     * @return 结果
     */
    @Override
    @Transactional
    public int updateCuxMaterialTransactionsPes(CuxMaterialTransactionsPesEO cuxMaterialTransactionsPes)
    {
        return cuxMaterialTransactionsPesMapper.updateCuxMaterialTransactionsPes(cuxMaterialTransactionsPes);
    }

    /**
     * 提交工单发料
     *
     * @param cuxMaterialTransactionsPes 提交工单发料
     * @return 结果
     */
    @Override
    public int selectSubmitWieToErp(CuxMaterialTransactionsPesEO cuxMaterialTransactionsPes) throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date Num = new Date();
        CuxMaterialTransactionsPesEO cuxMaterialTransactions = new CuxMaterialTransactionsPesEO();
        int failureNum = 0,successNum = 0;
        StringBuilder failureMsg = new StringBuilder();
        if(StringUtils.isNull(cuxMaterialTransactionsPes.getWorkOrderNumber())||StringUtils.isNull(cuxMaterialTransactionsPes.getPlanStartQuantity())){
            failureMsg.insert(0, "请输入工单号或者数量，不能倒扣！！！");
            throw new CustomException(failureMsg.toString());
        }else {
        int count = cuxMaterialTransactionsPesMapper.selectCuxMaterialTransactionsByIds(cuxMaterialTransactionsPes);
        if(count > 0 ? false : true){
            List<CuxMaterialTransactionsPesEO> cuxMaterialTransactionsLists = cuxMaterialTransactionsPesMapper.selectCuxMaterialTransactionsPesList(cuxMaterialTransactionsPes);
            for(CuxMaterialTransactionsPesEO list:cuxMaterialTransactionsLists){
                String lotNum = list.getLotNumber();
                if(lotNum == null||lotNum.isEmpty()){
                    lotNum = "NULL";
                }
                String xmlStr = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/types/\" xmlns:ns2=\"http://xmlns.oracle.com/apps/scm/commonWorkExecution/workOrderMaterialTransactions/materialTransactionsService/\">\n" +
                        "<soap:Body>\n" +
                        "<ns1:createWorkOrderMaterialTransactions>\n" +
                        "<ns1:batchInput>\n" +
                        "<ns2:MaterialTransactionInput>\n" +
                        "<ns2:HeaderNumber>HN_001</ns2:HeaderNumber>\n" +
                        "<ns2:WorkOrderNumber>" + list.getWorkOrderNumber() + "</ns2:WorkOrderNumber>\n" +
                        "<ns2:OperationSequence>10</ns2:OperationSequence>\n" +
                        "<ns2:TransactionType>MATERIAL_ISSUE</ns2:TransactionType>\n" +
                        "<ns2:InventoryItemNumber>" + list.getItemNumber() + "</ns2:InventoryItemNumber>\n" +
                        "<ns2:Organization>" + list.getOrganizationCode() + "</ns2:Organization>\n" +
                        "<ns2:TransactionQuantity unitCode=\"" + list.getTransactionUomCode() + "\">" + list.getTranctQty() + "</ns2:TransactionQuantity>\n" +
                        "<ns2:Subinventory>" + list.getSubinventoryCode() + "</ns2:Subinventory>\n" +
                        "<ns2:SourceHeaderReference>" + sdf.format(Num) + "</ns2:SourceHeaderReference>\n" +
                        "<ns2:TransactionLotInput>\n" +
                        "<ns2:LotNumber>" + lotNum + "</ns2:LotNumber>\n" +
                        "<ns2:TransactionQuantity>" + list.getTranctQty() + "</ns2:TransactionQuantity>\n" +
                        "</ns2:TransactionLotInput>\n" +
                        "</ns2:MaterialTransactionInput>\n" +
                        "</ns1:batchInput>\n" +
                        "</ns1:createWorkOrderMaterialTransactions>\n" +
                        "</soap:Body>\n" +
                        "</soap:Envelope>";

                    String  scode = WorkMaterialUtils.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getWorkMaterialUrl(),ConfigUtils.getWorkMaterialName(),ConfigUtils.getWorkMaterialMethodName()));

                if("COMPLETED".equals(scode)){
                    cuxMaterialTransactions.setCountId("1");
                    cuxMaterialTransactions.setId(list.getId());
                    //回写ERP成功标识
                    cuxMaterialTransactionsPesMapper.updatePesCountId(cuxMaterialTransactions);
                    successNum++;
                }else {
                    //回写ERP失败标识
                    cuxMaterialTransactions.setCountId("2");
                    cuxMaterialTransactions.setId(list.getId());
                    //回写成功标识
                    cuxMaterialTransactionsPesMapper.updatePesCountId(cuxMaterialTransactions);
                    failureNum++;
                    failureMsg.append("工单号："+list.getWorkOrderNumber()+",料号："+list.getItemNumber());
                }
            }
        }else {
            failureNum = count;
            failureMsg.append("工单不是全部齐套的，不能提交，请检查数据后在提交！！！");
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，倒扣失败！共 " + failureNum + " 条数据需要确认，错误如下：");
            throw new CustomException(failureMsg.toString());
        }
        }
        return (successNum + failureNum);
    }
}
