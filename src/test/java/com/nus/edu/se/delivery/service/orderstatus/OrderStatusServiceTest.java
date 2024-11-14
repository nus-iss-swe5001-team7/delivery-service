package com.nus.edu.se.delivery.service.orderstatus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;

class OrderStatusServiceTest {

    @InjectMocks
    private OrderStatusService orderStatusService;

    @Mock
    private SubmittedToRestaurantCommand submittedToRestaurantCommand;

    @Mock
    private OrderCancelCommand orderCancelCommand;

    @Mock
    private KitchenPreparingCommand kitchenPreparingCommand;

    @Mock
    private ReadyForDeliveryCommand readyForDeliveryCommand;

    @Mock
    private OnDeliveryCommand onDeliveryCommand;

    @Mock
    private DeliveredCommand deliveredCommand;

    private String validOrderId;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        validOrderId = "123e4567-e89b-12d3-a456-426614174000"; // Example UUID string
    }

    @Test
    void testSubmittedToRestaurant() {
        // Act
        orderStatusService.submittedToRestaurant(validOrderId);

        // Assert
        verify(submittedToRestaurantCommand, times(1)).execute(validOrderId);
    }

    @Test
    void testOrderCancel() {
        // Act
        orderStatusService.orderCancel(validOrderId);

        // Assert
        verify(orderCancelCommand, times(1)).execute(validOrderId);
    }

    @Test
    void testKitchenPreparing() {
        // Act
        orderStatusService.kitchenPreparing(validOrderId);

        // Assert
        verify(kitchenPreparingCommand, times(1)).execute(validOrderId);
    }

    @Test
    void testReadyForDelivery() {
        // Act
        orderStatusService.readyForDelivery(validOrderId);

        // Assert
        verify(readyForDeliveryCommand, times(1)).execute(validOrderId);
    }

    @Test
    void testOnDelivery() {
        // Act
        orderStatusService.onDelivery(validOrderId);

        // Assert
        verify(onDeliveryCommand, times(1)).execute(validOrderId);
    }

    @Test
    void testDelivered() {
        // Act
        orderStatusService.delivered(validOrderId);

        // Assert
        verify(deliveredCommand, times(1)).execute(validOrderId);
    }
}
