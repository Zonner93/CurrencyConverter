package com.zonner93.service.web_client;

import com.zonner93.model.dto.CurrencyDto;

import java.util.List;

public interface CurrencyService {
    public CurrencyDto getCurrency(String currencyCode);
    public List<CurrencyDto> getCurrencyList (List<String> currencyCodeList);
}
