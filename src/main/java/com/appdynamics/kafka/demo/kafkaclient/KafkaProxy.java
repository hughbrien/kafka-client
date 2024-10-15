package com.appdynamics.kafka.demo.kafkaclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class KafkaProxy {

    private static final Logger LOG = LoggerFactory.getLogger(com.appdynamics.kafka.demo.kafkaclient.KafkaProxy.class);


    public static void sendMessage( String Message ) {
        // Kafka broker address
        String bootstrapServers = "localhost:9092"; // Replace with your Kafka broker address

        // Create producer properties
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create the producer
        Producer<String, String> producer = new KafkaProducer<>(properties);

        int min = 3;
        int max = 10;
        Random random = new Random();
        int randomValue = random.nextInt((max - min) + 1) + min;

        String message = RandomMessageGenerator.generateRandomMessage(randomValue);
        // Create a producer record
        String topic = "test"; // Replace with your topic name
        String key = "message";
        String value = new Date().toString() + " " + message;
        LOG.info("The raw random messages is " + message);

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);

        LOG.info("The Producer Record is large");
        // Send the record
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                LOG.info("Message sent successfully!");
                LOG.info("Topic: " + metadata.topic());
                LOG.info("Partition: " + metadata.partition());
                LOG.info("Offset: " + metadata.offset());
                LOG.info("Timestamp: " + metadata.timestamp());
            } else {
                exception.printStackTrace();
            }
        });

        // Flush and close the producer
        producer.flush();
        producer.close();
    }
}
