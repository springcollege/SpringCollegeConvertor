package com.example.ConsumerProject.model;

import lombok.Data;

@Data
public class CurrencyConvertorParams {

    private String from;
    private String to;
    private int amount;
}
