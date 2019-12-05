package com.wanxp.blog.exception;

public class ApplicationException extends AbstractException {
    public ApplicationException(int code) {
        super(code, null, null);
    }

    public ApplicationException(int code, Object[] parameters) {
        super(code, parameters, null);
    }

    public ApplicationException(int code, Object[] parameters, Object data) {
        super(code, parameters, data);
    }

    public ApplicationException(String message, int code, Object[] parameters, Object data) {
        super(message, code, parameters, data);
    }

    public ApplicationException(String message, Throwable cause, int code, Object[] parameters, Object data) {
        super(message, cause, code, parameters, data);
    }

    public ApplicationException(Throwable cause, int code, Object[] parameters, Object data) {
        super(cause, code, parameters, data);
    }

    public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, Object[] parameters, Object data) {
        super(message, cause, enableSuppression, writableStackTrace, code, parameters, data);
    }
}
