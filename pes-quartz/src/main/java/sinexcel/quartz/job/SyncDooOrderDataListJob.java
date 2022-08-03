package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncDooOrderDataListEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.service.ISyncDooOrderDataListService;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncDooOrderDataListJob")
public class SyncDooOrderDataListJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private ISyncDooOrderDataListService syncDooOrderDataListService;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
            log.setJobName("SyncDooOrderDataListJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/PesDooOrderDataPlanList_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//SYNC_DOO_ORDER_DATA_LIST
            NodeList nodeList = root.getElementsByTagName("SYNC_DOO_ORDER_DATA_LIST");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncDooOrderDataListEO> list = new ArrayList<SyncDooOrderDataListEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncDooOrderDataListEO o = new SyncDooOrderDataListEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "BU_NAME":
                            o.setBuName(dataNode.getTextContent());
                            break;
                        case "PARTY_NAME":
                            o.setPartyName(dataNode.getTextContent());
                            break;
                        case "SALSES_NAME":
                            o.setSalsesName(dataNode.getTextContent());
                            break;
                        case "AGENT_SALE":
                            o.setAgentSale(dataNode.getTextContent());
                            break;
                        case "ORDER_SALSES_NAME":
                            o.setOrderSalsesName(dataNode.getTextContent());
                            break;
                        case "ORDER_SALSES_NAME_AGENT":
                            o.setOrderSalsesNameAgent(dataNode.getTextContent());
                            break;
                        case "CREATED_BY":
                            o.setCreatedBy(dataNode.getTextContent());
                            break;
                        case "ACCOUNT_NUMBER":
                            o.setAccountNumber(dataNode.getTextContent());
                            break;
                        case "CUSTOMER_PO_NUMBER":
                            o.setCustomerPoNumber(dataNode.getTextContent());
                            break;
                        case "ORDER_NUMBER":
                            o.setOrderNumber(dataNode.getTextContent());
                            break;
                        case "ORDER_TYPE":
                            o.setOrderType(dataNode.getTextContent());
                            break;
                        case "PROD_LINES":
                            o.setProdLines(dataNode.getTextContent());
                            break;
                        case "ORDER_CHANG_TYPE":
                            o.setOrderChangType(dataNode.getTextContent());
                            break;
                        case "ORDER_CHANG_REASON":
                            o.setOrderChangReason(dataNode.getTextContent());
                            break;
                        case "XIE_YI_NUMBER":
                            o.setXieYiNumber(dataNode.getTextContent());
                            break;
                        case "LINE_NUMBER":
                            o.setLineNumber(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "SOURCE_ORDER_NUMBER":
                            o.setSourceOrderNumber(dataNode.getTextContent());
                            break;
                        case "SOURCE_LINE_NUMBER":
                            o.setSourceLineNumber(dataNode.getTextContent());
                            break;
                        case "DISPLAY_LINE_NUMBER":
                            o.setDisplayLineNumber(dataNode.getTextContent());
                            break;
                        case "ITEM_NUMBER":
                            o.setItemNumber(dataNode.getTextContent());
                            break;
                        case "DESCRIPTION":
                            o.setDescription(dataNode.getTextContent());
                            break;
                        case "ERP_CATEGORY":
                            o.setErpCategory(dataNode.getTextContent());
                            break;
                        case "PROD_CATEGORY":
                            o.setProdCategory(dataNode.getTextContent());
                            break;
                        case "ORDERED_QTY":
                            try{
                                o.setOrderedQty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "FULFILLED_QTY":
                            try{
                                o.setFulfilledQty(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "TRANSACTIONAL_CURRENCY_CODE":
                            o.setTransactionalCurrencyCode(dataNode.getTextContent());
                            break;
                        case "UNIT_LIST_PRICE":
                            try{
                                o.setUnitListPrice(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "TAX_CLASSIFICATION_CODE":
                            o.setTaxClassificationCode(dataNode.getTextContent());
                            break;
                        case "CONVERSION_RATE":
                            try{
                                o.setConversionRate(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "STATUS_CODE":
                            o.setStatusCode(dataNode.getTextContent());
                            break;
                        case "ORDER_CREATION_DATE":
                            o.setOrderCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LINE_CREATION_DATE":
                            o.setLineCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "SUBMITTED_DATE":
                            o.setSubmittedDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "NEW_SUBMITTED_DATE":
                            o.setNewSubmittedDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "SCHEDULE_SHIP_DATE":
                            o.setScheduleShipDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "ORDER_STATUS_CODE":
                            o.setOrderStatusCode(dataNode.getTextContent());
                            break;
                        case "TAX_CODE":
                            try{
                                o.setTaxCode(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                    }
                }
                list.add(o);
            }
            if (list.size() > 0) {
                syncDooOrderDataListService.insertSyncDooOrderDataList(list);
            }
        }
    }
}
