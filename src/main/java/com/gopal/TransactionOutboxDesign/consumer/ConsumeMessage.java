package com.gopal.TransactionOutboxDesign.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumeMessage {
    @Value("${kafka.topic.name}")
    private String topicName;

    @KafkaListener(topics = {"transactionOutBoxTopic"}, groupId = "gopalKumar")
    public void consume(String message){
        log.info("Message Consumed : {}",message);
    }
}
