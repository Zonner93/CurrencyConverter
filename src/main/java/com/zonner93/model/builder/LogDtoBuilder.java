package com.zonner93.model.builder;

import com.zonner93.model.dto.LogDto;

public class LogDtoBuilder {
    private String date;
    private double quantity;
    private String currencyFrom;
    private String currencyTo;
    private String codeFrom;
    private String codeTo;
    private double result;

    public LogDtoBuilder withDate(String date) {
        this.date = date;
        return this;
    }

    public LogDtoBuilder withQuantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    public LogDtoBuilder withCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
        return this;
    }

    public LogDtoBuilder withCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
        return this;
    }

    public LogDtoBuilder withCodeFrom(String codeFrom) {
        this.codeFrom = codeFrom;
        return this;
    }

    public LogDtoBuilder withCodeTo(String codeTo) {
        this.codeTo = codeTo;
        return this;
    }

    public LogDtoBuilder withResult(double result) {
        this.result = result;
        return this;
    }

    public LogDto build() {
        LogDto logDto = new LogDto();
        logDto.setDate(date);
        logDto.setQuantity(quantity);
        logDto.setCurrencyFrom(currencyFrom);
        logDto.setCurrencyTo(currencyTo);
        logDto.setCodeFrom(codeFrom);
        logDto.setCodeTo(codeTo);
        logDto.setResult(result);
        return logDto;
    }
}
