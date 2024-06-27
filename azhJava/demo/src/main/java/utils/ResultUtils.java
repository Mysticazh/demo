package utils;

public class ResultUtils {
    // 成功
    public static <T> Result<T> success(T data){
        return new Result<>(200, data,"success");
    }

    // 失败
    public static <T> Result<T> failed(Integer code, String message, String description){
        return new Result<>(code,null,message,description);
    }
}

