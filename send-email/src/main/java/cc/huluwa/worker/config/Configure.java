package cc.huluwa.worker.config;

import com.liumapp.DNSQueen.worker.process.WokerEar;
import com.liumapp.DNSQueen.worker.tcp.TCPSocketMonitor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configure {

    @Bean
    @ConfigurationProperties(prefix = "hxy.email.generator")
    public Params params () {
        return new Params();
    }
    @Bean
    public TCPSocketMonitor tcpSocketMonitor (Params params) {
        Integer port = params.getPort();
        TCPSocketMonitor tcpSocketMonitor = new TCPSocketMonitor(port);
        return tcpSocketMonitor;
    }

    @Bean
    public WokerEar wokerEar (Params params) {
        Integer startDelay = params.getStartDelay();
        WokerEar wokerEar = new WokerEar();
        wokerEar.setStartDelay(startDelay);
        return wokerEar;
    }
}
