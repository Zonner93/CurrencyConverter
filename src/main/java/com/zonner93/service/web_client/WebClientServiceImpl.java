package com.zonner93.service.web_client;

import com.zonner93.model.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WebClientServiceImpl implements WebClientService {
    private final RestTemplate restTemplate;
    private final String NBP_API_URL = "https://api.nbp.pl/api/exchangerates/rates/c/";

    @Override
    public Currency getCurrency(String currencyCode) {
        return restTemplate.getForObject(NBP_API_URL + currencyCode + "/", Currency.class);
    }
}
