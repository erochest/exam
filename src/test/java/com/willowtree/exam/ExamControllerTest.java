package com.willowtree.exam;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExamControllerTest {

    @Test
    public void whenNoName_greetsWorld() throws Exception {
        ExamController examController = new ExamController();
        Greeting greeting = examController.greeting(null).getBody();
        assertThat(greeting.getMessage()).contains("World");
    }

    @Test
    public void whenName_greetsByName() throws Exception {
        ExamController examController = new ExamController();
        Greeting greeting = examController.greeting("Zaphod").getBody();
        assertThat(greeting.getMessage()).contains("Zaphod");
    }

    @Test
    public void greets() throws Exception {
        ExamController examController = new ExamController();
        Greeting greeting = examController.greeting(null).getBody();
        assertThat(greeting.getMessage()).startsWith("Hello, ");
    }
}