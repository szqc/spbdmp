package spb.crm.exception;

/**
 * 自定义异常
 */
public class BasicException extends RuntimeException{
    public String retCode;
    public String retMsg;

    public BasicException(String retCode,String retMsg){
        this.retCode = retCode;
        this.retMsg = retMsg;
    }
    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}
