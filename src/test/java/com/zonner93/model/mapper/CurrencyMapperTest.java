package com.zonner93.model.mapper;

import com.zonner93.model.Currency;
import com.zonner93.model.Rates;
import com.zonner93.model.dto.CurrencyDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyMapperTest {
    private CurrencyMapper mapper;

    @BeforeEach
    void initializeMapperBeforeEachTest() {
        mapper = new CurrencyMapper();
    }

    @Test
    void shouldReturnNullWhenCurrencyWillBeNull() {
//        given
        Currency currency = null;
//        when
        CurrencyDto currencyDto = mapper.currencyToDto(currency);
//        then
        assertNull(currency);
    }

    @Test
    void shouldReturnCurrencyDtoWhenCurrencyWillBeNotNull() {
//        given
        List<Rates> rates = new ArrayList<>();
        Rates rate = new Rates();
        rate.setEffectiveDate("2022-05-06");
        rate.setBid(4.3636);
        rate.setAsk(4.4518);
        rates.add(rate);
        Currency currency = new Currency();
        currency.setCurrency("dolar amerykański");
        currency.setCode("USD");
        currency.setRates(rates);
//        when
        CurrencyDto currencyDto = mapper.currencyToDto(currency);
//        then
        assertAll(
                () -> assertEquals("dolar amerykański", currencyDto.getCurrency()),
                () -> assertEquals("USD", currencyDto.getCode()),
                () -> assertEquals("2022-05-06", currencyDto.getEffectiveDate()),
                () -> assertEquals(4.3636, currencyDto.getBid()),
                () -> assertEquals(4.4518, currencyDto.getAsk()),
                () -> assertNotNull(currencyDto));
    }
}