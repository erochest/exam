package com.willowtree.exam;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExamController {
    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Greeting> greeting(@RequestParam(value = "name", required = false) String name) throws Exception {
        Greeting greeting = new Greeting("Hello, " + (name == null ? "World" : name));
        return ResponseEntity.ok(greeting);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> onError() {
        return ResponseEntity.badRequest().body(new ErrorMessage());
    }
}
