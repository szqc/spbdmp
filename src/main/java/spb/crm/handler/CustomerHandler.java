package spb.crm.handler;

import spb.crm.util.JsonData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerHandler {

    @ExceptionHandler
    public JsonData handlerException(NullPointerException e){
        return  new JsonData(null,false,"系统升级中，请稍后");
    }

//    @ExceptionHandler
//    public JsonData handlerException2(Exception e){
//        return  new JsonData(null,false,"系统升级中2，请稍后");
//    }
}
