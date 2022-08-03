package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncSWieWoOperaMaterialEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncSWieWoOperaMaterialMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncSWieWoOperaMaterialJob")
public class SyncSWieWoOperaMaterialJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private SyncSWieWoOperaMaterialMapper syncSWieWoOperaMaterialMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncSWieWoOperaMaterialJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/CuxWorkMaterialTrxData_externalPes.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//WIE_WO_OPERATION_MATERIALS
            NodeList nodeList = root.getElementsByTagName("WIE_WO_OPERATION_MATERIALS");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncSWieWoOperaMaterialEO> list = new ArrayList<SyncSWieWoOperaMaterialEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncSWieWoOperaMaterialEO o = new SyncSWieWoOperaMaterialEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "WO_OPERATION_MATERIAL_ID":
                            o.setWoOperationMaterialId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "WORK_ORDER_ID":
                            o.setWorkOrderId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "MATERIAL_SEQ_NUMBER":
                            try{
                                o.setMaterialSeqNumber(Integer.parseInt(dataNode.getTextContent()));
                            }catch(Exception e){
                            }
                            break;
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "QUANTITY":
                            try{
                                o.setQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "REQUIRED_DATE":
                            o.setRequiredDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ISSUED_QUANTITY":
                            try{
                                o.setIssuedQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "WO_OPERATION_ID":
                            o.setWoOperationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "MATERIAL_TYPE":
                            o.setMaterialType(dataNode.getTextContent());
                            break;
                        case "QUANTITY_PER_PRODUCT":
                            try{
                                o.setQuantityPerProduct(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "BASIS_TYPE":
                            o.setBasisType(dataNode.getTextContent());
                            break;
                        case "UOM_CODE":
                            o.setUomCode(dataNode.getTextContent());
                            break;
                        case "INCLUDE_IN_PLANNING_FLAG":
                            o.setIncludeInPlanningFlag(dataNode.getTextContent());
                            break;
                        case "SUPPLY_TYPE":
                            o.setSupplyType(dataNode.getTextContent());
                            break;
                        case "SUPPLY_SUBINVENTORY":
                            o.setSupplySubinventory(dataNode.getTextContent());
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
                        syncSWieWoOperaMaterialMapper.deleteSyncSWieWoOperaMaterialEO(list.subList(index, (batchLastIndex + 1)));
                        syncSWieWoOperaMaterialMapper.batchSyncSWieWoOperaMaterialEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncSWieWoOperaMaterialMapper.deleteSyncSWieWoOperaMaterialEO(list.subList(index, (batchLastIndex + 1)));
                        syncSWieWoOperaMaterialMapper.batchSyncSWieWoOperaMaterialEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
    }
}
