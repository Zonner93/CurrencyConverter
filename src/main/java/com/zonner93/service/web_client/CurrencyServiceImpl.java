package com.zonner93.service.web_client;

import com.zonner93.model.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService{
    private final WebClientServiceImpl webClientService;

    @Override
    public Currency getCurrency(String currencyCode) {
        return webClientService.getCurrency(currencyCode);
    }
}
