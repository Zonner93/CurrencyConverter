package com.zonner93.service.web_client;

import com.zonner93.model.Currency;
import com.zonner93.model.dto.CurrencyDto;

public interface WebClientService {
    public CurrencyDto getCurrencyDto(String currencyCode);
    public Currency getCurrency(String currencyCode);
}
