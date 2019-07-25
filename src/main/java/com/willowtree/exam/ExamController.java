package com.willowtree.exam;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExamController {
    private OpenWeatherClient openWeatherClient;
    private BadWeatherClient badWeatherClient;

    private String greeting;

    public ExamController(OpenWeatherClient openWeatherClient, String greeting) {
        this.openWeatherClient = openWeatherClient;
        this.greeting = greeting;
    }

    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Greeting> greeting(@RequestParam(value = "name", required = false) String name) throws Exception {
        Greeting greetingResponse = new Greeting(greeting + ", " + (name == null ? "World" : name));
        return ResponseEntity.ok(greetingResponse);
    }

    @GetMapping(value = "/weather", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<WeatherInfo> getWeather(@RequestParam(value = "city") String city) {
        WeatherInfo cityWeather = openWeatherClient.getCityWeather(city);
        return ResponseEntity.ok(cityWeather);
    }

    @GetMapping(value = "/bad-weather", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<WeatherInfo> getBadWeather() {
        return null;
    }
}
