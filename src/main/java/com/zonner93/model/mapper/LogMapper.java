package com.zonner93.model.mapper;

import com.zonner93.model.entity.LogEntity;
import com.zonner93.model.builder.LogDtoBuilder;
import com.zonner93.model.builder.LogEntityBuilder;
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

    public LogEntity dtoToEntity(LogDto logDto) {
        if (logDto == null) {
            return null;
        }
        LogEntityBuilder logEntityBuilder = new LogEntityBuilder();
        if (Objects.nonNull(logDto.getDate())) {
            logEntityBuilder.withDate(logDto.getDate());
        }
        if (logDto.getQuantity() > 0) {
            logEntityBuilder.withQuantity(logDto.getQuantity());
        }
        if (Objects.nonNull(logDto.getCurrencyFrom())) {
            logEntityBuilder.withCurrencyFrom(logDto.getCurrencyFrom());
        }
        if (Objects.nonNull(logDto.getCurrencyTo())) {
            logEntityBuilder.withCurrencyTo(logDto.getCurrencyTo());
        }
        if (Objects.nonNull(logDto.getCodeFrom())) {
            logEntityBuilder.withCodeFrom(logDto.getCodeFrom());
        }
        if (Objects.nonNull(logDto.getCodeTo())) {
            logEntityBuilder.withCodeTo(logDto.getCodeTo());
        }
        if (logDto.getResult() > 0) {
            logEntityBuilder.withResult(logDto.getResult());
        }
        return logEntityBuilder.build();
    }
}
