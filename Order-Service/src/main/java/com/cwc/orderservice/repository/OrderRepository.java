package com.cwc.orderservice.repository;

import com.cwc.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Deendayal Kumawat
 */

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
