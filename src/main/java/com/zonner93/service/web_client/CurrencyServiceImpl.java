package com.zonner93.service.web_client;

import com.zonner93.Exception.Currency.CurrencyError;
import com.zonner93.Exception.Currency.CurrencyException;
import com.zonner93.constans.AvailableCurrencyCodes;
import com.zonner93.model.Currency;
import com.zonner93.model.dto.CurrencyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final WebClientServiceImpl webClientService;

    @Override
    public CurrencyDto getCurrency(String currencyCode) {
        validateCurrencyCode(currencyCode);
        return webClientService.getCurrency(currencyCode);
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
