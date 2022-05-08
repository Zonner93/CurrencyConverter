package com.zonner93.Exception.LogException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LogError {
    QUANTITY_LESS_OR_EQUALS_ZERO("Quantity must be greather than zero"),
    THE_SAME_CURRENCY_FROM_AND_CURRENCY_TO("currencyCodeFrom and currencyCodeTo must be different");
    private final String message;
}
