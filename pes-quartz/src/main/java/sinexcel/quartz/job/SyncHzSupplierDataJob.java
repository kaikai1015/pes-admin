package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncHzPartiesEO;
import sinexcel.quartz.domain.SyncPozSuppliersEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncHzPartiesMapper;
import sinexcel.quartz.mapper.SyncPozSuppliersMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.*;

@Component("syncHzSupplierDataJob")
public class SyncHzSupplierDataJob {

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private SyncHzPartiesMapper syncHzPartiesMapper;

    @Autowired
    private SyncPozSuppliersMapper syncPozSuppliersMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncHzSupplierDataJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/PesHZSupplierData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//HZ_PARTIES
            NodeList nodeList = root.getElementsByTagName("HZ_PARTIES");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncHzPartiesEO> list = new ArrayList<SyncHzPartiesEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncHzPartiesEO o = new SyncHzPartiesEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "PARTY_ID":
                            o.setPartyId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PARTY_NUMBER":
                            o.setPartyNumber(dataNode.getTextContent());
                            break;
                        case "PARTY_NAME":
                            o.setPartyName(dataNode.getTextContent());
                            break;
                        case "PARTY_TYPE":
                            o.setPartyType(dataNode.getTextContent());
                            break;
                        case "PARTY_UNIQUE_NAME":
                            o.setPartyUniqueName(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "COMMENTS":
                            o.setComments(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =261;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncHzPartiesMapper.deleteSyncHzPartiesEO(list.subList(index, (batchLastIndex + 1)));
                        syncHzPartiesMapper.batchSyncHzPartiesEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncHzPartiesMapper.deleteSyncHzPartiesEO(list.subList(index, (batchLastIndex + 1)));
                        syncHzPartiesMapper.batchSyncHzPartiesEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }

        if (true) {//POZ_SUPPLIERS
            NodeList nodeList = root.getElementsByTagName("POZ_SUPPLIERS");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncPozSuppliersEO> list = new ArrayList<SyncPozSuppliersEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncPozSuppliersEO o = new SyncPozSuppliersEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "VENDOR_ID":
                            o.setVendorId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "SEGMENT1":
                            o.setSegment1(dataNode.getTextContent());
                            break;
                        case "PARTY_ID":
                            o.setPartyId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ENABLED_FLAG":
                            o.setEnabledFlag(dataNode.getTextContent());
                            break;
                        case "SUMMARY_FLAG":
                            o.setSummaryFlag(dataNode.getTextContent());
                            break;
                        case "VENDOR_TYPE_LOOKUP_CODE":
                            o.setVendorTypeLookupCode(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "START_DATE_ACTIVE":
                            o.setStartDateActive(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "END_DATE_ACTIVE":
                            o.setEndDateActive(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =208;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncPozSuppliersMapper.deleteSyncPozSuppliersEO(list.subList(index, (batchLastIndex + 1)));
                        syncPozSuppliersMapper.batchSyncPozSuppliersEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncPozSuppliersMapper.deleteSyncPozSuppliersEO(list.subList(index, (batchLastIndex + 1)));
                        syncPozSuppliersMapper.batchSyncPozSuppliersEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
    }
}
