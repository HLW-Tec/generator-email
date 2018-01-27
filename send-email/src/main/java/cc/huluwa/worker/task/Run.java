package cc.huluwa.worker.task;

import cc.huluwa.worker.model.Email;
import cc.huluwa.worker.service.IMailService;
import com.liumapp.pattern.sendemail.SendEmailPattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Run {
    @Autowired
    private IMailService mailService;

    /**
     * 解决 mailService 注入不进来的问题
     * @param mailService
     */
    private static Run run;

    public void setMailService(IMailService mailService) {
        this.mailService = mailService;
    }

    @PostConstruct
    public void init() {
        run = this;
        run.mailService = this.mailService;
    }

    public void start(SendEmailPattern sendEmailPattern) throws Exception {

        Email mail = new Email();
        mail.setEmails(sendEmailPattern.getEmails());  //邮箱
        mail.setCode(sendEmailPattern.getCode());      //标记
        mail.setContent(sendEmailPattern.getContent());//内容
        mail.setSubject(sendEmailPattern.getSubject());//标题
        Integer code = mail.getCode();
        mail.setTemplate("welcome");                   //模板
        switch (code) {
            case 1:
                //调用发送freemarker模板
                run.mailService.sendFreemarker(mail);
                return;
            case 2:
                //调用Thymeleaf模板
                run.mailService.sendThymeleaf(mail);
                return;
            case 3:
                //调用纯文本文件
                run.mailService.send(mail);
                return;
            case 4:
                //调用发送附件
                run.mailService.sendAffix(mail);
                return;
            case 5:
                //调用发送图片模板
                run.mailService.sengImg(mail);
                break;
            default:
                return;
        }
    }

}
