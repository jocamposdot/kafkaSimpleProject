package com.jrcofuhr.kafkaconsumerone.service;

import com.jrcofuhr.kafkaconsumerone.record.OrderRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    // @KafkaListener(topics = "jrcofuhr-order-processed", containerFactory = "orderKafkaListenerContainerFactory")
    @KafkaListener(topicPartitions = @TopicPartition(topic = "jrcofuhr-order-processed", partitions = { "0" }), containerFactory = "orderKafkaListenerContainerFactory")
    public void orderListener(OrderRecord order) {
        System.out.println("Received Message Consumer 01: " + order.name());
    }
}
