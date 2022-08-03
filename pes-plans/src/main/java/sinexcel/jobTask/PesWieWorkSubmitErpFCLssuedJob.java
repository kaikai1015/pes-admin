package sinexcel.jobTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.works.service.IPesWieWoOperationMaterialsErpService;

import java.util.Date;

@Component("pesWieWorkSubmitErpFCLssuedJob")
public class PesWieWorkSubmitErpFCLssuedJob {

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private IPesWieWoOperationMaterialsErpService pesWieWoOperationMaterialsErpService;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("PesWieWorkSubmitErpFCLssuedJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
        }
        sysJobLogMapper.updateLatUpdateDate(log);
        if(true){//获取PES单身信息，创建
            pesWieWoOperationMaterialsErpService.handleSubmitErpPesWieWorkOrdersBErpByIdsFCLJob("MATERIAL_ISSUE");
        }

        if(true){//获取PES单身信息，创建
            pesWieWoOperationMaterialsErpService.handleSubmitErpPesWieWorkOrdersBErpByIdsIssuedJob("MATERIAL_ISSUE");
        }
        if(true){//获取PES单身信息，DLC
            pesWieWoOperationMaterialsErpService.handleSubmitErpPesWieWorkOrdersBErpByIdsDLCJob("MATERIAL_ISSUE");
        }
    }
}
