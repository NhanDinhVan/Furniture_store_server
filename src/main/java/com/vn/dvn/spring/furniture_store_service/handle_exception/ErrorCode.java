package com.vn.dvn.spring.furniture_store_service.handle_exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(999, "Uncategorized exception !", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_EXISTED(1001, "User existed !",HttpStatus.BAD_REQUEST),
    USER_NOTFOUND(1002,"User not exist !",HttpStatus.NOT_FOUND),
    INVALID_PASSWORD(1003,"Password must be at least 8 character !",HttpStatus.BAD_REQUEST),
    INVALID_EMAIL(1004,"Invalid email !",HttpStatus.BAD_REQUEST),
    INVALID_MESSAGE_KEY(1005,"Invalid message key in validation !",HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1006,"Unauthenticated !",HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007,"You do not have permission !", HttpStatus.FORBIDDEN),
    PRODUCT_NOTEXIST(1008,"Product not exist !",HttpStatus.NOT_FOUND),
    DUPLICATESD_VALUES(1008,"Value in list is duplicated !",HttpStatus.BAD_REQUEST)

    ;
    private int code = 1000;
    private String message = null;
    private HttpStatusCode statusCode;
    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
