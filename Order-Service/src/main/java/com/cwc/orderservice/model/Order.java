package com.cwc.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author Deendayal Kumawat
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
@Entity
@Table(name = "t_orders",schema = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;
}
