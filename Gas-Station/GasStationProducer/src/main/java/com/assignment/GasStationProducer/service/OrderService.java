package com.assignment.GasStationProducer.service;





import com.assignment.GasStationProducer.entity.Order;
import com.assignment.GasStationProducer.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Value("${order.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper om=new ObjectMapper();

    public Order createOrder(Order order) {
        order =orderRepository.save(order);
        order.setStatus("ORDER");

        String message= null;
        try {
            message = om.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send(topicName,message);
        return order;
    }

    public List<Order> getAllOrders() {
        List<Order> orders= (List<Order>) orderRepository.findAll();
        return orders;
    }

}
