package com.devduni.event;

import lombok.Data;

@Data
public class ScheduleEvent {

    private String name;
    private String orderId;
    private String stockId;
    private String status;
    private String key;
    ;
    private String result;
    private String qty;
    private String date;


}