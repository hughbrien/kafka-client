package com.appdynamics.kafka.demo.kafkaclient;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class KafkaClientApplication {

    private static final Logger LOG = LoggerFactory.getLogger(com.appdynamics.kafka.demo.kafkaclient.KafkaClientApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KafkaClientApplication.class, args);
    }

}
