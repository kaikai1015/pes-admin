package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sinexcel.quartz.domain.SyncSWieWoOperaMaterialIdAllEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SyncSWieWoOperaMaterialIdAllMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wsc.DataModelCommon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.*;

@Component("syncSWieWoOperaMaterialIDAllJob")
public class SyncSWieWoOperaMaterialIDAllJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private SyncSWieWoOperaMaterialIdAllMapper syncSWieWoOperaMaterialIdAllMapper;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("SyncSWieWoOperaMaterialIDAllJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("FromDate",log.getFromDateToErp());
        params.put("ToDate",log.getStopTime());


        byte[] data = DataModelCommon.getData("/SYNC_DATA/CuxWorkMaterialTrxIdAllData_externalPes.xdm",params);

        sysJobLogMapper.updateLatUpdateDate(log);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(data)); // 读取xml文件
        Element root = document.getDocumentElement();

        if (true) {//WIE_WO_OPERATION_MATERIALS_ID_ALL
            NodeList nodeList = root.getElementsByTagName("WIE_WO_OPERATION_MATERIALS_ID_ALL");
            int dataSize = nodeList.getLength();
            //nodeList.getLength()多少条记录数据，然后循环每一条数据
            List<SyncSWieWoOperaMaterialIdAllEO> list = new ArrayList<SyncSWieWoOperaMaterialIdAllEO>();
            for (int i = 0; i < dataSize; i++) {
                Node node = nodeList.item(i);
                NodeList dataList = node.getChildNodes();
                //遍历每条数据的字段信息
                SyncSWieWoOperaMaterialIdAllEO o = new SyncSWieWoOperaMaterialIdAllEO();

                for (int j = 0; j < dataList.getLength(); ++j) {
                    Node dataNode = dataList.item(j);
                    switch(dataNode.getNodeName()){
                        case "WO_OPERATION_MATERIAL_ID":
                            o.setWoOperationMaterialId(Long.parseLong(dataNode.getTextContent()));
                            break;
                    }
                }
                list.add(o);
            }
            syncSWieWoOperaMaterialIdAllMapper.deleteSyncSWieWoOperaMaterialIdAllTempEO();
            if (list.size() > 0) {
                int batchCount =999;//每批处理的条数
                int batchLastIndex = batchCount - 1;// 每批最后一个的下标
                for (int index = 0; index < list.size();) {
                    if (batchLastIndex > (list.size() - 1)) {
                        batchLastIndex = list.size() - 1;
                        syncSWieWoOperaMaterialIdAllMapper.batchSyncSWieWoOperaMaterialIdAllTempEO(list.subList(index, (batchLastIndex + 1)));
                        break;// 数据插入完毕,退出循环
                    }else {
                        syncSWieWoOperaMaterialIdAllMapper.batchSyncSWieWoOperaMaterialIdAllTempEO(list.subList(index, (batchLastIndex + 1)));
                        index = batchLastIndex + 1;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
                syncSWieWoOperaMaterialIdAllMapper.batchSyncSWieWoOperaMaterialIdAllEO();
            }
        }
    }
}
