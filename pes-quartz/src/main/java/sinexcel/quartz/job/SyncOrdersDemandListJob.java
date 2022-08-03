package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncOrdersDemandListEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncOrdersDemandListMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.*;

@Component("syncOrdersDemandListJob")
public class SyncOrdersDemandListJob {

    @Autowired
    private SyncOrdersDemandListMapper syncOrdersDemandListMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncOrdersDemandListJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/CuxOrdersDemandData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//ORDERS_DEMAND_LIST
            NodeList nodeList = root.getElementsByTagName("ORDERS_DEMAND_LIST");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncOrdersDemandListEO> list = new ArrayList<SyncOrdersDemandListEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncOrdersDemandListEO o = new SyncOrdersDemandListEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PLAN_LOT_NUM":
                            o.setPlanLotNum(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PLAN_LOT_LINE_NUM":
                            o.setPlanLotLineNum(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PLAN_ITEM_QUANTITY":
                            try{
                                o.setPlanItemQuantity(new BigDecimal(dataNode.getTextContent()).setScale(5, BigDecimal.ROUND_HALF_UP));
                            }catch(Exception e){
                            }
                            break;
                        case "PLAN_DATE":
                            o.setPlanDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "DOCUMENT_NUMBER":
                            o.setDocumentNumber(dataNode.getTextContent());
                            break;
                        case "PLAN_ITEM_NUMBER":
                            o.setPlanItemNumber(dataNode.getTextContent());
                            break;
                        case "PLAN_ITEM_TYPE":
                            o.setPlanItemType(dataNode.getTextContent());
                            break;
                        case "CUST_PO_NUMBER":
                            o.setCustPoNumber(dataNode.getTextContent());
                            break;
                        case "DOCUMENT_LINE_NUM":
                            o.setDocumentLineNum(Integer.parseInt(dataNode.getTextContent()));
                            break;case "CUSTOMER_ID":
                            o.setCustomerId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CUSTOMER_NAME":
                            o.setCustomerName(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }
            if (list.size() > 0) {
                int batchCount =161;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncOrdersDemandListMapper.batchSyncOrdersDemandList(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncOrdersDemandListMapper.batchSyncOrdersDemandList(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
                //订单需求批次计划头
                syncOrdersDemandListMapper.addOrdersDemandsList(list.get(0).getPlanLotNum());
                //订单需求批次计划MPS头
                syncOrdersDemandListMapper.addOrdersDemandsMpsList(list.get(0).getPlanLotNum());
                //订单需求批次计划MRP头
                syncOrdersDemandListMapper.addOrdersDemandsMrpList(list.get(0).getPlanLotNum());
            }
        }
    }
}
