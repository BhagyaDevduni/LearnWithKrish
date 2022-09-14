package com.devduni.repository;

import com.devduni.model.FuelStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelStockRepository extends JpaRepository<FuelStock,Integer> {
}
