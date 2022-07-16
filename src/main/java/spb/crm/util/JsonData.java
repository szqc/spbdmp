package spb.crm.util;

public class JsonData {

    private Object data;
    private boolean status;
    private String msg;

    public JsonData() {
    }

    public JsonData(Object data, boolean status, String msg) {
        this.data = data;
        this.status = status;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
