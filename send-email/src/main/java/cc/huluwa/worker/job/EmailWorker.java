package cc.huluwa.worker.job;

import cc.huluwa.worker.task.Run;
import com.liumapp.DNSQueen.worker.ready.StandReadyWorker;
import com.liumapp.pattern.exception.PatternPropertiesNumberNotEnough;
import com.liumapp.pattern.exception.WrongType;
import com.liumapp.pattern.sendemail.SendEmailPattern;
import org.springframework.stereotype.Component;

@Component
public class EmailWorker extends StandReadyWorker {

    public String doWhatYouShouldDo(String line) {
        Run run=new Run();
        try {
            SendEmailPattern sendEmailPattern = SendEmailPattern.parse(line);
            if (sendEmailPattern.getCode() != null
                    && sendEmailPattern.getEmails() != null
                    && sendEmailPattern.getContent() != null
                    && sendEmailPattern.getSubject() != null) {
               run.start(sendEmailPattern);
            }
        } catch (PatternPropertiesNumberNotEnough patternPropertiesNumberNotEnough) {
            patternPropertiesNumberNotEnough.printStackTrace();
        } catch (WrongType wrongType) {
            wrongType.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
