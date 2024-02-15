package com.learn.productservice.service;

import com.learn.productservice.dto.InventoryResponse;
import com.learn.productservice.dto.OrderItemDto;
import com.learn.productservice.dto.OrderRequest;
import com.learn.productservice.model.Orders;
import com.learn.productservice.model.OrderItem;
import com.learn.productservice.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    WebClient.Builder webClient;
    public void placeOrder(OrderRequest request) {
        Orders orders = Orders.builder()
                .orderNumber(UUID.randomUUID().toString())
                 .orderItems(request.getOrderItemDtoList().stream().map(this::mapOrderList).toList())
                .build();



       //WebClient
       InventoryResponse[] inventoryResponses = webClient.build().get()

                .uri(uriBuilder -> uriBuilder.path("/api/inventory").build()
                        )
               .retrieve()
               .bodyToMono(InventoryResponse[].class).block();

       boolean allProductInStock= Arrays.stream(inventoryResponses).allMatch(inventoryResponse -> inventoryResponse.getQuantity() > 0 );

        if(allProductInStock)
            orderRepository.save(orders);
        else
            System.out.println("Error");


    }

    private OrderItem mapOrderList(OrderItemDto orderItemDto) {
        return OrderItem.builder()
                .price(orderItemDto.getPrice())
                .skuCode(orderItemDto.getSkuCode())
                .quantity(orderItemDto.getQuantity())
                .build();
    }

    public List<Orders> findAll() {
        return orderRepository.findAll();
    }
}
