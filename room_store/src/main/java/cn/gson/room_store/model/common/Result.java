package cn.gson.room_store.model.common;

public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }
    public Result(T data){this.data=data;}
    public static cn.gson.room_store.model.common.Result success(){
        cn.gson.room_store.model.common.Result result =new cn.gson.room_store.model.common.Result<>();
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }
    public static<T> cn.gson.room_store.model.common.Result<T> success(T data){
        cn.gson.room_store.model.common.Result<T> result =new cn.gson.room_store.model.common.Result<>(data);
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }
    public static cn.gson.room_store.model.common.Result error(String code, String msg){
        cn.gson.room_store.model.common.Result result = new cn.gson.room_store.model.common.Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
