package com.zonner93.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Currency {
    private String table;
    private String currency;
    private String code;
    private Rates rates;
}
