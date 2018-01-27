package cc.huluwa.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cc.huluwa"})
public class App {
    public static void main(String[] args) {

        SpringApplication.run(App.class,args);

    }
}
