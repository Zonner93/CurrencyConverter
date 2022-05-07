package com.zonner93.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyDto {
    private String currency;
    private String code;
    private String effectiveDate;
    private double bid;
    private double ask;
}
