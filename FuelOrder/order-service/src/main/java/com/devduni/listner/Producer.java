package com.devduni.listner;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.awt.*;

@Slf4j
public class Producer {

    public static final String topic = "Fuel Order";
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void topic(Event message) {
        log.info("topic " + topic);
        Gson gson=new Gson();
        String newMessage=gson.toJson(message);
        this.kafkaTemplate.send(topic, newMessage);

    }

}
