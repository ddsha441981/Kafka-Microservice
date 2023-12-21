package com.cwc.orderservice.service.impl;

import com.cwc.orderservice.dto.InventoryResponse;
import com.cwc.orderservice.dto.OrderItemsDto;
import com.cwc.orderservice.dto.RequestOrder;
import com.cwc.orderservice.exception.ProductOutOfStockException;
import com.cwc.orderservice.model.Order;
import com.cwc.orderservice.model.OrderLineItems;
import com.cwc.orderservice.repository.OrderRepository;
import com.cwc.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author Deendayal Kumawat
 */

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private final WebClient webClient;
    @Override
    public Order saveOrder(RequestOrder requestOrder) {
        Order order = new Order();
                order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> itemsList = requestOrder.getOrderItemsDtos().stream().map(orderLineDto -> MapToDto(orderLineDto)).toList();

        order.setOrderLineItemsList(itemsList);


        //SkuCode List
        List<String> skuCodes = order.getOrderLineItemsList().stream().map(OrderLineItems::getSkuCode).toList();


        // call Inventory Service to place order if product is in stock
        InventoryResponse[] inventoryResponseArray = webClient.get()
                .uri("http://localhost:9593/api/v1/inventory",uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStocks = Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);

        if (allProductsInStocks){
            return this.orderRepository.save(order);
        }else {
            throw new ProductOutOfStockException("Product is Out of Stock");
        }





    }

    private OrderLineItems MapToDto(OrderItemsDto orderLineDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setSkuCode(orderLineDto.getSkuCode());
        orderLineItems.setPrice(orderLineDto.getPrice());
        orderLineItems.setQuantity(orderLineDto.getQuantity());
        return orderLineItems;
    }
}
