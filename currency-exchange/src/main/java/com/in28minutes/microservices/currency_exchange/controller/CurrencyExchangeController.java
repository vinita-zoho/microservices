package com.in28minutes.microservices.currency_exchange.controller;

import com.in28minutes.microservices.currency_exchange.model.CurrencyExchange;
import com.in28minutes.microservices.currency_exchange.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Environment environment;

    private CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    public CurrencyExchangeController(Environment environment, CurrencyExchangeRepository currencyExchangeRepository) {
        this.environment = environment;
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeVal(@PathVariable String from, @PathVariable String to)
    {
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to).get();
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
