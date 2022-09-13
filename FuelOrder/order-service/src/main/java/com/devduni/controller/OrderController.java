package com.devduni.controller;


import com.devduni.model.Order;
import com.devduni.model.OrderModel;
import com.devduni.model.OrderStatus;
import com.devduni.service.OrderService;
import com.devduni.service.OrderStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderStatusService statusService;


    public Order save(@RequestBody Order order) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        order.setCurrentDate(formatter.format(date));
        order.setOrderId((int) (System.currentTimeMillis()));

        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderId(order.getOrderId());
        orderStatus.setAllocationStatus("PENDING");
        orderStatus.setScheduleStatus("PENDING");
        orderStatus.setDispatchStatus("PENDING");
        orderStatus.setDeliverStatus("PENDING");
        statusService.saveStatus(orderStatus);
        log.info("Successfully Saved");

        return orderService.save(order);

    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {

        return orderService.getAllOrders();
    }

    @GetMapping("/dispatchOrders")
    public List<OrderModel> getAllDispatchedOrders(){
        return orderService.findDispatchOrders();
    }

    @GetMapping("/orderById")
    public Optional<Order> getOrdersById(@RequestParam("id") int id){
        return orderService.findById(id);
    }

    @GetMapping("/deliveredOrders")
    public List<OrderModel> getDeliveredOrders(){
        log.info("find Delivered Orders");
        return orderService.findDeliver();
    }

    @GetMapping("/registerNo")
    public List<OrderModel> getOrdersByRegisterNo(@RequestParam("id") String id){

        return orderService.findByRegisterNo(id);
    }

}
