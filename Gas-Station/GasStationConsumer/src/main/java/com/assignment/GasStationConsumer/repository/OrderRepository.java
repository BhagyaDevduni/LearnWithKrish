package com.assignment.GasStationConsumer.repository;

import com.assignment.GasStationConsumer.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository  extends CrudRepository<Order,Integer> {
}
