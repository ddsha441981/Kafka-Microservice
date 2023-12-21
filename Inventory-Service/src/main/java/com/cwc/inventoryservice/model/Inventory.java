package com.cwc.inventoryservice.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Deendayal Kumawat
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "t_inventory")
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;
}
