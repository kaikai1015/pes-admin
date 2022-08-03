package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncPorRequisitionHeadersAllEO;
import sinexcel.quartz.domain.SyncPorRequisitionLinesAllEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncPorRequisitionHeadersAllMapper;
import sinexcel.quartz.mapper.SyncPorRequisitionLinesAllMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncPorRequisitionHeadersAllJob")
public class SyncPorRequisitionHeadersAllJob {

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private SyncPorRequisitionHeadersAllMapper syncPorRequisitionHeadersAllMapper;

    @Autowired
    private SyncPorRequisitionLinesAllMapper syncPorRequisitionLinesAllMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncPorRequisitionHeadersAllJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/PesPRInforData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//POR_REQUISITION_HEADERS_ALL
            NodeList nodeList = root.getElementsByTagName("POR_REQUISITION_HEADERS_ALL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncPorRequisitionHeadersAllEO> list = new ArrayList<SyncPorRequisitionHeadersAllEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncPorRequisitionHeadersAllEO o = new SyncPorRequisitionHeadersAllEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "REQUISITION_HEADER_ID":
                            o.setRequisitionHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "REQUISITION_NUMBER":
                            o.setRequisitionNumber(dataNode.getTextContent());
                            break;
                        case "REQ_BU_ID":
                            o.setReqBuId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DESCRIPTION":
                            o.setDescription(dataNode.getTextContent());
                            break;
                        case "DOCUMENT_STATUS":
                            o.setDocumentStatus(dataNode.getTextContent());
                            break;
                        case "PRC_BU_ID":
                            o.setPrcBuId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SUBMISSION_DATE":
                            o.setSubmissionDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "APPROVED_DATE":
                            o.setApprovedDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "DOCUMENT_SUB_TYPE":
                            o.setDocumentSubType(dataNode.getTextContent());
                            break;
                        case "SOLDTO_LE_ID":
                            o.setSoldtoLeId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "FUNDS_STATUS":
                            o.setFundsStatus(dataNode.getTextContent());
                            break;
                        case "PROCESS_STATUS":
                            o.setProcessStatus(dataNode.getTextContent());
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
                    }
                }
                list.add(o);
            }
            if (list.size() > 0) {
                int batchCount =130;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncPorRequisitionHeadersAllMapper.deleteSyncPorRequisitionHeadersAllEO(list.subList(index, (batchLastIndex + 1)));
                        syncPorRequisitionHeadersAllMapper.batchSyncPorRequisitionHeadersAllEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncPorRequisitionHeadersAllMapper.deleteSyncPorRequisitionHeadersAllEO(list.subList(index, (batchLastIndex + 1)));
                        syncPorRequisitionHeadersAllMapper.batchSyncPorRequisitionHeadersAllEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
        if (true) {//POR_REQUISITION_LINES_ALL
            NodeList nodeList = root.getElementsByTagName("POR_REQUISITION_LINES_ALL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncPorRequisitionLinesAllEO> list = new ArrayList<SyncPorRequisitionLinesAllEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncPorRequisitionLinesAllEO o = new SyncPorRequisitionLinesAllEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "REQUISITION_LINE_ID":
                            o.setRequisitionLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "REQUISITION_HEADER_ID":
                            o.setRequisitionHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "NEED_BY_DATE":
                            o.setNeedByDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "PO_HEADER_ID":
                            o.setPoHeaderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PO_LINE_ID":
                            o.setPoLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LINE_STATUS":
                            o.setLineStatus(dataNode.getTextContent());
                            break;
                        case "LAST_SUBMITTED_DATE":
                            o.setLastSubmittedDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_APPROVAL_DATE":
                            o.setLastApprovalDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
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
                        case "WORK_ORDER_PRODUCT":
                            o.setWorkOrderProduct(dataNode.getTextContent());
                            break;
                        case "WORK_ORDER_NUMBER":
                            o.setWorkOrderNumber(dataNode.getTextContent());
                            break;
                        case "WORK_ORDER_ID":
                            o.setWorkOrderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WORK_ORDER_OPERATION_SEQ":
                            o.setWorkOrderOperationSeq(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "WORK_ORDER_OPERATION_ID":
                            o.setWorkOrderOperationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LINE_NUMBER":
                            o.setLineNumber(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "CATEGORY_ID":
                            o.setCategoryId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ITEM_DESCRIPTION":
                            o.setItemDescription(dataNode.getTextContent());
                            break;
                        case "UOM_CODE":
                            o.setUomCode(dataNode.getTextContent());
                            break;
                        case "UNIT_PRICE":
                            try{
                                o.setUnitPrice(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "QUANTITY":
                            try{
                                o.setQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "ITEM_ID":
                            o.setItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "VENDOR_ID":
                            o.setVendorId(Long.parseLong(dataNode.getTextContent()));
                            break;
                    }
                }
                list.add(o);
            }
            if (list.size() > 0) {
                int batchCount =80;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncPorRequisitionLinesAllMapper.deleteSyncPorRequisitionLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                        syncPorRequisitionLinesAllMapper.batchSyncPorRequisitionLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncPorRequisitionLinesAllMapper.deleteSyncPorRequisitionLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                        syncPorRequisitionLinesAllMapper.batchSyncPorRequisitionLinesAllEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
    }
}
