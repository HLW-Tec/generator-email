package cc.huluwa;


import com.liumapp.DNSQueen.queen.Queen;
import com.liumapp.pattern.sendemail.SendEmailPattern;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.*;
@RunWith(SpringRunner.class)
public class EmailTest {

    @Test
    public void testEmail(){
        Queen queen=new Queen();
        queen.setPort(0000);
        try {
            queen.connect();
            SendEmailPattern sendEmailPattern=new SendEmailPattern();
            List<String>list=new ArrayList<String>();
            list.add("hxyHelloWorld@163.com");
            list.add("haoxiaoyong@huluwa.cc");
            String content="你好,这是邮件内容4";
            String subject="测试通知";
            sendEmailPattern.sendEmailPattern(1,list, content,subject);
            if(sendEmailPattern.chk()){
                String encoding = sendEmailPattern.getEncoding();
                queen.say(encoding);
                System.out.println(queen.hear());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
