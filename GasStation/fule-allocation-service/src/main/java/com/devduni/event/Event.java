package com.devduni.event;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Event {


   private String name;
    private String status;
    private String orderId;
    private String stockId;
    private  String key;;
    private String qty;
    private  String result;
}
