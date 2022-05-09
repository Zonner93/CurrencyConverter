package com.zonner93.model.mapper;

import com.zonner93.model.dto.LogDto;
import com.zonner93.model.entity.LogEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LogMapperTest {
    private LogMapper mapper;

    @BeforeEach
    void initializeMapperBeforeEachTest() {
        mapper = new LogMapper();
    }

    @Test
    void shouldReturnNullWhenLogDtoWillBeNull() {
//        given
        LogDto logDto = null;
//        when
        LogEntity logEntity = mapper.dtoToEntity(logDto);
//        then
        assertNull(logEntity);
    }

    @Test
    void shouldReturnNullWhenLogEntityWillBeNull() {
//        given
        LogEntity logEntity = null;
//        when
        LogDto logDto = mapper.entityToDto(logEntity);
//        then
        assertNull(logDto);
    }

    @Test
    void shouldReturnEntityWhenLogDtoWillBeNotNull() {
//        given
        String dateTimeNow = LocalDateTime.now().toString();
        LogDto logDto = new LogDto();
        logDto.setDate(dateTimeNow);
        logDto.setQuantity(100.0);
        logDto.setCurrencyFrom("funt szterling");
        logDto.setCurrencyTo("jen (Japonia)");
        logDto.setCodeFrom("gbp");
        logDto.setCodeTo("jpy");
        logDto.setResult(1240.34);
//        when
        LogEntity logEntity = mapper.dtoToEntity(logDto);
//        then
        assertAll(
                () -> assertEquals(dateTimeNow, logEntity.getDate()),
                () -> assertEquals(100.0, logEntity.getQuantity()),
                () -> assertEquals("funt szterling", logEntity.getCurrencyFrom()),
                () -> assertEquals("jen (Japonia)", logEntity.getCurrencyTo()),
                () -> assertEquals("gbp", logEntity.getCodeFrom()),
                () -> assertEquals("jpy", logEntity.getCodeTo()),
                () -> assertEquals(1240.34, logEntity.getResult()),
                () -> assertNotNull(logEntity));
    }

    @Test
    void shouldReturnDtoWhenLogEntityWillBeNotNull() {
//        given
        String dateTimeNow = LocalDateTime.now().toString();
        LogEntity logEntity = new LogEntity();
        logEntity.setDate(dateTimeNow);
        logEntity.setQuantity(125.0);
        logEntity.setCurrencyFrom("euro");
        logEntity.setCurrencyTo("dolar amerykański");
        logEntity.setCodeFrom("eur");
        logEntity.setCodeTo("usd");
        logEntity.setResult(111.88);
//        when
        LogDto logDto = mapper.entityToDto(logEntity);
//        then
        assertAll(
                () -> assertEquals(dateTimeNow, logEntity.getDate()),
                () -> assertEquals(125.0, logEntity.getQuantity()),
                () -> assertEquals("euro", logEntity.getCurrencyFrom()),
                () -> assertEquals("dolar amerykański", logEntity.getCurrencyTo()),
                () -> assertEquals("eur", logEntity.getCodeFrom()),
                () -> assertEquals("usd", logEntity.getCodeTo()),
                () -> assertEquals(111.88, logEntity.getResult()),
                () -> assertNotNull(logDto));
    }
}
