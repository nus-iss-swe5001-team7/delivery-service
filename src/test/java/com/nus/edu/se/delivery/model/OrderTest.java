package com.nus.edu.se.delivery.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @Test
    void testSetAndGetId() {
        UUID id = UUID.randomUUID();
        order.setId(id);
        assertEquals(id, order.getId());
    }

    @Test
    void testSetAndGetUserId() {
        UUID userId = UUID.randomUUID();
        order.setUserId(userId);
        assertEquals(userId, order.getUserId());
    }

    @Test
    void testSetAndGetRestaurantId() {
        String restaurantId = "12345";
        order.setRestaurantId(restaurantId);
        assertEquals(restaurantId, order.getRestaurantId());
    }

    @Test
    void testSetAndGetGroupFoodOrder() {
        GroupFoodOrder groupFoodOrder = new GroupFoodOrder();
        groupFoodOrder.setId(UUID.randomUUID());
        order.setGroupFoodOrder(groupFoodOrder);
        assertEquals(groupFoodOrder, order.getGroupFoodOrder());
    }

    @Test
    void testSetAndGetCreatedTime() {
        Date createdTime = new Date();
        order.setCreatedTime(createdTime);
        assertEquals(createdTime, order.getCreatedTime());
    }

    @Test
    void testSetAndGetDeliveryFee() {
        float deliveryFee = 10.99f;
        order.setDeliveryFee(deliveryFee);
        assertEquals(deliveryFee, order.getDeliveryFee());
    }

    @Test
    void testSetAndGetPaymentStatus() {
        order.setPaymentStatus(Order.PaymentStatus.COMPLETED);
        assertEquals(Order.PaymentStatus.COMPLETED, order.getPaymentStatus());
    }

    @Test
    void testDefaultPaymentStatus() {
        assertEquals(Order.PaymentStatus.PENDING, order.getPaymentStatus());
    }
}
