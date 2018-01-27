package cc.huluwa.worker.service.impl;

import cc.huluwa.worker.model.Email;
import cc.huluwa.worker.service.IMailService;
import cc.huluwa.worker.utils.Constants;
import cc.huluwa.worker.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.ResourceUtils;

import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
@Service
public class IMailServiceImpl implements IMailService{
    @Autowired
    public Configuration configuration;         //freemarker
    @Autowired
    private SpringTemplateEngine templateEngine;//thymeleaf

    public void send(Email mail) throws Exception {
        MimeMessage message = EmailUtils.getEmail(mail);
        message.setContent(mail.getContent(), "text/html;charset=UTF-8");
        Transport.send(message);
    }

    public void sendAffix(Email mail) throws Exception {
        MimeMessage message = EmailUtils.getEmail(mail);
        MimeMessageHelper helper = new MimeMessageHelper(message, true,"utf-8");
        helper.setText(
                mail.getContent().toString(),
                true);
        File file = ResourceUtils.getFile("classpath:static"
                + Constants.SF_FILE_SEPARATOR + "file"
                + Constants.SF_FILE_SEPARATOR + "放心签文档.zip");
        helper.addAttachment("放心签", file);
        Transport.send(helper.getMimeMessage());

    }

    public void sendFreemarker(Email mail) throws Exception {
        MimeMessage message = EmailUtils.getEmail(mail);
        MimeMessageHelper helper = new MimeMessageHelper(message, true,"utf-8");
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("content", mail.getContent());
        Template template = configuration.getTemplate(mail.getTemplate()+".flt");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(
                template, model);
        helper.setText(text, true);
        Transport.send(helper.getMimeMessage());
    }

    public void sendThymeleaf(Email mail) throws Exception {
        MimeMessage message = EmailUtils.getEmail(mail);
        MimeMessageHelper helper = new MimeMessageHelper(message, true,"utf-8");
        Context context = new Context();
        context.setVariable("email", mail);
        String text = templateEngine.process(mail.getTemplate(), context);
        helper.setText(text, true);
    }

    public void sengImg(Email mail) throws Exception {
        MimeMessage message = EmailUtils.getEmail(mail);
        MimeMessageHelper helper = new MimeMessageHelper(message, true,"utf-8");
        helper.setText(
                "<html><body>美女</br><img src=\"cid:meinv\" ></body></html>",
                true);

       File file = ResourceUtils.getFile("classpath:static"
                + Constants.SF_FILE_SEPARATOR + "image"
                + Constants.SF_FILE_SEPARATOR + "meinv.jpg");
        helper.addInline("meinv", file);
        Transport.send(helper.getMimeMessage());
    }
}
