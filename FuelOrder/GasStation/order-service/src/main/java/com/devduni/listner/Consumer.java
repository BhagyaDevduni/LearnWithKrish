package com.devduni.listner;

import com.devduni.event.OrderEvent;
import com.devduni.model.OrderStatus;
import com.devduni.service.OrderStatusService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;


public class Consumer {


    @Autowired
    private OrderStatusService statusService;

    @Autowired
    private Producer producer;

    @KafkaListener(topics = "FuelOrder-response", groupId = "FuelOrder-group")
    public void message(String message) {
        OrderEvent orderEvent = new Gson().fromJson(message, OrderEvent.class);
        if(orderEvent.getName().equals("Allocation Service") && orderEvent.getStatus().equals("Allocation Complete")){
            if(orderEvent.getResult().equals("SUCCESSFUL")){
                List<OrderStatus> list=statusService.getAllStatus();
                for(OrderStatus sts :list){
                    if(sts.getOrderId()==Integer.parseInt(orderEvent.getOrderId())){
                        OrderStatus orderStatus=new OrderStatus();
                        orderStatus.setOrderStatusId(sts.getOrderStatusId());
                        orderStatus.setOrderId(sts.getOrderId());
                        orderStatus.setAllocationStatus("SUCCESSFUL");
                        orderStatus.setDispatchStatus(sts.getDispatchStatus());
                        orderStatus.setScheduleStatus(sts.getScheduleStatus());
                        orderStatus.setDeliverStatus(sts.getDeliverStatus());

                        statusService.saveStatus(orderStatus);
                    }
                }
            }

        }

    }
}
