package com.zonner93.Exception.Currency;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CurrencyExceptionHandler {

    @ExceptionHandler(value = CurrencyException.class)
    public ResponseEntity<CurrencyErrorInfo> handlerCurrencyException(CurrencyException e) {
        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;
        if (CurrencyError.CURRENCY_NOT_FOUND.equals(e.getCurrencyError())) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(httpStatus).body(new CurrencyErrorInfo(e.getCurrencyError().getMessage()));
    }
}
