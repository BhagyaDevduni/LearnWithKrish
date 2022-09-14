package com.devduni.repository;

import com.devduni.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation,Integer> {
}
