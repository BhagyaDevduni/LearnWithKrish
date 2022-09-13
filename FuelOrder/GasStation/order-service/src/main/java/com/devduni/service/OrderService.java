package com.devduni.service;

import com.devduni.model.Order;
import com.devduni.model.OrderModel;
import com.devduni.model.OrderStatus;
import com.devduni.model.Schedule;
import com.devduni.repository.OrderRepository;
import com.devduni.repository.OrderStatusRepository;
import com.devduni.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatusRepository statusRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Order save(Order order){
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        List<Order> order= (List<Order>) orderRepository.findAll();
        return order;
    }

    public Optional<Order> findById(int id) {
        return orderRepository.findById(id);
    }


    public List<OrderModel> findByRegisterNo(String id) {

        List<Order> order = orderRepository.findAll();
        List<OrderStatus> status = statusRepository.findAll();
        List<Schedule> schedule = scheduleRepository.findAll();
        List<OrderModel> model = new ArrayList<>();

        for (Order ordr : order) {
            for (OrderStatus sts : status) {
                for (Schedule schdl : schedule) {
                    if (ordr.getRegisterNo().equals(id)) {
                        if (ordr.getOrderId() == sts.getOrderId() && ordr.getOrderId() == schdl.getOrderId()) {

                            OrderModel orderModel = new OrderModel();
                            orderModel.setOrderId(ordr.getOrderId());
                            orderModel.setRegisterNo(ordr.getRegisterNo());
                            orderModel.setFuelType(ordr.getFuelType());
                            orderModel.setQty(ordr.getQty());
                            orderModel.setScheduleDate(ordr.getScheduleDate());
                            orderModel.setAllocation(sts.getAllocationStatus());
                            orderModel.setSchedule(sts.getScheduleStatus());
                            orderModel.setDispatch(sts.getDispatchStatus());
                            model.add(orderModel );
                        }
                    }
                }
            }

        }
        return model;
    }

    public List<OrderModel> findDispatchOrders() {

        List<Order> order = orderRepository.findAll();
        List<OrderStatus> status = statusRepository.findAll();
        List<Schedule> schedule = scheduleRepository.findAll();
        List<OrderModel> model = new ArrayList<>();

        for (Order ordr : order) {
            for (OrderStatus sts : status) {
                for (Schedule schdl : schedule) {
                        if (ordr.getOrderId() == sts.getOrderId() && ordr.getOrderId() == schdl.getOrderId()) {
                            OrderModel orderModel = new OrderModel();

                            orderModel.setOrderId(ordr.getOrderId());
                            orderModel.setRegisterNo(ordr.getRegisterNo());
                            orderModel.setFuelType(ordr.getFuelType());
                            orderModel.setQty(ordr.getQty());
                            orderModel.setScheduleDate(ordr.getScheduleDate());
                            orderModel.setAllocation(sts.getAllocationStatus());
                            orderModel.setSchedule(sts.getScheduleStatus());
                            orderModel.setDeliver(sts.getDeliverStatus());
                            model.add(orderModel );
                        }

                }
            }

        }
        return model;
    }

    public List<OrderModel> findDeliver() {

        List<Order> order = orderRepository.findAll();
        List<OrderStatus> status = statusRepository.findAll();
        List<Schedule> schedule = scheduleRepository.findAll();
        List<OrderModel> model = new ArrayList<>();

        for (Order ordr : order) {
            for (OrderStatus sts : status) {
                for (Schedule schdl : schedule) {
                    if (ordr.getOrderId() == sts.getOrderId() && ordr.getOrderId() == schdl.getOrderId() && sts.getDeliverStatus().equals("SUCCESS")) {
                        OrderModel orderModel = new OrderModel();

                        orderModel.setOrderId(ordr.getOrderId());
                        orderModel.setRegisterNo(ordr.getRegisterNo());
                        orderModel.setFuelType(ordr.getFuelType());
                        orderModel.setQty(ordr.getQty());
                        orderModel.setScheduleDate(ordr.getScheduleDate());
                        orderModel.setAllocation(sts.getAllocationStatus());
                        orderModel.setSchedule(sts.getScheduleStatus());
                        orderModel.setDeliver(sts.getDeliverStatus());
                        model.add(orderModel );
                    }

                }
            }

        }
        return model;
    }


}
