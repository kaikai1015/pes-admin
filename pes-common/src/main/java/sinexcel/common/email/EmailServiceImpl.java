package sinexcel.common.email;

import cn.hutool.extra.mail.Mail;
import org.springframework.stereotype.Service;
import cn.hutool.extra.mail.MailAccount;
import sinexcel.common.exception.BaseException;

@Service
public class EmailServiceImpl implements EmailService  {

    @Override
    public void send(EmailVo emailVo) {
        // 封装
        MailAccount account = new MailAccount();
        account.setUser("pes_erp@sinexcel.cn");
        account.setHost("smtp.exmail.qq.com");
        account.setPort(465);
        account.setAuth(true);
        account.setPass("rffv3kfjXDCecVtv");
        account.setFrom("pes_erp"+"<"+"pes_erp@sinexcel.cn"+">");
        // ssl方式发送
        account.setSslEnable(true);
        // 使用STARTTLS安全连接
        account.setStarttlsEnable(true);
        String content = emailVo.getContent();

        // 发送
        try {
            int size = emailVo.getTos().size();
            Mail.create(account)
                    .setTos(emailVo.getTos().toArray(new String[size]))
                    .setTitle(emailVo.getSubject())
                    .setContent(content)
                    .setHtml(true)
                    //关闭session
                    .setUseGlobalSession(false)
                    .send();
        }catch (Exception e){
            throw new BaseException(e.getMessage());
        }
    }
}
