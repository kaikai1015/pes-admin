package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncEgpStructuresB;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncEgpStructuresBMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;


@Component("syncEgpStructuresBJob")
public class SyncEgpStructuresBJob{

    @Autowired
    private SyncEgpStructuresBMapper syncEgpStructuresBMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncEgpStructuresBJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/CuxStructureData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//EGP_STRUCTURES_B
            NodeList nodeList = root.getElementsByTagName("EGP_STRUCTURES_B");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncEgpStructuresB> list = new ArrayList<SyncEgpStructuresB>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncEgpStructuresB o = new SyncEgpStructuresB();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "BILL_SEQUENCE_ID":
                            o.setBillSequenceId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ALTERNATE_BOM_DESIGNATOR":
                            o.setAlternateBomDesignator(dataNode.getTextContent());
                            break;
                        case "COMMON_BILL_SEQUENCE_ID":
                            o.setCommonBillSequenceId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "REQUEST_ID":
                            o.setRequestId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "STRUCTURE_TYPE_ID":
                            o.setStructureTypeId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORIGINAL_SYSTEM_REFERENCE":
                            o.setOriginalSystemReference(dataNode.getTextContent());
                            break;
                        case "OBJ_NAME":
                            o.setObjName(dataNode.getTextContent());
                            break;
                        case "PK1_VALUE":
                            o.setPk1Value(dataNode.getTextContent());
                            break;
                        case "PK2_VALUE":
                            o.setPk2Value(dataNode.getTextContent());
                            break;
                        case "EFFECTIVITY_CONTROL":
                            try{
                                o.setEffectivityControl(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SOURCE_BILL_SEQUENCE_ID":
                            o.setSourceBillSequenceId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CHANGE_ID":
                            o.setChangeId(Long.parseLong(dataNode.getTextContent()));
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
                        case "CREATED_BY":
                            o.setCreatedBy(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
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
                int batchCount =95;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncEgpStructuresBMapper.deleteSyncEgpStructuresBByIds(list.subList(index, (batchLastIndex + 1)));
                        syncEgpStructuresBMapper.batchSyncEgpStructuresB(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncEgpStructuresBMapper.deleteSyncEgpStructuresBByIds(list.subList(index, (batchLastIndex + 1)));
                        syncEgpStructuresBMapper.batchSyncEgpStructuresB(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
    }
}
