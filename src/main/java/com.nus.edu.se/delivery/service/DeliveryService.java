package com.nus.edu.se.delivery.service;

import com.nus.edu.se.delivery.dao.DeliveryRepository;
import com.nus.edu.se.delivery.dto.GroupFoodOrderList;
import com.nus.edu.se.delivery.model.GroupFoodOrder;
import com.nus.edu.se.delivery.model.StatusEnum;
import com.nus.edu.se.notification.NotificationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    NotificationService notificationService;

    private final WebClient.Builder webClientBuilder;

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public List<GroupFoodOrderList> getAllGroupOrders(String token) {
        return getAllGroupOrders(null);
    }

    @Transactional
    public GroupFoodOrder updateStatus(String orderId, StatusEnum status) {
        UUID orderUUID = UUID.fromString(orderId);
        GroupFoodOrder groupFoodOrder = new GroupFoodOrder();
        Optional<GroupFoodOrder> groupOrder = deliveryRepository.findById(orderUUID);

        if (groupOrder.isPresent()) {
            groupFoodOrder = groupOrder.get();
            groupFoodOrder.setId(orderUUID);
            groupFoodOrder.setStatus(status);
            if (status== StatusEnum.DELIVERED || status== StatusEnum.ON_DELIVERY){
                groupFoodOrder.setGroupOrderDeliveryTime(new Date());
            }
            groupFoodOrder = deliveryRepository.saveAndFlush(groupFoodOrder);
            try {
                notificationService.sendNotification(groupFoodOrder, status);
            } catch (Exception e) {
                System.err.println("Failed to send notification for order " + groupFoodOrder.getId() + ": " + e.getMessage());
            }
        } else {
            throw new RuntimeException("Not found GroupOrder with orderId = " + orderId);
        }
        return groupFoodOrder;
    }


    public List<GroupFoodOrderList> getGroupFoodOrderListByUserId(UUID userId,  String location, String token){
        String uri = String.format("http://order-service/groupFoodOrdersAPI/getOrdersForDeliveryStaff?userId=%s&location=%s", userId, location);

        Mono<List<GroupFoodOrderList>> response = webClientBuilder.build()
                .get()
                .uri(uri)
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<GroupFoodOrderList>>() {});

        return response.block();
//        List<GroupFoodOrderList> groupFoodOrderLists = response.block();
//
//        // Populate additional details for restaurant and delivery based on the new JSON structure
//        for (GroupFoodOrderList orderDto : groupFoodOrderLists) {
//            // Example hardcoded data, replace with actual data retrieval logic
//            GroupFoodOrderList.Restaurant restaurant = new GroupFoodOrderList.Restaurant();
//            restaurant.setName("Dumpling House");
//            restaurant.setId("5b75eb9f-fb89-45a2-94da-afbe6c21ff9c");
//            restaurant.setRating(3);
//            restaurant.setImgUrl("https://images.pexels.com/photos/7363691/pexels-photo-7363691.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
//            restaurant.setAddress("Fairprice Hub Joo Koon");
//            restaurant.setLatitude(1.3249278764785808);
//            restaurant.setLongitude(103.67851212473738);
//            restaurant.setArea("South");
//            restaurant.setPickupTime(null);
//
//            orderDto.setRestaurant(restaurant);
//
//            GroupFoodOrderList.Delivery delivery = new GroupFoodOrderList.Delivery();
//            delivery.setLocation("Central");
//            delivery.setAddress("National University of Singapore");
//            delivery.setLatitude(1.2936935424804688);
//            delivery.setLongitude(103.77532958984375);
//            delivery.setDeliveryTime(null);
//
//            orderDto.setDelivery(delivery);
//        }
//
//        return groupFoodOrderLists;
    }


}
