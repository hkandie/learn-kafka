package com.spiderwalker.kafka.demo;

import java.time.Duration;
import java.util.Arrays;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")

public class KafkaController {

    private final Producer producer;
    private final Logger logger = LoggerFactory.getLogger(KafkaController.class);
    private final  ConsumerFactory<String, String> consumerFactory;

    KafkaController(Producer producer, ConsumerFactory<String, String> consumerFactory) {
        this.producer = producer;
        this.consumerFactory = consumerFactory;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody Abcd abcd) {
        logger.info("Message received: %s " + abcd.toString());
        this.producer.sendMessage(abcd);
    }

    private void consumeKafka(String searchCriteria) {
        Consumer<String, String> consumer = consumerFactory.createConsumer();
        consumer.subscribe(Arrays.asList("a.bunch.of.topics"));
        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord cr : consumerRecords) {
                // Convert cr to object, check whether object fits criteria, import or not...
            }
        }
    }
}
