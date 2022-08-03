package sinexcel.jobTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.mapper.SysJobLogMapper;
import sinexcel.works.service.IPesWieWoOperationMaterialsErpService;
import sinexcel.works.service.IPesWieWorkOrderOperationErpService;
import sinexcel.works.service.IPesWieWorkOrderOperationResourceErpService;
import sinexcel.works.service.IPesWieWorkOrdersBErpService;

import java.util.Date;

@Component("pesWieWorkSubmitErpJob")
public class PesWieWorkSubmitErpJob {

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Autowired
    private IPesWieWorkOrdersBErpService pesWieWorkOrdersBErpService;

    @Autowired
    private IPesWieWoOperationMaterialsErpService pesWieWoOperationMaterialsErpService;

    @Autowired
    private IPesWieWorkOrderOperationErpService pesWieWorkOrderOperationErpService;

    @Autowired
    private IPesWieWorkOrderOperationResourceErpService pesWieWorkOrderOperationResourceErpService;

    public void report() throws Exception {

        SysJobLog log = new SysJobLog();
        log.setJobName("PesWieWorkSubmitErpJob");
        log.setStopTime(new Date());

        SysJobLog lastSucLog = sysJobLogMapper.getTaskNameLastDate(log.getJobName());
        if(lastSucLog!=null){
            log.setStartTime(lastSucLog.getToDate());
        }
        sysJobLogMapper.updateLatUpdateDate(log);
        if(true){//获取PES工单头信息，创建
            pesWieWorkOrdersBErpService.handleSubmitErpPesWieWorkOrdersBErpByIdsJob("intgAdmin");
        }
        if(true){//工序创建
            pesWieWorkOrderOperationErpService.handleSubmitErpPesWieWorkOrdersBErpByIdsJob("intgAdmin");
        }
        if(true){//资源，创建
            pesWieWorkOrderOperationResourceErpService.handleSubmitErpPesWieWorkOrdersBErpByIdsJob("intgAdmin");
        }
        if(true){//获取PES单身信息，创建
            pesWieWoOperationMaterialsErpService.handleSubmitErpPesWieWorkOrdersBErpByIdsJob("intgAdmin");
        }
        if(true){//获取PES工序信息，变更
            pesWieWorkOrderOperationErpService.updateSubmitErpPesWieWorkOrdersOperationBErpByIdsJob("intgAdmin");
        }
        if(true){//资源，变更
            pesWieWorkOrderOperationResourceErpService.updateSubmitErpPesWieWorkOrdersBErpByIdsJob("intgAdmin");
        }
        if(true){//获取PES单身信息，变更
            pesWieWoOperationMaterialsErpService.updateSubmitErpPesWieWorkOrdersBErpByIdsJob("intgAdmin");
        }
        if(true){//获取PES工单头信息，变更
            pesWieWorkOrdersBErpService.updateSubmitErpPesWieWorkOrdersBErpByIdsJob("intgAdmin");
        }
    }
}
