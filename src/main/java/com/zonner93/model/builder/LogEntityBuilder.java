package com.zonner93.model.builder;

import com.zonner93.model.LogEntity;

public class LogEntityBuilder {
    private String date;
    private double quantity;
    private String currencyFrom;
    private String currencyTo;
    private String codeFrom;
    private String codeTo;
    private double result;

    public LogEntityBuilder withDate(String date) {
        this.date = date;
        return this;
    }

    public LogEntityBuilder withQuantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    public LogEntityBuilder withCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
        return this;
    }

    public LogEntityBuilder withCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
        return this;
    }

    public LogEntityBuilder withCodeFrom(String codeFrom) {
        this.codeFrom = codeFrom;
        return this;
    }

    public LogEntityBuilder withCodeTo(String codeTo) {
        this.codeTo = codeTo;
        return this;
    }

    public LogEntityBuilder withResult(double result) {
        this.result = result;
        return this;
    }

    public LogEntity build() {
        LogEntity logEntity = new LogEntity();
        logEntity.setDate(date);
        logEntity.setQuantity(quantity);
        logEntity.setCurrencyFrom(currencyFrom);
        logEntity.setCurrencyTo(currencyTo);
        logEntity.setCodeFrom(codeFrom);
        logEntity.setCodeTo(codeTo);
        logEntity.setResult(result);
        return logEntity;
    }
}
