package com.zonner93.exception.currency;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CurrencyException extends RuntimeException {
    private final CurrencyError currencyError;
}
