package com.zonner93.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AvailableCurrency {
    List<String> currencyCodeList = new ArrayList<>();
}
