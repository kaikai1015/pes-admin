package sinexcel.quartz.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.quartz.domain.MesToPesWieWorkProcessingQuantityListEO;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.quartz.service.IMesToPesWieWorkProcessingQuantityListService;

import java.util.*;


@Component("mesToPesWieWorkProcessingQuantityListJob")
public class MesToPesWieWorkProcessingQuantityListJob{

    @Autowired
    private IMesToPesWieWorkProcessingQuantityListService mesToPesWieWorkProcessingQuantityListService;

    @Autowired

    private SysJobLogMapper sysJobLogMapper;


    public void report() {

        SysJobLog log = new SysJobLog();
        log.setJobName("MesToPesWieWorkProcessingQuantityListJob");
        log.setStopTime(new Date());
        //系统时间转换成格林威治时间
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(log.getStopTime() .getTime());
        cal.add(Calendar.HOUR, -8);

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
            log.setFromDateToErp(lastSucLog.getFromDateToErp());
        }

        sysJobLogMapper.updateLatUpdateDate(log);

        if(true){
                List<MesToPesWieWorkProcessingQuantityListEO> lists = mesToPesWieWorkProcessingQuantityListService.selectMesWieWorkProcessingQuantityListList();
                if(lists.size() > 0){
                mesToPesWieWorkProcessingQuantityListService.insertMesWieWorkProcessingQuantityList(lists);
                }
        }

    }
}
