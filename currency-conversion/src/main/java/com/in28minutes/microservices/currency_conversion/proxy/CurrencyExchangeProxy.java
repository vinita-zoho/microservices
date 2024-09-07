package com.in28minutes.microservices.currency_conversion.proxy;

import com.in28minutes.microservices.currency_conversion.entity.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange", url = "localhost:8000")
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeVal(@PathVariable String from, @PathVariable String to);

}
