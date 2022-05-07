package com.zonner93.service.web_client;

import com.zonner93.model.dto.CurrencyDto;

public interface CurrencyService {
    public CurrencyDto getCurrency(String currencyCode);
}
