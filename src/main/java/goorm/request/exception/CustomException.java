package goorm.request.exception;


import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
    private String message;

    @Override
    public String getMessage() {
        if (StringUtils.hasLength(this.message)) {
            return this.message;
        }
        return errorCode.getMessage();
    }

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public CustomException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public CustomException(ErrorCode errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;
        if (data != null) {
            ExceptionContext.threadLocal.get().put(data.getClass().getSimpleName(), data);
        }
    }
}
