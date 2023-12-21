package com.cwc.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Deendayal Kumawat
 */
@Configuration
public class MyConfig {

    @Bean
    WebClient webClient(){
        return WebClient.builder().build();
    }
}
