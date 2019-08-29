package com.willowtree.exam;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExamControllerTest {

    WeatherInfo weatherInfo;
    FakeWeatherClient fakeWeatherClient;
    ExamController examController;

    String GREETING = "Greeting";

    @Before
    public void setUp() {
        fakeWeatherClient = new FakeWeatherClient();
        examController = new ExamController(fakeWeatherClient, GREETING);
    }

    @Test
    public void whenNoName_greetsWorld() throws Exception {
        Greeting greeting = examController.greeting(null).getBody();
        assertThat(greeting.getMessage()).contains("World");
    }

    @Test
    public void whenName_greetsByName() throws Exception {
        Greeting greeting = examController.greeting("Zaphod").getBody();
        assertThat(greeting.getMessage()).contains("Zaphod");
    }

    @Test
    public void greets() throws Exception {
        Greeting greeting = examController.greeting(null).getBody();
        assertThat(greeting.getMessage()).startsWith(GREETING + ", ");
    }

    class FakeWeatherClient implements WeatherClient {
        @Override
        public WeatherInfo getCityWeather(String city) {
            return ExamControllerTest.this.weatherInfo;
        }
    }
}