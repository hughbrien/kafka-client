package com.appdynamics.kafka.demo.kafkaclient;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private static final Logger LOG = LoggerFactory.getLogger(com.appdynamics.kafka.demo.kafkaclient.KafkaController.class);

    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public KafkaController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String topic, @RequestParam String key, @RequestParam String message) {
        LOG.info("Calling sendMessage /send " );
        kafkaProducerService.sendMessage(topic, key, message);
        return "Message sent to Kafka topic " + topic;
    }

    @PostMapping("/senddefaultmessage")
    public String sendDefaultMessage() {
        LOG.info("Calling sendMessage /send " );
        kafkaProducerService.sendMessage("test", "default", "Welcome to Basic Kafka in Spring" + new java.util.Date().toString());
        return "Message sent to Kafka topic test";
    }


    private String generateLargeMessage(int sizeInMB) {
        int sizeInBytes = sizeInMB * 1024 * 1024;
        StringBuilder sb = new StringBuilder(sizeInBytes);
        for (int i = 0; i < sizeInBytes; i++) {
            sb.append('A');  // You can use any character or pattern
        }
        return sb.toString();
    }
}
