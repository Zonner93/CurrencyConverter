package com.zonner93.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates implements Serializable {
    private String effectiveDate;
    private double bid;
    private double ask;
}
