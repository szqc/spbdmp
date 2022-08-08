package spb.crm.handler;

import spb.crm.exception.BasicException;
import spb.crm.util.JsonData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理方法，如果请求的异常能精准匹配到其他方法的异常入参，则直接调用其他方法，
 * 如NullPointerException、BasicException，会调用到定义了该异常为入参的方法，如果
 * 没有匹配的参数，则调用入参为Exception的处理方法
 */
@RestControllerAdvice
public class CustomerHandler {

    @ExceptionHandler
    public JsonData handlerException(Exception e){
        if(e instanceof  BasicException){
            BasicException be = (BasicException)e;
            return  new JsonData(null,be.getRetCode(),false,"统一异常处理" + be.getRetMsg());
        }else {
            return  new JsonData(null,"221100",false,"未知异常，提示系统升级中……");
        }

    }
    @ExceptionHandler
    public JsonData handlerException2(NullPointerException e){
        return  new JsonData(null,"123456",false,"空指针异常，系统升级中2，请稍后");
    }
}
