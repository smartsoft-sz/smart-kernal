package com.smart.core;

/**
 * 服务（业务）异常如“ 账号或密码错误 ”，该异常只做INFO级别的日志记录 @see WebMvcConfigurer
 */
public class ServiceException extends RuntimeException {
    private ResultCode resultCode;

    public ServiceException() {
    }
    public ServiceException(Integer errorCode) {
        super(errorCode+"");
    }

    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
