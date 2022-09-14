package com.devduni.event;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Event {


    private String name;
    private String orderId;
    private String stockId;
    private String status;
    private  String key;;
    private  String result;
    private String qty;
}
