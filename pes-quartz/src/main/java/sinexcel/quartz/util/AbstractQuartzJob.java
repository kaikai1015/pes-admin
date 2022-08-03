package sinexcel.quartz.util;

import java.util.*;

import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sinexcel.common.constant.Constants;
import sinexcel.common.constant.ScheduleConstants;
import sinexcel.common.email.EmailService;
import sinexcel.common.email.EmailVo;
import sinexcel.common.utils.ExceptionUtil;
import sinexcel.common.utils.StringUtils;
import sinexcel.common.utils.bean.BeanUtils;
import sinexcel.common.utils.spring.SpringUtils;
import sinexcel.quartz.domain.SysJob;
import sinexcel.quartz.domain.SysJobLog;
import sinexcel.quartz.service.ISysJobLogService;

/**
 * 抽象quartz调用
 *
 * @author pes
 */
public abstract class AbstractQuartzJob implements Job
{
//    private static final Logger log = LoggerFactory.getLogger(AbstractQuartzJob.class);

    /**
     * 线程本地变量
     */
//    private static ThreadLocal<Date> threadLocal = new ThreadLocal<>();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException
    {
        SysJob sysJob = new SysJob();
        BeanUtils.copyBeanProp(sysJob, context.getMergedJobDataMap().get(ScheduleConstants.TASK_PROPERTIES));
        try
        {
            before(context, sysJob);
            if (sysJob != null)
            {
                doExecute(context, sysJob);
            }
            after(context, sysJob, null);
        }
        catch (Exception e)
        {
//            log.error("任务执行异常  - ：", e);
            after(context, sysJob, e);
        }
    }

    /**
     * 执行前
     *
     * @param context 工作执行上下文对象
     * @param sysJob 系统计划任务
     */
    protected void before(JobExecutionContext context, SysJob sysJob)
    {
//        threadLocal.set(new Date());

        final SysJobLog sysJobLog = new SysJobLog();
        sysJobLog.setJobName(sysJob.getJobName());
        sysJobLog.setJobGroup(sysJob.getJobGroup());
        sysJobLog.setInvokeTarget(sysJob.getInvokeTarget());
        sysJobLog.setStartTime(new Date());
        sysJobLog.setStatus(Constants.YUN);

        // 写入数据库当中
        SpringUtils.getBean(ISysJobLogService.class).addJobLog(sysJobLog);
    }

    /**
     * 执行后
     *
     * @param context 工作执行上下文对象
     * @param sysJob 系统计划任务
     */
    protected void after(JobExecutionContext context, SysJob sysJob, Exception e)
    {
        final SysJobLog sysLastJobLog = new SysJobLog();
        sysLastJobLog.setJobName(sysJob.getJobName());
        sysLastJobLog.setStopTime(new Date());
        if (e != null)
        {
            sysLastJobLog.setStatus(Constants.FAIL);
            String errorMsg = StringUtils.substring(ExceptionUtil.getExceptionMessage(e), 0, 7000);
            sysLastJobLog.setExceptionInfo(errorMsg.toString());
            if(sysJob.getEmail()!= null){
                EmailService emailService = SpringUtils.getBean(EmailService.class);
                EmailVo emailVo = taskAlarm(sysJob, errorMsg.toString());
                emailService.send(emailVo);
            }
        }
        else
        {
            sysLastJobLog.setStatus(Constants.SUCCESS);
        }

        // 写入数据库当中
        SpringUtils.getBean(ISysJobLogService.class).updateLatJobStatus(sysLastJobLog);
    }

    /**
     * 执行方法，由子类重载
     *
     * @param context 工作执行上下文对象
     * @param sysJob 系统计划任务
     * @throws Exception 执行过程中的异常
     */
    protected abstract void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception;

    private EmailVo taskAlarm(SysJob sysJob, String msg) {
        String jobInfor = "任务信息：";
        String jobName = "任务名称";
        String jobMethod = "执行方法";
        String jobExpress = "Cron表达式";
        String jobDes = "任务描述";
        String jobException = "异常信息：";
        String jobCopy = "Copyright © 2007 - 2021 深圳市盛弘电气股份有限公司.";

        EmailVo emailVo = new EmailVo();
        emailVo.setSubject("【"+ sysJob.getJobDesc() +"】执行失败，请尽快处理！");
        Map<String, Object> data = new HashMap<>(16);
        data.put("task", sysJob);
        data.put("msg", msg);

        //模板中文乱码，暂时用这样笨办法处理
        data.put("jobInfor", jobInfor);
        data.put("jobName", jobName);
        data.put("jobMethod", jobMethod);
        data.put("jobExpress", jobExpress);
        data.put("jobDes", jobDes);
        data.put("jobException", jobException);
        data.put("jobCopy", jobCopy);

        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("template", TemplateConfig.ResourceMode.CLASSPATH));
        Template template = engine.getTemplate("template/taskAlarm.ftl");
        emailVo.setContent(template.render(data));
        List<String> emails = Arrays.asList(sysJob.getEmail().split("\\[,，]"));
        emailVo.setTos(emails);
        return emailVo;
    }
}
