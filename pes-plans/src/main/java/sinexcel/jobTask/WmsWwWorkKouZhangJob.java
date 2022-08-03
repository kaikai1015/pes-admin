package sinexcel.jobTask    ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.wms.service.ICuxWmsWorkKouZhangListService;

import java.util.Date;

@Component("wmsWwWorkKouZhangJob")
public class WmsWwWorkKouZhangJob {

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private ICuxWmsWorkKouZhangListService wmsWorkKouZhangListService;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("wmsWwWorkKouZhangJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
        }
        wmsWorkKouZhangListService.autoErpCuxWmsWorkKouZhangListByIds("1","Y");
        sysJobLogMapper.updateLatUpdateDate(log);
    }
}
