package com.idanchuang.shop.user.exception;

import java.security.PrivilegedActionException;

public class ResultException extends Exception {
    public ResultException() {
        super();
    }

    public ResultException(String message) {
        super(message);
    }

    public ResultException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResultException(Throwable cause) {
        super(cause);
    }

    public ResultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
