package com.nus.edu.se.delivery.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class GroupFoodOrderList {

    private UUID groupFoodOrderId;

    Date deliveryTime;

    Date orderTime;

    String orderStatus;

    String restaurantName;

    String restaurantId;

    private String location;

    private String restaurantAddress;

    private String restaurantLongitude;

    private String restaurantLLatitude;

    private String rating;

    private String imgUrl;

    private String deliveryLocation;

    private String deliveryAddress;

    private String deliveryLongitude;

    private String deliveryLatitude;

    public UUID getGroupFoodOrderId() {
        return groupFoodOrderId;
    }

    public void setGroupFoodOrderId(UUID groupFoodOrderId) {
        this.groupFoodOrderId = groupFoodOrderId;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRestaurantLongitude() {
        return restaurantLongitude;
    }

    public void setRestaurantLongitude(String longitude) {
        this.restaurantLongitude = restaurantLongitude;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }
//    private Date orderTime;
//    private String orderStatus;
//    private Restaurant restaurant;
//    private Delivery delivery;
//
//    @Data
//    public static class Restaurant {
//        private String name;
//        private String id;
//        private int rating;
//        private String imgUrl;
//        private String address;
//        private double latitude;
//        private double longitude;
//        private String area;
//        private Date pickupTime;
//    }
//
//    @Data
//    public static class Delivery {
//        private String location;
//        private String address;
//        private double latitude;
//        private double longitude;
//        private Date deliveryTime;
//    }
}
