package com.cwc.orderservice.controller;

import com.cwc.orderservice.dto.RequestOrder;
import com.cwc.orderservice.model.Order;
import com.cwc.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Deendayal Kumawat
 */
@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<?> placeOrder(@RequestBody RequestOrder requestOrder) {
        log.info("Order Request: {}", requestOrder.toString());
        Order saveOrder = this.orderService.saveOrder(requestOrder);
        return new ResponseEntity<>(saveOrder, HttpStatus.CREATED);

    }
}
