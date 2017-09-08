package com.models;


import com.models.enums.OrderStatus;
import com.models.enums.PreparationStage;
import com.sunmi.trans.TransBean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order extends TransBean{

    private Long id;
    private String code;
    private Courier courier;
    private OrderStatus currentStatus;
    private Customer customer;
    private Address deliveryAddress;
    private String description;
    private List<String> incidents;
    private boolean mcd;
    private Date pickupTime;
    private PreparationStage preparationStage;
    private Float productsTotal;
    private String scheduledTime;
    private int size;
    private String storageTrackingTime;
    private static final SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy H:m:s");


    public Order(String code, Courier courier, OrderStatus currentStatus,
                 Customer customer, Address deliveryAddress, String description,
                 Long id, List<String> incidents, boolean mcd, Timestamp pickupTime,
                 PreparationStage preparationStage, Float productsTotal,
                 String scheduledTime, int size, String storageTrackingTime
    ) {
        this.code = code;
        this.courier = courier;
        this.currentStatus = currentStatus;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.description = description;
        this.id = id;
        this.incidents = incidents;
        this.mcd = mcd;
        this.pickupTime = pickupTime;
        this.preparationStage = preparationStage;
        this.productsTotal = productsTotal;
        this.scheduledTime = scheduledTime;
        this.size = size;
        this.storageTrackingTime = storageTrackingTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public OrderStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(OrderStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<String> incidents) {
        this.incidents = incidents;
    }

    public boolean isMcd() {
        return mcd;
    }

    public void setMcd(boolean mcd) {
        this.mcd = mcd;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public String getPickupTimeAsstring() {
        return dateFormater.format(pickupTime);
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public PreparationStage getPreparationStage() {
        return preparationStage;
    }

    public void setPreparationStage(PreparationStage preparationStage) {
        this.preparationStage = preparationStage;
    }

    public Float getProductsTotal() {
        return productsTotal;
    }

    public void setProductsTotal(Float productsTotal) {
        this.productsTotal = productsTotal;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getStorageTrackingTime() {
        return storageTrackingTime;
    }

    public void setStorageTrackingTime(String storageTrackingTime) {
        this.storageTrackingTime = storageTrackingTime;
    }






}
