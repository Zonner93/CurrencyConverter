package com.zonner93.exception.currency;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CurrencyErrorInfo {
    private final String message;
}
