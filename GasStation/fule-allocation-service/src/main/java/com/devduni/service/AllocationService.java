package com.devduni.service;

import com.devduni.model.Allocation;
import com.devduni.repository.AllocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationService {

    private AllocationRepository allocationRepository;


    public Allocation save(Allocation allocation){
        return allocationRepository.save(allocation);
    }

    public List<Allocation> getAllAllocation() {
        return allocationRepository.findAll();
    }

    public double allocatedFuelStock() {
        double allocateFuel = 0;
        List<Allocation> allocations =  allocationRepository.findAll();
        for (Allocation allocation: allocations){
            allocateFuel += allocation.getQty();
        }

        return allocateFuel;

    }

}
