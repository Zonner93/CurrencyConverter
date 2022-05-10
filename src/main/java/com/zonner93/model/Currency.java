package com.zonner93.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency implements Serializable {
    private String table;
    private String currency;
    private String code;
    private List<Rates> rates;
}
