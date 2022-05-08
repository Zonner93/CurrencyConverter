package com.zonner93.Exception.LogException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LogExceptionHandler {

    @ExceptionHandler(value = LogException.class)
    public ResponseEntity<LogErrorInfo> handlerLogException(LogException e) {
        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;
        if (LogError.QUANTITY_LESS_OR_EQUALS_ZERO.equals(e.getLogError())) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(httpStatus).body(new LogErrorInfo(e.getLogError().getMessage()));
    }

}
