package com.example.demo.common.exception;

import com.example.demo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    Result handler(IllegalArgumentException e){
        log.error("参数异常", e);
        return Result.fail(e.getMessage());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    Result handler(RuntimeException e){
        log.error("运行时异常{}", e);
        return Result.fail(e.getMessage());
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    Result handler(Exception e){
        log.error("系统异常", e);
        return Result.fail(e.getMessage());
    }

    /**
     * 实体效验异常捕获
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    Result handler(MethodArgumentNotValidException e){
        BindingResult result=e.getBindingResult();
        ObjectError objectError=result.getAllErrors().stream().findFirst().get();
        log.error("实体效验异常", e);
        return Result.fail(objectError.getDefaultMessage());
    }

    /**
     * 参数效验异常捕获
     */
    @ExceptionHandler(BindException.class)
    public Result bindExceptionHandler(BindException e) {
        log.error("参数效验异常！{}", e);
        return Result.fail(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
