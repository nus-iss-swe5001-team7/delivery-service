package com.nus.edu.se.notification;

import com.nus.edu.se.delivery.model.GroupFoodOrder;
import com.nus.edu.se.delivery.model.StatusEnum;
import com.nus.edu.se.delivery.dao.OrderRepository;
import com.nus.edu.se.delivery.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NotificationServiceTest {

    @InjectMocks
    private NotificationService notificationService;

    @Mock
    private NotificationInterface notificationInterface;

    @Mock
    private OrderRepository orderRepository;

    private GroupFoodOrder groupFoodOrder;
    private Order order1;
    private Order order2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        groupFoodOrder = new GroupFoodOrder();
        groupFoodOrder.setId(UUID.randomUUID());

        order1 = new Order();
        order1.setId(UUID.randomUUID());
        order1.setUserId(UUID.randomUUID());

        order2 = new Order();
        order2.setId(UUID.randomUUID());
        order2.setUserId(UUID.randomUUID());
    }

    @Test
    void testSendNotification_Success() {
        // Mock the repository to return orders for the group food order
        when(orderRepository.findOrderByGroupFoodOrderOrderByCreatedTimeAsc(groupFoodOrder))
                .thenReturn(Arrays.asList(order1, order2));

        // Mock the notification interface to return a successful response
        when(notificationInterface.publish(any(MessageRequest.class)))
                .thenReturn(new ResponseEntity<>("Notification Sent", HttpStatus.OK));

        // Call the method to test
        notificationService.sendNotification(groupFoodOrder, StatusEnum.DELIVERED);

        // Verify interactions and behavior
        verify(orderRepository, times(1)).findOrderByGroupFoodOrderOrderByCreatedTimeAsc(groupFoodOrder);
        verify(notificationInterface, times(2)).publish(any(MessageRequest.class));
    }

    @Test
    void testSendNotification_PartialSuccess() {
        // Mock the repository to return orders for the group food order
        when(orderRepository.findOrderByGroupFoodOrderOrderByCreatedTimeAsc(groupFoodOrder))
                .thenReturn(Arrays.asList(order1, order2));

        // Mock the notification interface to return a successful response for one order and a failure for another
        when(notificationInterface.publish(any(MessageRequest.class)))
                .thenReturn(new ResponseEntity<>("Notification Sent", HttpStatus.OK))
                .thenReturn(new ResponseEntity<>("Notification Failed", HttpStatus.INTERNAL_SERVER_ERROR));

        // Call the method to test
        notificationService.sendNotification(groupFoodOrder, StatusEnum.DELIVERED);

        // Verify interactions and behavior
        verify(orderRepository, times(1)).findOrderByGroupFoodOrderOrderByCreatedTimeAsc(groupFoodOrder);
        verify(notificationInterface, times(2)).publish(any(MessageRequest.class));
    }

    @Test
    void testSendNotification_NoOrders() {
        // Mock the repository to return an empty list
        when(orderRepository.findOrderByGroupFoodOrderOrderByCreatedTimeAsc(groupFoodOrder))
                .thenReturn(Arrays.asList());

        // Call the method to test
        notificationService.sendNotification(groupFoodOrder, StatusEnum.DELIVERED);

        // Verify that the notification interface was never called
        verify(orderRepository, times(1)).findOrderByGroupFoodOrderOrderByCreatedTimeAsc(groupFoodOrder);
        verify(notificationInterface, times(0)).publish(any(MessageRequest.class));
    }
}
