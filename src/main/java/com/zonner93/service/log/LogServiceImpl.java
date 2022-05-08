package com.zonner93.service.log;

import com.zonner93.Exception.LogException.LogError;
import com.zonner93.Exception.LogException.LogException;
import com.zonner93.model.Currency;
import com.zonner93.model.dto.LogDto;
import com.zonner93.model.mapper.LogMapper;
import com.zonner93.model.repository.LogRepository;
import com.zonner93.service.web_client.WebClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {
    private final WebClientServiceImpl webClientService;
    private final LogRepository logRepository;
    private final LogMapper logMapper;

    @Override
    public LogDto convertCurrency(double quantity, String currencyCodeFrom, String currencyCodeTo) {
        validateQuantity(quantity);
        validateCurrencyCodesDifference(currencyCodeFrom, currencyCodeTo);

        Currency currencyFrom = webClientService.getCurrency(currencyCodeFrom);
        Currency currencyTo = webClientService.getCurrency(currencyCodeTo);
        LogDto logDto = new LogDto();
        logDto.setCurrencyFrom(currencyCodeFrom);
        logDto.setCodeTo(currencyCodeTo);
        logDto.setCodeFrom(currencyCodeFrom);
        logDto.setDate(LocalDateTime.now().toString());
        logDto.setQuantity(quantity);
        logDto.setCurrencyFrom(currencyFrom.getCurrency());
        logDto.setCurrencyTo(currencyTo.getCurrency());
        double quantityPLN = convertForeignCurrencyToPLN(quantity, currencyFrom.getRates().get(0).getBid());
        double quantityNewCurrency = convertPLNToForeignCurrency(quantityPLN, currencyTo.getRates().get(0).getAsk());
        logDto.setResult(quantityNewCurrency);

        logRepository.save(logMapper.dtoToEntity(logDto));
        return logDto;
    }

    protected double convertForeignCurrencyToPLN(double quantity, double currencyBid) {
        return quantity * currencyBid;
    }

    protected double convertPLNToForeignCurrency(double quantity, double currencyAsk) {
        return quantity / currencyAsk;
    }

    protected void validateQuantity(double quantity) {
        if (quantity <= 0.0) {
            throw new LogException(LogError.QUANTITY_LESS_OR_EQUALS_ZERO);
        }
    }
    protected void validateCurrencyCodesDifference(String currencyCodeFrom, String currencyCodeTo) {
        if (currencyCodeFrom.equals(currencyCodeTo)) {
            throw new LogException(LogError.THE_SAME_CURRENCY_FROM_AND_CURRENCY_TO);
        }
    }
}
