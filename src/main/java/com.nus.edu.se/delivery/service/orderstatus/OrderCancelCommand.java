package com.nus.edu.se.delivery.service.orderstatus;

import com.nus.edu.se.delivery.model.StatusEnum;
import com.nus.edu.se.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderCancelCommand implements OrderStatusCommandInterface {

    @Autowired
    private final DeliveryService deliveryService;

    public OrderCancelCommand(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Override
    public void execute(String orderId) {
        if (orderId == null) {
            throw new NullPointerException("Order ID cannot be null");
        }
        deliveryService.updateStatus(orderId, StatusEnum.ORDER_CANCEL);
    }
}

