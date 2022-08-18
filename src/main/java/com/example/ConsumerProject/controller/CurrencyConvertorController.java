package com.example.ConsumerProject.controller;

import com.example.ConsumerProject.model.CurrencyConvertorParams;
import com.example.ConsumerProject.model.CurrencyResponse;
import com.example.ConsumerProject.service.CurrencyConvertorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency")
public class CurrencyConvertorController {

    @Autowired
    private CurrencyConvertorService coinsConvertorService;

    @PostMapping("/convert")
    public CurrencyResponse currencyConvert(@RequestBody CurrencyConvertorParams params) {
        return coinsConvertorService.convert(params);
    }

}
