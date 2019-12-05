package com.wanxp.blog.exception;

import lombok.Getter;

@Getter
public abstract class AbstractException extends RuntimeException {
    private int code;
    private Object[] parameters;
    private Object data;

    public AbstractException(int code, Object[] parameters, Object data) {
        this.code = code;
        this.parameters = parameters;
        this.data = data;
    }

    public AbstractException(String message, int code, Object[] parameters, Object data) {
        super(message);
        this.code = code;
        this.parameters = parameters;
        this.data = data;
    }

    public AbstractException(String message, Throwable cause, int code, Object[] parameters, Object data) {
        super(message, cause);
        this.code = code;
        this.parameters = parameters;
        this.data = data;
    }

    public AbstractException(Throwable cause, int code, Object[] parameters, Object data) {
        super(cause);
        this.code = code;
        this.parameters = parameters;
        this.data = data;
    }

    public AbstractException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, Object[] parameters, Object data) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.parameters = parameters;
        this.data = data;
    }
}
