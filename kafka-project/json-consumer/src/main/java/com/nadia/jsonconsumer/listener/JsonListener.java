package com.nadia.jsonconsumer.listener;

import com.nadia.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
@Log4j2
public class JsonListener {
    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) {

        log.info("I received the payment {}", payment.toString());
        sleep(1000);

        log.info("Validating fraud...");
        sleep(2000);

        log.info("Purchase Approved");
        sleep(3000);
    }
    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGeneretor(@Payload Payment payment) {
        log.info("Generating pdf do produto de id {}...", payment.getId());
        sleep(4000);

    }
    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail() {
        log.info("Sending confirmation email...");
        sleep(5000);

    }
}
