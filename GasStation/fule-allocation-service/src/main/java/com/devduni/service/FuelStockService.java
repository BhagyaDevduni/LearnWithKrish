package com.devduni.service;

import com.devduni.model.FuelStock;
import com.devduni.repository.FuelStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuelStockService {

    @Autowired
    private FuelStockRepository fuelStockRepository;


    public FuelStock save(FuelStock fuelStock) {
        return fuelStockRepository.save(fuelStock);
    }


    public List<FuelStock> getAvailableFuelStock() {
        return fuelStockRepository.findAll();
    }


    public Optional<FuelStock> getFuelStock(int id) {

        return fuelStockRepository.findById(id);
    }

}
