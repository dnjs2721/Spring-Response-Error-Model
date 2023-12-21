package goorm.request.controller;

import goorm.request.ApiResponse;
import goorm.request.exception.CustomException;
import goorm.request.exception.ExceptionContext;
import goorm.request.exception.InputRestriction;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

abstract public class BaseController {
    public <T> ApiResponse<T> makeResponse(T result) {
        return new ApiResponse<>(new ArrayList<>(List.of(result)));
    }

    public <T> ApiResponse<T> makeResponse(List<T> result) {
        return new ApiResponse<>(result);
    }

    @ResponseBody
    @ExceptionHandler(CustomException.class)
    public <T> ApiResponse<T> customExceptionHandler(HttpServletResponse response, CustomException customException) {
        response.setStatus(customException.getErrorCode().getHttpStatus().value());

        int code = customException.getErrorCode().getCode();
        String message = customException.getMessage();
        Map<String, Object> data = ExceptionContext.threadLocal.get();

        return new ApiResponse<>(code, message, data);
    }
}
