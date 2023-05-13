package com.student.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    public static final int SUCCESS_CODE = 1;
    public static final int ERROR_CODE = 0;

    private String msg;
    private Integer code;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<T>(SUCCESS_CODE, null, data);
    }

    public static <T> Result<T> error(String msg) {
        return new Result<T>(ERROR_CODE, msg, null);
    }

    public static <T> Result<T> custom(String msg, int code, T data) {
        return new Result<T>(code, msg, data);
    }

    private Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // getter and setter methods
}
