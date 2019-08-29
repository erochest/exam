package com.willowtree.exam;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

public class OpenWeatherClient implements WeatherClient {
    private final RestTemplate restTemplate;
    private final String url;
    private final String apiKey;

    public OpenWeatherClient(RestTemplate restTemplate, String url, String apiKey) {
        this.restTemplate = restTemplate;
        this.url = url;
        this.apiKey = apiKey;
    }

    @Override
    public WeatherInfo getCityWeather(String city) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("q", city).queryParam("appid",
                apiKey);

        System.err.println(String.format("OPEN WEATHER CALL TO %s", builder.toUriString()));
        // WeatherResult weatherResult = restTemplate.getForObject(
        // builder.toUriString(),
        // WeatherResult.class
        // );

        ResponseEntity<WeatherResult> weatherResult = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,
                new HttpEntity<>(httpHeaders), WeatherResult.class);

        return new WeatherInfo(weatherResult.getBody().getMain().getTemp());
    }

    private static class WeatherResult {
        private final WeatherMain main;

        public WeatherResult() {
            this.main = null;
        }

        public WeatherResult(WeatherMain main) {
            this.main = main;
        }

        public WeatherMain getMain() {
            return main;
        }
    }

    private static class WeatherMain {
        private final float temp;

        public WeatherMain() {
            this.temp = 0.0f;
        }

        public WeatherMain(float temp) {
            this.temp = temp;
        }

        public float getTemp() {
            return temp;
        }
    }
}
