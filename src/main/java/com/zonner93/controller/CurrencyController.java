package com.zonner93.controller;

import com.zonner93.model.dto.CurrencyDto;
import com.zonner93.model.dto.LogDto;
import com.zonner93.service.currency.CurrencyService;
import com.zonner93.service.log.LogService;
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
    private final LogService logService;

    @GetMapping(value = "/")
    public CurrencyDto getCurrency(@RequestParam String currencyCode) {
        return currencyService.getCurrency(currencyCode);
    }

    @GetMapping("/list")
    public List<CurrencyDto> getCurrencyList(@RequestParam List<String> currencyCodeList) {
        return currencyService.getCurrencyList(currencyCodeList);
    }

    @GetMapping("/convert")
    public LogDto convertCurrency(@RequestParam double quantity,
                                  @RequestParam String currencyCodeFrom,
                                  @RequestParam String currencyCodeTo) {
        return logService.convertCurrency(quantity, currencyCodeFrom, currencyCodeTo);
    }
}
