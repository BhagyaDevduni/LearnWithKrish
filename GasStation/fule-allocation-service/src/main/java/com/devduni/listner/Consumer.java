package com.devduni.listner;

import com.devduni.event.Event;
import com.devduni.model.Allocation;
import com.devduni.model.FuelStock;
import com.devduni.service.AllocationService;
import com.devduni.service.FuelStockService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class Consumer {


    @Autowired
    private AllocationService allocationService;

    @Autowired
    private FuelStockService stockService;

    @Autowired
    private Producer producer;

    @Autowired
    private ScheduleProducer scheduleProducer;

    @KafkaListener(topics = "Fuel-order", groupId = "FuelOrder-group")
    public void read(String message) {
        Event event = new Gson().fromJson(message, Event.class);
        if (event.getStatus().equals("Place-new-fuel-order")) {
            Optional<FuelStock> fuelStock = stockService.getFuelStock(Integer.parseInt(event.getStockId()));

            if (fuelStock.isPresent()) {
                double orderFuelQty = Double.parseDouble(event.getQty());
                double availableFuelQty = fuelStock.get().getAvailableStockQty();
                if (availableFuelQty >= orderFuelQty) {
                    if (availableFuelQty >= allocationService.allocatedFuelStock() + orderFuelQty) ;{

                        Allocation allocation = new Allocation();
                        allocation.setAllocationId(Integer.parseInt(event.getOrderId()));
                        allocation.setQty(Double.parseDouble(event.getQty()));
                        allocation.setStockId(event.getStockId());
                        allocationService.save(allocation);
                        log.info("Successfully saved");

                        producer.toTopic(new Event("Allocation_service", "complete_allocation", event.getOrderId(), event.getStockId(), event.getKey(), event.getQty(), "SUCCESSFUL"));
                        scheduleProducer.toTopic(new Event("Allocation_service", "Allocation_Complete", event.getOrderId(), event.getStockId(), event.getKey(), event.getQty(), "SUCCESSFUL"));
                    }
                } else {

                    log.info("No Stock Available");
                }
            }
        }

    }
}
