package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncCstCostedVuCostsVEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.domain.SyncCstTransactionsOnhandEO;
import sinexcel.quartz.mapper.SyncCstCostedVuCostsVMapper;
import sinexcel.quartz.mapper.SyncCstTransactionsOnhandMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncCstCostedVuCostsVJob")
public class SyncCstCostedVuCostsVJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private SyncCstCostedVuCostsVMapper syncCstCostedVuCostsVMapper;

    @Autowired
    private SyncCstTransactionsOnhandMapper syncCstTransactionsOnhandMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncCstCostedVuCostsVJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());

        byte[] data = DataModelCommon.getData("/SYNC_DATA/PesCstVuCostedVData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//CST_COSTED_VU_COSTS_V
            NodeList nodeList = root.getElementsByTagName("CST_COSTED_VU_COSTS_V");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncCstCostedVuCostsVEO> list = new ArrayList<SyncCstCostedVuCostsVEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncCstCostedVuCostsVEO o = new SyncCstCostedVuCostsVEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "COST_ELEMENT_ID":
                            o.setCostElementId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SNAPSHOT_DATE":
                            o.setSnapshotDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "UNIT_COST":
                            try{
                                o.setUnitCost(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                    }
                }
                list.add(o);
            }
            syncCstCostedVuCostsVMapper.deleteSyncCstCostedVuCostsVEO();
            if (list.size() > 0) {
                int batchCount =418;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncCstCostedVuCostsVMapper.batchSyncCstCostedVuCostsVEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncCstCostedVuCostsVMapper.batchSyncCstCostedVuCostsVEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
                syncCstCostedVuCostsVMapper.insertSyncCstCostedVuCostsVEO();
            }
        }

        if (true) {//CST_TRANSACTIONS_ONHAND_V
            NodeList nodeList = root.getElementsByTagName("CST_TRANSACTIONS_ONHAND_V");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncCstTransactionsOnhandEO> list = new ArrayList<SyncCstTransactionsOnhandEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncCstTransactionsOnhandEO o = new SyncCstTransactionsOnhandEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "COST_DATE":
                            o.setCostDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "QUANTITY_ONHAND":
                            try{
                                o.setQuantityOnhand(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "SUBINVENTORY_CODE":
                            o.setSubinventoryCode(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }
            syncCstTransactionsOnhandMapper.deleteSyncCstTransactionsOnhandEO();
            if (list.size() > 0) {
                int batchCount =418;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncCstTransactionsOnhandMapper.batchSyncCstTransactionsOnhandEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncCstTransactionsOnhandMapper.batchSyncCstTransactionsOnhandEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }

    }
}
