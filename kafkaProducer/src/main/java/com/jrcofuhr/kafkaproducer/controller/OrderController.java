package com.jrcofuhr.kafkaproducer.controller;

import com.jrcofuhr.kafkaproducer.record.OrderRecord;
import com.jrcofuhr.kafkaproducer.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    
    public final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
   
    @PostMapping
    public void createOrder(@RequestBody OrderRecord order) {
        orderService.sendMessageOrder(order);
    }
}
