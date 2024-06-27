package utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    // 1.状态码
    private Integer code;
    // 2.内容
    private T data;
    // 3.消息
    private String message;
    // 4.描述
    private String description;
    // 5.有参构造方法
    public Result(Integer code, T data, String message, String description){
        this.code =  code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    // 6.构造方法
    public Result(Integer code, T data){
        this(code,data,"","");
    }

    public Result(Integer code, T data, String message){
        this(code,data,message,"");
    }
}
