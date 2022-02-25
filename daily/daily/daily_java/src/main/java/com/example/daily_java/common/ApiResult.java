package com.example.daily_java;
/*
 前后端数据交互错误控制msg类

 */


public class ApiResult<T> {
    private static final String SUCCESS_CODE = "200";
    private static final String FAIL_CODE = "500";

    private Boolean success;
    private String code;
    private String message;
    private T data;

    public ApiResult() {}

    public ApiResult(Boolean success, String code) {
        this.success = success;
        this.code = code;
    }

    public ApiResult(Boolean success, String code, String message) {
        this(success, code);
        this.message = message;
    }

    public ApiResult(Boolean success, String code, String message, T data) {
        this(success, code, message);
        this.data = data;
    }

    public static ApiResult<String> fail() {
        return new ApiResult<>(false, FAIL_CODE, "fail");
    }

    public static ApiResult<String> fail(String message) {
        return new ApiResult<>(false, FAIL_CODE, message);
    }

    public static ApiResult<String> fail(String code, String message) {
        return new ApiResult<>(false, code, message);
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<T>(true, SUCCESS_CODE, "success", data);
    }

    public static ApiResult<String> success() {
        return new ApiResult<>(true, SUCCESS_CODE, "success");
    }
}


