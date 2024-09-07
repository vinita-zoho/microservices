package com.in28minutes.microservices.currency_conversion.controller;

import com.in28minutes.microservices.currency_conversion.entity.CurrencyConversion;
import com.in28minutes.microservices.currency_conversion.proxy.CurrencyExchangeProxy;
import org.bouncycastle.jcajce.provider.digest.MD2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {

    CurrencyExchangeProxy currencyExchangeProxy;

    @Autowired
    public CurrencyConversionController(CurrencyExchangeProxy currencyExchangeProxy) {
        this.currencyExchangeProxy = currencyExchangeProxy;
    }

    @GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
    {
        HashMap uriVariables = new HashMap();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
        CurrencyConversion currencyConversion = responseEntity.getBody();
        BigDecimal totalCalculatedAmount = quantity.multiply(currencyConversion.getConversionMultiple());

        return new CurrencyConversion(currencyConversion.getId(), from, to,currencyConversion.getConversionMultiple(), quantity, totalCalculatedAmount, currencyConversion.getEnvironment());
    }

    @GetMapping(path = "/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
    {
        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchangeVal(from, to);
        BigDecimal totalCalculatedAmount = quantity.multiply(currencyConversion.getConversionMultiple());

        return new CurrencyConversion(currencyConversion.getId(), from, to,currencyConversion.getConversionMultiple(), quantity, totalCalculatedAmount, currencyConversion.getEnvironment());
    }
}
