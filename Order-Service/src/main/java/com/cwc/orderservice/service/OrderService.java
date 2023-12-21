package com.cwc.orderservice.service;

import com.cwc.orderservice.dto.RequestOrder;
import com.cwc.orderservice.model.Order;

/**
 * @author Deendayal Kumawat
 */
public interface OrderService {

   public Order saveOrder(RequestOrder requestOrder);
}
