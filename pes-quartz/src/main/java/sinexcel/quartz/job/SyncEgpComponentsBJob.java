package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncEgpComponentsBEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncEgpComponentsBMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;


@Component("syncEgpComponentsBJob")
public class SyncEgpComponentsBJob{

    @Autowired
    private SyncEgpComponentsBMapper syncEgpComponentsBMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncEgpComponentsBJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());

        byte[] data = DataModelCommon.getData("/SYNC_DATA/CuxEGPCompData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//EGP_COMPONENTS_B
            NodeList nodeList = root.getElementsByTagName("EGP_COMPONENTS_B");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncEgpComponentsBEO> list = new ArrayList<SyncEgpComponentsBEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncEgpComponentsBEO o = new SyncEgpComponentsBEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "COMPONENT_SEQUENCE_ID":
                            o.setComponentSequenceId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "OPERATION_SEQ_NUM":
                            try{
                                o.setOperationSeqNum(new BigDecimal(dataNode.getTextContent()));
                            }catch(Exception e){
                            }
                            break;
                        case "PRIMARY_UOM_CODE":
                            o.setPrimaryUomCode(dataNode.getTextContent());
                            break;
                        case "CHANGE_ID":
                            o.setChangeId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ITEM_NUM":
                            try{
                                o.setItemNum(new BigDecimal(dataNode.getTextContent()));
                            }catch(Exception e){
                            }
                            break;
                        case "COMPONENT_QUANTITY":
                            try{
                                o.setComponentQuantity(new BigDecimal(dataNode.getTextContent()));
                            }catch(Exception e){
                            }
                            break;
                        case "COMPONENT_YIELD_FACTOR":
                            try{
                                o.setComponentYieldFactor(new BigDecimal(dataNode.getTextContent()));
                            }catch(Exception e){
                            }
                            break;
                        case "COMPONENT_REMARKS":
                            o.setComponentRemarks(dataNode.getTextContent());
                            break;
                        case "EFFECTIVITY_DATE":
                            o.setEffectivityDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "DISABLE_DATE":
                            o.setDisableDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "IMPLEMENTATION_DATE":
                            o.setImplementationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ATTRIBUTE_CATEGORY":
                            o.setAttributeCategory(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE1":
                            o.setAttribute1(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE2":
                            o.setAttribute2(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE3":
                            o.setAttribute3(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE4":
                            o.setAttribute4(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE5":
                            o.setAttribute5(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE6":
                            o.setAttribute6(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE7":
                            o.setAttribute7(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE8":
                            o.setAttribute8(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE9":
                            o.setAttribute9(dataNode.getTextContent());
                            break;
                        case "ATTRIBUTE10":
                            o.setAttribute10(dataNode.getTextContent());
                            break;
                        case "CREATED_BY":
                            o.setCreatedBy(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_LOGIN":
                            o.setLastUpdateLogin(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "CREATION_DATE":
                            o.setCreationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "OBJECT_VERSION_NUMBER":
                            o.setObjectVersionNumber(Integer.parseInt(dataNode.getTextContent()));
                            break;
                        case "PLANNING_FACTOR":
                            try{
                                o.setPlanningFactor(new BigDecimal(dataNode.getTextContent()));
                            }catch(Exception e){
                            }
                            break;
                        case "ACD_TYPE":
                            try{
                                o.setAcdType(new BigDecimal(dataNode.getTextContent()));
                            }catch(Exception e){
                            }
                            break;
                        case "OLD_COMPONENT_SEQUENCE_ID":
                            o.setOldComponentSequenceId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "BILL_SEQUENCE_ID":
                            o.setBillSequenceId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "REQUEST_ID":
                            o.setRequestId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WIP_SUPPLY_TYPE":
                            try{
                                o.setWipSupplyType(new BigDecimal(dataNode.getTextContent()));
                            }catch(Exception e){
                            }
                            break;
                        case "PICK_COMPONENTS":
                            try{
                                o.setPickComponents(new BigDecimal(dataNode.getTextContent()));
                            }catch(Exception e){
                            }
                            break;
                        case "BOM_ITEM_TYPE":
                            try{
                                o.setBomItemType(new BigDecimal(dataNode.getTextContent()));
                            }catch(Exception e){
                            }
                            break;
                        case "PLAN_LEVEL":
                            try{
                                o.setPlanLevel(new BigDecimal(dataNode.getTextContent()));
                            }catch(Exception e){
                            }
                            break;
                        case "VENDOR_ID":
                            o.setVendorId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "UNIT_PRICE":
                            try{
                                o.setUnitPrice(new BigDecimal(dataNode.getTextContent()));
                            }catch(Exception e){
                            }
                            break;
                        case "PK1_VALUE":
                            o.setPk1Value(dataNode.getTextContent());
                            break;
                        case "PK2_VALUE":
                            o.setPk2Value(dataNode.getTextContent());
                            break;
                        case "BASIS_TYPE":
                            try{
                                o.setBasisType(new BigDecimal(dataNode.getTextContent()));
                            }catch(Exception e){
                            }
                            break;
                        case "COMMON_COMPONENT_SEQUENCE_ID":
                            o.setCommonComponentSequenceId(Long.parseLong(dataNode.getTextContent()));
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =48;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncEgpComponentsBMapper.deleteSyncEgpComponentsBEO(list.subList(index, (batchLastIndex + 1)));
                        syncEgpComponentsBMapper.batchSyncEgpComponentsBEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncEgpComponentsBMapper.deleteSyncEgpComponentsBEO(list.subList(index, (batchLastIndex + 1)));
                        syncEgpComponentsBMapper.batchSyncEgpComponentsBEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
    }
}
