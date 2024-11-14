package com.nus.edu.se.delivery.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GroupFoodOrderTest {

    private GroupFoodOrder groupFoodOrder;

    @BeforeEach
    void setUp() {
        groupFoodOrder = new GroupFoodOrder();
    }

    @Test
    void testSetAndGetId() {
        UUID id = UUID.randomUUID();
        groupFoodOrder.setId(id);
        assertEquals(id, groupFoodOrder.getId());
    }

    @Test
    void testSetAndGetGroupOrderCreateTime() {
        Date createTime = new Date();
        groupFoodOrder.setGroupOrderCreateTime(createTime);
        assertEquals(createTime, groupFoodOrder.getGroupOrderCreateTime());
    }

    @Test
    void testSetAndGetGroupOrderDeliveryTime() {
        Date deliveryTime = new Date();
        groupFoodOrder.setGroupOrderDeliveryTime(deliveryTime);
        assertEquals(deliveryTime, groupFoodOrder.getGroupOrderDeliveryTime());
    }

    @Test
    void testSetAndGetDeliveryLocation() {
        String deliveryLocation = "123 Main Street";
        groupFoodOrder.setDeliveryLocation(deliveryLocation);
        assertEquals(deliveryLocation, groupFoodOrder.getDeliveryLocation());
    }

    @Test
    void testSetAndGetDeliveryFee() {
        float deliveryFee = 5.99f;
        groupFoodOrder.setDeliveryFee(deliveryFee);
        assertEquals(deliveryFee, groupFoodOrder.getDeliveryFee());
    }

    @Test
    void testSetAndGetStatus() {
        StatusEnum status = StatusEnum.READY_FOR_DELIVERY;
        groupFoodOrder.setStatus(status);
        assertEquals(status, groupFoodOrder.getStatus());
    }

    @Test
    void testDefaultStatus() {
        assertEquals(StatusEnum.PENDING_USER_JOIN, groupFoodOrder.getStatus());
    }
}
