package com.nus.edu.se.delivery.service.orderstatus;

import com.nus.edu.se.delivery.model.StatusEnum;
import com.nus.edu.se.delivery.service.DeliveryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OnDeliveryCommandTest {

    @InjectMocks
    private OnDeliveryCommand onDeliveryCommand;

    @Mock
    private DeliveryService deliveryService;

    private String validOrderId;
    private String nullOrderId;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        validOrderId = "123e4567-e89b-12d3-a456-426614174000"; // Example UUID string
        nullOrderId = null;
    }

    @Test
    void testExecute_WithValidOrderId() {
        // Act
        onDeliveryCommand.execute(validOrderId);

        // Assert
        verify(deliveryService, times(1)).updateStatus(validOrderId, StatusEnum.ON_DELIVERY);
    }

    @Test
    void testExecute_WithNullOrderId() {
        // Act and Assert
        NullPointerException exception = assertThrows(NullPointerException.class, () ->
                onDeliveryCommand.execute(nullOrderId)
        );

        assertEquals("Order ID cannot be null", exception.getMessage());
        verify(deliveryService, times(0)).updateStatus(anyString(), any(StatusEnum.class));
    }
}
