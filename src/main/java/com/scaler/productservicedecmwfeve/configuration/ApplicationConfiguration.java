package com.scaler.productservicedecmwfeve.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public RestTemplate createRestTemplet(){
        return new RestTemplateBuilder().build();
    }
}
