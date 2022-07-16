package spb.crm.controller;

import spb.crm.task.AsynTask;
import spb.crm.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private AsynTask asynTask;

    @RequestMapping("testOne")
    public JsonData test() throws InterruptedException {
        long begin = System.currentTimeMillis();
        asynTask.task1();
        asynTask.task2();
        asynTask.task3();
        long end = System.currentTimeMillis();
        Map map = new HashMap();
        return new JsonData(map,true,String.valueOf(end - begin));
    }

    @RequestMapping("testTwo")
    public JsonData test2() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Future<String> task4 = asynTask.task4();
        Future<String> task5 = asynTask.task5();
        while (true){
            if(task4.isDone() && task5.isDone()){
                System.out.println("任务4和任务5执行完成==============");
                break;
            }
        }
        System.out.println("===========先打印还是先执行完任务4和任务5=========");
        long end = System.currentTimeMillis();
        Map map = new HashMap();
        return new JsonData(map,true,String.valueOf(end - begin));
    }
}
