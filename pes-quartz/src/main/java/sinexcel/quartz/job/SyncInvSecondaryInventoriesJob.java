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
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncInvSecondaryInventoriesJob")
public class SyncInvSecondaryInventoriesJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private SyncInvSecondaryInventoriesMapper syncInvSecondaryInventoriesMapper;

    @Autowired
    private SyncInvTrnxEffMapper syncInvTrnxEffMapper;

    @Autowired
    private SyncInvTransactionTypeTlMapper syncInvTransactionTypeTlMapper;

    @Autowired
    private SyncInvTrxSourceTypeTlMapper syncInvTrxSourceTypeTlMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncInvSecondaryInventoriesJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/PesINVSecondaryData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//INV_SECONDARY_INVENTORIES
            NodeList nodeList = root.getElementsByTagName("INV_SECONDARY_INVENTORIES");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncInvSecondaryInventoriesEO> list = new ArrayList<SyncInvSecondaryInventoriesEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncInvSecondaryInventoriesEO o = new SyncInvSecondaryInventoriesEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "SECONDARY_INVENTORY_NAME":
                            o.setSecondaryInventoryName(dataNode.getTextContent());
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "DESCRIPTION":
                            o.setDescription(dataNode.getTextContent());
                            break;
                        case "DISABLE_DATE":
                            o.setDisableDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "INVENTORY_ATP_CODE":
                            o.setInventoryAtpCode(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "AVAILABILITY_TYPE":
                            o.setAvailabilityType(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "RESERVABLE_TYPE":
                            o.setReservableType(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "LOCATOR_TYPE":
                            o.setLocatorType(dataNode.getTextContent());
                            break;
                        case "PICKING_ORDER":
                            try{
                                o.setPickingOrder(new BigDecimal(dataNode.getTextContent()).setScale(2));
                            }catch(Exception e){
                            }
                            break;
                        case "QUANTITY_TRACKED":
                            o.setQuantityTracked(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "SUBINVENTORY_ID":
                            o.setSubinventoryId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ASSET_INVENTORY":
                            o.setAssetInventory(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "FILL_KILL_TO_LOOKUP":
                            o.setFillKillToLookup(dataNode.getTextContent());
                            break;
                        case "LOCATION_ID":
                            o.setLocationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PICK_UOM_CODE":
                            o.setPickUomCode(dataNode.getTextContent());
                            break;
                        case "DEPRECIABLE_FLAG":
                            o.setDepreciableFlag(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "STATUS_ID":
                            o.setStatusId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SUBINVENTORY_TYPE":
                            o.setSubinventoryType(dataNode.getTextContent());
                            break;
                        case "PLANNING_LEVEL":
                            o.setPlanningLevel(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "DEFAULT_COUNT_TYPE_CODE":
                            o.setDefaultCountTypeCode(dataNode.getTextContent());
                            break;
                        case "COUNT_METHOD":
                            o.setCountMethod(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =90;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncInvSecondaryInventoriesMapper.deleteSyncInvSecondaryInventoriesEO(list.subList(index, (batchLastIndex + 1)));
                        syncInvSecondaryInventoriesMapper.batchSyncInvSecondaryInventoriesEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncInvSecondaryInventoriesMapper.deleteSyncInvSecondaryInventoriesEO(list.subList(index, (batchLastIndex + 1)));
                        syncInvSecondaryInventoriesMapper.batchSyncInvSecondaryInventoriesEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
        if (true) {//INV_MATERIAL_TXNS_EFF
            NodeList nodeList = root.getElementsByTagName("INV_MATERIAL_TXNS_EFF");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncInvTrnxEffEO> list = new ArrayList<SyncInvTrnxEffEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncInvTrnxEffEO o = new SyncInvTrnxEffEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "FLEX_VALUE":
                            o.setFlexValue(dataNode.getTextContent());
                            break;
                        case "DESCRIPTION":
                            o.setDescription(dataNode.getTextContent());
                            break;
                        case "TYPE":
                            o.setType(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }
            syncInvTrnxEffMapper.deleteSyncInvTrnxEffLis();
            if (list.size() > 0) {
                int batchCount =697;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncInvTrnxEffMapper.batchSyncInvTrnxEffLis(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncInvTrnxEffMapper.batchSyncInvTrnxEffLis(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
        if (true) {//INV_TRANSACTION_TYPES_TL
            NodeList nodeList = root.getElementsByTagName("INV_TRANSACTION_TYPES_TL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncInvTransactionTypeTlEO> list = new ArrayList<SyncInvTransactionTypeTlEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncInvTransactionTypeTlEO o = new SyncInvTransactionTypeTlEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "TRANSACTION_TYPE_ID":
                            o.setTransactionTypeId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LANGUAGE":
                            o.setLanguage(dataNode.getTextContent());
                            break;
                        case "SOURCE_LANG":
                            o.setSourceLang(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "CREATION_DATE":
                            o.setCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CREATED_BY":
                            o.setCreatedBy(dataNode.getTextContent());
                            break;
                        case "TRANSACTION_TYPE_NAME":
                            o.setTransactionTypeName(dataNode.getTextContent());
                            break;
                        case "DESCRIPTION":
                            o.setDescription(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }
            if (list.size() > 0) {
                int batchCount =232;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncInvTransactionTypeTlMapper.deleteSyncInvTransactionTypeTl(list.subList(index, (batchLastIndex + 1)));
                        syncInvTransactionTypeTlMapper.batchSyncInvTransactionTypeTl(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncInvTransactionTypeTlMapper.deleteSyncInvTransactionTypeTl(list.subList(index, (batchLastIndex + 1)));
                        syncInvTransactionTypeTlMapper.batchSyncInvTransactionTypeTl(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
        if (true) {//INV_TXN_SOURCE_TYPES_TL
            NodeList nodeList = root.getElementsByTagName("INV_TXN_SOURCE_TYPES_TL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncInvTrxSourceTypeTlEO> list = new ArrayList<SyncInvTrxSourceTypeTlEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncInvTrxSourceTypeTlEO o = new SyncInvTrxSourceTypeTlEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "TRANSACTION_SOURCE_TYPE_ID":
                            o.setTransactionSourceTypeId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "LANGUAGE":
                            o.setLanguage(dataNode.getTextContent());
                            break;
                        case "SOURCE_LANG":
                            o.setSourceLang(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "CREATION_DATE":
                            o.setCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CREATED_BY":
                            o.setCreatedBy(dataNode.getTextContent());
                            break;
                        case "TRANSACTION_SOURCE_TYPE_NAME":
                            o.setTransactionSourceTypeName(dataNode.getTextContent());
                            break;
                        case "DESCRIPTION":
                            o.setDescription(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }
            if (list.size() > 0) {
                int batchCount =232;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncInvTrxSourceTypeTlMapper.deleteSyncInvTrxSourceTypeTl(list.subList(index, (batchLastIndex + 1)));
                        syncInvTrxSourceTypeTlMapper.batchSyncInvTrxSourceTypeTl(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncInvTrxSourceTypeTlMapper.deleteSyncInvTrxSourceTypeTl(list.subList(index, (batchLastIndex + 1)));
                        syncInvTrxSourceTypeTlMapper.batchSyncInvTrxSourceTypeTl(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
    }
}
