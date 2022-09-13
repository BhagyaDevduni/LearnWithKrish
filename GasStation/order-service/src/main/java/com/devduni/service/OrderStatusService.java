package com.devduni.service;

import com.devduni.model.OrderStatus;
import com.devduni.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusService {

    @Autowired
    OrderStatusRepository statusRepository;

    public OrderStatus saveStatus(OrderStatus orderStatus) {
        return statusRepository.save(orderStatus);
    }


    public List<OrderStatus> getAllStatus()  {
        List<OrderStatus> orderStatus = (List<OrderStatus>) statusRepository.findAll();
        return orderStatus;
    }

    public OrderStatus findById(int id) {
        List<OrderStatus> list = statusRepository.findAll();
        OrderStatus orderStatus = new OrderStatus();
        for (OrderStatus sts : list) {
            if (sts.getOrderId() == id) {
                orderStatus.setOrderStatusId(sts.getOrderStatusId());
                orderStatus.setOrderId(sts.getOrderId());
                orderStatus.setScheduleStatus(sts.getScheduleStatus());
                orderStatus.setAllocationStatus(sts.getAllocationStatus());
                orderStatus.setDispatchStatus(sts.getDispatchStatus());
                orderStatus.setDeliverStatus(sts.getDeliverStatus());

            }
        }
        return orderStatus;
    }

    public OrderStatus updateDeliveryStatus(int id) {

        OrderStatus orderStatus=new OrderStatus();
        OrderStatus orderStatus1=null;
        List<OrderStatus> list=statusRepository.findAll();
        for(OrderStatus sts:list){
            if(sts.getOrderId()==id){
                orderStatus.setOrderStatusId(sts.getOrderStatusId());
                orderStatus.setAllocationStatus(sts.getAllocationStatus());
                orderStatus.setScheduleStatus(sts.getScheduleStatus());
                orderStatus.setDispatchStatus(sts.getDispatchStatus());
                orderStatus.setDeliverStatus("SUCCESSFUL");
                orderStatus1 = statusRepository.save(orderStatus);
            }
        }
        return orderStatus1;
    }
}
