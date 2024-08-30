package com.in28minutes.microservices.limits_services.config;

import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("limits-service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@org.springframework.context.annotation.Configuration
public class Configuration {

    private int minimum;

    private int maximum;
}
