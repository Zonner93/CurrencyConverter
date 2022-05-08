package com.zonner93.Exception.LogException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LogException extends RuntimeException {
    private final LogError logError;
}
