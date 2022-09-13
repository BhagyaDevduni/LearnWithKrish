package com.assignment.GasStationProducer.controller;

import com.assignment.GasStationProducer.entity.Allocation;
import com.assignment.GasStationProducer.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/allocation")
public class AllocationController {
    @Autowired
    AllocationRepository allocationRepository;

    @GetMapping("/all")
    public List<Allocation> getAllAllocations() {
        List<Allocation> allocations = (List<Allocation>) allocationRepository.findAll();
        return allocations;
    }

    @PostMapping("/save")
    public Allocation saveUser(@RequestBody Allocation allocation) {
        allocation = allocationRepository.save(allocation);
        return allocation;
    }
}
