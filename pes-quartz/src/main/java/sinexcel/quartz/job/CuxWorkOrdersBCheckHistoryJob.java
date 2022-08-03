package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.quartz.domain.CuxWorkOrdersBCheckHistoryEO;
import sinexcel.quartz.domain.CuxWorkOrdersQtDetailsQlHistoryEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.CuxWorkOrdersBCheckHistoryMapper;
import sinexcel.quartz.mapper.CuxWorkOrdersQtDetailsQlHistoryMapper;
import sinexcel.quartz.mapper.SysJobLogMapper;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 周计划导入历史记录表cux_wie_work_orders_b_check_w_history
 *
 * @author Zhang Kai
 * @date 2021-03-12
 */

@Component("cuxWorkOrdersBCheckHistoryJob")
public class CuxWorkOrdersBCheckHistoryJob {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private CuxWorkOrdersBCheckHistoryMapper cuxWorkOrdersBCheckHistoryMapper;

    @Autowired
    private CuxWorkOrdersQtDetailsQlHistoryMapper cuxWorkOrdersQtDetailsQlHistoryMapper;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("CuxWorkOrdersBCheckHistoryJob");
        log.setStopTime(new Date());
        log.setStartTime(log.getStopTime());

        sysJobLogMapper.updateLatUpdateDate(log);

        long time= log.getStopTime().getTime();
        long sevenTime = 30*24*60*60*1000;
        long times = time - sevenTime;
        Date dat=new Date(times);
        String lotNum = sdf.format(dat);

        //周计划导入信息
        List<CuxWorkOrdersBCheckHistoryEO> list = cuxWorkOrdersBCheckHistoryMapper.getCuxWorkOrdersBCheckHistoryList(lotNum);
        //欠料信息
        List<CuxWorkOrdersQtDetailsQlHistoryEO> lists = cuxWorkOrdersQtDetailsQlHistoryMapper.getCuxWorkOrdersQtDetailsQlHistoryList(lotNum);

        if (list.size() > 0) {
            int batchCount =130;//每批处理的条数
            int batchLastIndex = batchCount - 1;// 每批最后一个的下标
            for (int index = 0; index < list.size();) {
                if (batchLastIndex > (list.size() - 1)) {
                    batchLastIndex = list.size() - 1;
                    cuxWorkOrdersBCheckHistoryMapper.batchCuxWorkOrdersBCheckHistoryEO(list.subList(index, (batchLastIndex + 1)));
                    break;// 数据插入完毕,退出循环
                }else {
                    cuxWorkOrdersBCheckHistoryMapper.batchCuxWorkOrdersBCheckHistoryEO(list.subList(index, (batchLastIndex + 1)));
                    index = batchLastIndex + 1;// 设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
            //历史记录备份后，删除响应批次数据
            cuxWorkOrdersBCheckHistoryMapper.delCuxWorkOrdersBCheckHistoryList(lotNum);
        }
        if (lists.size() > 0) {
            int batchCount =86;//每批处理的条数
            int batchLastIndex = batchCount - 1;// 每批最后一个的下标
            for (int index = 0; index < lists.size();) {
                if (batchLastIndex > (lists.size() - 1)) {
                    batchLastIndex = lists.size() - 1;
                    cuxWorkOrdersQtDetailsQlHistoryMapper.batchCuxWorkOrdersQtDetailsQlHistoryEO(lists.subList(index, (batchLastIndex + 1)));
                    break;// 数据插入完毕,退出循环
                }else {
                    cuxWorkOrdersQtDetailsQlHistoryMapper.batchCuxWorkOrdersQtDetailsQlHistoryEO(lists.subList(index, (batchLastIndex + 1)));
                    index = batchLastIndex + 1;// 设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
            //历史记录备份后，删除响应批次数据
            cuxWorkOrdersQtDetailsQlHistoryMapper.delCuxWorkOrdersQtDetailsQlHistoryList(lotNum);
        }
    }
}