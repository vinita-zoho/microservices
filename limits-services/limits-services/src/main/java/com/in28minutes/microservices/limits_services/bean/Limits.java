package com.in28minutes.microservices.limits_services.bean;

import com.in28minutes.microservices.limits_services.config.Configuration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Limits {

    int minimum;
    int maximum;

}
