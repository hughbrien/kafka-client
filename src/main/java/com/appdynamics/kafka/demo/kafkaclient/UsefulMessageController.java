package com.appdynamics.kafka.demo.kafkaclient;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsefulMessageController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/usefulmessage")
    public UsefulMessage usefulmessage(@RequestParam(value = "name", defaultValue = "World") String name) {
        KafkaProxy.sendMessage(name);

        return new UsefulMessage(counter.incrementAndGet(), String.format(template, name));
    }


    @GetMapping("/largeusefulmessage")
    public UsefulMessage largeusefulmessage(@RequestParam(value = "name", defaultValue = "World") String name) {
        KafkaProxy.sendMessage(name);
        return new UsefulMessage(counter.incrementAndGet(), String.format(template, name));
    }



}