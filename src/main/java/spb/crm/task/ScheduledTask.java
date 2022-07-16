package spb.crm.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ScheduledTask {

    @Scheduled(fixedRate = 200000)
    public void taskOne(){
        String token = UUID.randomUUID().toString();
        System.out.println("===============执行定时任务==============="+token);
    }
}
