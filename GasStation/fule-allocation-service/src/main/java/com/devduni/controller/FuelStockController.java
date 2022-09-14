package com.devduni.controller;


import com.devduni.model.FuelStock;
import com.devduni.model.FuelStockModel;
import com.devduni.service.AllocationService;
import com.devduni.service.FuelStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class FuelStockController {

    @Autowired
    private FuelStockService fuelStockService;

    @Autowired
    private AllocationService allocationService;

    @GetMapping("/all")
    public List<FuelStockModel> getAvailableStock() {
        List<FuelStockModel> fuelStockList = new ArrayList<>();
        List<FuelStock> fuelStock = fuelStockService.getAvailableFuelStock();

        for (FuelStock stock : fuelStock )  {
            FuelStockModel stockModel = new FuelStockModel();
            stockModel.setStockId(stock.getStockId());
            stockModel.setFuelType(stock.getFuelType());
            stockModel.setStockQty(stock.getStockQty());
            fuelStockList.add(stockModel);
        }
        return fuelStockList;
    }
}
