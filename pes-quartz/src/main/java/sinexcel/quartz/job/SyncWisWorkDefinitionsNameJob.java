package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncWisWorkDefinionNameBEO;
import sinexcel.quartz.domain.SyncWisWorkDefinitionsEO;
import sinexcel.quartz.domain.SyncWisWorkDefinitionsIdEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncWisWorkDefinionNameBMapper;
import sinexcel.quartz.mapper.SyncWisWorkDefinitionsIdMapper;
import sinexcel.quartz.mapper.SyncWisWorkDefinitionsMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncWisWorkDefinitionsNameJob")
public class SyncWisWorkDefinitionsNameJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private SyncWisWorkDefinitionsMapper syncWisWorkDefinitionsMapper;

    @Autowired
    private SyncWisWorkDefinionNameBMapper syncWisWorkDefinionNameBMapper;

    @Autowired
    private SyncWisWorkDefinitionsIdMapper syncWisWorkDefinitionsIdMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncWisWorkDefinitionsNameJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/CuxWorkDefinitionPesData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // ??????xml??????
        Element root = document.getDocumentElement();

        if (true) {//WIS_WORK_DEFINITION_NAMES_B
            NodeList nodeList = root.getElementsByTagName("WIS_WORK_DEFINITION_NAMES_B");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()???????????????????????????????????????????????????
            List<SyncWisWorkDefinionNameBEO> list = new ArrayList<SyncWisWorkDefinionNameBEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //?????????????????????????????????
                SyncWisWorkDefinionNameBEO o = new SyncWisWorkDefinionNameBEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "WORK_DEFINITION_NAME_ID":
                            o.setWorkDefinitionNameId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WORK_DEFINITION_CODE":
                            o.setWorkDefinitionCode(dataNode.getTextContent());
                            break;
                        case "WORK_DEFINITION_TYPE":
                            o.setWorkDefinitionType(dataNode.getTextContent());
                            break;
                        case "SEEDED_FLAG":
                            o.setSeededFlag(dataNode.getTextContent());
                            break;
                        case "USED_IN_PLANNING_FLAG":
                            o.setUsedInPlanningFlag(dataNode.getTextContent());
                            break;
                        case "EFFECTIVE_FROM_DATE":
                            o.setEffectiveFromDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "EFFECTIVE_TO_DATE":
                            o.setEffectiveToDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
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
                        case "WORK_DEF_NAME":
                            o.setWorkDefName(dataNode.getTextContent());
                            break;
                        case "WORK_DEF_NAME_DESCRIPTION":
                            o.setWorkDefNameDescription(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }
            if (list.size() > 0) {
                int batchCount =160;//?????????????????????
                int batchLastIndex = batchCount - 1;// ???????????????????????????
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncWisWorkDefinionNameBMapper.deleteSyncWisWorkDefinionNameEO(list.subList(index, (batchLastIndex + 1)));
                        syncWisWorkDefinionNameBMapper.batchSyncWisWorkDefinionNameEO(list.subList(index, (batchLastIndex + 1)));
                        break;// ??????????????????,????????????
                    }else {
                        syncWisWorkDefinionNameBMapper.deleteSyncWisWorkDefinionNameEO(list.subList(index, (batchLastIndex + 1)));
                        syncWisWorkDefinionNameBMapper.batchSyncWisWorkDefinionNameEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// ?????????????????????
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
        if (true) {//WIS_WORK_DEFINITIONS
            NodeList nodeList = root.getElementsByTagName("WIS_WORK_DEFINITIONS");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()???????????????????????????????????????????????????
            List<SyncWisWorkDefinitionsEO> list = new ArrayList<SyncWisWorkDefinitionsEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //?????????????????????????????????
                SyncWisWorkDefinitionsEO o = new SyncWisWorkDefinitionsEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "WORK_DEFINITION_ID":
                            o.setWorkDefinitionId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WORK_DEFINITION_TYPE":
                            o.setWorkDefinitionType(dataNode.getTextContent());
                            break;
                        case "WORK_METHOD_ID":
                            o.setWorkMethodId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TRANSFORM_FROM_ITEM_ID":
                            o.setTransformFromItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WORK_DEFINITION_NAME_ID":
                            o.setWorkDefinitionNameId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WD_MNT_NAME_ID":
                            o.setWdMntNameId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "STATUS_CODE":
                            o.setStatusCode(dataNode.getTextContent());
                            break;
                        case "INACTIVE_DATE":
                            o.setInactiveDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "WORK_DEFINITION_HEADER_NAME":
                            o.setWorkDefinitionHeaderName(dataNode.getTextContent());
                            break;
                        case "PRODUCTION_PRIORITY":
                            try{
                                o.setProductionPriority(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "COSTING_PRIORITY":
                            try{
                                o.setCostingPriority(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SERIAL_TRACKING_FLAG":
                            o.setSerialTrackingFlag(dataNode.getTextContent());
                            break;
                        case "BILL_SEQUENCE_ID":
                            o.setBillSequenceId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "QUANTITY":
                            try{
                                o.setQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "UOM_CODE":
                            o.setUomCode(dataNode.getTextContent());
                            break;
                        case "SYSTEM_GENERATED_FLAG":
                            o.setSystemGeneratedFlag(dataNode.getTextContent());
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
                int batchCount =94;//?????????????????????
                int batchLastIndex = batchCount - 1;// ???????????????????????????
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncWisWorkDefinitionsMapper.deleteSyncWisWorkDefinitionsEO(list.subList(index, (batchLastIndex + 1)));
                        syncWisWorkDefinitionsMapper.batchSyncWisWorkDefinitionsEO(list.subList(index, (batchLastIndex + 1)));
                        break;// ??????????????????,????????????
                    }else {
                        syncWisWorkDefinitionsMapper.deleteSyncWisWorkDefinitionsEO(list.subList(index, (batchLastIndex + 1)));
                        syncWisWorkDefinitionsMapper.batchSyncWisWorkDefinitionsEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// ?????????????????????
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
        if (true) {//WIS_WORK_DEFINITIONS_ID
            NodeList nodeList = root.getElementsByTagName("WIS_WORK_DEFINITIONS_ID");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()???????????????????????????????????????????????????
            List<SyncWisWorkDefinitionsIdEO> list = new ArrayList<SyncWisWorkDefinitionsIdEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //?????????????????????????????????
                SyncWisWorkDefinitionsIdEO o = new SyncWisWorkDefinitionsIdEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "WORK_DEFINITION_ID":
                            o.setWorkDefinitionId(Long.parseLong(dataNode.getTextContent()));
                            break;
                    }
                }
                list.add(o);
            }
            //??????????????????
            syncWisWorkDefinitionsIdMapper.deleteSyncWisWorkDefinitionsIdTempEO();
            if (list.size() > 0) {
                int batchCount =999;//?????????????????????
                int batchLastIndex = batchCount - 1;// ???????????????????????????
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncWisWorkDefinitionsIdMapper.batchSyncWisWorkDefinitionsIdTempEO(list.subList(index, (batchLastIndex + 1)));
                        break;// ??????????????????,????????????
                    }else {
                        syncWisWorkDefinitionsIdMapper.batchSyncWisWorkDefinitionsIdTempEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// ?????????????????????
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
                syncWisWorkDefinitionsIdMapper.batchSyncWisWorkDefinitionsIdEO();
            }
        }
    }
}
