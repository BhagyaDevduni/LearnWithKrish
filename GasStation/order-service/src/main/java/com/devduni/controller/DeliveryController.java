package com.devduni.controller;

import com.devduni.model.OrderStatus;
import com.devduni.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
   private OrderStatusService statusService;

    @GetMapping("/getDelivery")
    public OrderStatus deliverOrder(@RequestParam("id") int id){
        return statusService.updateDeliveryStatus(id);
    }
}
