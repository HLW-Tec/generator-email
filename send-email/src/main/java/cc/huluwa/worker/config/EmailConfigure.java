package cc.huluwa.worker.config;

import org.springframework.stereotype.Component;

@Component
public class EmailConfigure {

    private String ALIDM_SMTP_HOST="XXXXX";

    private int ALIDM_SMTP_PORT=80;

    private String USER_NAME="xxxxxxx";

    private String PASS_WORD="xxxxxxx";

    private String MAIL_USER = "mail.user";

    private String MAIL_PASS_WORD = "mail.password";

    public String getALIDM_SMTP_HOST() {
        return ALIDM_SMTP_HOST;
    }

    public void setALIDM_SMTP_HOST(String ALIDM_SMTP_HOST) {
        this.ALIDM_SMTP_HOST = ALIDM_SMTP_HOST;
    }

    public int getALIDM_SMTP_PORT() {
        return ALIDM_SMTP_PORT;
    }

    public void setALIDM_SMTP_PORT(int ALIDM_SMTP_PORT) {
        this.ALIDM_SMTP_PORT = ALIDM_SMTP_PORT;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getPASS_WORD() {
        return PASS_WORD;
    }

    public void setPASS_WORD(String PASS_WORD) {
        this.PASS_WORD = PASS_WORD;
    }

    public String getMAIL_USER() {
        return MAIL_USER;
    }

    public void setMAIL_USER(String MAIL_USER) {
        this.MAIL_USER = MAIL_USER;
    }

    public String getMAIL_PASS_WORD() {
        return MAIL_PASS_WORD;
    }

    public void setMAIL_PASS_WORD(String MAIL_PASS_WORD) {
        this.MAIL_PASS_WORD = MAIL_PASS_WORD;
    }
}
