package com.example.springsecurity686.handle;

import com.example.springsecurity686.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        // 构造错误响应体
        ErrorResponse errorResponse = new ErrorResponse("Internal Server Error", ex.getMessage());
        // 返回HTTP状态码和错误响应体
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // 定义其他异常处理方法，如处理特定异常类型的方法
}