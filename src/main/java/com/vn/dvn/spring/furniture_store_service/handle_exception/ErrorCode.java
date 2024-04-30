package com.vn.dvn.spring.furniture_store_service.handle_exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(999, "Uncategorized exception !"),
    USER_EXISTED(1001, "User existed !"),
    USER_NOTFOUND(1002,"User not found !"),
    INVALID_PASSWORD(1003,"Password must be at least 8 character !"),
    INVALID_EMAIL(1004,"Invalid email !"),
    INVALID_MESSAGE_KEY(1005,"Invalid message key in validation !"),
    UNAUTHENTICATED(1006,"Unauthenticated !")
    ;
    private int code = 1000;
    private String message = null;
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
