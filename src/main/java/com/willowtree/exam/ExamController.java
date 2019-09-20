package com.willowtree.exam;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExamController {
    private WeatherClient weatherClient;
    // private BadWeatherClient badWeatherClient;

    private String greeting;

    private DiscoveryClient discoveryClient;

    public ExamController(WeatherClient weatherClient, String greeting, DiscoveryClient discoveryClient) {
        this.weatherClient = weatherClient;
        this.greeting = greeting;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Greeting> greeting(@RequestParam(value = "name", required = false) String name)
            throws Exception {
        Greeting greetingResponse = new Greeting(greeting + ", " + (name == null ? "World" : name));
        return ResponseEntity.ok(greetingResponse);
    }

    @GetMapping(value = "/weather", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<WeatherInfo> getWeather(@RequestParam(value = "city") String city) {
        WeatherInfo cityWeather = weatherClient.getCityWeather(city);
        return ResponseEntity.ok(cityWeather);
    }

    @GetMapping(value = "/bad-weather", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<WeatherInfo> getBadWeather() {
        return null;
    }
}
