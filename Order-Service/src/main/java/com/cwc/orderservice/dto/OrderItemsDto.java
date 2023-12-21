package com.cwc.orderservice.dto;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author Deendayal Kumawat
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Builder
public class OrderItemsDto {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;;


}
