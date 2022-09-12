package com.assignment.GasStationConsumer.repository;

import com.assignment.GasStationConsumer.entity.Allocation;
import com.assignment.GasStationConsumer.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface AllocationRepository extends CrudRepository<Allocation,Integer> {
}
