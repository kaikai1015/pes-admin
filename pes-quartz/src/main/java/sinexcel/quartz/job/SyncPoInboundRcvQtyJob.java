package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.*;
import sinexcel.quartz.mapper.*;
import sinexcel.quartz.service.ISyncInvOnhandQuantityNewCodeService;
import sinexcel.quartz.service.ISyncInvOnhandQuantityNewService;
import sinexcel.quartz.service.ISyncPoInboundRcvQtyService;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncPoInboundRcvQtyJob")
public class SyncPoInboundRcvQtyJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private ISyncPoInboundRcvQtyService syncPoInboundRcvQtyService;

    @Autowired
    private ISyncInvOnhandQuantityNewService syncInvOnhandQuantityNewService;

    @Autowired
    private ISyncInvOnhandQuantityNewCodeService syncInvOnhandQuantityNewCodeService;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncPoInboundRcvQtyJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/CuxPOInforDataW_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//PO_INBOUNT_RCV_QTY
            NodeList nodeList = root.getElementsByTagName("PO_INBOUNT_RCV_QTY");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncPoInboundRcvQtyEO> list = new ArrayList<SyncPoInboundRcvQtyEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncPoInboundRcvQtyEO o = new SyncPoInboundRcvQtyEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "ITEM_ID":
                            o.setItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIP_TO_ORGANIZATION_ID":
                            o.setShipToOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "RECEIVE_QUANTITY":
                            try{
                                o.setReceiveQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "INBOUND_QUANTITY":
                            try{
                                o.setInboundQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                syncPoInboundRcvQtyService.batchInsertDeleteSyncPoInboundRcvQtyEO(list);
            }
        }
        if (true) {//INV_ONHAND_QUANTITIES_DETAIL_NEW
            NodeList nodeList = root.getElementsByTagName("INV_ONHAND_QUANTITIES_DETAIL_NEW");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncInvOnhandQuantityNewEO> list = new ArrayList<SyncInvOnhandQuantityNewEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncInvOnhandQuantityNewEO o = new SyncInvOnhandQuantityNewEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "QUANTITY":
                            try{
                                o.setQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                    }
                }
                list.add(o);
            }
            if (list.size() > 0) {
                syncInvOnhandQuantityNewService.batchInsertDeleteSyncInvOnhandQuantityNewTempEO(list);
            }
        }
        if (true) {//PES_INV_ONHAND_QUANTITY_DETAIL
            NodeList nodeList = root.getElementsByTagName("PES_INV_ONHAND_QUANTITY_DETAIL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncInvOnhandQuantityNewCodeEO> list = new ArrayList<SyncInvOnhandQuantityNewCodeEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncInvOnhandQuantityNewCodeEO o = new SyncInvOnhandQuantityNewCodeEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SUBINVENTORY_CODE":
                            o.setSubinventoryCode(dataNode.getTextContent());
                            break;
                        case "STATUS_ID":
                            o.setStatusId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "QUANTITY":
                            try{
                                o.setQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "MIN_DATE_RECEIVED":
                            o.setMinDateReceived(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                syncInvOnhandQuantityNewCodeService.batchInsertDeleteSyncInvOnhandQuantityNewCodeTempEO(list);
            }
        }
    }
}
