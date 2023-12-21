package com.cwc.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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
@Table(name = "t_order_line_items")
public class OrderLineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
