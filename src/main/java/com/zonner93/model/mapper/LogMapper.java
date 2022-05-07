package com.zonner93.model.mapper;

import com.zonner93.model.LogEntity;
import com.zonner93.model.builder.LogDtoBuilder;
import com.zonner93.model.dto.LogDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LogMapper {
    public LogDto entityToDto(LogEntity logEntity) {
        if (logEntity == null) {
            return null;
        }
        LogDtoBuilder logDtoBuilder = new LogDtoBuilder();
        if (Objects.nonNull(logEntity.getDate())) {
            logDtoBuilder.withDate(logEntity.getDate());
        }
        if (logEntity.getQuantity() > 0) {
            logDtoBuilder.withQuantity(logEntity.getQuantity());
        }
        if (Objects.nonNull(logEntity.getCurrencyFrom())) {
            logDtoBuilder.withCurrencyFrom(logEntity.getCurrencyFrom());
        }
        if (Objects.nonNull(logEntity.getCurrencyTo())) {
            logDtoBuilder.withCurrencyTo(logEntity.getCurrencyTo());
        }
        if (Objects.nonNull(logEntity.getCodeFrom())) {
            logDtoBuilder.withCodeFrom(logEntity.getCodeFrom());
        }
        if (Objects.nonNull(logEntity.getCodeTo())) {
            logDtoBuilder.withCodeTo(logEntity.getCodeTo());
        }
        if (logEntity.getResult() > 0) {
            logDtoBuilder.withResult(logEntity.getResult());
        }
        return logDtoBuilder.build();
    }
}
