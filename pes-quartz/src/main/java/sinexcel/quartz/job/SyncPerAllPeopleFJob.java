package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncPerAllPeopleFEO;
import sinexcel.quartz.domain.SyncPerPersonNamesFEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncPerAllPeopleFMapper;
import sinexcel.quartz.mapper.SyncPerPersonNamesFMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.*;

@Component("syncPerAllPeopleFJob")
public class SyncPerAllPeopleFJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private SyncPerAllPeopleFMapper syncPerAllPeopleFMapper;

    @Autowired
    private SyncPerPersonNamesFMapper syncPerPersonNamesFMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncPerAllPeopleFJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/PesUserAndRoleData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//PER_ALL_PEOPLE_F
            NodeList nodeList = root.getElementsByTagName("PER_ALL_PEOPLE_F");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncPerAllPeopleFEO> list = new ArrayList<SyncPerAllPeopleFEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncPerAllPeopleFEO o = new SyncPerAllPeopleFEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "PERSON_ID":
                            o.setPersonId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "EFFECTIVE_START_DATE":
                            o.setEffectiveStartDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "EFFECTIVE_END_DATE":
                            o.setEffectiveEndDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                        case "PERSON_NUMBER":
                            o.setPersonNumber(dataNode.getTextContent());
                            break;
                        case "EMAIL_ADDRESS":
                            o.setEmailAddress(dataNode.getTextContent());
                            break;
                        case "PHONE_NUMBER":
                            o.setPhoneNumber(dataNode.getTextContent());
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
                        syncPerAllPeopleFMapper.deleteSyncPerAllPeopleFEO(list.subList(index, (batchLastIndex + 1)));
                        syncPerAllPeopleFMapper.batchSyncPerAllPeopleFEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncPerAllPeopleFMapper.deleteSyncPerAllPeopleFEO(list.subList(index, (batchLastIndex + 1)));
                        syncPerAllPeopleFMapper.batchSyncPerAllPeopleFEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }

        if (true) {//PER_PERSON_NAMES_F
            NodeList nodeList = root.getElementsByTagName("PER_PERSON_NAMES_F");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncPerPersonNamesFEO> list = new ArrayList<SyncPerPersonNamesFEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncPerPersonNamesFEO o = new SyncPerPersonNamesFEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "PERSON_NAME_ID":
                            o.setPersonNameId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "EFFECTIVE_START_DATE":
                            o.setEffectiveStartDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "EFFECTIVE_END_DATE":
                            o.setEffectiveEndDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "PERSON_ID":
                            o.setPersonId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "DISPLAY_NAME":
                            o.setDisplayName(dataNode.getTextContent());
                            break;
                        case "LAST_UPDATE_DATE":
                            o.setLastUpdateDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "LAST_UPDATED_BY":
                            o.setLastUpdatedBy(dataNode.getTextContent());
                            break;
                    }
                }
                list.add(o);
            }

            if (list.size() > 0) {
                int batchCount =299;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncPerPersonNamesFMapper.deleteSyncPerPersonNamesFEO(list.subList(index, (batchLastIndex + 1)));
                        syncPerPersonNamesFMapper.batchSyncPerPersonNamesFEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncPerPersonNamesFMapper.deleteSyncPerPersonNamesFEO(list.subList(index, (batchLastIndex + 1)));
                        syncPerPersonNamesFMapper.batchSyncPerPersonNamesFEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
    }
}
