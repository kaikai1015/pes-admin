package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.common.utils.DateUtils;
import sinexcel.quartz.domain.SyncHzCustAccountsEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncHzCustAccountsMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.*;

@Component("syncHzCustAccDataJob")
public class SyncHzCustAccDataJob {

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private SyncHzCustAccountsMapper syncHzCustAccountsMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncHzCustAccDataJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/PesCustomerData_external.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//HZ_CUST_ACCOUNTS
            NodeList nodeList = root.getElementsByTagName("HZ_CUST_ACCOUNTS");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncHzCustAccountsEO> list = new ArrayList<SyncHzCustAccountsEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncHzCustAccountsEO o = new SyncHzCustAccountsEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "CUST_ACCOUNT_ID":
                            o.setCustAccountId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "PARTY_ID":
                            o.setPartyId(Long.parseLong(dataNode.getTextContent()));
                            break;
                        case "ACCOUNT_NUMBER":
                            o.setAccountNumber(dataNode.getTextContent());
                            break;
                        case "STATUS":
                            o.setStatus(dataNode.getTextContent());
                            break;
                        case "ACCOUNT_ESTABLISHED_DATE":
                            o.setAccountEstablishedDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
                            break;
                        case "ACCOUNT_NAME":
                            o.setAccountName(dataNode.getTextContent());
                            break;
                        case "ACCOUNT_TERMINATION_DATE":
                            o.setAccountTerminationDate(DateUtils.toDate_cloud(dataNode.getTextContent()));
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
                int batchCount =232;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncHzCustAccountsMapper.deleteSyncHzCustAccountsEO(list.subList(index, (batchLastIndex + 1)));
                        syncHzCustAccountsMapper.batchSyncHzCustAccountsEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncHzCustAccountsMapper.deleteSyncHzCustAccountsEO(list.subList(index, (batchLastIndex + 1)));
                        syncHzCustAccountsMapper.batchSyncHzCustAccountsEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        }
    }
}
