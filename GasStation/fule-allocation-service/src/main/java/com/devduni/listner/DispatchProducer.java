package com.devduni.listner;

import com.devduni.event.Event;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class DispatchProducer {

    public static final String topic = "Connection";
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void toTopic(Event message) {
        System.out.println("dispatch order:" + topic);
        Gson gson=new Gson();
        String newMessage=gson.toJson(message);
        this.kafkaTemplate.send(topic, newMessage);

    }
}
