package com.assignment.GasStationConsumer.listener;

import com.assignment.GasStationConsumer.entity.Allocation;
import com.assignment.GasStationConsumer.entity.Order;
import com.assignment.GasStationConsumer.repository.AllocationRepository;
import com.assignment.GasStationConsumer.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderNotificationListener {
    @Value("${order.topic.name}")
    private String topicName;

    ObjectMapper objectMapper =new ObjectMapper();
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    AllocationRepository allocationRepository;

    @KafkaListener(topics="GasOrder-topic", groupId = "groupId")
    public void processOrder(String message){
        System.out.println("Received Message" + message);
        Allocation allocation = null;
       // try {
            //Order order=  objectMapper.readValue(message , Order.class);
           // allocation = objectMapper.readValue(message, Allocation.class);
           // Allocation allocation = allocationRepository.findById(order.getRegisterNo()).get();
           // if(allocation.getBalance()>order.getOrderAmount()){
               // order.setStatus("SUCCESS");
                //allocation.setBalance(allocation.getBalance()-order.getOrderAmount());
               // allocationRepository.save(allocation);
           // }

            //orderRepository.save(order);   //save the order
      //  } catch (JsonProcessingException e) {
           // throw new RuntimeException(e);
       // }

        try {
            allocation = objectMapper.readValue(message, Allocation.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Order order=orderRepository.findById(allocation.getRegisterNo()).get();
        if (order.getOrderAmount() < allocation.getBalance()) {
            order.setOrderAmount(allocation.getBalance() - order.getOrderAmount() );
            allocation.setStatus("ALLOCATION SUCCESS");
            orderRepository.save(order);
            allocationRepository.save(allocation);
        } else {
            allocation.setStatus("ALLOCATION FAILED");
            allocationRepository.save(allocation);

        }


    }
}
