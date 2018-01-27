package cc.huluwa.worker.config;

import org.springframework.stereotype.Component;

@Component
public class Params {
    private Integer port = 0000;

    private Integer startDelay = 3000;

    private String encoding = "utf-8";

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getStartDelay() {
        return startDelay;
    }

    public void setStartDelay(Integer startDelay) {
        this.startDelay = startDelay;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
