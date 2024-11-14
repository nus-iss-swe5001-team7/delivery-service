package com.nus.edu.se.delivery.service;

import com.nus.edu.se.delivery.dao.DeliveryRepository;
import com.nus.edu.se.delivery.dto.GroupFoodOrderList;
import com.nus.edu.se.delivery.model.GroupFoodOrder;
import com.nus.edu.se.delivery.model.StatusEnum;
import com.nus.edu.se.notification.NotificationService;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeliveryServiceTest {

    @InjectMocks
    private DeliveryService deliveryService;

    @Mock
    private DeliveryRepository deliveryRepository;

    @Mock
    private NotificationService notificationService;

    @Mock
    private WebClient.Builder webClientBuilder;

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestHeadersUriSpec<?> requestHeadersUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec<?> requestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    @Mock
    private HttpServletRequest httpServletRequest;

    private UUID orderId;
    private UUID userId;
    private String token;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderId = UUID.randomUUID();
        userId = UUID.randomUUID();
        token = "dummyToken";
    }

    @Test
    void testResolveToken_WithValidBearerToken() {
        when(httpServletRequest.getHeader("Authorization")).thenReturn("Bearer " + token);

        String resolvedToken = deliveryService.resolveToken(httpServletRequest);

        assertEquals(token, resolvedToken);
    }

    @Test
    void testResolveToken_WithInvalidBearerToken() {
        when(httpServletRequest.getHeader("Authorization")).thenReturn("InvalidToken");

        String resolvedToken = deliveryService.resolveToken(httpServletRequest);

        assertNull(resolvedToken);
    }

}
