package com.jrcofuhr.kafkaconsumertwo.service;

import com.jrcofuhr.kafkaconsumertwo.record.OrderRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    // @KafkaListener(topics = "jrcofuhr-order-processed", containerFactory = "orderKafkaListenerContainerFactory")
    @KafkaListener(topicPartitions = @TopicPartition(topic = "jrcofuhr-order-processed", partitions = { "1" }), containerFactory = "orderKafkaListenerContainerFactory")
    public void orderListener(OrderRecord order) {
        System.out.println("Received Message Consumer 02: " + order.name());
    }
}
