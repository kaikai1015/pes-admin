package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncPoHeadersAllEO;
import sinexcel.quartz.domain.SyncPoLineLocationsAllEO;
import sinexcel.quartz.domain.SyncPoLinesAllEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.service.ISyncPurchaseDataService;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncPurchaseDataJob")
public class SyncPurchaseDataJob {

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private ISyncPurchaseDataService syncPurchaseDataService;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncPurchaseDataJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/PesPOInforData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//PO_HEADERS_ALL
            NodeList nodeList = root.getElementsByTagName("PO_HEADERS_ALL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncPoHeadersAllEO> list = new ArrayList<SyncPoHeadersAllEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncPoHeadersAllEO o = new SyncPoHeadersAllEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "PO_HEADER_ID":
                            o.setPoHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DOCUMENT_STATUS":
                            o.setDocumentStatus(dataNode.getTextContent());
                            break;
                        case "PRC_BU_ID":
                            o.setPrcBuId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "AGENT_ID":
                            o.setAgentId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TYPE_LOOKUP_CODE":
                            o.setTypeLookupCode(dataNode.getTextContent());
                            break;
                        case "SEGMENT1":
                            o.setSegment1(dataNode.getTextContent());
                            break;
                        case "VENDOR_ID":
                            o.setVendorId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SOLDTO_LE_ID":
                            o.setSoldtoLeId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "COMMENTS":
                            o.setComments(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CREATION_DATE":
                            o.setCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                syncPurchaseDataService.batchSyncPoHeadersAllEO(list);
            }
        }

        if (true) {//PO_LINES_ALL
            NodeList nodeList = root.getElementsByTagName("PO_LINES_ALL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncPoLinesAllEO> list = new ArrayList<SyncPoLinesAllEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncPoLinesAllEO o = new SyncPoLinesAllEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "PO_HEADER_ID":
                            o.setPoHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PO_LINE_ID":
                            o.setPoLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PRC_BU_ID":
                            o.setPrcBuId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LINE_NUM":
                            o.setLineNum(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "LINE_STATUS":
                            o.setLineStatus(dataNode.getTextContent());
                            break;
                        case "WORK_ORDER_ID":
                            o.setWorkOrderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ITEM_ID":
                            o.setItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "UOM_CODE":
                            o.setUomCode(dataNode.getTextContent());
                            break;
                        case "QUANTITY":
                            try{
                                o.setQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UNIT_PRICE":
                            try{
                                o.setUnitPrice(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "NEED_BY_DATE":
                            o.setNeedByDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                syncPurchaseDataService.batchSyncPoLinesAllEO(list);
            }
        }

        if (true) {//PO_LINE_LOCATIONS_ALL
            NodeList nodeList = root.getElementsByTagName("PO_LINE_LOCATIONS_ALL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncPoLineLocationsAllEO> list = new ArrayList<SyncPoLineLocationsAllEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncPoLineLocationsAllEO o = new SyncPoLineLocationsAllEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "LINE_LOCATION_ID":
                            o.setLineLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PRC_BU_ID":
                            o.setPrcBuId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SCHEDULE_STATUS":
                            o.setScheduleStatus(dataNode.getTextContent());
                            break;
                        case "INPUT_TAX_CLASSIFICATION_CODE":
                            o.setInputTaxClassificationCode(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "PO_HEADER_ID":
                            o.setPoHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PO_LINE_ID":
                            o.setPoLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CREATION_DATE":
                            o.setCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CREATED_BY":
                            o.setCreatedBy(dataNode.getTextContent());
                            break;
                        case "QUANTITY":
                            try{
                                o.setQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "QUANTITY_RECEIVED":
                            try{
                                o.setQuantityReceived(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "QUANTITY_ACCEPTED":
                            try{
                                o.setQuantityAccepted(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "QUANTITY_REJECTED":
                            try{
                                o.setQuantityRejected(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "QUANTITY_BILLED":
                            try{
                                o.setQuantityBilled(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "QUANTITY_CANCELLED":
                            try{
                                o.setQuantityCancelled(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UOM_CODE":
                            o.setUomCode(dataNode.getTextContent());
                            break;
                        case "SHIP_TO_LOCATION_ID":
                            o.setShipToLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "NEED_BY_DATE":
                            o.setNeedByDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CANCEL_FLAG":
                            o.setCancelFlag(dataNode.getTextContent());
                            break;
                        case "CANCELLED_BY":
                            o.setCancelledBy(dataNode.getTextContent());
                            break;
                        case "CANCEL_DATE":
                            o.setCancelDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CANCEL_REASON":
                            o.setCancelReason(dataNode.getTextContent());
                            break;
                        case "INSPECTION_REQUIRED_FLAG":
                            o.setInspectionRequiredFlag(dataNode.getTextContent());
                            break;
                        case "SHIP_TO_ORGANIZATION_ID":
                            o.setShipToOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "QUANTITY_SHIPPED":
                            try{
                                o.setQuantityShipped(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "PRICE_OVERRIDE":
                            try{
                                o.setPriceOverride(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "WORK_ORDER_ID":
                            o.setWorkOrderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WORK_ORDER_NUMBER":
                            o.setWorkOrderNumber(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                syncPurchaseDataService.batchSyncPoLinesLocationAllEO(list);
            }
        }
    }
}
