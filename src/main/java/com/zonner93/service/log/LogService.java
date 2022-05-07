package com.zonner93.service.log;

import com.zonner93.model.dto.LogDto;

public interface LogService {
    public LogDto convertCurrency (double quantity, String currencyCodeFrom, String currencyCodeTo);
}
