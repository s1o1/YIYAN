package com.gzj.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class ExcepionHandler {
    @ExceptionHandler(Exception.class)
    public String doException(Exception ex){
        log.error("异常处理: {}",ex.toString());
        return "error";
    }
}
