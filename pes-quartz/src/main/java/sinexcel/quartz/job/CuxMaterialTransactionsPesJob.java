package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.quartz.domain.CuxMaterialTransactionsPesEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.CuxMaterialTransactionsPesMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("cuxMaterialTransactionsPesJob")
public class CuxMaterialTransactionsPesJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private CuxMaterialTransactionsPesMapper cuxMaterialTransactionsPesMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("CuxMaterialTransactionsPesJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/PesWorkMetrialTrnData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//PES_MATERIAL_TRANSACTIONS
            NodeList nodeList = root.getElementsByTagName("PES_MATERIAL_TRANSACTIONS");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<CuxMaterialTransactionsPesEO> list = new ArrayList<CuxMaterialTransactionsPesEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                CuxMaterialTransactionsPesEO o = new CuxMaterialTransactionsPesEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "WORK_ORDER_NUMBER":
                            o.setWorkOrderNumber(dataNode.getTextContent());
                            break;
                        case "ORGANIZATION_CODE":
                            o.setOrganizationCode(dataNode.getTextContent());
                            break;
                        case "ITEM_NUMBER":
                            o.setItemNumber(dataNode.getTextContent());
                            break;
                        case "QUANTITY":
                            try{
                                o.setQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ISSUED_QUANTITY":
                            try{
                                o.setIssuedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "TRANCT_QTY":
                            try{
                                o.setTranctQty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ONHAND_QUANTITY":
                            try{
                                o.setOnhandQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "TRANSACTION_UOM_CODE":
                            o.setTransactionUomCode(dataNode.getTextContent());
                            break;
                        case "SUBINVENTORY_CODE":
                            o.setSubinventoryCode(dataNode.getTextContent());
                            break;
                        case "LOT_NUMBER":
                            o.setLotNumber(dataNode.getTextContent());
                            break;
                        case "DESCRIPTION":
                            o.setDescription(dataNode.getTextContent());
                            break;
                        case "WORK_QUANTITY":
                            o.setWorkQuantity(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }
            cuxMaterialTransactionsPesMapper.deleteCuxMaterialTransactionsPesEO(list);
            if (list.size() > 0) {
                int batchCount =173;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        cuxMaterialTransactionsPesMapper.batchCuxMaterialTransactionsPesEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        cuxMaterialTransactionsPesMapper.batchCuxMaterialTransactionsPesEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
    }
}