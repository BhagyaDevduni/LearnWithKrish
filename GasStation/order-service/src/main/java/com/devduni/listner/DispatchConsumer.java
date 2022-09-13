package com.devduni.listner;

import com.devduni.event.OrderEvent;
import com.devduni.model.OrderStatus;
import com.devduni.service.OrderStatusService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DispatchConsumer {

    @Autowired
    OrderStatusService statusService;

    @KafkaListener(topics = "Connection", groupId = "fuelOrder-group")
    public void message(String message){
        OrderEvent orderEvent=new Gson().fromJson(message, OrderEvent.class);

        if(orderEvent.getName().equals("Dispatch") && orderEvent.getStatus().equals("Dispatch Complete") && orderEvent.getResult().equals("SUCCESSFUL")) {
            List<OrderStatus> list = statusService.getAllStatus();
            for (OrderStatus sts : list) {
                if (sts.getOrderId() == Integer.parseInt(orderEvent.getOrderId())) {
                    OrderStatus orderStatus = new OrderStatus();
                    orderStatus.setOrderStatusId(sts.getOrderStatusId());
                    orderStatus.setOrderId(sts.getOrderId());
                    orderStatus.setAllocationStatus(sts.getAllocationStatus());
                    orderStatus.setScheduleStatus(sts.getScheduleStatus());
                    orderStatus.setDispatchStatus(orderEvent.getResult());
                    orderStatus.setDeliverStatus(sts.getDeliverStatus());
                    statusService.saveStatus(orderStatus);
                }

            }
        }
    }
}
