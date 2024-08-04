package com.gopal.TransactionOutboxDesign.services;

import com.gopal.TransactionOutboxDesign.entity.OrderOutbox;
import com.gopal.TransactionOutboxDesign.publisher.MessagePublisher;
import com.gopal.TransactionOutboxDesign.repository.OutboxRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableScheduling
@Slf4j
public class KafkaPublisher {
    @Autowired
    private MessagePublisher messagePublisher;
    @Autowired
    private OutboxRepository outboxRepository;

    @Scheduled(fixedRate = 30000)
    private void pollOutboxMessagesAndPublish(){
        List<OrderOutbox> orderOutboxesList = outboxRepository.findByProcessedFalse();
        log.info(" Total Number of Message to be Published {}",orderOutboxesList.size());
        for(OrderOutbox outbox : orderOutboxesList){
            messagePublisher.publishTopic(outbox.getPayLoad());
            outbox.setProcessed(true);
            outboxRepository.save(outbox);
        }
    }

}
