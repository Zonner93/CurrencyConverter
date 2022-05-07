package com.zonner93.model;

public class CurrencyDtoBuilder {
    private String currency;
    private String code;
    private String effectiveDate;
    private double bid;
    private double ask;

    public CurrencyDtoBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public CurrencyDtoBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public CurrencyDtoBuilder withEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    public CurrencyDtoBuilder withBid(double bid) {
        this.bid = bid;
        return this;
    }

    public CurrencyDtoBuilder withAsk(double ask) {
        this.ask = ask;
        return this;
    }

    public CurrencyDto build() {
        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setCurrency(currency);
        currencyDto.setCode(code);
        currencyDto.setEffectiveDate(effectiveDate);
        currencyDto.setBid(bid);
        currencyDto.setAsk(ask);
        return currencyDto;
    }
}
