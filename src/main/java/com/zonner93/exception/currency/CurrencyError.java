package com.zonner93.exception.currency;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CurrencyError {
    CURRENCY_NOT_FOUND("Currency code provided is invalid.");
    private final String message;
}
