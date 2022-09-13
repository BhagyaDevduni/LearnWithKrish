package com.devduni.listner;

import com.devduni.event.ScheduleEvent;
import com.devduni.model.Order;
import com.devduni.model.OrderStatus;
import com.devduni.model.Schedule;
import com.devduni.service.OrderService;
import com.devduni.service.OrderStatusService;
import com.devduni.service.ScheduleService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleConsumer {

    @Autowired
    private OrderStatusService statusService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ScheduleService scheduleService;

    @KafkaListener(topics = "schedule-response", groupId = "FuelOrder-group")
    public void message(String message) {
        ScheduleEvent scheduleEvent = new Gson().fromJson(message, ScheduleEvent.class);

        if (scheduleEvent.getName().equals("Schedule Service") && scheduleEvent.getStatus().equals("Schedule Complete") && scheduleEvent.getResult().equals("SUCCESSFUL")) {

            List<OrderStatus> list=statusService.getAllStatus();
            List<Order> orderList= orderService.getAllOrders();
            for(OrderStatus sts :list){
                if(sts.getOrderId()==Integer.parseInt(scheduleEvent.getOrderId())){
                    OrderStatus orderStatus=new OrderStatus();
                    orderStatus.setOrderStatusId(sts.getOrderStatusId());
                    orderStatus.setOrderId(sts.getOrderId());
                    orderStatus.setAllocationStatus(scheduleEvent.getResult());
                    orderStatus.setDispatchStatus(sts.getDispatchStatus());
                    orderStatus.setScheduleStatus("SUCCESSFUL");

                    statusService.saveStatus(orderStatus);
                }
            }

            Schedule schedule = new Schedule();
            schedule.setOrderId(Integer.parseInt(scheduleEvent.getOrderId()));
            schedule.setDate(scheduleEvent.getDate());
            scheduleService.save(schedule);

        }

    }
}

