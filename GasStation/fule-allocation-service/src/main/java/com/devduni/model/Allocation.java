package com.devduni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "allocation")
public class Allocation {

    @Id
    @GeneratedValue
    private int allocationId;
    //private int id;
    private double qty;
    private FuelType fuelType;
    private String stockId;
    private String status;

    public Allocation(){

    }

    public Allocation(int allocationId, double qty, FuelType fuelType, String stockId, String status) {
        this.allocationId = allocationId;
        this.qty = qty;
        this.fuelType = fuelType;
        this.stockId = stockId;
        this.status = status;
    }

    public int getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(int allocationId) {
        this.allocationId = allocationId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
