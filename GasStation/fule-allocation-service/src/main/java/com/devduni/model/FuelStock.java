package com.devduni.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fuelStock")
public class FuelStock {

    @Id
    private int stockId;
    private FuelType fuelType;
    private double availableStockQty;

    public FuelStock(){

    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public double getAvailableStockQty() {
        return availableStockQty;
    }

    public void setAvailableStockQty(double availableStockQty) {
        this.availableStockQty = availableStockQty;
    }
}
