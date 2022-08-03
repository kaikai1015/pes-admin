package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncWieWoOperationsBEO;
import sinexcel.quartz.domain.SyncWieWoOperationsBIDEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncWieWoOperationsBIDMapper;
import sinexcel.quartz.mapper.SyncWieWoOperationsBMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncWieWoOperationsBJob")
public class SyncWieWoOperationsBJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private SyncWieWoOperationsBMapper syncWieWoOperationsBMapper;

    @Autowired
    private SyncWieWoOperationsBIDMapper syncWieWoOperationsBIDMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncWieWoOperationsBJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());

        byte[] data = DataModelCommon.getData("/SYNC_DATA/CuxWorkOperationData_externalPes.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//WIE_WO_OPERATIONS_B
            NodeList nodeList = root.getElementsByTagName("WIE_WO_OPERATIONS_B");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncWieWoOperationsBEO> list = new ArrayList<SyncWieWoOperationsBEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncWieWoOperationsBEO o = new SyncWieWoOperationsBEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "WO_OPERATION_ID":
                            o.setWoOperationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "OBJECT_VERSION_NUMBER":
                            o.setObjectVersionNumber(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WORK_ORDER_ID":
                            o.setWorkOrderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "OPERATION_TYPE":
                            o.setOperationType(dataNode.getTextContent());
                            break;
                        case "OPERATION_SEQ_NUMBER":
                            try{
                                o.setOperationSeqNumber(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "STANDARD_OPERATION_ID":
                            o.setStandardOperationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WORK_CENTER_ID":
                            o.setWorkCenterId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "COUNT_POINT_OPERATION_FLAG":
                            o.setCountPointOperationFlag(dataNode.getTextContent());
                            break;
                        case "AUTO_TRANSACT_FLAG":
                            o.setAutoTransactFlag(dataNode.getTextContent());
                            break;
                        case "READY_QUANTITY":
                            try{
                                o.setReadyQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "COMPLETED_QUANTITY":
                            try{
                                o.setCompletedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SCRAPPED_QUANTITY":
                            try{
                                o.setScrappedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "REJECTED_QUANTITY":
                            try{
                                o.setRejectedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "PLANNED_START_DATE":
                            o.setPlannedStartDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "PLANNED_COMPLETION_DATE":
                            o.setPlannedCompletionDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ACTUAL_START_DATE":
                            o.setActualStartDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ACTUAL_COMPLETION_DATE":
                            o.setActualCompletionDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "SERIAL_TRACKING_FLAG":
                            o.setSerialTrackingFlag(dataNode.getTextContent());
                            break;
                        case "PREVIOUS_CP_OP_SEQ_NUM":
                            try{
                                o.setPreviousCpOpSeqNum(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "NEXT_CP_OP_SEQ_NUM":
                            try{
                                o.setNextCpOpSeqNum(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "WD_OPERATION_ID":
                            o.setWdOperationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SHIPPING_DOCUMENTS_FLAG":
                            o.setShippingDocumentsFlag(dataNode.getTextContent());
                            break;
                        case "OSP_ITEM_ID":
                            o.setOspItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SUPPLIER_ID":
                            o.setSupplierId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SUPPLIER_SITE_ID":
                            o.setSupplierSiteId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LEAD_TIME_UOM":
                            o.setLeadTimeUom(dataNode.getTextContent());
                            break;
                        case "FIXED_LEAD_TIME":
                            try{
                                o.setFixedLeadTime(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "VARIABLE_LEAD_TIME":
                            try{
                                o.setVariableLeadTime(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "IN_PROCESS_QUANTITY":
                            try{
                                o.setInProcessQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "PO_REQUESTED_QUANTITY":
                            try{
                                o.setPoRequestedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "PO_APPROVED_QUANTITY":
                            try{
                                o.setPoApprovedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SHIPPED_QUANTITY":
                            try{
                                o.setShippedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "RECEIVED_QUANTITY":
                            try{
                                o.setReceivedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "OVER_RECEIPT_QUANTITY":
                            try{
                                o.setOverReceiptQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CUMULATIVE_SCRAP_QUANTITY":
                            try{
                                o.setCumulativeScrapQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "CREATED_BY":
                            o.setCreatedBy(dataNode.getTextContent());
                            break;
                        case "CREATION_DATE":
                            o.setCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATE_LOGIN":
                            o.setLastUpdateLogin(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE_CATEGORY":
                            o.setAttributeCategory(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE_CHAR1":
                            o.setAttributeChar1(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE_CHAR2":
                            o.setAttributeChar2(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE_CHAR3":
                            o.setAttributeChar3(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE_CHAR4":
                            o.setAttributeChar4(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE_CHAR5":
                            o.setAttributeChar5(dataNode.getTextContent());
                            break;
                        case "REQUEST_ID":
                            o.setRequestId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "OPERATION_NAME":
                            o.setOperationName(dataNode.getTextContent());
                            break;
                        case "OPERATION_DESCRIPTION":
                            o.setOperationDescription(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =39;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncWieWoOperationsBMapper.deleteSyncWieWoOperationsBEO(list.subList(index, (batchLastIndex + 1)));
                        syncWieWoOperationsBMapper.batchSyncWieWoOperationsBEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncWieWoOperationsBMapper.deleteSyncWieWoOperationsBEO(list.subList(index, (batchLastIndex + 1)));
                        syncWieWoOperationsBMapper.batchSyncWieWoOperationsBEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
        if (true) {//WIE_WO_OPERATIONS_B_ID
            NodeList nodeList = root.getElementsByTagName("WIE_WO_OPERATIONS_B_ID");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncWieWoOperationsBIDEO> list = new ArrayList<SyncWieWoOperationsBIDEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncWieWoOperationsBIDEO o = new SyncWieWoOperationsBIDEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "WO_OPERATION_ID":
                            o.setWoOperationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                    }
                }
                list.add(o);
            }
            //删除原表数据
            syncWieWoOperationsBIDMapper.deleteSyncWieWoOperationsBIdTempEO();
            if (list.size() > 0) {
                int batchCount =999;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncWieWoOperationsBIDMapper.batchSyncWieWoOperationsBIdTempEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncWieWoOperationsBIDMapper.batchSyncWieWoOperationsBIdTempEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
                syncWieWoOperationsBIDMapper.batchSyncWieWoOperationsBIdEO();
            }
        }
    }
}
