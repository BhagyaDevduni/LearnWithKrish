package com.assignment.GasStationProducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@EnableConfigurationProperties
public class GasStationProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GasStationProducerApplication.class, args);
	}

}
