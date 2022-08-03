package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncEgpCategoryBEO;
import sinexcel.quartz.domain.SyncEgpItemCateGorieEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncEgpCategoryBMapper;
import sinexcel.quartz.mapper.SyncEgpItemCateGorieMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.*;

@Component("syncEgpCategoryJob")
public class SyncEgpCategoryJob {

    @Autowired
    private SyncEgpItemCateGorieMapper syncEgpItemCateGorieMapper;

    @Autowired
    private SyncEgpCategoryBMapper syncEgpCategoryBMapper;

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncEgpCategoryJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/CuxCategoryPesData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//EGP_ITEM_CATEGORIES
            NodeList nodeList = root.getElementsByTagName("EGP_ITEM_CATEGORIES");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncEgpItemCateGorieEO> list = new ArrayList<SyncEgpItemCateGorieEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncEgpItemCateGorieEO o = new SyncEgpItemCateGorieEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "INVENTORY_ITEM_ID":
                            o.setInventoryItemId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ORGANIZATION_ID":
                            o.setOrganizationId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CATEGORY_SET_ID":
                            o.setCategorySetId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "CATEGORY_ID":
                            o.setCategoryId(Long.parseLong(dataNode.getTextContent()));
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
                        case "START_DATE":
                            o.setStartDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "END_DATE":
                            o.setEndDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
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
                        syncEgpItemCateGorieMapper.deleteSyncEgpItemCateGorieEO(list.subList(index, (batchLastIndex + 1)));
                        syncEgpItemCateGorieMapper.batchSyncEgpItemCateGorieEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncEgpItemCateGorieMapper.deleteSyncEgpItemCateGorieEO(list.subList(index, (batchLastIndex + 1)));
                        syncEgpItemCateGorieMapper.batchSyncEgpItemCateGorieEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
        if (true) {//EGP_CATEGORIES_B
            NodeList nodeList = root.getElementsByTagName("EGP_CATEGORIES_B");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncEgpCategoryBEO> list = new ArrayList<SyncEgpCategoryBEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncEgpCategoryBEO o = new SyncEgpCategoryBEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "CATEGORY_ID":
                            o.setCategoryId(Long.parseLong(dataNode.getTextContent()));
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
                        case "DESCRIPTION":
                            o.setDescription(dataNode.getTextContent());
                            break;
                        case "DISABLE_DATE":
                            o.setDisableDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "SUMMARY_FLAG":
                            o.setSummaryFlag(dataNode.getTextContent());
                            break;
                        case "ENABLED_FLAG":
                            o.setEnabledFlag(dataNode.getTextContent());
                            break;
                        case "START_DATE_ACTIVE":
                            o.setStartDateActive(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "END_DATE_ACTIVE":
                            o.setEndDateActive(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "SUPPLIER_ENABLED_FLAG":
                            o.setSupplierEnabledFlag(dataNode.getTextContent());
                            break;
                        case "CATEGORY_CONTENT_CODE":
                            o.setCategoryContentCode(dataNode.getTextContent());
                            break;
                        case "CATEGORY_CODE":
                            o.setCategoryCode(dataNode.getTextContent());
                            break;
                        case "WEB_STATUS":
                            o.setWebStatus(dataNode.getTextContent());
                            break;
                        case "CATEGORY_NAME":
                            o.setCategoryName(dataNode.getTextContent());
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
                        syncEgpCategoryBMapper.deleteSyncEgpCategoryBEO(list.subList(index, (batchLastIndex + 1)));
                        syncEgpCategoryBMapper.batchSyncEgpCategoryBEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncEgpCategoryBMapper.deleteSyncEgpCategoryBEO(list.subList(index, (batchLastIndex + 1)));
                        syncEgpCategoryBMapper.batchSyncEgpCategoryBEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
    }
}
