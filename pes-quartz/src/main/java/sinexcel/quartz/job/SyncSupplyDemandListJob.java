package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncSupplyDemandList;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncSupplyDemandListMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncSupplyDemandListJob")
public class SyncSupplyDemandListJob {

    @Autowired
    private SyncSupplyDemandListMapper syncSupplyDemandListMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncSupplyDemandListJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/CuxSupplyDemandData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//ITEM_SUPPLY_DEMAND_LIST
            NodeList nodeList = root.getElementsByTagName("ITEM_SUPPLY_DEMAND_LIST");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncSupplyDemandList> list = new ArrayList<SyncSupplyDemandList>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncSupplyDemandList o = new SyncSupplyDemandList();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "TYPE":
                            o.setType(dataNode.getTextContent());
                            break;
                        case "QUANTITY":
                            try{
                                o.setQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "REQUIRED_DATE":
                            o.setDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "DOCUMENT_NUMBER":
                            o.setDocumentNumber(dataNode.getTextContent());
                            break;
                        case "UOM_CODE":
                            o.setUom(dataNode.getTextContent());
                            break;
                        case "DOCUMENT_ID":
                            o.setDocumentId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DOCUMENT_LINE_ID":
                            o.setDocumentLineId(Long.parseLong(dataNode.getTextContent()));
                            break;
                    }
                }
                list.add(o);
            }
            syncSupplyDemandListMapper.deleteSyncSupplyDemandListTemp();
            if (list.size() > 0) {
                int batchCount =232;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncSupplyDemandListMapper.batchSyncSupplyDemandListTemp(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncSupplyDemandListMapper.batchSyncSupplyDemandListTemp(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
                syncSupplyDemandListMapper.deleteSyncSupplyDemandList();
                syncSupplyDemandListMapper.batchSyncSupplyDemandHeaderList();
            }
        }
        syncSupplyDemandListMapper.batchSyncSupplyDemandQuantity();
    }
}
