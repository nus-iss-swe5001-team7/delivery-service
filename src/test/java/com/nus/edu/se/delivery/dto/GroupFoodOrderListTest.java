package com.nus.edu.se.delivery.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GroupFoodOrderListTest {

    private GroupFoodOrderList groupFoodOrderList;

    @BeforeEach
    void setUp() {
        groupFoodOrderList = new GroupFoodOrderList();
    }

    @Test
    void testSetAndGetGroupFoodOrderId() {
        UUID groupFoodOrderId = UUID.randomUUID();
        groupFoodOrderList.setGroupFoodOrderId(groupFoodOrderId);
        assertEquals(groupFoodOrderId, groupFoodOrderList.getGroupFoodOrderId());
    }

    @Test
    void testSetAndGetDeliveryTime() {
        Date deliveryTime = new Date();
        groupFoodOrderList.setDeliveryTime(deliveryTime);
        assertEquals(deliveryTime, groupFoodOrderList.getDeliveryTime());
    }

    @Test
    void testSetAndGetOrderTime() {
        Date orderTime = new Date();
        groupFoodOrderList.setOrderTime(orderTime);
        assertEquals(orderTime, groupFoodOrderList.getOrderTime());
    }

    @Test
    void testSetAndGetOrderStatus() {
        String orderStatus = "DELIVERED";
        groupFoodOrderList.setOrderStatus(orderStatus);
        assertEquals(orderStatus, groupFoodOrderList.getOrderStatus());
    }

    @Test
    void testSetAndGetRestaurantName() {
        String restaurantName = "Tasty Food Place";
        groupFoodOrderList.setRestaurantName(restaurantName);
        assertEquals(restaurantName, groupFoodOrderList.getRestaurantName());
    }

    @Test
    void testSetAndGetRestaurantId() {
        String restaurantId = "12345";
        groupFoodOrderList.setRestaurantId(restaurantId);
        assertEquals(restaurantId, groupFoodOrderList.getRestaurantId());
    }

    @Test
    void testSetAndGetLocation() {
        String location = "City Center";
        groupFoodOrderList.setLocation(location);
        assertEquals(location, groupFoodOrderList.getLocation());
    }

    @Test
    void testSetAndGetRating() {
        String rating = "4.5";
        groupFoodOrderList.setRating(rating);
        assertEquals(rating, groupFoodOrderList.getRating());
    }

    @Test
    void testSetAndGetImgUrl() {
        String imgUrl = "http://example.com/image.jpg";
        groupFoodOrderList.setImgUrl(imgUrl);
        assertEquals(imgUrl, groupFoodOrderList.getImgUrl());
    }

    @Test
    void testSetAndGetDeliveryLocation() {
        String deliveryLocation = "123 Main Street";
        groupFoodOrderList.setDeliveryLocation(deliveryLocation);
        assertEquals(deliveryLocation, groupFoodOrderList.getDeliveryLocation());
    }

    @Test
    void testSetAndGetDeliveryAddress() {
        String deliveryAddress = "123 Main Street, Suite 5";
        groupFoodOrderList.setDeliveryAddress(deliveryAddress);
        assertEquals(deliveryAddress, groupFoodOrderList.getDeliveryAddress());
    }

    @Test
    void testSetAndGetDeliveryLatitude() {
        String deliveryLatitude = "12.3456";
        groupFoodOrderList.setDeliveryLatitude(deliveryLatitude);
        assertEquals(deliveryLatitude, groupFoodOrderList.getDeliveryLatitude());
    }

    @Test
    void testSetAndGetDeliveryLongitude() {
        String deliveryLongitude = "65.4321";
        groupFoodOrderList.setDeliveryLongitude(deliveryLongitude);
        assertEquals(deliveryLongitude, groupFoodOrderList.getDeliveryLongitude());
    }

    @Test
    void testSetAndGetRestaurantAddress() {
        String restaurantAddress = "456 Elm Street";
        groupFoodOrderList.setRestaurantAddress(restaurantAddress);
        assertEquals(restaurantAddress, groupFoodOrderList.getRestaurantAddress());
    }

    @Test
    void testSetAndGetRestaurantLatitude() {
        String restaurantLatitude = "78.9101";
        groupFoodOrderList.setRestaurantLatitude(restaurantLatitude);
        assertEquals(restaurantLatitude, groupFoodOrderList.getRestaurantLatitude());
    }

    @Test
    void testSetAndGetRestaurantLongitude() {
        String restaurantLongitude = "21.3456";
        groupFoodOrderList.setRestaurantLongitude(restaurantLongitude);
        assertEquals(restaurantLongitude, groupFoodOrderList.getRestaurantLongitude());
    }
}
