package com.nus.edu.se.delivery.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "group_food_orders")
public class GroupFoodOrder {

    @Id
    @UuidGenerator
    @Column(name = "group_food_order_id", nullable = false)
    private UUID id;

    @Column(name = "group_food_order_create_time", nullable = false)
    private Date groupOrderCreateTime;

    @Column(name = "group_food_order_delivery_time")
    private Date groupOrderDeliveryTime;

    @Column(name = "delivery_location")
    private String deliveryLocation;

    @Column(name = "delivery_fee", nullable = false)
    private float deliveryFee;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.PENDING_USER_JOIN;

    public GroupFoodOrder() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getGroupOrderCreateTime() {
        return groupOrderCreateTime;
    }

    public void setGroupOrderCreateTime(Date groupOrderCreateTime) {
        this.groupOrderCreateTime = groupOrderCreateTime;
    }

    public Date getGroupOrderDeliveryTime() {
        return groupOrderDeliveryTime;
    }

    public void setGroupOrderDeliveryTime(Date groupOrderDeliveryTime) {
        this.groupOrderDeliveryTime = groupOrderDeliveryTime;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public float getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(float deliveryFee) {
        this.deliveryFee = deliveryFee;
    }
}
