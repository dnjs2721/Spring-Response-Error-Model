package goorm.request.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ErrorCode {
    OK(2000, HttpStatus.OK, "OK"),
    SERVER_ERROR(4000, HttpStatus.BAD_REQUEST, "BAD_REQUEST");

    @Getter
    private final int code;
    @Getter
    private final HttpStatus httpStatus;
    @Getter
    private final String message;

    ErrorCode(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
