package com.jrcofuhr.kafkaproducer.service;

import com.jrcofuhr.kafkaproducer.record.OrderRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OrderService {

    private final KafkaTemplate<String, OrderRecord> kafkaTemplateOrder;

    private final Random random = new Random();

    public OrderService(KafkaTemplate<String, OrderRecord> kafkaTemplateOrder) {
        this.kafkaTemplateOrder = kafkaTemplateOrder;
    }

    @SuppressWarnings("null")
    public void sendMessageOrder(OrderRecord order) {
        int partition = random.nextInt(2);
        System.out.println("Sent message to partition: " + partition);
        System.out.println("Sending Order: " + order.name());
        kafkaTemplateOrder.send("jrcofuhr-order-processed",partition, null, order);
    }

}
