package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncWorkOrderUpdateMaterialQuantityEO;
import sinexcel.quartz.domain.SyncWorkOrderUpdateQuantityEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.service.ISyncWorkOrderUpdateQuantityService;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncWorkOrderUpdateQuantityJob")
public class SyncWorkOrderUpdateQuantityJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private ISyncWorkOrderUpdateQuantityService syncWorkOrderUpdateQuantityService;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncWorkOrderUpdateQuantityJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getStartTime());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/CuxWorkOrderUpdateQuantityData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//WIE_ORDERS_B_ERP_QUANTITY
            NodeList nodeList = root.getElementsByTagName("WIE_ORDERS_B_ERP_QUANTITY");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncWorkOrderUpdateQuantityEO> list = new ArrayList<SyncWorkOrderUpdateQuantityEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncWorkOrderUpdateQuantityEO o = new SyncWorkOrderUpdateQuantityEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSACTION_SOURCE_ID":
                            o.setTransactionSourceId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SUM_TRANSACTION_QUANTITY":
                            try{
                                o.setSumTransactionQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SUBINVENTORY_CODE":
                            o.setSubinventoryCode(dataNode.getTextContent());
                            break;
                    }
                }
                o.setCreateDate(DateUtils.getNowDate());
                list.add(o);
            }
            if (list.size() > 0) {
                syncWorkOrderUpdateQuantityService.batchSyncWorkOrderUpdateQuantityEO(list);
            }
        }

        if (true) {//WIE_OPERATION_MATERIALS_ERP_QUANTITY
            NodeList nodeList = root.getElementsByTagName("WIE_OPERATION_MATERIALS_ERP_QUANTITY");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncWorkOrderUpdateMaterialQuantityEO> list = new ArrayList<SyncWorkOrderUpdateMaterialQuantityEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncWorkOrderUpdateMaterialQuantityEO o = new SyncWorkOrderUpdateMaterialQuantityEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSACTION_SOURCE_ID":
                            o.setTransactionSourceId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SUM_TRANSACTION_QUANTITY":
                            try{
                                o.setSumTransactionQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                    }
                }
                o.setCreateDate(DateUtils.getNowDate());
                list.add(o);
            }
            if (list.size() > 0) {
                syncWorkOrderUpdateQuantityService.batchSyncWorkOrderUpdateMaterialQuantityEO(list);
            }
        }

    }
}
