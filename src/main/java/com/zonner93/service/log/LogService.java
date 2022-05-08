package com.zonner93.service.log;

import com.zonner93.model.dto.LogDto;

import java.util.List;

public interface LogService {
    public LogDto convertCurrency(double quantity, String currencyCodeFrom, String currencyCodeTo);
    public List<LogDto> getAllLogs();
}
