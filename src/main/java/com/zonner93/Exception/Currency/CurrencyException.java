package com.zonner93.Exception.Currency;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CurrencyException extends RuntimeException {
    private final CurrencyError currencyError;
}
