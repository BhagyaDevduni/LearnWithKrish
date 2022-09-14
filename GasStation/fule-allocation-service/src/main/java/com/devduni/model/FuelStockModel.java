package com.devduni.model;

import lombok.Data;

@Data
public class FuelStockModel {

    private int stockId;
    private FuelType fuelType;
    private double StockQty;

}
