package spb.crm.controller;

import spb.crm.exception.BasicException;
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



    @RequestMapping("noBody")
    public JsonData noBody() {
        int i = 1/0;
        return new JsonData(null,"000000",true,null);
    }

    @RequestMapping("zdyException")
    public JsonData zdyException() {
        throw new BasicException("123456","自定义异常提示……");
    }

    @RequestMapping("nullException")
    public JsonData nullException() throws BasicException {
        Integer i = null;
        int j = i/1;
        return new JsonData(null,"000000",true,null);
    }

    @RequestMapping("testOne")
    public JsonData test() throws InterruptedException {
        long begin = System.currentTimeMillis();
        asynTask.task1();
        asynTask.task2();
        asynTask.task3();
        long end = System.currentTimeMillis();
        Map map = new HashMap();
        return new JsonData(map,"000000",true,String.valueOf(end - begin));
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
        return new JsonData(map,"000000",true,String.valueOf(end - begin));
    }


}
