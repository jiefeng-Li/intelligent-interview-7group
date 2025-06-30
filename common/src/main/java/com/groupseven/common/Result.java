package com.groupseven.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;



    public static <T>Result<T> success(){
        return new Result(200, "success", null);
    }

    public static <T>Result<T> success(String msg) {
        return new Result(200, msg, null);
    }

    public static <T>Result<T> success(T data){
        return new Result<>(200, "success", data);
    }

    public static <T>Result<T> success(String msg, T data){
        return new Result<>(200, msg, data);
    }

    public static Result error(Integer code,String msg){
        Result result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(String msg){
        return new Result(500, msg, null);
    }
}
