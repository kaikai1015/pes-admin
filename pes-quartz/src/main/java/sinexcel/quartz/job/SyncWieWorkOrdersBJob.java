package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncWieWoStatusHistoryEO;
import sinexcel.quartz.domain.SyncWieWorkOrdersBEO;
import sinexcel.quartz.domain.SyncWieWorkOrdersBWEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncWieWoStatusHistoryMapper;
import sinexcel.quartz.mapper.SyncWieWorkOrdersBMapper;
import sinexcel.quartz.mapper.SyncWieWorkOrdersBWMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncWieWorkOrdersBJob")
public class SyncWieWorkOrdersBJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private SyncWieWorkOrdersBMapper syncWieWorkOrdersBMapper;

    @Autowired
    private SyncWieWorkOrdersBWMapper syncWieWorkOrdersBWMapper;

    @Autowired
    private SyncWieWoStatusHistoryMapper syncWieWoStatusHistoryMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncWieWorkOrdersBJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/PesWieData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // ??????xml??????
        Element root = document.getDocumentElement();

        if (true) {//WIE_WORK_ORDERS_B
            NodeList nodeList = root.getElementsByTagName("WIE_WORK_ORDERS_B");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()???????????????????????????????????????????????????
            List<SyncWieWorkOrdersBEO> list = new ArrayList<SyncWieWorkOrdersBEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //?????????????????????????????????
                SyncWieWorkOrdersBEO o = new SyncWieWorkOrdersBEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "WORK_DEFINITION_ID":
                            o.setWorkDefinitionId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WORK_ORDER_ID":
                            o.setWorkOrderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WORK_ORDER_NUMBER":
                            o.setWorkOrderNumber(dataNode.getTextContent());
                            break;
                        case "WORK_ORDER_TYPE":
                            o.setWorkOrderType(dataNode.getTextContent());
                            break;
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WORK_ORDER_STATUS_ID":
                            o.setWorkOrderStatusId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PLANNED_START_QUANTITY":
                            try{
                                o.setPlannedStartQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "COMPLETED_QUANTITY":
                            try{
                                o.setCompletedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UOM_CODE":
                            o.setUomCode(dataNode.getTextContent());
                            break;
                        case "PLANNED_START_DATE":
                            o.setPlannedStartDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "PLANNED_COMPLETION_DATE":
                            o.setPlannedCompletionDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "COMPL_SUBINVENTORY_CODE":
                            o.setComplSubinventoryCode(dataNode.getTextContent());
                            break;
                        case "WORK_ORDER_DESCRIPTION":
                            o.setWorkOrderDescription(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "WORK_ORDER_PRIORITY":
                            o.setWorkOrderPriority(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =123;//?????????????????????
                int batchLastIndex = batchCount - 1;// ???????????????????????????
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncWieWorkOrdersBMapper.deleteSyncWieWorkOrdersBEO(list.subList(index, (batchLastIndex + 1)));
                        syncWieWorkOrdersBMapper.batchSyncWieWorkOrdersBEO(list.subList(index, (batchLastIndex + 1)));
                        break;// ??????????????????,????????????
                    }else {
                        syncWieWorkOrdersBMapper.deleteSyncWieWorkOrdersBEO(list.subList(index, (batchLastIndex + 1)));
                        syncWieWorkOrdersBMapper.batchSyncWieWorkOrdersBEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// ?????????????????????
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
        if (true) {//WIE_WORK_ORDERS_B_W
            NodeList nodeList = root.getElementsByTagName("WIE_WORK_ORDERS_B_W");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()???????????????????????????????????????????????????
            List<SyncWieWorkOrdersBWEO> list = new ArrayList<SyncWieWorkOrdersBWEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //?????????????????????????????????
                SyncWieWorkOrdersBWEO o = new SyncWieWorkOrdersBWEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "WORK_ORDER_ID":
                            o.setWorkOrderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WORK_ORDER_NUMBER":
                            o.setWorkOrderNumber(dataNode.getTextContent());
                            break;
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PLANNED_START_QUANTITY":
                            try{
                                o.setPlannedStartQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "COMPLETED_QUANTITY":
                            try{
                                o.setCompletedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_CODE":
                            o.setOrganizationCode(dataNode.getTextContent());
                            break;
                        case "DESCRIPTION":
                            o.setDescription(dataNode.getTextContent());
                            break;
                        case "ITEM_NUMBER":
                            o.setItemNumber(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }
            syncWieWorkOrdersBWMapper.deleteSyncWieWorkOrdersBWTempEO();
            if (list.size() > 0) {
                int batchCount =208;//?????????????????????
                int batchLastIndex = batchCount - 1;// ???????????????????????????
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncWieWorkOrdersBWMapper.batchSyncWieWorkOrdersBWTempEO(list.subList(index, (batchLastIndex + 1)));
                        break;// ??????????????????,????????????
                    }else {
                        syncWieWorkOrdersBWMapper.batchSyncWieWorkOrdersBWTempEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// ?????????????????????
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
                syncWieWorkOrdersBWMapper.batchSyncWieWorkOrdersBWEO();
            }
        }

        if (true) {//WIE_WO_STATUS_HISTORY
            NodeList nodeList = root.getElementsByTagName("WIE_WO_STATUS_HISTORY");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()???????????????????????????????????????????????????
            List<SyncWieWoStatusHistoryEO> list = new ArrayList<SyncWieWoStatusHistoryEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //?????????????????????????????????
                SyncWieWoStatusHistoryEO o = new SyncWieWoStatusHistoryEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "WORK_ORDER_ID":
                            o.setWorkOrderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "NEW_STATUS_ID":
                            o.setNewStatusId(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "STATUS_CHANGE_DATE":
                            o.setStatusChangeDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =520;//?????????????????????
                int batchLastIndex = batchCount - 1;// ???????????????????????????
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncWieWoStatusHistoryMapper.deleteSyncWieWoStatusHistoryEO(list.subList(index, (batchLastIndex + 1)));
                        syncWieWoStatusHistoryMapper.batchSyncWieWoStatusHistoryEO(list.subList(index, (batchLastIndex + 1)));
                        break;// ??????????????????,????????????
                    }else {
                        syncWieWoStatusHistoryMapper.deleteSyncWieWoStatusHistoryEO(list.subList(index, (batchLastIndex + 1)));
                        syncWieWoStatusHistoryMapper.batchSyncWieWoStatusHistoryEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// ?????????????????????
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
    }
}
