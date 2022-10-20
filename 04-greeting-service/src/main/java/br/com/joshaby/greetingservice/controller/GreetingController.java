package br.com.joshaby.greetingservice.controller;

import br.com.joshaby.greetingservice.configuration.GreetingConfig;
import br.com.joshaby.greetingservice.model.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
@RequiredArgsConstructor
public class GreetingController {

    private static final String template = "%s, %s!";

    private final AtomicLong counter = new AtomicLong();

    private final GreetingConfig config;

    @GetMapping
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
        if (name.isEmpty()) name = config.getDefaultValue();
        return new Greeting(counter.incrementAndGet(), String.format(template, config.getGreeting(), name));
    }
}
