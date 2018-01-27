package cc.huluwa.worker.utils;

import cc.huluwa.worker.config.EmailConfigure;
import cc.huluwa.worker.model.Email;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class EmailUtils {

    private static final String ALIDM_SMTP_HOST = "xxxxx";
    private static final int ALIDM_SMTP_PORT = 25;

    public static MimeMessage getEmail(Email mail) {
        EmailConfigure emailConfigure =new EmailConfigure();
        final Properties props = new Properties();                                          // 配置发送邮件的环境属性
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", ALIDM_SMTP_HOST);
        props.put("mail.smtp.port", ALIDM_SMTP_PORT);
        props.put("mail.user", emailConfigure.getUSER_NAME());            //发起人账号
        props.put("mail.password", emailConfigure.getPASS_WORD());       // 访问SMTP服务时需要提供的密码
        Authenticator authenticator = new Authenticator() {                                 // 构建授权信息，用于进行SMTP进行身份验证
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        Session mailSession = Session.getInstance(props, authenticator);                    // 使用环境属性和授权信息，创建邮件会话
        MimeMessage message = new MimeMessage(mailSession);                                 // 创建邮件消息
        InternetAddress from = null;                                                        // 设置发件人
        try {
            from = new InternetAddress(emailConfigure.getUSER_NAME());
            message.setFrom(from);
            List<String> list = mail.getEmails();                                           // 设置收件人
            Address[] a = new Address[list.size()];
            for (int i = 0; i < list.size(); i++) {
                String replace = list.get(i).replace("[", "").replace("]", "");
                a[i] = new InternetAddress(replace);
            }
            //message.setRecipient(MimeMessage.RecipientType.TO, a[0],to);  //单独发送
            message.addRecipients(MimeMessage.RecipientType.TO, a);//群发
            message.setSubject(mail.getSubject());
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return message;
    }
}