package com.zonner93.Exception.Currency;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CurrencyError {
    CURRENCY_NOT_FOUND("Currency code provided is invalid.");
    private final String message;
}
