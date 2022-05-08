package com.zonner93.service.currency;

import com.zonner93.Exception.Currency.CurrencyError;
import com.zonner93.Exception.Currency.CurrencyException;
import com.zonner93.constants.AvailableCurrencyCodes;
import com.zonner93.model.AvailableCurrency;
import com.zonner93.model.dto.CurrencyDto;
import com.zonner93.service.web_client.WebClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final WebClientServiceImpl webClientService;

    @Override
    public CurrencyDto getCurrency(String currencyCode) {
        validateCurrencyCode(currencyCode);
        return webClientService.getCurrencyDto(currencyCode);
    }

    @Override
    public List<CurrencyDto> getCurrencyList(List<String> currencyCodeList) {
        List<CurrencyDto> currencyDtoList = new ArrayList<>();
        for (String code : currencyCodeList) {
            CurrencyDto currency = getCurrency(code);
            currencyDtoList.add(currency);
        }
        return currencyDtoList;
    }

    @Override
    public AvailableCurrency getAvailableCurrency() {
        AvailableCurrency availableCurrency = new AvailableCurrency();
        List<String> currencyCodeList = availableCurrency.getCurrencyCodeList();
        for (AvailableCurrencyCodes c : AvailableCurrencyCodes.values()) {
            currencyCodeList.add(c.name());
        }
        return availableCurrency;
    }

    protected boolean isCurrencyCodeValid(String code) {
        for (AvailableCurrencyCodes c : AvailableCurrencyCodes.values()) {
            if (c.name().equals(code)) {
                return true;
            }
        }
        return false;
    }

    protected void validateCurrencyCode(String currencyCode) {
        if (!isCurrencyCodeValid(currencyCode)) {
            throw new CurrencyException(CurrencyError.CURRENCY_NOT_FOUND);
        }
    }
}
