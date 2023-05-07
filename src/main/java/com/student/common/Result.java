package com.student.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private static final Integer SUCCEE_CODE = 1;
    private static final Integer EROOR_CODE = 0;

    private String msg;
    private Integer code;
    private Object data;

    public static Result succee(Object obj){
        Result r = new Result();
        r.code = SUCCEE_CODE;
        r.data =obj;
        return r;
    }

    public static Result error(String msg){
        Result r = new Result();
        r.code = EROOR_CODE;
        r.msg = msg;
        return r;
    }

    public Result cost(String msg,Integer code,Object obj ){
        Result r = new Result();
        r.code = code;
        r.msg = msg;
        r.data = obj;
        return  r;

    }
}
