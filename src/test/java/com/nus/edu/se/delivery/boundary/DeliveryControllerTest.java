package com.nus.edu.se.delivery.boundary;

import com.nus.edu.se.delivery.dto.GroupFoodOrderList;
import com.nus.edu.se.delivery.service.DeliveryService;
import com.nus.edu.se.delivery.service.orderstatus.OrderStatusService;
import com.nus.edu.se.user.service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Date;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DeliveryController.class)
class DeliveryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderStatusService orderStatusService;

    @MockBean
    private UsersService usersService;

    @MockBean
    private DeliveryService deliveryService;

    private UUID userId;
    private String orderId;
    private String location;
    private String token;

    @BeforeEach
    void setUp() {
        userId = UUID.randomUUID();
        orderId = UUID.randomUUID().toString();
        location = "City Center";
        token = "dummyToken";
    }

    @Test
    void testUpdateStatusToOnDelivery_Success() throws Exception {
        doNothing().when(orderStatusService).onDelivery(orderId);

        mockMvc.perform(put("/deliveryAPI/onDelivered/{orderId}", orderId))
                .andExpect(status().isOk());

        verify(orderStatusService, times(1)).onDelivery(orderId);
    }

    @Test
    void testUpdateStatusToOnDelivery_NotFound() throws Exception {
        doThrow(new RuntimeException()).when(orderStatusService).onDelivery(orderId);

        mockMvc.perform(put("/deliveryAPI/onDelivered/{orderId}", orderId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.fail_message").value("updateStatusToOnDelivery Not found GroupOrder with orderId"));

        verify(orderStatusService, times(1)).onDelivery(orderId);
    }

    @Test
    void testUpdateStatusToDelivered_Success() throws Exception {
        doNothing().when(orderStatusService).delivered(orderId);

        mockMvc.perform(put("/deliveryAPI/delivered/{orderId}", orderId))
                .andExpect(status().isOk());

        verify(orderStatusService, times(1)).delivered(orderId);
    }

    @Test
    void testUpdateStatusToDelivered_NotFound() throws Exception {
        doThrow(new RuntimeException()).when(orderStatusService).delivered(orderId);

        mockMvc.perform(put("/deliveryAPI/delivered/{orderId}", orderId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.fail_message").value("updateStatusToReadyForDelivery Not found GroupOrder with orderId"));

        verify(orderStatusService, times(1)).delivered(orderId);
    }

    @Test
    void testGetOrdersForDeliveryStaff() throws Exception {
        GroupFoodOrderList orderList = new GroupFoodOrderList();
        orderList.setGroupFoodOrderId(UUID.randomUUID());
        orderList.setDeliveryTime(new Date());
        orderList.setOrderTime(new Date());
        List<GroupFoodOrderList> mockOrders = Collections.singletonList(orderList);

        when(deliveryService.resolveToken(any())).thenReturn(token);
        when(deliveryService.getGroupFoodOrderListByUserId(userId, location, token)).thenReturn(mockOrders);

        mockMvc.perform(get("/deliveryAPI/getAllGroupOrdersForDelivery")
                        .param("userId", userId.toString())
                        .param("location", location)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].groupFoodOrderId").value(orderList.getGroupFoodOrderId().toString()));

        verify(deliveryService, times(1)).resolveToken(any());
        verify(deliveryService, times(1)).getGroupFoodOrderListByUserId(userId, location, token);
    }
}
