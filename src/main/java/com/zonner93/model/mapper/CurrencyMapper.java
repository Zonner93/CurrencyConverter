package com.zonner93.model.mapper;

import com.zonner93.model.Currency;
import com.zonner93.model.builder.CurrencyDtoBuilder;
import com.zonner93.model.dto.CurrencyDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CurrencyMapper {
    public CurrencyDto currencyToDto (Currency currency) {
        if (currency == null) {
            return null;
        }
        CurrencyDtoBuilder currencyDtoBuilder = new CurrencyDtoBuilder();
        if (Objects.nonNull(currency.getCurrency())) {
            currencyDtoBuilder.withCurrency(currency.getCurrency());
        }
        if (Objects.nonNull(currency.getCode())) {
            currencyDtoBuilder.withCode(currency.getCode());
        }
        if (Objects.nonNull(currency.getRates()) && Objects.nonNull(currency.getRates().get(0).getEffectiveDate())) {
            currencyDtoBuilder.withEffectiveDate(currency.getRates().get(0).getEffectiveDate());
        }
        if (Objects.nonNull(currency.getRates()) && Objects.nonNull(currency.getRates().get(0).getBid())) {
            currencyDtoBuilder.withBid(currency.getRates().get(0).getBid());
        }
        if (Objects.nonNull(currency.getRates()) && Objects.nonNull(currency.getRates().get(0).getAsk())) {
            currencyDtoBuilder.withAsk(currency.getRates().get(0).getAsk());
        }
        return currencyDtoBuilder.build();
    }
}
