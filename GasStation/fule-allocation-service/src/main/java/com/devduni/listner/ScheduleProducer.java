package com.devduni.listner;

import com.devduni.event.Event;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ScheduleProducer {

    public static final String topic = "fuel order";
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void toTopic(Event message) {
        System.out.println("to schedule" + topic);
        Gson gson=new Gson();
        String newMessage=gson.toJson(message);
        this.kafkaTemplate.send(topic, newMessage);

    }
}