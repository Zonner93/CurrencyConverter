package com.zonner93.controller;

import com.zonner93.model.dto.CurrencyDto;
import com.zonner93.service.web_client.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping(value = "/")
    public CurrencyDto getCurrency(@RequestParam String currencyCode) {
        return currencyService.getCurrency(currencyCode);
    }

    @GetMapping("/list")
    public List<CurrencyDto> getCurrencyList(@RequestParam List<String> currencyCodeList) {
        return currencyService.getCurrencyList(currencyCodeList);
    }
}
