package cc.huluwa.worker.model;

import com.liumapp.pattern.sendemail.SendEmailPattern;

import java.io.Serializable;

/**
 * Email 封装类
 */
public class Email  extends SendEmailPattern implements Serializable {

    private String template;//模板

    public Email() {
        super();
    }


    public String getTemplate() {
        return template;
    }
    public void setTemplate(String template) {
        this.template = template;
    }
}
