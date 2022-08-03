package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncBomItemDataLisEO;
import sinexcel.quartz.domain.SyncItemNumsDescLisEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.service.ISyncItemsNumDesListService;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncItemNumsDescListJob")
public class SyncItemNumsDescListJob {

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private ISyncItemsNumDesListService syncItemsNumDesListService;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncItemNumsDescListJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

            Map<String,Object> params = new HashMap<String,Object>();
            params.put("FromDate",log.getFromDateToErp());
            params.put("ToDate",log.getStopTime());


            byte[] data = DataModelCommon.getData("/SYNC_DATA/CuxItemsNumDesData_external.xdm",params);

            sysJobLogMapper.updateLatUpdateDate(log);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
            Element root = document.getDocumentElement();

            if (true) {//ITEMS_NUM_DESC_LIST
                NodeList nodeList = root.getElementsByTagName("ITEMS_NUM_DESC_LIST");
                int dataSize = nodeList.getLength();
                //nodeList.getLength()多少条记录数据，然后循环每一条数据
                List<SyncItemNumsDescLisEO> list = new ArrayList<SyncItemNumsDescLisEO>();
                for (int i = 0; i < dataSize; i++) {
                    Node node = nodeList.item(i);
                    NodeList dataList = node.getChildNodes();
                    //遍历每条数据的字段信息
                    SyncItemNumsDescLisEO o = new SyncItemNumsDescLisEO();

                    for (int j = 0; j < dataList.getLength(); ++j) {
                        Node dataNode = dataList.item(j);
                        switch(dataNode.getNodeName()){
                            case "ORGANIZATION_ID":
                                o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                                break;
                            case "INVENTORY_ITEM_ID":
                                o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                                break;
                            case "ITEM_NUMBER":
                                o.setItemNumber(dataNode.getTextContent());
                                break;
                            case "LAST_UPDATE_DATE":
                                o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                                break;
                            case "DESCRIPTION":
                                o.setItemDescription(dataNode.getTextContent());
                                break;
                            case "ITEM_TYPE":
                                o.setItemType(dataNode.getTextContent());
                                break;
                            case "PLANNING_MAKE_BUY_CODE":
                                o.setPlanningMakeBuyCode(dataNode.getTextContent());
                                break;
                            case "PRIMARY_UOM_CODE":
                                o.setPrimaryUomCode(dataNode.getTextContent());
                                break;
                            case "BUYER_NAME":
                                o.setBuyerName(dataNode.getTextContent());
                                break;
                            case "INVENTORY_ITEM_STATUS_CODE":
                                o.setInventoryItemStatusCode(dataNode.getTextContent());
                                break;
                            case "FIXED_LEAD_TIME":
                                try{
                                    o.setFixedLeadTime(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                                }catch(Exception e){
                                }
                                break;
                            case "MINIMUM_ORDER_QUANTITY":
                                try{
                                    o.setMinimumOrderQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                                }catch(Exception e){
                                }
                                break;
                        }
                    }
                    list.add(o);
                }
                if (list.size() > 0) {
                    syncItemsNumDesListService.batchSyncItemNumsDescLis(list);
                }
            }

        if (true) {//BOM_ITEM_INFOR_DATA
            NodeList nodeList = root.getElementsByTagName("BOM_ITEM_INFOR_DATA");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncBomItemDataLisEO> list = new ArrayList<SyncBomItemDataLisEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncBomItemDataLisEO o = new SyncBomItemDataLisEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "COMPONENT_SEQUENCE_ID":
                            o.setComponentSequenceId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "P_INVENTORY_ITEM_ID":
                            o.setpInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "COMPONENT_QUANTITY":
                            try{
                                o.setComponent_quantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "DISABLE_DATE":
                            o.setDisableDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "IMPLEMENTATION_DATE":
                            o.setImplementationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                    }
                }
                list.add(o);
            }
            if (list.size() > 0) {
                syncItemsNumDesListService.batchSyncBomItemDataLis(list);
            }
        }

    }
}
