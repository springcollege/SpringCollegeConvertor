package com.example.ConsumerProject.service;

import com.example.ConsumerProject.config.CurrencyConvertorConfig;
import com.example.ConsumerProject.model.CurrencyConvertorParams;
import com.example.ConsumerProject.model.CurrencyResponse;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CurrencyConvertorService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @Autowired
    private CurrencyConvertorConfig convertorConfig;
    public CurrencyResponse convert(CurrencyConvertorParams params) {

        /**
         * REST API call, using REST Template approach
         */
        ResponseEntity<String> response = restTemplate.getForEntity(
                convertorConfig.getBaseEndpoint() + params.getFrom(),
                String.class
        );

        /**
         * REST API call, using WebClient approach
         */
        String webClientResponse = webClient.method(HttpMethod.GET)
                .uri(convertorConfig.getBaseEndpoint() + params.getFrom())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JsonObject webClientJsonResponse = new Gson().fromJson(webClientResponse, JsonObject.class);

        JsonObject responseJson = new Gson().fromJson(response.getBody(), JsonObject.class);
        JsonElement rate = responseJson.get("rates").getAsJsonObject().get(params.getTo());

        float conversionResult = Float.parseFloat(rate.toString()) * params.getAmount();

        return new CurrencyResponse(conversionResult);
    }
}
