package com.assignment.GasStationProducer.repository;

import com.assignment.GasStationProducer.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Integer> {
    //after creating this class -> go to the orderService class
}
