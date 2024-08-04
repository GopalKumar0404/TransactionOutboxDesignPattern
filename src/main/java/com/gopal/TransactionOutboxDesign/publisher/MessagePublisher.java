package com.gopal.TransactionOutboxDesign.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class MessagePublisher {
    @Value("${kafka.topic.name}")
    private String kafkaTopicName;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishTopic(String message) {
        CompletableFuture<SendResult<String, String>> resultCompletableFuture = kafkaTemplate.send(kafkaTopicName, message);
        resultCompletableFuture.whenCompleteAsync((result,ex)->{
            if(ex==null)
                log.info("Message Published to Kafka topic : {} , message : {} ",kafkaTopicName,message);
            else
                log.error("Exception Occurred : {}",ex.getMessage());
        });
    }
}
