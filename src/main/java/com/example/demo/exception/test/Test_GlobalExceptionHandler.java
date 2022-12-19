package com.example.demo.exception.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Test_GlobalExceptionHandler extends RuntimeException{

    @ExceptionHandler(java.lang.NullPointerException.class)
    public String handleException(){
        return "test/test_exception/exception_error2";
    }
}
