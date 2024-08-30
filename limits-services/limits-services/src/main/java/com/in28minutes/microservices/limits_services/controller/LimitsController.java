package com.in28minutes.microservices.limits_services.controller;

import com.in28minutes.microservices.limits_services.bean.Limits;
import com.in28minutes.microservices.limits_services.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    LimitsController(Configuration configuration)
    {
        this.configuration = configuration;
    }

    @GetMapping(path = "/limits")
    public Limits retrieveLimits()
    {
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
