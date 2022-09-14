package com.devduni.controller;


import com.devduni.event.Event;
import com.devduni.listner.DispatchProducer;
import com.devduni.model.Allocation;
import com.devduni.model.Dispatch;
import com.devduni.model.FuelStock;
import com.devduni.service.AllocationService;
import com.devduni.service.DispatchService;
import com.devduni.service.FuelStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/dispatch")
@Transactional
public class DispatchController {

    @Autowired
    private DispatchService dispatchService;

    @Autowired
    private FuelStockService fuelStockService;

    @Autowired
    private AllocationService allocationService;

    @Autowired
    private DispatchProducer dispatchProducer;


    @PostMapping("/save")
    public Dispatch saveDispatch(@RequestBody Dispatch dispatch) {
        List<Allocation> allocation = allocationService.getAllAllocation();
        for (Allocation allocation1: allocation) {
            if (allocation1.getAllocationId() == dispatch.getOrderId()) {
               log.info("Invalid ID");

                Optional<FuelStock> fuelStockOptional = fuelStockService.getFuelStock(Integer.parseInt(allocation1.getStockId()));
                double physicalStock = fuelStockOptional.get().getAvailableStockQty();
                double dispatchStock = allocation1.getQty();
                double remainStock = physicalStock - dispatchStock;

                FuelStock update = new  FuelStock();
                update.setStockId(fuelStockOptional.get().getStockId());
                update.setFuelType(fuelStockOptional.get().getFuelType());
                update.setAvailableStockQty(remainStock);
                fuelStockService.save(update);

            }

        }
        return dispatchService.save(dispatch);
    }


    @PutMapping("/update")
    public Dispatch updateDispatch(@RequestBody Dispatch dispatch){
        List<Dispatch> list = dispatchService.getDispatch();
        Dispatch dispatches = new Dispatch();
        for (Dispatch dis : list) {
            if (dis.getOrderId() == dispatch.getOrderId()) {
                dispatches.setDispatchId(dis.getDispatchId());
                dispatches.setOrderId(dis.getOrderId());
                dispatches.setRegisterNo(dis.getRegisterNo());
                dispatches.setDispatchStatus("Received");
            }
        }
        return dispatchService.save(dispatch);
    }


    @GetMapping(value = "/all")
    public List<Dispatch> getAllDispatch() {
        return dispatchService.getDispatch();
    }
}
