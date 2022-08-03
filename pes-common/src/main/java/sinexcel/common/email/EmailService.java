package sinexcel.common.email;

public interface EmailService {
    /**
     * 发送邮件
     * @param emailVo 邮件发送的内容
     * @throws Exception /
     */
    void send(EmailVo emailVo);
}
