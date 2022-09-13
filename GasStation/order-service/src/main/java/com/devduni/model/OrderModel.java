package com.devduni.model;

public class OrderModel {

    private int orderId;
    private String registerNo;
    private FuelType fuelType;
    private int qty;
    private String scheduleDate;
    private String allocation;
    private String schedule;
    private String dispatch;
    private String deliver;

    public OrderModel() {

    }

    public OrderModel(int orderId, String registerNo, FuelType fuelType, int qty, String scheduleDate, String allocation, String schedule, String dispatch, String deliver) {
        this.orderId = orderId;
        this.registerNo = registerNo;
        this.fuelType = fuelType;
        this.qty = qty;
        this.scheduleDate = scheduleDate;
        this.allocation = allocation;
        this.schedule = schedule;
        this.dispatch = dispatch;
        this.deliver = deliver;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getAllocation() {
        return allocation;
    }

    public void setAllocation(String allocation) {
        this.allocation = allocation;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDispatch() {
        return dispatch;
    }

    public void setDispatch(String dispatch) {
        this.dispatch = dispatch;
    }

    public String getDeliver() {
        return deliver;
    }

    public void setDeliver(String deliver) {
        this.deliver = deliver;
    }
}
