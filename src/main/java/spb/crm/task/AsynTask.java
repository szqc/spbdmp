package spb.crm.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Async
public class AsynTask {

    public void task1() throws InterruptedException {
        Thread.sleep(1000);
    }

    public void task2() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void task3() throws InterruptedException {
        Thread.sleep(3000);
    }

    public Future<String> task4() throws InterruptedException {
        Thread.sleep(3000);
        return new AsyncResult<>("定时任务4执完成");

    }

    public Future<String> task5() throws InterruptedException {
        Thread.sleep(3000);
        return new AsyncResult<>("定时任务5执完成");
    }
}
