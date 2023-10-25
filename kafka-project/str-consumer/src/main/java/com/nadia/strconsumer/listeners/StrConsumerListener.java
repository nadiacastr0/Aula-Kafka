package com.nadia.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Log4j2
@Component
public class StrConsumerListener {

    @KafkaListener(groupId = "group-1", topics = "topic", containerFactory = "strContainerFactory")
    public void create(String message) {
        log.info("CREATE ::: Receive message {}", message);
    }
}
