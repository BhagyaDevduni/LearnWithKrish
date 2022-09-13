package com.devduni.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_status")
public class OrderStatus {

    @Id
    @GeneratedValue
    private int OrderStatusId;
    private int orderId;
    private String allocationStatus;
    private String scheduleStatus;
    private String dispatchStatus;
    private String deliverStatus;

    public OrderStatus(){

    }

    public int getOrderStatusId() {
        return OrderStatusId;
    }

    public OrderStatus(int orderStatusId, int orderId, String allocationStatus, String scheduleStatus, String dispatchStatus, String deliverStatus) {
        OrderStatusId = orderStatusId;
        this.orderId = orderId;
        this.allocationStatus = allocationStatus;
        this.scheduleStatus = scheduleStatus;
        this.dispatchStatus = dispatchStatus;
        this.deliverStatus = deliverStatus;
    }

    public void setOrderStatusId(int orderStatusId) {
        OrderStatusId = orderStatusId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getAllocationStatus() {
        return allocationStatus;
    }

    public void setAllocationStatus(String allocationStatus) {
        this.allocationStatus = allocationStatus;
    }

    public String getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(String scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }

    public String getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(String deliverStatus) {
        this.deliverStatus = deliverStatus;
    }
}
