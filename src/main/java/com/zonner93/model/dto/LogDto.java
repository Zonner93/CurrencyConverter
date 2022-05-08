package com.zonner93.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogDto {
    private String date;
    private double quantity;
    private String currencyFrom;
    private String currencyTo;
    private String codeFrom;
    private String codeTo;
    private double result;
}
