package com.willowtree.exam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ExamConfiguration {
    @Value("${open-weather.api.key}")
    public String apiKey;

    @Value("${open-weather.api.url}")
    public String openWeatherUrl;

    @Value("${hello-weather.greeting}")
    public String greeting;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

    @Bean
    public OpenWeatherClient openWeatherClient(RestTemplate restTemplate) {
        return new OpenWeatherClient(restTemplate, openWeatherUrl, apiKey);
    }

    @Bean
    public String getGreeting() {
        return greeting;
    }
}
